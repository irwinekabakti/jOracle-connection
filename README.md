# PL/SQL STEPS

[//]: # (## 1. CREATE PROCEDURE IN PL/SQL)
### Procedure for employees by address
```
CREATE OR REPLACE PROCEDURE get_employees_by_address (
    e_address IN VARCHAR2,
    e_address_count OUT NUMBER) AS
BEGIN
    SELECT COUNT(*)
    INTO e_address_count   
    FROM employees
    WHERE UPPER(address) LIKE UPPER('%' || e_address || '%');
END;
```
### Procedure for salary statistics by age
```
CREATE OR REPLACE PROCEDURE get_salary_stats_by_age (
    e_min_age IN NUMBER,
    e_max_age IN NUMBER,
    e_avg_salary OUT NUMBER,
    e_max_salary OUT NUMBER,
    e_player_count OUT NUMBER
) AS
BEGIN
    SELECT 
        AVG(NVL(salary, 0)),
        MAX(NVL(salary, 0)),
        COUNT(*)
    INTO 
        e_avg_salary,
        e_max_salary,
        e_player_count
    FROM employees
    WHERE age BETWEEN e_min_age AND e_max_age;
END;
```
### Function for calculating total wages by location
```
CREATE OR REPLACE FUNCTION calculate_location_wages (
    e_location IN VARCHAR2) RETURN NUMBER AS
    v_total_wages NUMBER;
BEGIN
    SELECT NVL(SUM(NVL(salary, 0)), 0)
    INTO v_total_wages
    FROM employees
    WHERE UPPER(address) LIKE UPPER('%' || e_location || '%');
    
    RETURN v_total_wages;
END;
```