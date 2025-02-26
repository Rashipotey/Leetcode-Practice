/* Write your PL/SQL query statement below */
select class from(select count(student) as s,class from courses group by class)where s>4;