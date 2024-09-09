SELECT month(start_date) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE month(start_date) BETWEEN 8 AND 10 AND
car_id IN
(
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE month(start_date) BETWEEN 8 AND 10  
    GROUP BY car_id
    HAVING COUNT(*) > 4
)
GROUP BY car_id, month
ORDER BY month, car_id DESC