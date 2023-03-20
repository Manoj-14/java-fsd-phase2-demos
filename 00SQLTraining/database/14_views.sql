create view peopleRole as
select concat(p.firstname," ",p.lastname) as Fullname,r.role as role 
from person p,roles r
where p.id = r.id ;


select * from peopleRole;

drop view peopleRole;