-- select the park name, campground name, open_from_mm, open_to_mm & daily_fee ordered by park name and then campground name
-- (expected: 7 rows, starting with "Blackwoods")

SELECT park.name, campground.name, campground.open_from_mm, campground.open_to_mm, campground.daily_fee
FROM campground
LEFT JOIN park ON campground.park_id = park.park_id
ORDER BY park.name ASC, campground.name ASC;



-- select the park name and the total number of campgrounds for each park ordered by park name
-- (expected: 3 rows, starting with "Acadia")

SELECT park.name, COUNT(campground.campground_id)
FROM park
LEFT JOIN campground ON campground.park_id = park.park_id
GROUP BY park.name
ORDER BY park.name ASC;

-- select the park name, campground name, site number, max occupancy, accessible, max rv length, utilities where the campground name is 'Blackwoods'
-- (expected: 12 rows)

SELECT park.name, campground.name, site.site_number, site.max_occupancy, site.accessible, site.max_rv_length, site.utilities
FROM site
LEFT JOIN campground ON site.campground_id= campground.campground_id
LEFT JOIN park ON campground.park_id = park.park_id
WHERE campground.name='Blackwoods';

-- select site number, reservation name, reservation from and to date ordered by reservation from date
-- (expected: 44 rows, starting with the earliest date)


SELECT site.site_number, reservation.name, reservation.from_date, reservation.to_date
FROM reservation
LEFT JOIN site ON site.site_id = reservation.site_id
ORDER BY reservation.from_date;

-- done