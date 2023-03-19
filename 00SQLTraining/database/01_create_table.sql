use newdb;


create table person(
	id int AUTO_INCREMENT PRIMARY KEY,
	firstname varchar(30),
	lastname varchar(30),
	dob date,
	notes text(50),
	created timestamp DEFAULT CURRENT_TIMESTAMP
);

create table Roles(
	id int ,
	role varchar(30),
	foreign key (id) REFERENCES Person(id)
);
