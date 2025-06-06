# Write your MySQL query statement below
select id, SUM(if(month='Jan', revenue, null)) as Jan_Revenue, 
SUM(if(month='Feb', revenue, null)) as Feb_Revenue, 
SUM(if(month='Mar', revenue, null)) as Mar_Revenue, 
SUM(if(month='Apr', revenue, null)) as Apr_Revenue, 
SUM(if(month='May', revenue, null)) as May_Revenue, 
SUM(if(month='Jun', revenue, null)) as Jun_Revenue, 
SUM(if(month='Jul', revenue, null)) as Jul_Revenue, 
SUM(if(month='Aug', revenue, null)) as Aug_Revenue, 
SUM(if(month='Sep', revenue, null)) as Sep_Revenue, 
SUM(if(month='Oct', revenue, null)) as Oct_Revenue, 
SUM(if(month='Nov', revenue, null)) as Nov_Revenue, 
SUM(if(month='Dec', revenue, null)) as Dec_Revenue
from Department group by id;