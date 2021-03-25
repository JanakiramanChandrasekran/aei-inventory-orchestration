CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    price_min float,
    price_list float,
    image_link VARCHAR(255),
    category INT,
    price_currency ENUM('$')
);