# Write your MySQL query statement below
select E.name, B.bonus from Employee E LEFT outer JOIN Bonus B
on E.empId = B.empId
WHERE bonus<1000 or bonus IS NULL;