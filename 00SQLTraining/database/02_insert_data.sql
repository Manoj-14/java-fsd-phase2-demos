use newdb;


insert into person(firstname,lastname,dob,notes) values("Manoj","M","2001-08-14","Joined");
insert into person(firstname,lastname,dob,notes) values("Mohan","V","2001-10-23","Helll0");
insert into person(firstname,lastname,dob) values("Darshan","V","2002-03-18");
insert into person(firstname,lastname,dob,notes,salary) values("Karthik","G V","2001-08-14","Joined",15000);
insert into person(firstname,lastname,dob,notes,salary) values("Hemanth","R","2001-08-14","Joined",15000);
insert into person(firstname,lastname,dob,notes,salary) values("Sohan","G","2001-08-14","Joined",15000);

insert into roles values(1,"Team lead");
insert into roles values(2,"Tester");
insert into roles values(3,"Developer");
insert into roles values(4,"DevOps");
insert into roles values(5,"Scrum master");
insert into roles values(6,"Trinee");
insert into roles values(7,"Hr");


insert into manager(name) values("Manager 1");
insert into manager(name) values("Manager 2");
insert into manager(name) values("Manager 3");
insert into manager(name) values("Manager 4");

insert into team(name,empId,mgrId) values("team 1",1,1);
insert into team(name,empId,mgrId) values("team 1",3,1);
insert into team(name,empId,mgrId) values("team 1",7,1);


insert into team(name,empId,mgrId) values("team 2",2,3);
insert into team(name,empId,mgrId) values("team 2",4,3);
insert into team(name,empId,mgrId) values("team 2",6,3);

