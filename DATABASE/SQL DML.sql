-- shopping cart DML

-- Insert data into the customer table
INSERT INTO customer (customerId, fName, lName, phoneNum, shippingAddress, email)
VALUES
  (1, 'John', 'Doe', '1234567890', '123 Main St', 'john@example.com'),
  (2, 'Jane', 'Smith', '9876543210', '456 Elm St', 'jane@example.com');

-- Insert data into the orders table
INSERT INTO orders (orderId, quantity, productId, customerId)
VALUES
  (1, 2, 1, 1),
  (2, 1, 2, 2),
  (3, 3, 3, 1);

-- Insert data into the product table
INSERT INTO product (productId, productCatId)
VALUES
  (1, 1, "prod1"),
  (2, 2, "prod2"),
  (3, 1, "prod3"),
  (4, 2, "prod4");

-- Insert data into the productCategory table
INSERT INTO productCategory (catId, productCat)
VALUES
  (1, 'Electronics'),
  (2, 'Clothing');

-- Insert data into the supplier table
INSERT INTO supplier (supplierId, supPhoneNum, supEmail)
VALUES
  (1, 987654321, 'supplier1@example.com'),
  (2, 123456789, 'supplier2@example.com');

-- Insert data into the orderProduct table
INSERT INTO orderProduct (orderId, productId)
VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (3, 4),
  (3, 1);

-- Insert data into the productSupplier table
INSERT INTO productSupplier (productId, supplierId)
VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (3, 2),
  (4, 1);
