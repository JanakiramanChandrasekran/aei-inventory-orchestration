CREATE TABLE equipment (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    mac varchar(255),
    category INT,
    available BOOLEAN
);