
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` INT NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(50) NULL DEFAULT NULL,
  `lName` VARCHAR(50) NULL DEFAULT NULL,
  `phoneNum` VARCHAR(10) NULL DEFAULT NULL,
  `shippingAddress` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`customerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 100
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orders` ;

CREATE TABLE IF NOT EXISTS `orders` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NULL DEFAULT NULL,
  `customerId` INT NULL DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  INDEX `customerId` (`customerId` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_2`
    FOREIGN KEY (`customerId`)
    REFERENCES `customer` (`customerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 100
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `productcategory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `productcategory` ;

CREATE TABLE IF NOT EXISTS `productcategory` (
  `catId` INT NOT NULL AUTO_INCREMENT,
  `productCat` VARCHAR(40) NULL DEFAULT NULL,
  `catImage` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`catId`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `productId` INT NOT NULL AUTO_INCREMENT,
  `productCatId` INT NULL DEFAULT NULL,
  `productName` VARCHAR(50) NULL DEFAULT NULL,
  `productPrice` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`productId`),
  INDEX `productCatId` (`productCatId` ASC) VISIBLE,
  CONSTRAINT `product_ibfk_1`
    FOREIGN KEY (`productCatId`)
    REFERENCES `productcategory` (`catId`))
ENGINE = InnoDB
AUTO_INCREMENT = 100
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `orderproduct`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orderproduct` ;

CREATE TABLE IF NOT EXISTS `orderproduct` (
  `orderId` INT NOT NULL,
  `productId` INT NOT NULL,
  PRIMARY KEY (`orderId`, `productId`),
  INDEX `productId` (`productId` ASC) VISIBLE,
  CONSTRAINT `orderproduct_ibfk_1`
    FOREIGN KEY (`orderId`)
    REFERENCES `orders` (`orderId`),
  CONSTRAINT `orderproduct_ibfk_2`
    FOREIGN KEY (`productId`)
    REFERENCES `product` (`productId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supplier` ;

CREATE TABLE IF NOT EXISTS `supplier` (
  `supplierId` INT NOT NULL AUTO_INCREMENT,
  `supPhoneNum` INT NULL DEFAULT NULL,
  `supEmail` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`supplierId`))
ENGINE = InnoDB
AUTO_INCREMENT = 100
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `productsupplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `productsupplier` ;

CREATE TABLE IF NOT EXISTS `productsupplier` (
  `productId` INT NOT NULL,
  `supplierId` INT NOT NULL,
  PRIMARY KEY (`productId`, `supplierId`),
  INDEX `supplierId` (`supplierId` ASC) VISIBLE,
  CONSTRAINT `productsupplier_ibfk_1`
    FOREIGN KEY (`productId`)
    REFERENCES `product` (`productId`),
  CONSTRAINT `productsupplier_ibfk_2`
    FOREIGN KEY (`supplierId`)
    REFERENCES `supplier` (`supplierId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



