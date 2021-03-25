CREATE TABLE location (
    id INT PRIMARY KEY AUTO_INCREMENT,
    address_line1 varchar(255),
    address_line2 varchar(255),
    city varchar(255),
    state varchar(255),
    country_code varchar(2),
    zip varchar(255),
    description varchar(255)
);