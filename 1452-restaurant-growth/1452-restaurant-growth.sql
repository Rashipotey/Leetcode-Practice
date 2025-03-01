/* Write your PL/SQL query statement below */
select to_char(visited_on) as visited_on, amount, round((amount/7),2) as average_amount from 
                (
               select distinct visited_on,
               sum(amount) over(order by visited_on range between interval '6' day preceding and current row )as  amount,
                    min(visited_on) over() as fstdate
                    from customer
                ) ready
                where visited_on>=fstdate+6;
                order by visited_on;