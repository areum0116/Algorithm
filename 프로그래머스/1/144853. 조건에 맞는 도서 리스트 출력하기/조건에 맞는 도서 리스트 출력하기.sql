-- 코드를 입력하세요
SELECT book_id, date_format(published_date, '%Y-%m-%d')
from book
where date_format(published_date, '%y') = 21 and category = '인문'
order by 2