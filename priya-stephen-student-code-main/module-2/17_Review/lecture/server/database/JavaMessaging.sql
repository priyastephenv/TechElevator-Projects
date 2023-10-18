BEGIN TRANSACTION;

DROP TABLE IF EXISTS app_user, message_type, message;

DROP SEQUENCE IF EXISTS seq_user_id, seq_message_id;

-- Sequence to start user_id values at 1001 instead of 1
CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE app_user (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_app_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

-- Sequence to start account_id values at 2001 instead of 1
-- Note: Use similar sequences with unique starting values for additional tables


CREATE TABLE message_type (
	message_type_id serial NOT NULL,
	message_type_desc varchar(10) NOT NULL,
	CONSTRAINT PK_message_type PRIMARY KEY (message_type_id)
);

CREATE SEQUENCE seq_message_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;

CREATE TABLE message (
  message_id int NOT NULL DEFAULT nextval('seq_message_id'),
  message_type_id int NOT NULL,
  sender_name varchar(32) NOT NULL,
  private boolean NOT NULL DEFAULT FALSE,
  receiver_name varchar(32),
  message_text varchar(200) NOT NULL,
  CONSTRAINT pk_message_message_id PRIMARY KEY (message_id),
  CONSTRAINT FK_message_sender_name FOREIGN KEY (sender_name) REFERENCES app_user (username),
  CONSTRAINT FK_message_receiver_name FOREIGN KEY (receiver_name) REFERENCES app_user (username),
  CONSTRAINT FK_message_message_type FOREIGN KEY (message_type_id) REFERENCES message_type (message_type_id)
);


INSERT INTO message_type (message_type_desc) VALUES ('Receive');
INSERT INTO message_type (message_type_desc) VALUES ('Send');

COMMIT;
