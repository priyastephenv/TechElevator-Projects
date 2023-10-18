BEGIN TRANSACTION;

DROP TABLE IS EXISTS pet, pet_visit, pet_procedure;

-- Create tables
CREATE TABLE pet(
	pet_id serial PRIMARY KEY,		-- PRIMARY KEY
	name varchar(30),
	type varchar(20),
	birthday timestamp,
	owner varchar(100)	-- maybe split into own table?
);

CREATE TABLE pet_visit(
	invoice_id serial PRIMARY KEY,		-- PRIMARY KEY
	pet_id int,				-- FOREIGN KEY
	visit_date timestamp NOT NULL,
	procedure_id int,			-- FOREIGN KEY
	CONSTRAINT fk_visit_procedure
		FOREIGN KEY (procedure_id)
			REFERENCES pet_procedure(procedure_id),
	CONSTRAINT fk_visit_pet
		FOREIGN KEY (pet_id)
			REFERENCES pet(pet_id),
);

CREATE TABLE pet_procedure(
	procedure_id serial PRIMARY KEY,	-- PRIMARY KEY
	description varchar(100)
);

-- SET UP constraints and FOREIGN KEYS
-- after all tables are set up
ALTER TABLE pet_visit
	ADD CONSTRAINT fk_pet_visit_pet_id
		FOREIGN KEY(pet_id)
			REFERENCES pet(pet_id);

ALTER TABLE pet_visit
	ADD CONSTRAINT fk_pet_visit_pet_procedure
		FOREIGN KEY(procedure_id)
			REFERENCES pet_procedure(procedure_id);

ALTER TABLE pet
	ADD CONSTRAINT chk_pet_type
		CHECK(type IN ('Dog', 'Cat', 'Bird'));

COMMIT;

