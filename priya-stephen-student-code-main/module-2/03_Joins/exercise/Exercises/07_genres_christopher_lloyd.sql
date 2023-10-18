-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.

SELECT DISTINCT genre_name
FROM genre
JOIN movie_genre mg on mg.genre_id = genre.genre_id
JOIN movie ON movie.movie_id = mg.movie_id
JOIN movie_actor ma ON ma.movie_id = movie.movie_id
JOIN person a ON ma.actor_id = a.person_id
WHERE a.person_name = 'Christopher Lloyd'
ORDER BY genre_name ASC;