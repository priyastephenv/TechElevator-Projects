BEGIN TRANSACTION;

DROP TABLE IF EXISTS customer, purchase, art, artist;

CREATE TABLE customer(
	customer_id serial PRIMARY KEY, 	-- primary key
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	address varchar(100),	-- default value
	phone_number varchar(12) NOT NULL
);

-- Must be before purchase table is created because
-- of foreign key constraints reference this table
CREATE TABLE art(
	art_code varchar(12) PRIMARY KEY,	-- primary key
	title varchar(100),
	artist_id int				-- foreign key
);

CREATE TABLE purchase(
	customer_id int,
	art_code varchar(12),
	purchase_date timestamp,
	price numeric(12,2),
	CONSTRAINT pk_purchase
		PRIMARY KEY(customer_id, art_code, purchase_date),
	CONSTRAINT fk_customer_id_purchase
		FOREIGN KEY(customer_id)
			REFERENCES customer(customer_id),
	CONSTRAINT fk_art_code_purchase
		FOREIGN KEY(art_code)
			REFERENCES art(art_code)
);

CREATE TABLE artist(
	artist_id serial PRIMARY KEY,	-- primary key
	first_name varchar(50),
	last_name varchar(50)
);


-- ALTER TABLE after all tables are created
-- so there won't be an issue with a table
-- not being created yet
ALTER TABLE art
	ADD CONSTRAINT fk_artist_id
		FOREIGN KEY(artist_id)
			REFERENCES artist(artist_id);


COMMIT;
