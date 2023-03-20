use newdb;

select * from person
where salary=(
	select min(salary) 
	from person
)

select * from person
where salary in (
	select max(salary) 
	from person
)

-- exists clouse
select * from person p
where exists (
	select * from team t
	where p.id = t.empId
)
and salary >10000

select * from person p
where not exists (
	select * from team t
	where p.id = t.empId
)

--derrived tables
select max(salaryReport)
from(
	select p.firstname, count(*) salaryReport
	from person p
	group by p.firstname
)counts;