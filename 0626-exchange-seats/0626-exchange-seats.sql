select b.id, a.student from Seat a, Seat b
where (mod(a.id,2)=1 and (a.id+1=b.id)) 
    or (mod(a.id,2)=0 and a.id-1=b.id) 
    or (mod(b.id,2)=1 and a.id = b.id 
        and b.id = (select count(*) from seat))
order by b.id