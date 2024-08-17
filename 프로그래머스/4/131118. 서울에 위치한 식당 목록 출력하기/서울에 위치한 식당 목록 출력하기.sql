-- 코드를 입력하세요
SELECT I.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS,
ROUND(SUM(REVIEW_SCORE) / COUNT(REVIEW_SCORE), 2) SCORE
FROM REST_INFO I
JOIN REST_REVIEW R
ON I.REST_ID = R.REST_ID
WHERE SUBSTR(ADDRESS, 1, 2) = '서울'
GROUP BY 1
ORDER BY SCORE DESC, FAVORITES DESC