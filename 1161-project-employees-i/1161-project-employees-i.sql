/* Write your PL/SQL query statement below */
select project_id, round(sum(experience_years)/count(*),2) as average_years from project join employee using (employee_id) group by project_id