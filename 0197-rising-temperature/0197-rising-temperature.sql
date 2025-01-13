# Write your MySQL query statement below
select y.id from Weather x, Weather y where DATEDIFF(y.recordDate, x.recordDate)=1 and y.temperature>x.temperature;