-- Giovanni De Franceschi, Abdullah Tariq, Riyad Argoub
-- WILEY EDGE - FINAL PROJECT - SHOPPING CART APP FULL STACK

DROP DATABASE IF EXISTS shoppingcart;
CREATE DATABASE shoppingcart;
USE shoppingcart;

CREATE TABLE productCategory (
  catId INT PRIMARY KEY,
  productCat VARCHAR(40),
  catImage BLOB
);

CREATE TABLE supplier (
  supplierId INT PRIMARY KEY,
  supPhoneNum INT,
  supEmail VARCHAR(40)
);

CREATE TABLE customer (
  customerId INT,
  fName VARCHAR(50),
  lName VARCHAR(50),
  phoneNum VARCHAR(10),
  shippingAddress VARCHAR(100),
  email VARCHAR(30),
  PRIMARY KEY (customerId)
);

CREATE TABLE product (
  productId INT PRIMARY KEY,
  productCatId INT,
  productName VARCHAR (45),
  productPrice DECIMAL (10,2),
  FOREIGN KEY (productCatId) REFERENCES productCategory(catId)
);

CREATE TABLE orders (
  orderId INT PRIMARY KEY,
  quantity INT,
  productId INT,
  customerId INT,
  FOREIGN KEY (productId) REFERENCES product(productId),
  FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

CREATE TABLE orderProduct (
  orderId INT,
  productId INT,
  PRIMARY KEY (orderId, productId),
  FOREIGN KEY (orderId) REFERENCES orders(orderId),
  FOREIGN KEY (productId) REFERENCES product(productId)
);

CREATE TABLE productSupplier (
  productId INT,
  supplierId INT,
  PRIMARY KEY (productId, supplierId),
  FOREIGN KEY (productId) REFERENCES product(productId),
  FOREIGN KEY (supplierId) REFERENCES supplier(supplierId)
);


-- Drop the orderProduct table
DROP TABLE IF EXISTS orderProduct;

-- Drop the productSupplier table
DROP TABLE IF EXISTS productSupplier;

-- Drop the orders table
DROP TABLE IF EXISTS orders;

-- Drop the product table
DROP TABLE IF EXISTS product;

-- Drop the productCategory table
DROP TABLE IF EXISTS productCategory;

-- Drop the supplier table
DROP TABLE IF EXISTS supplier;

-- Drop the customer table
DROP TABLE IF EXISTS customer;
