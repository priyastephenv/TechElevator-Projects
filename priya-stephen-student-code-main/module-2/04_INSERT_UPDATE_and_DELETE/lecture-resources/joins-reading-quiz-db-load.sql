BEGIN TRANSACTION;

DROP TABLE IF EXISTS employee, wage, timecard CASCADE;
DROP SEQUENCE IF EXISTS emp_id;

CREATE SEQUENCE emp_id
  INCREMENT BY 1
  START WITH 10001
  NO MAXVALUE;

CREATE TABLE employee (
	employee_id int DEFAULT nextval('emp_id') PRIMARY KEY,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	department varchar(20) CONSTRAINT DF_dept DEFAULT('None'),
	CONSTRAINT CHK_dept
		CHECK(department IN ('None', 'Sales', 'Finance', 'Engineering', 'HR'))
);

CREATE TABLE wage (
	wage_id serial PRIMARY KEY,
	employee_id int NOT NULL,
	hourly_rate int NOT NULL,
	tax_rate_percent int CONSTRAINT DF_tax_percent DEFAULT(25),
	CONSTRAINT FK_employee_id
		FOREIGN KEY(employee_id)
			REFERENCES employee(employee_id)
);

CREATE TABLE timecard (
	timecard_id serial PRIMARY KEY,
	employee_id int NOT NULL,
	normal_hours int CONSTRAINT DF_hours DEFAULT(40),
	overtime_hours int CONSTRAINT DF_hours DEFAULT(0),
	CONSTRAINT FK_employee_id
		FOREIGN KEY(employee_id)
			REFERENCES employee(employee_id)
);

INSERT INTO employee
(first_name, last_name, department)
VALUES
('Linda', 'Mojito', 'Sales'),
('Chuck', 'Powers', 'Finance'),
('Heartless', 'John', 'HR'),
('Indiana', 'Jones', 'Sales');

INSERT INTO wage
(employee_id, hourly_rate, tax_rate_percent)
VALUES
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Linda'
	  AND last_name = 'Mojito'
 ), 25, 20
),
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Chuck'
	  AND last_name = 'Powers'
 ), 20, 25
),
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Heartless'
	  AND last_name = 'John'
 ), 25, 15
),
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Indiana'
	  AND last_name = 'Jones'
 ), 30, 20
);

INSERT INTO timecard
(employee_id, normal_hours, overtime_hours)
VALUES
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Linda'
	  AND last_name = 'Mojito'
 ), 36, 0
),
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Chuck'
	  AND last_name = 'Powers'
 ), 40, 0
),
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Heartless'
	  AND last_name = 'John'
 ), 45, 5
),
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Heartless'
	  AND last_name = 'John'
 ), 50, 10
),
((
	SELECT employee_id
	FROM employee
	WHERE first_name = 'Linda'
	  AND last_name = 'Mojito'
 ), 44, 4
);

COMMIT;
