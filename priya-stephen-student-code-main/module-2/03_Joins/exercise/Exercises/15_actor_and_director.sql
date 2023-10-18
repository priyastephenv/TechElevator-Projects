-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)

SELECT DISTINCT m.title, p.person_name
FROM movie m
JOIN person p on m.director_id = p.person_id
JOIN movie_actor ma ON ma.actor_id = m.director_id
WHERE m.movie_id = ma.movie_id
ORDER by m.title ASC;