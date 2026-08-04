# Write your MySQL query statement below
SELECT P.product_id, IFNULL(ROUND(SUM(P.price * U.units) / SUM(u.units), 2), 0) AS average_price FROM Prices P LEFT JOIN UnitsSold U
ON P.product_id = U.product_id AND U.purchase_date BETWEEN P.start_date AND p.END_DATE
GROUP BY P.product_id;