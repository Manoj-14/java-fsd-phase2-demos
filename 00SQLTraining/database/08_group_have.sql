select count(*) from person;


select salary, count(salary)
from person
group by salary;


select left(firstname,1) initial,salary,count(*),min(salary),max(salary)
from person
group by initial,salary;

select left(firstname,1) initial,salary,count(*),min(salary),max(salary)
from person
group by initial,salary
having salary>1000;


