select r.contest_id, ROUND((COUNT(r.contest_id)/(select count(user_id) from users))*100.00,2) as percentage from Users u join Register r on u.user_id = r.user_id group by  r.contest_id order by  percentage DESC, r.contest_id  ;

