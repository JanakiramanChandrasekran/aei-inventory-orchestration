insert into product_category(name) values ('Icecream');
insert into product_category(name) values ('Salads');
insert into product_category(name) values ('Soups');

INSERT INTO product (name, description, price_min, price_list, image_link, category, price_currency) 
VALUES 

('Butter Pecan', 'Butter Pecan', 10.5, 11.5, 'https://testlink', 1, '$'),
('Chocolate', 'Chocolate', 11.5, 12.5, 'https://testlink', 1, '$'),
('Vanilla Bean', 'Vanilla Bean', 11.5, 12.5, 'https://testlink', 1, '$'),
('Mint Chocolate Chip', 'Mint Chocolate Chip', 11.5, 12.5, 'https://testlink', 1, '$'),
('Black Raspberry Chocolate Chip', 'Black Raspberry Chocolate Chip', 11.5, 12.5, 'https://testlink', 1, '$'),

('Bacon Mac & Cheese', 'Bacon Mac & Cheese', 5.5, 5.5, 'https://testlink', 2, '$'),
('Cheesesteak Mac & Cheese', 'Cheesesteak Mac & Cheese', 5.5, 5.5, 'https://testlink', 2, '$'),
('Roasted Chicken Burrito Bowl', 'Roasted Chicken Burrito Bowl', 5.5, 5.5, 'https://testlink', 2, '$'),
('Fiery Brisket Mac & Cheese', 'Fiery Brisket Mac & Cheese', 5.5, 5.5, 'https://testlink', 2, '$'),

('Chicken Noodle', 'Chicken Noodle', 5.5, 5.5, 'https://testlink', 3, '$'),
('Tomato Basil Bisque', 'Tomato Basil Bisque', 5.5, 5.5, 'https://testlink', 3, '$'),
('Chicken Corn Chowder', 'Chicken Corn Chowder', 5.5, 5.5, 'https://testlink', 3, '$');

INSERT INTO equipment_category (name) VALUES ('Cold'),('Warm');

INSERT INTO equipment (name, mac, category, available) VALUES 
('Freezer', 'AA:BB:CC:DD', 1, true),
('Oven', 'AA2:BB2:CC2:DD2', 2, true);

INSERT INTO location (address_line1, city, state, country_code, zip, description) VALUES 
('123 Arch Street', 'Philadelphia', 'PA', 'US', '19144', 'A'),
('100 Matera Street', 'Vienna', 'VA', 'US', '22043', 'A');

INSERT INTO store (location_id, name, available) VALUES (1, 'AEI - Arch Street', true ),
(2, 'AEI - Matera Street', true );

INSERT INTO inventory (product_id, store_id, equipment_id, quantity) 
VALUES
(1, 1, 1, 10),
(2, 1, 1, 10),
(3, 1, 1, 10),
(4, 1, 1, 10),
(6, 1, 2, 10),
(6, 1, 2, 10),
(7, 1, 2, 10),
(8, 1, 2, 10),
(11, 1, 2, 10),
(12, 1, 2, 10),

(1, 2, 1, 10),
(2, 2, 1, 10),
(3, 2, 1, 10),
(4, 2, 1, 10),
(6, 2, 2, 10),
(6, 2, 2, 10),
(7, 2, 2, 10),
(8, 2, 2, 10),
(11, 2, 2, 10),
(12, 2, 2, 10);

