use newdb;

create table Employee(
	Eid int PRIMARY KEY,
	Ename varchar(30),
	Age int,
	Password varchar(30)
);

select * from employee