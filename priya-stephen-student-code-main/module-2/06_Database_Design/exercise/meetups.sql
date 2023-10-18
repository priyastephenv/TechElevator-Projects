BEGIN TRANSACTION;

DROP TABLE IF EXISTS member, groups, event, member_group, event_member;

CREATE TABLE member (
	member_id int NOT NULL,
	last_name varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	phone_number int,
	DOB date NOT NULL,
	HasReminders boolean NOT NULL,
	CONSTRAINT PK_member_id PRIMARY KEY(member_id)
);


CREATE TABLE groups (
	group_id int NOT NULL, 	
	group_name varchar (50) NOT NULL,
	CONSTRAINT PK_group_id PRIMARY KEY(group_id),
	CONSTRAINT UQ_group_name UNIQUE(group_name)
);

CREATE TABLE event (
	event_id int NOT NULL,
	event_name varchar(50) NOT NULL,
	description varchar(500) NOT NULL,
	date_time timestamp NOT NULL,
	duration int,
	group_id int NOT NULL,
	CONSTRAINT PK_event_id PRIMARY KEY(event_id),
	CONSTRAINT CHK_duration CHECK (duration >= 30)
);

CREATE TABLE member_group (
	member_id int NOT NULL,
	group_id int NOT NULL,
	CONSTRAINT PK_member_group PRIMARY KEY(member_id, group_id)
);


CREATE TABLE event_member (
	event_id int NOT NULL,
	member_id int NOT NULL,
	CONSTRAINT PK_event_member PRIMARY KEY(event_id, member_id)
);

INSERT INTO member( member_id, last_name, first_name, email, DOB, HasReminders)
VALUES (1, 'Varghese', 'Viv', 'viv.varghese@gmail.com',  '1996-02-19', true),
	   (2, 'Stephen', 'Tara', 'tara.stephen@gmail.com', '1994-11-23', true ),
	   ( 3, 'Grisby', 'Clay', 'clay.grisby@gmail.com', '1996-03-09', true),
	   ( 4, 'Dame', 'Zay', 'zay.dame@gmail.com', '1997-12-05', false),
	   (5, 'Barsotti', 'Ziva', 'ziva.barsotti@gmail.com', '1998-03-04', false),
	   (6, 'Bois', 'Gwen', 'gwen.bois@gmail.com', '1996-08-05', false),
	   (7, 'Li', 'Alice', 'alice.li@gmail.com', '1996-04-20', true),
	   (8, 'Giang', 'Jen', 'jen.giang@gmail.com', '1998-08-08', true);
	  
INSERT INTO groups( group_id,group_name )
VALUES (1, 'UC Alums'),
	   (2, 'Vermonters'),
	   (3, 'New Yorkers');

INSERT INTO event( event_id, event_name, description, date_time, duration, group_id)
VALUES (1, 'Why Not Move?', 'Convincing everyone to move to New York','2023-11-02 08:00:00', 600, 3 ),
	   (2, 'Everywhere Is Just Burlington', 'Comparing different cities to Burlington, VT','2023-10-25 16:00:00', 60, 2 ),
	   (3, 'Sports Are Hard, But We Must Play Them','Viv getting on my nerves about Sports', '2023-11-25 12:00:00', 180, 1 ),
	   (4, 'I Went Abroad Once And Now I Am Insufferable', 'How to be annoying after going to Spain once', '2023-12-02 10:00:00 EST',300, 1);
	   
INSERT INTO member_group (member_id, group_id)
VALUES 	(1,2),
		(2,1),
		(3,1),
		(3,2),
		(4,2),
		(5,1),
		(5,3),
		(6,3),
		(7,3);
		
INSERT INTO event_member (event_id, member_id)
VALUES (4,1),
	   (3,2),
	   (4,2),
	   (1,3),
	   (2,3),
	   (3,3),
	   (4,3),
	   (1,4),
	   (2,4),
	   (4,4),
	   (1,5),
	   (2,5),
	   (4,5),
	   (1,6),
	   (4,6),
	   (1,7),
	   (4,7),
	   (4,8);
	   
	   ALTER TABLE event ADD CONSTRAINT FK_group_id FOREIGN KEY(group_id) REFERENCES groups(group_id);

  
COMMIT;