# Write your MySQL query statement below
SELECT * FROM PRODUCTS WHERE DESCRIPTION REGEXP '(^|[^A-Za-z])SN[0-9]{4}-[0-9]{4}([^0-9]|$)' ORDER BY PRODUCT_ID;