/* Write your PL/SQL query statement below */
select round(sum(tiv_2016),2) tiv_2016 from insurance i1
where 1 = (select count(lat||'#'||lon) from insurance i2 where i2.lat=i1.lat and i1.lon=i2.lon)
and 1 < (select count(tiv_2015) from insurance i3 where i3.tiv_2015=i1.tiv_2015)