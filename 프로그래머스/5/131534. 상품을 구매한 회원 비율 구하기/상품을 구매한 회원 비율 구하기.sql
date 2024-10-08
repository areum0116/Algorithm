-- 코드를 입력하세요
SELECT YEAR(O.SALES_DATE) YEAR, MONTH(O.SALES_DATE) MONTH, COUNT(DISTINCT(U.USER_ID)) PURCHASED_USERS, 
ROUND(COUNT(DISTINCT(O.USER_ID)) / (SELECT COUNT(*) FROM USER_INFO WHERE YEAR(JOINED)=2021), 1) PUCHASED_RATIO
FROM USER_INFO U
JOIN ONLINE_SALE O
ON U.USER_ID = O.USER_ID
WHERE YEAR(U.JOINED) = 2021
GROUP BY 1, 2
ORDER BY 1, 2