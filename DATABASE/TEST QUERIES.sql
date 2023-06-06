-- QUERIES TEST SUPPLIER 102 LIST OF CUSTOMERS

SELECT c.*
FROM customer c
JOIN orders o ON c.customerId = o.customerId
JOIN orderproduct op ON o.orderId = op.orderId
JOIN product p ON op.productId = p.productId
JOIN productsupplier ps ON p.productId = ps.productId
WHERE ps.supplierId = 102;


-- QUERY TO TEST PRODUCT BY ORDER
SELECT p.*, o.orderId
FROM product p
JOIN orderProduct op ON p.productId = op.productId
JOIN orders o ON o.orderId = op.orderId
WHERE op.orderId = o.orderId;
