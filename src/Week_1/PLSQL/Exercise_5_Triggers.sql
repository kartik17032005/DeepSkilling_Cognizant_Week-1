CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :new.LastModified := SYSDATE;
END;
/

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType, LogDate)
    VALUES (:new.TransactionID, :new.AccountID, :new.TransactionDate, :new.Amount, :new.TransactionType, SYSDATE);
END;
/

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_bal NUMBER;
BEGIN
    IF :new.TransactionType = 'Deposit' THEN
        IF :new.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'Deposit amount must be positive.');
        END IF;
    ELSIF :new.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = :new.AccountID;
        IF :new.Amount > v_bal THEN
            RAISE_APPLICATION_ERROR(-20002, 'Withdrawal amount exceeds account balance.');
        END IF;
        IF :new.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20003, 'Withdrawal amount must be positive.');
        END IF;
    END IF;
END;
/
