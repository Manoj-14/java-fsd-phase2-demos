select p.firstname,m.name
from person p,team r,manager m
where p.id = r.empId
and r.mgrId = m.id;

select * from person p
left join person m
on p.id = m.id;