DROP TABLE IF EXISTS TBL_PRODUCTS;

CREATE TABLE TBL_PRODUCTS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  category VARCHAR(250) NOT NULL,
  retail_price DECIMAL(10,2) DEFAULT NOT NULL,
  discounted_price DECIMAL(10,2) DEFAULT NOT NULL,
  availability BOOLEAN DEFAULT NOT NULL
);

-- Inserting Dummy Data for Testing (to be commented while running Test Cases)

--INSERT INTO TBL_PRODUCTS (name, category, retail_price, discounted_price, availability) VALUES
--
--('Waterproof', 'Coats and Jackets', 274.0, 230.167, true),
--('Cotton', 'Coats and Jackets', 374.0, 330.167, true),
--('Nylon', 'Coats and Jackets', 474.0, 430.167, false),
--('Plastic', 'Coats and Jackets', 574.0, 530.167, true),
--('Omni Heat', 'Coats and Jackets', 674.0, 260.167, false),
--('Waterproof', 'Hats', 274.0, 230.167, true),
--('Cotton', 'Hats', 234.0, 200.167, true),
--('Nylon', 'Hats', 474.0, 240.167, false),
--('Plastic', 'Hats', 574.0, 530.167, true),
--('Omni Heat', 'Hats', 674.0, 460.167, false),
--('Waterproof', 'Footwear', 274.0, 230.167, true),
--('Cotton', 'Footwear', 273.0, 100.167, true),
--('Nylon', 'Footwear', 474.0, 230.167, false),
--('Plastic', 'Footwear', 789.0, 678.167, true),
--('Plastic3', 'Footwear', 1000, 400, true),
--('Plastic2', 'Footwear', 500, 200, true),
--('Plastic1', 'Footwear', 1000, 400, true),
--('Omni Heat', 'Footwear', 678.0, 333.167, false);