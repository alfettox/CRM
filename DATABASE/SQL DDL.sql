DROP DATABASE IF EXISTS shoppingcart;

CREATE DATABASE shoppingcart;

USE shoppingcart;

CREATE TABLE customer (
  customerId INT,
  fName VARCHAR(50),
  lName VARCHAR(50),
  phoneNum VARCHAR(10),
  shippingAddress VARCHAR(100),
  email VARCHAR(30),
  PRIMARY KEY (customerId)
);

CREATE TABLE orders (
  orderId INT PRIMARY KEY,
  quantity INT,
  productId INT,
  customerId INT,
  FOREIGN KEY (productId) REFERENCES product(productId),
  FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

CREATE TABLE product (
  productId INT PRIMARY KEY,
  productCatId INT,
  productName VARCHAR (45),
  FOREIGN KEY (productCatId) REFERENCES productCategory(catId)
);

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
