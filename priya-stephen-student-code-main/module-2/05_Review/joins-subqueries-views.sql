-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)


-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent first. 
-- (9 rows)
SELECT title, release_date
FROM movie m
JOIN collection c ON c.collection_id = m.collection_id
WHERE collection_name = 'Star Wars Collection'
ORDER BY release_date DESC;


-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)
INSERT INTO movie_actor
(movie_id, actor_id)
VALUES
--( <back to the future movie id>, <actor id for Eric Stoltz);
( (
	SELECT movie_id
	FROM movie
	WHERE title = 'Back to the Future'
),
(
	SELECT person_id
	FROM person
	WHERE person_name = 'Eric Stoltz'
));

-- back to the future movie id
SELECT movie_id
FROM movie
WHERE title = 'Back to the Future';

-- actor id for Eric Stoltz
SELECT person_id
FROM person
WHERE person_name = 'Eric Stoltz';

-- QUERY ALL THE ACTORS in Back to the future for checking
SELECT person_name
FROM person p
JOIN movie_actor ma ON ma.actor_id = p.person_id
JOIN movie m ON m.movie_id = ma.movie_id
WHERE title = 'Back to the Future'
ORDER BY person_name;



-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

-- a. create new record in collection table
INSERT INTO collection
(collection_name)
VALUES
('Bill Murray Collection');

SELECT * FROM collection ORDER BY collection_name;

-- b. migrate all movies into the Bill Murray collection
UPDATE movie
SET collection_id = (<collection id for bill murray collection>)
WHERE movie_id IN (<bill murray movies>)

UPDATE movie
SET collection_id = (
	SELECT collection_id
	FROM collection
	WHERE collection_name = 'Bill Murray Collection'
)
WHERE movie_id IN (
	SELECT m.movie_id
	FROM movie m
	JOIN movie_actor ma ON m.movie_id = ma.movie_id
	JOIN person p ON p.person_id = ma.actor_id
	WHERE person_name = 'Bill Murray'
);


-- QUERY collection_id for bill murray collection
SELECT collection_id
FROM collection
WHERE collection_name = 'Bill Murray Collection';

-- QUERY movie_id bill murray movies AS an actor
SELECT m.movie_id, title
FROM movie m
JOIN movie_actor ma ON m.movie_id = ma.movie_id
JOIN person p ON p.person_id = ma.actor_id
WHERE person_name = 'Bill Murray';



-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)
SELECT title, tagline
FROM movie m
JOIN movie_genre mg ON m.movie_id = mg.movie_id
JOIN genre g ON mg.genre_id = g.genre_id
JOIN movie_actor ma ON m.movie_id = ma.movie_id
JOIN person p ON ma.actor_id = p.person_id
WHERE person_name = 'Samuel L. Jackson'
AND genre_name = 'Family'
ORDER BY title;


/*
 * CREATE VIEW
 */
DROP VIEW IF EXISTS movie_actor_genre;

-- VIEW to consolodate joins, no new table is created
CREATE VIEW movie_actor_genre AS
SELECT p.person_name, m.title, m.tagline, g.genre_name
FROM movie m
JOIN movie_genre mg ON m.movie_id = mg.movie_id
JOIN genre g ON mg.genre_id = g.genre_id
JOIN movie_actor ma ON m.movie_id = ma.movie_id
JOIN person p ON ma.actor_id = p.person_id;

-- select from VIEW
SELECT title, tagline
FROM movie_actor_genre mag
WHERE person_name = 'Samuel L. Jackson'
AND genre_name = 'Family'
ORDER BY title;


/*
 * JOIN & SUBQUERY
 */
SELECT *
FROM collection c
JOIN (
	SELECT  collection_id, title, tagline
	FROM movie
) AS sub ON sub.collection_id = c.collection_id;




