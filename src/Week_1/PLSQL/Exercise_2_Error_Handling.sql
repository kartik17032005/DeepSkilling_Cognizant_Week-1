CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_src_acc IN NUMBER,
    p_dest_acc IN NUMBER,
    p_amount IN NUMBER
) IS
    v_src_bal NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_src_bal FROM Accounts WHERE AccountID = p_src_acc FOR UPDATE;
    IF v_src_bal < p_amount THEN
        RAISE insufficient_funds;
    END IF;
    
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_src_acc;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_dest_acc;
    
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_src_acc);
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    v_exists NUMBER;
    emp_not_found EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_exists FROM Employees WHERE EmployeeID = p_emp_id;
    IF v_exists = 0 THEN
        RAISE emp_not_found;
    END IF;
    
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100)
    WHERE EmployeeID = p_emp_id;
    COMMIT;
EXCEPTION
    WHEN emp_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_emp_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_cust_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) IS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
    VALUES (p_cust_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_cust_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
