-- HotelReservations Database
ROLLBACK;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS address, reservation, hotel CASCADE;

CREATE TABLE address (
  id SERIAL PRIMARY KEY,
  address varchar(30) NOT NULL,
  address2 varchar(30), 
  city varchar(20) NOT NULL,
  state varchar(20) NOT NULL,
  zip varchar(10) NOT NULL
);


INSERT INTO address (address, city, state, zip) VALUES ('1111 W. 10th St', 'Cleveland', 'Ohio', '44115');
INSERT INTO address (address, city, state, zip) VALUES ('100 Lakeside Ave', 'Cleveland', 'Ohio', '44114');
INSERT INTO address (address, city, state, zip) VALUES ('2017 E 9th St', 'Cleveland', 'Ohio', '44115');
INSERT INTO address (address, city, state, zip) VALUES ('1000 Penn Ave', 'Pittsburgh', 'Pennsylvania', '15222');
INSERT INTO address (address, city, state, zip) VALUES ('401 N. High St', 'Columbus', 'Ohio', '43215');
INSERT INTO address (address, city, state, zip) VALUES ('5345 Medpace Way', 'Cincinnati', 'Ohio', '45202');
INSERT INTO address (address, city, state, zip) VALUES ('1200 St Antoine St', 'Detroit', 'Michigan', '48226');



CREATE TABLE hotel (
  hotel_id SERIAL PRIMARY KEY,
  name varchar(30) NOT NULL,
  address_id int NOT NULL, 
  stars int NOT NULL,
  rooms_available int NOT NULL,
  cost_per_night numeric(7,2) NOT NULL,
  cover_img varchar(40),
	CONSTRAINT fk_hotel_address FOREIGN KEY (address_id) REFERENCES address (id)
);

INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, cover_img) VALUES ('Aloft Cleveland', 1, 4, 48, 274.00, 'default-cover-image.png');
INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, cover_img) VALUES ('Hilton Cleveland Downtown', 2, 4, 12, 287.00, 'default-cover-image.png');
INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, cover_img) VALUES ('Metropolitan at the 9', 3, 5, 22, 319.00, 'default-cover-image.png');
INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, cover_img) VALUES ('The Westin Pittsburgh', 4, 4, 60, 131.00, 'default-cover-image.png');
INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, cover_img) VALUES ('Hilton Columbus Downtown', 5, 3, 34, 190.00, 'default-cover-image.png');
INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, cover_img) VALUES ('Summit a Dolce Hotel', 6, 4, 43, 218.00, 'default-cover-image.png');
INSERT INTO hotel (name, address_id, stars, rooms_available, cost_per_night, cover_img) VALUES ('Greektown Detroit', 7, 5, 77, 159.00, 'default-cover-image.png');



CREATE TABLE reservation (
  reservation_id SERIAL PRIMARY KEY,
  hotel_id int NOT NULL,
  full_name varchar(30) NOT NULL,
  checkin_date date,
  checkout_date date,
  guests int NOT NULL,
	CONSTRAINT fk_reservation_hotel FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
);

INSERT INTO reservation (hotel_id, full_name, checkin_date, checkout_date, guests) VALUES (1, 'John Smith', NOW(), now() + interval '3 days', 2);
INSERT INTO reservation (hotel_id, full_name, checkin_date, checkout_date, guests) VALUES (1, 'Sam Turner', NOW() + interval '5 days', now() + interval '10 days', 4);
INSERT INTO reservation (hotel_id, full_name, checkin_date, checkout_date, guests) VALUES (1, 'Mark Johnson', NOW() + interval '7 days', now() + interval '10 days', 2);

COMMIT;

SELECT *
FROM reservation
--SELECT * FROM address;
--SELECT * FROM hotel;
SELECT * FROM reservation;