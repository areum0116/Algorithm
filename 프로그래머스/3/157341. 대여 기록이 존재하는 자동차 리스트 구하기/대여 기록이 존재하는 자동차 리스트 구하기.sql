-- 코드를 입력하세요
SELECT distinct c.car_id
from car_rental_company_car c
join
CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on c.car_id = h.car_id
where car_type = '세단' and date_format(start_date, '%m') = 10
order by 1 desc
