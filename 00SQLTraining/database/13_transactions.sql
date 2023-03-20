use newdb;

select * from person;

start transaction;
update person set salary =10000 where id = 4 ;

rollback;
commit;