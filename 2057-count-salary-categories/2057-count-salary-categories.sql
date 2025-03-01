/* Write your PL/SQL query statement below */
select 'Low Salary' as category , count(account_id) as  accounts_count from accounts where income <20000
union 
select 'Average Salary' as category , count(account_id) as  accounts_count from accounts where income between 20000 and 50000
union
select 'High Salary' as category , count(account_id) as  accounts_count from accounts where income > 50000;