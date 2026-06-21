CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_dept IN VARCHAR2,
    p_bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_pct / 100)
    WHERE Department = p_dept;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_src_acc IN NUMBER,
    p_dest_acc IN NUMBER,
    p_amount IN NUMBER
) IS
    v_src_bal NUMBER;
BEGIN
    SELECT Balance INTO v_src_bal FROM Accounts WHERE AccountID = p_src_acc FOR UPDATE;
    IF v_src_bal >= p_amount THEN
        UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_src_acc;
        UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_dest_acc;
        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance to perform transfer.');
    END IF;
END;
/
