select substr(product_code, 1, 2) category, count(*)
from product
group by 1
order by 1