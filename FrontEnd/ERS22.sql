DROP TABLE roles22 CASCADE;
DROP TABLE type22 CASCADE;
DROP TABLE expense22 CASCADE;
DROP TABLE status22 CASCADE;
DROP TABLE users22 CASCADE;

CREATE TABLE roles22 (
	ers_user_role_id  INTEGER PRIMARY KEY,  
	user_role VARCHAR(20));

INSERT INTO roles22 (ers_user_role_id, user_role)
	VALUES (1, 'Finance Manager'),
	(2, 'salesman'),
	(3, 'Director'),
	(4, 'engineer');

SELECT * FROM roles22;
	 

CREATE TABLE type (
	reimb_type_id  INTEGER PRIMARY KEY,  
	reimb_type VARCHAR(20));

INSERT INTO type (reimb_type_id, reimb_type)
	VALUES (1, 'Food'),
	(2, 'Airfare'),
	(3, 'Lodging'),
	(4, 'Transportation'),
	(5, 'Other');

SELECT * FROM type;


CREATE TABLE status (
	reimb_status_id  INTEGER PRIMARY KEY,  
	reimb_status VARCHAR(20));

INSERT INTO status (reimb_status_id, reimb_status)
	VALUES (1, 'Submitted'),
	(2, 'Under Review'),
	(3, 'Accepted'),
	(4, 'Declined');

SELECT * FROM status;
 
CREATE TABLE users (
	ers_users_id  SERIAL PRIMARY KEY,  
	ers_username VARCHAR(50),
	ers_password VARCHAR(50),
	user_first_name VARCHAR(100),
	user_last_name VARCHAR(100),
	user_email VARCHAR(150),
	user_role_id INTEGER REFERENCES roles(ers_user_role_id));

INSERT INTO users (ers_username, ers_password, user_first_name,
	user_last_name, user_email, user_role_id)
	VALUES ('johnsmith','password1','John','Smith','johnsmith@revature.net',1),
	('janedoe','password2','Jane','Doe','janeDoe@revature.net',2),
	('kevinsmith','password3','Kevin','Smith','kevinsmith@revature.net',3),
	('kathysmith','password4','Kathy','Smith','kathysmith@revature.net',4),
	('madhacker','password5','Mad','Hacker','madhacker@gmail.com',4);

SELECT * FROM users;
 
CREATE TABLE expense22 (   
	reimb_id  SERIAL PRIMARY KEY,       
	reimb_amount DECIMAL,
	reimb_submitted date,
	reimb_resolved date,
	reimb_description VARCHAR(100),
	reimb_author INTEGER REFERENCES users(ers_users_id),
	reimb_resolver INTEGER REFERENCES roles(ers_user_role_id),
	reimb_status_id INTEGER REFERENCES status(reimb_status_id),
	reimb_type_id INTEGER REFERENCES type(reimb_type_id));

INSERT INTO expense22 (reimb_amount,reimb_submitted,reimb_resolved,reimb_description,
		reimb_author,reimb_resolver,reimb_status_id,reimb_type_id)
	VALUES (110.55, '2021-06-01', '2021-06-04', 'moving expense', 1,1,1,4),
		   (535.57, '2021-06-02', '2021-06-04','new computer', 2,1,1,1),
		   (200.00, '2021-06-04', '2021-06-04','client onsite', 3,1,4,5),
		   (150.55, '2021-06-05', '2021-06-06','client onsite', 3,3,2,4),
		   (600.75, '2021-06-15', '2021-06-16','onsite support', 4,1,3,2),
		   (300.45, '2021-06-17', '2021-06-18','phone support', 2,1,4,4),
		   (500.00, '2021-07-01', '2021-07-02','moving expense', 5,1,4,3);
				
SELECT * FROM expense22;
SELECT * FROM expense;


 