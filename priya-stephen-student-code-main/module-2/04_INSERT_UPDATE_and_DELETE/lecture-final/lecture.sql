-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
SELECT * FROM park;

INSERT INTO park
(park_name, date_established, area, has_camping)
VALUES
('Disneyland', '1955-07-17', 2.1, false);

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
INSERT INTO city
(city_name, state_abbreviation, population, area)
VALUES
('Hawkins', 'IN', 30000, 38.1),
('Cicely', 'AK', 839, 11.4);

SELECT * FROM city ORDER BY city_id DESC;


-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
INSERT INTO park_state
(park_id, state_abbreviation)
VALUES
((SELECT park_id FROM park WHERE park_name = 'Disneyland'), 'CA');

SELECT *
FROM park_state
JOIN park ON park.park_id = park_state.park_id;

-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT state_name, state_nickname, population
FROM state
WHERE state_name = 'California';

-- state_nickname is UNIQUE so can't give TX the same nickname as CA
UPDATE state
SET state_nickname = 'The Happiest Place on Earth'
WHERE state_name = 'Texas';

-- starter update template
-- UPDATE ?
-- SET ?
-- WHERE ?

-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population + 1000000
WHERE state_name = 'California';


-- Change the capital of California to Anaheim.
UPDATE state
SET capital = (
	SELECT city_id
	FROM city
	WHERE city_name = 'Anaheim'
	  AND state_abbreviation = 'CA'
)
WHERE state_abbreviation = 'CA';

SELECT state_name, city_name, capital
FROM state s
JOIN city c ON c.city_id = s.capital
WHERE c.state_abbreviation = 'CA';




-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.



-- DELETE

-- Delete Hawkins, IN from the city table.

-- starter DELETE template
-- DELETE FROM ?
-- WHERE ?

-- Delete all cities with a population of less than 1,000 people from the city table.
-- DELETE FROM city
-- WHERE population < 1000;


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.

-- state 'XX' can't be referred to b/c it's not in the state table
INSERT INTO city
(city_name, state_abbreviation, population, area)
VALUES
('Springfield', 'XX', 100, 5);

-- Try deleting California from the state table.
-- Can't DELETE TX because cities in the city table refer to it
DELETE FROM state
WHERE state_abbreviation = 'TX';

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.

-- must delete record that refers to disneyland first
-- before disneyland can be deleted
DELETE FROM park_state
WHERE park_id = (
	SELECT park_id
	FROM park
	WHERE park_name = 'Disneyland'
);

DELETE FROM park
WHERE park_name = 'Disneyland';


-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.


-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city
(city_name, state_abbreviation, area)
VALUES
('Smallville', 'KS', 11);

SELECT * FROM city WHERE city_name = 'Smallville';

-- Retrieve the new record to confirm it has been given a default, non-null value for population.


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).

-- state_nickname is UNIQUE so can't give TX the same nickname as CA
UPDATE state
SET state_nickname = 'The Happiest Place on Earth'
WHERE state_name = 'Texas';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).



-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
BEGIN TRANSACTION;

DELETE FROM city
WHERE city_name = 'Smallville' AND state_abbreviation = 'KS';

--ROLLBACK;
--COMMIT;

-- NO COMMIT!
SELECT *
FROM city
WHERE city_name = 'Smallville' AND state_abbreviation = 'KS';


-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.


-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.


-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
