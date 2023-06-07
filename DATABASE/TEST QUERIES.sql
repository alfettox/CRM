-- QUERIES TEST SUPPLIER 102 LIST OF CUSTOMERS

SELECT c.*
FROM customer c
JOIN orders o ON c.customerId = o.customerId
JOIN orderproduct op ON o.orderId = op.orderId
JOIN product p ON op.productId = p.productId
JOIN productsupplier ps ON p.productId = ps.productId
WHERE ps.supplierId = 102;

-- ALTER ADDRESS customer 158
UPDATE customer
SET shippingAddress = '123 Main Street, Montreal, QC, H3A 1A1'
WHERE customerId = 158;



