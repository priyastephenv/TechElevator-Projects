-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)

SELECT DISTINCT p.person_name
FROM person p
JOIN movie_actor ma ON ma.actor_id = p.person_id
JOIN movie m ON m.movie_id = ma.movie_id
JOIN collection c ON c.collection_id = m.collection_id
WHERE c.collection_name = 'Back to the Future Collection'
ORDER BY p.person_name;