create procedure getTeamDetails(teamName text)
begin
	select concat(p.firstname," ",p.lastname) as fullname ,p.salary,r.role,t.mgrId
	from person p,roles r,team t
	where p.id = r.id
	and t.empId = p.id
	and t.name = teamName
	order by fullname asc;
end ;

call getTeamDetails("team 2");

drop procedure getTeamDetails;