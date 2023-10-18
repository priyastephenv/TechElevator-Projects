-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)

SELECT person_name, birthday
FROM person
JOIN movie_actor ma on person.person_id = ma.actor_id
JOIN movie ON  movie.movie_id = ma.movie_id
WHERE movie.title = 'The Fifth Element'
ORDER BY person_name ASC;