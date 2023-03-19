use newdb;


create table person(
	id int AUTO_INCREMENT PRIMARY KEY,
	firstname varchar(30),
	lastname varchar(30),
	dob date,
	notes text(50),
	created timestamp DEFAULT CURRENT_TIMESTAMP
);

