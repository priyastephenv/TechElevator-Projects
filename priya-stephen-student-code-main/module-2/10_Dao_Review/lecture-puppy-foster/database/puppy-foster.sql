--  Database for shelters

BEGIN TRANSACTION;

DROP TABLE IF EXISTS puppy, shelter;

CREATE TABLE shelter (
    shelter_id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
    address varchar(50) NOT NULL,
    phone_number text NOT NULL,
    primary_contact varchar(50) NOT NULL
);

CREATE TABLE puppy (
    puppy_id serial PRIMARY KEY,
    shelter_id int NOT NULL,
    puppy_name varchar(30) NOT NULL,
    weight_lbs int CHECK (weight_lbs > 0),
    gender varchar(10),
    breed varchar(50) NOT NULL,
    is_fostered boolean,
    image_url varchar(300)
);

ALTER TABLE puppy
    ADD CONSTRAINT fk_puppy_shelter
        FOREIGN KEY (shelter_id)
            REFERENCES shelter(shelter_id);

INSERT INTO shelter
(name, address, phone_number, primary_contact)
VALUES
('Happy Paws Shelter', '42 Everything lane', '555-123-4567', 'Deep Thought'),
('Furry Friends Haven', '123 McLaren St', '555-987-6543', 'Polly Owl');

INSERT INTO puppy
(puppy_name, shelter_id, weight_lbs, gender, breed, is_fostered, image_url)
VALUES
('Snoopy', (
    SELECT shelter_id FROM shelter WHERE name = 'Happy Paws Shelter'
), 25, 'male', 'Beagle', false, 'https://images.fineartamerica.com/images/artworkimages/mediumlarge/3/snoopy-free-jala-udin.jpg'),

('Clifford', (
    SELECT shelter_id FROM shelter WHERE name = 'Happy Paws Shelter'
), 2500, 'male', 'Red Labrador', false, 'https://www.kindpng.com/picc/m/425-4251348_clifford-the-big-red-dog-hd-png-download.png'),

('Katy', (
    SELECT shelter_id FROM shelter WHERE name = 'Happy Paws Shelter'
), 45, 'female', 'Pit Mix', false, 'https://cdn.pixabay.com/photo/2016/03/25/02/24/cute-1278095__340.jpg'),

('Proton', (
    SELECT shelter_id FROM shelter WHERE name = 'Furry Friends Haven'
), 35, 'male', 'Corgi', false, 'https://i.pinimg.com/originals/39/ea/2e/39ea2ef9c74c127ffba4bc4ec4f1a9bc.jpg'),

('Webster', (
    SELECT shelter_id FROM shelter WHERE name = 'Furry Friends Haven'
), 102, 'male', 'Yellow Labrador', false, 'https://thumbs.dreamstime.com/b/yellow-lab-puppy-12131907.jpg'),

('Rosie', (
    SELECT shelter_id FROM shelter WHERE name = 'Furry Friends Haven'
), 20, 'female', 'Golden Doodle', false, 'https://happytailpuppies.com/cdn/shop/files/Mini_Goldendoodle_1080x.png?v=1643389463');


COMMIT;
