-- Reading Quiz Join, Question 8 multiple choice
-- A
SELECT timecard_id, employee_id, normal_hours
FROM timecard
WHERE employee_id = (SELECT * FROM employee WHERE department = 'Sales');

-- B
SELECT timecard_id, employee_id, normal_hours
FROM timecard
WHERE employee_id = (SELECT employee_id FROM employee WHERE department = 'Sales');

-- C
SELECT timecard_id, employee_id, normal_hours
FROM timecard
WHERE employee_id IN (SELECT employee_id FROM employee WHERE department = 'Sales');

-- D
SELECT tc.timecard_id, tc.employee_id, tc.normal_hours
FROM employee AS emp
JOIN timecard AS tc ON emp.department = 'Sales';

-- E
SELECT tc.timecard_id, tc.employee_id, tc.normal_hours
FROM timecard AS tc
JOIN employee AS emp ON tc.employee_id = emp.employee_id
WHERE emp.department = 'Sales';
