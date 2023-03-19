use newdb;


select count(dob) from person where notes is not null;

select sum(salary) from person;

select max(salary) from person;

select min(salary) from person;

select min(firstname) from person;

select max(firstname) from person;
