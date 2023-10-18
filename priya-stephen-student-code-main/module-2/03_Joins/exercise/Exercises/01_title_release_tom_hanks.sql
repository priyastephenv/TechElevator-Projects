-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)

SELECT movie.title, movie.release_date
FROM movie
JOIN movie_actor ma ON movie.movie_id = ma.movie_id
JOIN person on ma.actor_id = person.person_id
WHERE person_name = 'Tom Hanks'
ORDER BY release_date DESC;