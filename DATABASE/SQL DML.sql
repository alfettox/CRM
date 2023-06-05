-- Giovanni De Franceschi, Abdullah Tariq, Riyad Argoub
-- WILEY EDGE - FINAL PROJECT - SHOPPING CART APP FULL STACK

TRUNCATE TABLE orderProduct;
TRUNCATE TABLE productSupplier;
TRUNCATE TABLE orders;
TRUNCATE TABLE customer;
TRUNCATE TABLE product;
TRUNCATE TABLE productCategory;
TRUNCATE TABLE supplier;

-- Insert data into the productCategory table
INSERT INTO productCategory (catId, productCat)
VALUES
  (1, 'Electronics'),
  (2, 'Clothing');

-- Insert data into the supplier table
INSERT INTO supplier (supplierId, supPhoneNum, supEmail)
VALUES
  (1, '987654321', 'supplier1@example.com'),
  (2, '123456789', 'supplier2@example.com');


-- Insert data into the customer table
INSERT INTO customer (customerId, fName, lName, phoneNum, shippingAddress, email)
VALUES
  (3, 'Mark', 'Johnson', '5551234567', '789 Oak St', 'mark.johnson@gmail.com'),
  (4, 'Emily', 'Davis', '5559876543', '987 Maple Ave', 'emily.davis@yahoo.com'),
  (5, 'Michael', 'Wilson', '5552345678', '654 Pine Rd', 'michael.wilson@hotmail.com'),
  (6, 'Jessica', 'Brown', '5558765432', '321 Cedar Ln', 'jessica.brown@gmail.com'),
  (7, 'David', 'Taylor', '5553456789', '234 Walnut Dr', 'david.taylor@yahoo.com'),
  (8, 'Sarah', 'Anderson', '5557654321', '876 Elm Ct', 'sarah.anderson@hotmail.com'),
  (9, 'Matthew', 'Clark', '5554567890', '567 Oak St', 'matthew.clark@gmail.com'),
  (10, 'Olivia', 'Martin', '5558901234', '123 Cedar Ln', 'olivia.martin@yahoo.com');

-- Insert data into the product table
INSERT INTO product (productId, productCatId, productName, productPrice)
VALUES
  (5, 2, 'Laptop', 999.99),
  (6, 1, 'T-Shirt', 19.99),
  (7, 2, 'Headphones', 79.99),
  (8, 1, 'Jeans', 49.99),
  (9, 2, 'Smartphone', 699.99),
  (10, 1, 'Dress', 59.99),
  (11, 2, 'Camera', 599.99),
  (12, 1, 'Shoes', 79.99),
  (13, 2, 'Tablet', 499.99),
  (14, 1, 'Watch', 199.99);

-- Insert data into the orders table
INSERT INTO orders (orderId, quantity, productId, customerId)
VALUES
  (4, 2, 5, 3),
  (5, 3, 6, 4),
  (6, 1, 7, 5),
  (7, 4, 8, 6),
  (8, 2, 9, 7),
  (9, 3, 10, 8),
  (10, 1, 11, 9),
  (11, 2, 12, 10),
  (12, 3, 13, 3),
  (13, 1, 14, 4);


-- Insert data into the orderProduct table
INSERT INTO orderProduct (orderId, productId)
VALUES
  (4, 5),
  (4, 6),
  (5, 7),
  (6, 8),
  (7, 5),
  (8, 6),
  (9, 7),
  (10, 8),
  (11, 5),
  (12, 6),
  (13, 7),
  (13, 8);

-- Insert data into the productSupplier table
INSERT INTO productSupplier (productId, supplierId)
VALUES
  (5, 1),
  (5, 2),
  (6, 1),
  (6, 2),
  (7, 1),
  (7, 2),
  (8, 1),
  (8, 2),
  (9, 1),
  (9, 2),
  (10, 1),
  (10, 2),
  (11, 1),
  (11, 2),
  (12, 1),
  (12, 2),
  (13, 1),
  (13, 2),
  (14, 1),
  (14, 2);
