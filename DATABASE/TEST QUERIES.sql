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

-- EXAMPLE QUERY BY supplier 'supplier@example.com'
SELECT c.*
FROM customer AS c
JOIN orders AS o ON o.customerId = c.customerId
JOIN orderproduct AS op ON op.orderId = o.orderId
JOIN product AS p ON p.productId = op.productId
JOIN productsupplier AS ps ON ps.productId = p.productId
JOIN supplier AS s ON s.supplierId = ps.supplierId
WHERE s.supEmail = 'supplier@example.com';

SELECT c.*
FROM customer AS c
JOIN orders AS o ON o.customerId = c.customerId
JOIN orderproduct AS op ON op.orderId = o.orderId
JOIN product AS p ON p.productId = op.productId
JOIN productsupplier AS ps ON ps.productId = p.productId
JOIN supplier AS s ON s.supplierId = ps.supplierId
WHERE s.supEmail = 'supplier2@example.com';

SELECT *
FROM orders
WHERE customerId = 120;


-- GET ALL PRODUCT FOR A SPECIFIC ORDER ID orderId153 is good
SELECT o.orderId,p.productId, p.productCatId, p.productName, p.productPrice,
       pc.catId AS productCategoryId, pc.productCat AS productCategoryName,
       o.orderId, o.quantity,
       c.customerId, c.fName AS customerFirstName, c.lName AS customerLastName,
       c.phoneNum AS customerPhoneNumber, c.shippingAddress AS customerShippingAddress, c.email AS customerEmail
FROM orders o
JOIN orderproduct op ON o.orderId = op.orderId
JOIN product p ON op.productId = p.productId
JOIN customer c ON o.customerId = c.customerId
JOIN productcategory pc ON p.productCatId = pc.catId;

-- add pproducts for order 153
INSERT INTO `product` (productCatId, productName, productPrice)
VALUES (1, 'Product 1', 10.99);

SET @productId1 = LAST_INSERT_ID();

INSERT INTO `product` (productCatId, productName, productPrice)
VALUES (1, 'Product 2', 15.99);

SET @productId2 = LAST_INSERT_ID();

INSERT INTO `orderproduct` (orderId, productId)
VALUES (153, @productId1);

INSERT INTO `orderproduct` (orderId, productId)
VALUES (153, @productId2);


