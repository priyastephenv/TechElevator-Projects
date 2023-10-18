-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)

SELECT m.title
FROM movie m
JOIN collection c ON m.collection_id = c.collection_id
JOIN person p ON p.person_ID = m.director_ID
WHERE c.collection_name = 'Star Wars Collection' AND person_name != 'George Lucas'
ORDER BY m.title ASC;