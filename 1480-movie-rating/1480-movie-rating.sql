select name results from (
select u.name,count(rating) cr from
movierating r inner join users u on  r.user_id=u.user_id
group by name order by cr desc,name)
where rownum=1

union all

select title from(
select title,avg(rating) ar from(
select 
r.*,
extract(month  from r.created_at) mn,
extract(year from r.created_at) yr, m.title 
from 
movierating r inner join movies m on  r.movie_id=m.movie_id
where 
extract(month  from r.created_at)=2 and
extract(year  from r.created_at)=2020)
group by title order by 2 desc ,1)
where rownum=1