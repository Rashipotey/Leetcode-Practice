# Write your MySQL query statement below
select e1.name as employee from Employee e1, Employee e2 where e1.managerId=e2.id AND e1.salary>e2.salary;