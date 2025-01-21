/* Write your PL/SQL query statement below */
SELECT name FROM Employee WHERE id IN(SELECT  managerID FROM Employee GROUP BY managerId HAVING COUNT(*)>=5);