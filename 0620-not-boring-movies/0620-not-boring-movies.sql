# Write your MySQL query statement below
SELECT * FROM Cinema c
WHERE c.id%2=1 && description<>'boring'
ORDER BY rating DESC;