-- CAMPGROUND TABLE
-----------------------------------------------

-- select name and daily fee of all campgrounds (expected: 7 rows)
SELECT cg.name, cg.daily_fee
FROM campground AS cg;

-- select name and daily fee of all campgrounds ordered by campground name (expected: 7 rows, starting with "Blackwoods")
SELECT cg.name, cg.daily_fee
FROM campground AS cg
ORDER BY cg.name;

-- select name, open from month, open to month, and daily fee of the campgrounds where daily fee is less than $100 (expected: 5 rows)
SELECT cg.name, cg.open_from_mm, cg.open_to_mm, cg.daily_fee
FROM campground AS cg
WHERE cg.daily_fee < '100';

-- select name and daily fee of the campgrounds where the campground is open all year long (expected: 4 rows)
SELECT cg.name, cg.daily_fee
FROM campground As cg
WHERE cg.open_from_mm = 1 AND cg.open_to_mm = 12;

-- PARK TABLE
-----------------------------------------------

-- select name and description of all parks order by established date in descending order (expected: 3 rows, startng with "Cuyahoga Valley")
SELECT p.name, p.description
FROM park AS p
ORDER BY p.establish_date DESC;

-- select name and description of all parks in Ohio (expected: 1 row)
SELECT p.name, p.description
FROM park AS p
WHERE p.location = 'Ohio';

-- select name and description of all parks NOT in Ohio (expected: 2 rows)
SELECT p.name, p.description
FROM park AS p
WHERE p.location != 'Ohio';

-- select the total number of visitors for all parks (expected: around 6 million)
SELECT SUM(p.visitors)
FROM park AS p;

-- select the average number of visitors for all parks (expected: around 2 million)
SELECT AVG(visitors)
FROM park;

-- SITE TABLE
-----------------------------------------------

-- select all columns from site where utilities is true and order by max RV length with the largest coming first
-- (expected: 26 rows, starting with 35-foot max_rv_length)
SELECT *
FROM site
WHERE utilities = TRUE
ORDER BY max_rv_length DESC;

-- select total number of sites that have utilities hook up (expected: around 25)

SELECT COUNT(site_id)
FROM site
WHERE utilities = TRUE;

-- RESERVATION TABLE
-----------------------------------------------

-- select reservation id, site id, name, from date, to date of the reservations where the checkin date 
--	is between the first and last day of the current month (hard coded month is ok) 
-- (expected row count may vary, should be no more than 44)

-- select all columns from reservation where name includes 'Reservation' (expected: 23 rows)

-- select the total number of reservations in the reservation table (expected: around 40)

-- select reservation id, site id, name of the reservations where site id is in the list 9, 20, 24, 45, 46 (expected: 16 rows)

-- select the date and number of reservations for each date ordered by from_date in ascending order (expected: 24 rows, starting from the earliest date)

