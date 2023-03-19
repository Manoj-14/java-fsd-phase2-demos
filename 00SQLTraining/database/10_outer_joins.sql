select * from person p
inner join roles r
on p.id = r.id;

select * from person p
inner join roles r
on p.id = r.id
where notes is not null;

select * from person p
left join roles r
on p.id = r.id
where notes is not null;

select * from team t
right join person p
on p.id = t.empId
where p.notes is not null;