DECLARE
    CURSOR c_statements IS
        SELECT c.Name, a.AccountID, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
    FOR r_stmt IN c_statements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || r_stmt.Name || ' | Account: ' || r_stmt.AccountID || ' | Trans: ' || r_stmt.TransactionID || ' | Date: ' || TO_CHAR(r_stmt.TransactionDate, 'YYYY-MM-DD') || ' | Type: ' || r_stmt.TransactionType || ' | Amount: $' || r_stmt.Amount);
    END LOOP;
END;
/

DECLARE
    v_fee NUMBER := 10.0;
    CURSOR c_accounts IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE;
BEGIN
    FOR r_acc IN c_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE CURRENT OF c_accounts;
    END LOOP;
    COMMIT;
END;
/

DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate FROM Loans FOR UPDATE;
BEGIN
    FOR r_loan IN c_loans LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE CURRENT OF c_loans;
    END LOOP;
    COMMIT;
END;
/
