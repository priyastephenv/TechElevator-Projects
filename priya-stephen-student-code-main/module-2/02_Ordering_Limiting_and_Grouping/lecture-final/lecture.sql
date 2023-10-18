-- ORDERING RESULTS

/* Lecture test queries
SELECT state_name AS sn
FROM state
ORDER BY sn;

SELECT census_region AS region, population
FROM state
ORDER BY region DESC, population ASC;
*/

-- order of execution so far
-- FROM, WHERE, SELECT, ORDER BY
-- ORDER BY can use alias defined in SELECT
SELECT census_region AS region, population AS pop
FROM state
WHERE census_region IS NULL
ORDER BY pop
LIMIT 3;

-- Populations of all states from largest to smallest.
SELECT population, state_name
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
FROM STATE
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT park_name, area
FROM park
ORDER BY area DESC;

-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.

-- METHOD 1
SELECT park_name, date_established
FROM park
ORDER BY date_established ASC, park_name ASC
LIMIT 20;

-- METHOD 2
SELECT park_name, (CURRENT_DATE - date_established) / 365 AS age_years
FROM park
ORDER BY age_years DESC, park_name ASC
LIMIT 20;

-- METHOD 3: using EXTRACT
SELECT EXTRACT(YEAR FROM CURRENT_DATE) AS year,
	   EXTRACT(MONTH FROM CURRENT_DATE) AS month,
  	   EXTRACT(DAY FROM CURRENT_DATE) AS day,
	   EXTRACT(CENTURY FROM CURRENT_DATE) AS century,
	   EXTRACT(hour FROM CURRENT_TIME) AS hour,
	   EXTRACT(minute FROM CURRENT_TIME) AS minute,
	   EXTRACT(second FROM CURRENT_TIME) AS second;


SELECT park_name, EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM date_established) AS age_years
FROM park
ORDER BY age_years DESC, park_name ASC
LIMIT 20;

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.


-- The all parks by name and date established.
SELECT (park_name || ', ' || date_established) AS park_date_established
FROM park
ORDER BY  date_established;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT state_name, population
FROM state
WHERE state_name ILIKE 'a%'
ORDER BY population;

SELECT SUM(population) AS sum_state_pop
FROM state
WHERE state_name ILIKE 'am%';

-- Total population in the West and South census regions
SELECT SUM(population) AS south_west_region_populations
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(*) as million_pop_cities
FROM city
WHERE population > 1000000;

-- Sanity check for above ^
SELECT * FROM city ORDER BY population DESC;

-- The number of state nicknames.
-- METHOD 1
SELECT COUNT(state_nickname) AS nickname_count
FROM state
WHERE state_nickname IS NOT NULL;

SELECT COUNT(state_nickname) AS nickname_count, COUNT(*) AS total_states
FROM state;

-- Sanity check for above ^
SELECT state_name, state_nickname FROM state ORDER BY state_nickname DESC;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest_area, MAX(area) AS largest_area
FROM park;

-- get names of largest and smallest parks with the min & max
-- Using a SUBQUERY
SELECT MIN(area) FROM park;
SELECT MAX(area) FROM park;

SELECT park_name, area
FROM park
WHERE area = (SELECT MIN(area) FROM park)  -- 0.8
   OR area = (SELECT MAX(area) FROM park); -- 33682.6;

-- Sanity check for above ^
SELECT area FROM park ORDER BY area;

-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(city_name) AS num_cities
FROM city
GROUP BY state_abbreviation
ORDER BY num_cities DESC;

-- Sanity check for ^
SELECT state_abbreviation
FROM city
WHERE state_abbreviation = 'AZ';

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, ROUND(AVG(area), 2) AS park_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS sum_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city DESC;

-- subquery
SELECT state_abbreviation, city_name, population
FROM city
WHERE (state_abbreviation, population) IN (
		SELECT state_abbreviation, MIN(population) AS smallest_city
		FROM city
		GROUP BY state_abbreviation
	   )
ORDER BY population DESC;

-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT state_name
FROM state
WHERE state_abbreviation = 'CA';

SELECT (
		SELECT state_name
		FROM state
		WHERE state.state_abbreviation = city.state_abbreviation
	   ), 
	   COUNT(city_name) AS num_cities
FROM city
GROUP BY (state_abbreviation)
ORDER BY num_cities DESC;

-- Include the names of the smallest and largest parks
SELECT park_name, area
FROM park
WHERE area = (SELECT MIN(area) FROM park)  -- 0.8
   OR area = (SELECT MAX(area) FROM park); -- 33682.6;

-- List the capital cities for the states in the Northeast census region.
-- SUBQUERY
SELECT city_name, city_id
FROM city
WHERE city_id = 133; -- Hartford, CT

-- Original query with the capital as a city_id
SELECT state_abbreviation, capital
FROM state
WHERE census_region = 'Northeast';

-- Final query with a sub-query
SELECT s.state_abbreviation,
	(
	 SELECT c.city_name
	 FROM city AS c
	 WHERE c.city_id = s.capital
	)
FROM state AS s
WHERE s.census_region = 'Northeast';

