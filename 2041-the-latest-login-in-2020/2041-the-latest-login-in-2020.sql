# Write your MySQL query statement below
SELECT user_id, CONVERT(MAX(time_stamp), char) AS last_stamp FROM Logins WHERE time_stamp LIKE '2020%' GROUP BY user_id ORDER BY TIME(MAX(time_stamp)) DESC;