select t1.name as first_employee,
       t2.name as second_employee
from   employee as t1
join   employee as t2
on     t1.salary < t2.salary
order by t1.employee_id asc,
       t2.salary asc;