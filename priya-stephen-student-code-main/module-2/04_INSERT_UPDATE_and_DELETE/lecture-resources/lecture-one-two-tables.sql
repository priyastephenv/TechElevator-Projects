BEGIN TRANSACTION;

DROP TABLE IF EXISTS one, two;

CREATE TABLE one(
	num int,
	description VARCHAR(30)
);

CREATE TABLE two(
	num int,
	description VARCHAR(30)
);

INSERT INTO one
(num, description)
VALUES
(100, 'ONE - 100'),
(101, 'ONE - 101'),
(102, 'ONE - 102'),
(103, 'ONE - 103'),
(104, 'ONE - 104'),
(105, 'ONE - 105'),
(990, 'ONE-BOTH - 990'),
(991, 'ONE-BOTH - 991'),
(992, 'ONE-BOTH - 993'),
(993, 'ONE-BOTH - 994'),
(994, 'ONE-BOTH - 995');

INSERT INTO two
(num, description)
VALUES
(200, 'ONE - 200'),
(201, 'ONE - 201'),
(202, 'ONE - 202'),
(203, 'ONE - 203'),
(204, 'ONE - 204'),
(205, 'ONE - 205'),
(990, 'TWO-BOTH - 990'),
(991, 'TWO-BOTH - 991'),
(992, 'TWO-BOTH - 993'),
(993, 'TWO-BOTH - 994'),
(994, 'TWO-BOTH - 995');

COMMIT;


SELECT *
FROM one
FULL OUTER JOIN two ON one.num = two.num;







