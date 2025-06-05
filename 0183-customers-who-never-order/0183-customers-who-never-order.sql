# Write your MySQL query statement below
select c.name as customers from Customers c LEFT JOIN Orders o ON c.id=o.customerId where o.id is null;