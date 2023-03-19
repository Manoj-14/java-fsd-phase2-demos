select * from person p,roles r,team t
where p.id=r.id
and t.empId = p.id;