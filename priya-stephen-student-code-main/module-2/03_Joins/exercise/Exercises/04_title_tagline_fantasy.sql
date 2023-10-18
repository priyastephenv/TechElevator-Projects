-- 4. The titles and taglines of all the movies that are in the Fantasy genre. 
-- Order the results by title (A-Z).
-- (81 rows)

SELECT movie.title, movie.tagline
FROM movie
JOIN movie_genre mg on movie.movie_id = mg.movie_id
JOIN genre ON genre.genre_id = mg.genre_id
WHERE genre_name = 'Fantasy'
ORDER BY movie.title;