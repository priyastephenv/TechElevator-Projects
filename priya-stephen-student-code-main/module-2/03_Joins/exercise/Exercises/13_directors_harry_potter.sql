-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)


SELECT DISTINCT p. person_name
FROM person p
JOIN movie m ON m.director_id = p.person_id
JOIN collection c on c.collection_id = m.collection_id
WHERE c.collection_name = 'Harry Potter Collection'
ORDER BY p.person_name ASC;