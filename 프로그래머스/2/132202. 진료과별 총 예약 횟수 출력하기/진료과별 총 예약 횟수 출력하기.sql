-- 코드를 입력하세요
SELECT mcdp_cd '진료과코드', count(*) '5월예약건수'
from appointment
where date_format(apnt_ymd, '%y%m') = 2205
group by 1
order by 2, 1
