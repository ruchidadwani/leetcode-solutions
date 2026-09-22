# Write your MySQL query statement below
/*SELECT name FROM Employee
WHERE id IN(
SELECT managerId from Employee GROUP BY managerId HAVING COUNT(id)>=5);
*/
SELECT E1.name FROM Employee E1 INNER JOIN Employee E2
ON E1.id = E2.managerId
GROUP BY E2.managerId
HAVING COUNT(E2.managerId) >=5;