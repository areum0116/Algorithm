-- 코드를 입력하세요
SELECT PRICE_GROUP, count(1) PRODUCTS
from
(
select floor(price / 10000) * 10000 PRICE_GROUP
from product
) a
group by 1
order by 1