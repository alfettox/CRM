-- Giovanni De Franceschi
-- WILEY EDGE - FINAL PROJECT - SHOPPING CART APP FULL STACK

TRUNCATE TABLE orderProduct;
TRUNCATE TABLE productSupplier;
TRUNCATE TABLE orders;
TRUNCATE TABLE customer;
TRUNCATE TABLE product;
TRUNCATE TABLE productCategory;
TRUNCATE TABLE supplier;
-- Inserting into `productcategory`
INSERT INTO `productcategory` (`productCat`, `catImage`)
VALUES ('Electronics', NULL),
       ('Clothing', NULL),
       ('Books', NULL),
       ('Home Appliances', NULL),
       ('Beauty', NULL),
       ('Toys', NULL),
       ('Sports', NULL),
       ('Furniture', NULL),
       ('Jewelry', NULL),
       ('Food', NULL);

-- Inserting into `supplier`
INSERT INTO `supplier` (`supPhoneNum`, `supEmail`)
VALUES (123456789, 'supplier1@example.com'),
       (234567890, 'supplier2@example.com'),
       (345678901, 'supplier3@example.com'),
       (456789012, 'supplier4@example.com'),
       (567890123, 'supplier5@example.com'),
       (678901234, 'supplier6@example.com'),
       (789012345, 'supplier7@example.com'),
       (890123456, 'supplier8@example.com'),
       (901234567, 'supplier9@example.com'),
       (123456780, 'supplier10@example.com');

-- Inserting into `product`
INSERT INTO `product` (`productCatId`, `productName`, `productPrice`)
VALUES (1, 'TV', 999.99),
       (2, 'T-Shirt', 19.99),
       (3, 'Novel', 9.99),
       (4, 'Refrigerator', 1499.99),
       (5, 'Lipstick', 14.99),
       (6, 'Action Figure', 24.99),
       (7, 'Soccer Ball', 19.99),
       (8, 'Armchair', 199.99),
       (9, 'Necklace', 49.99),
       (10, 'Chocolate', 5.99);

-- Inserting into `customer`
INSERT INTO `customer` (`fName`, `lName`, `phoneNum`, `shippingAddress`, `email`)
VALUES ('John', 'Doe', '1234567890', '123 Main St', 'john.doe@example.com'),
       ('Jane', 'Smith', '2345678901', '456 Elm St', 'jane.smith@example.com'),
       ('Michael', 'Johnson', '3456789012', '789 Oak St', 'michael.johnson@example.com'),
       ('Emily', 'Brown', '4567890123', '987 Pine St', 'emily.brown@example.com'),
       ('Daniel', 'Miller', '5678901234', '654 Cedar St', 'daniel.miller@example.com'),
       ('Olivia', 'Davis', '6789012345', '321 Birch St', 'olivia.davis@example.com'),
       ('William', 'Wilson', '7890123456', '159 Maple St', 'william.wilson@example.com'),
       ('Sophia', 'Anderson', '8901234567', '753 Spruce St', 'sophia.anderson@example.com'),
       ('James', 'Taylor', '9012345678', '951 Walnut St', 'james.taylor@example.com'),
       ('Isabella', 'Thomas', '1234567809', '357 Cherry St', 'isabella.thomas@example.com');

-- Inserting into `orders`
INSERT INTO `orders` (`quantity`, `customerId`)
VALUES (1, 120),(2, 121),
       (3, 122),
       (4, 123),
       (5, 124),
       (6, 125),
       (7, 126),
       (8, 127),
       (9, 128),
       (10, 129);

-- Inserting into `orderproduct`
INSERT INTO `orderproduct` (`orderId`, `productId`)
VALUES (153, 100),
       (154, 101),
       (155, 102),
       (156, 103),
       (157, 104),
       (158, 105),
       (159, 106),
       (160, 107),
       (161, 108),
       (162, 109);

-- Inserting into `productsupplier`
INSERT INTO `productsupplier` (`productId`, `supplierId`)
VALUES (100, 100),
       (101, 101),
       (102, 102),
       (103, 103),
       (104, 104),
       (105, 105),
       (106, 106),
       (107, 107),
       (108, 108),
       (109, 109);

-- ALTER CUSTOMER TABLE TO STORE A RANDOM SERIES OF COST VALUES
ALTER TABLE customer
ADD COLUMN totalCost DECIMAL(10, 2);

UPDATE customer
SET totalCost = FLOOR(RAND() * (150 - 3 + 1) + 3);
