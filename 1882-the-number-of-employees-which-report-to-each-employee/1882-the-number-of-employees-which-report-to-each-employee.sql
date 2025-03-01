/* Write your PL/SQL query statement below */
select e.employee_id as employee_id, e.name , count(r.reports_to) as  reports_count , round(avg(r.age)) as average_age
from employees e
inner join employees r
on e.employee_id = r.reports_to
group by e.employee_id,e.name
order by e.employee_id;