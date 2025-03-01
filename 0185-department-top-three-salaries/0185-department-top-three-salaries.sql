/* Write your PL/SQL query statement below */
select Department, Employee, salary
from
(select d.name Department, e.name Employee, salary, dense_rank() over(partition by e.departmentid  order by salary desc) rank
from employee e
join department d on e.departmentId = d.id)
where rank < 4