/* Write your PL/SQL query statement below */
SELECT distinct to_CHAR(SELL_DATE, 'YYYY-MM-DD') AS sell_date , COUNT(product) as num_sold  , 
LISTAGG( product, ',')
         WITHIN GROUP (ORDER BY sell_date) "products"
         from (SELECT DISTINCT SELL_DATE , PRODUCT FROM  activities) 
group by sell_date
order by sell_date;