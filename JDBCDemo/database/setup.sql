use newdb;

create table account(acc_no int,lastname varchar(30),firstname varchar(30),bal int);


insert into account values(12001,"Manoj","M",15000);
insert into account values(12002,"Shruthi","K S",15000);
insert into account values(12003,"Madhu","M",15000);

select * from account;