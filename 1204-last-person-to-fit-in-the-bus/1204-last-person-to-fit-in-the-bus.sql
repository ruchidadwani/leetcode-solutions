# Write your MySQL query statement below
SELECT person_name
FROM (
    SELECT person_name, turn, SUM(weight) OVER(ORDER BY turn) AS Total_weight FROM Queue
)AS q
WHERE Total_weight<=1000
ORDER BY turn DESC
LIMIT 1;