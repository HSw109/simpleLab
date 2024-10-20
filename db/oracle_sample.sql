-- Grant necessary privileges to the user
GRANT CONNECT, RESOURCE TO system;

-- Connect to the new schema
CONNECT system/trgg1234;

-- Create a table
CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    department VARCHAR2(50),
    salary NUMBER
);

-- Optionally, create a sequence for generating unique IDs
CREATE SEQUENCE employee_id_seq START WITH 1 INCREMENT BY 1;

-- Optionally, create a trigger to automatically populate the ID column using the sequence
CREATE OR REPLACE TRIGGER employees_trigger
BEFORE INSERT ON employees
FOR EACH ROW
BEGIN
    SELECT employee_id_seq.NEXTVAL
    INTO :new.employee_id
    FROM dual;
END;
/

-- Example of inserting data into the table
INSERT INTO employees (employee_id, first_name, last_name, department, salary) 
VALUES (employee_id_seq.NEXTVAL, 'John', 'Doe', 'IT', 60000);

INSERT INTO employees (employee_id, first_name, last_name, department, salary) 
VALUES (employee_id_seq.NEXTVAL, 'Jane', 'Smith', 'HR', 55000);
