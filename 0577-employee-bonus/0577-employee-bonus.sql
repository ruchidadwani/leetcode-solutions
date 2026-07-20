# Write your MySQL query statement below
SELECT E.name, B.bonus FROM Employee E LEFT OUTER JOIN Bonus B
ON E.empId = B.empId
WHERE bonus<1000 OR bonus IS NULL;