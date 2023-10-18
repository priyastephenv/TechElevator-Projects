-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)

SELECT genre_name
FROM genre
JOIN movie_genre mg ON mg.genre_id = genre.genre_id
JOIN movie on mg.movie_id = movie.movie_id
WHERE movie.title = 'The Wizard of Oz'
ORDER BY genre.genre_name ASC;