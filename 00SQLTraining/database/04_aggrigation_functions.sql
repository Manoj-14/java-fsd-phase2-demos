use newdb;


select count(dob) from person where notes is not null;

select sum(salary) from person;

select max(salary) from person;

select min(salary) from person;

select min(firstname) from person;

select max(firstname) from person;

select * from person where left(firstname,1) = "M"
UNION ALL
select * from person where left(lastname,1) = "V"
ORDER BY firstname asc;

select id,firstname from person
union
select * from roles;
