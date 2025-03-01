/* Write your PL/SQL query statement below */
SELECT DISTINCT l1.num AS ConsecutiveNums
FROM logs l1, logs l2, logs l3
WHERE l1.id = l2.id + 1 
  AND l1.num = l2.num
  AND l1.id = l3.id + 2 
  AND l1.num = l3.num;