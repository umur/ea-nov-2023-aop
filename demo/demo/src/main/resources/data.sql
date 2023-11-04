-- Insert data into the Category table
INSERT INTO Category (name) VALUES ('Electronics');
INSERT INTO Category (name) VALUES ('Merch');
-- Insert data into the Product table
INSERT INTO Product (name, price, rating, category_id) VALUES ('Laptop', 1999.99, 4.5, 1);
INSERT INTO Product (name, price, rating, category_id) VALUES ('T-shirt', 19.99, 4.0, 2);
-- Insert data into the User table
INSERT INTO User (email, password, first_name, last_name) VALUES ('u1@example.com', 'p111', 'James', 'Lopez');
INSERT INTO User (email, password, first_name, last_name) VALUES ('u2@example.com', '1232', 'Jana', 'Smith');
-- Insert data into the Address table
INSERT INTO Address (street, zip, city, user_id) VALUES ('123 Navy Pier', '60602', 'Chicago', 2);
INSERT INTO Address (street, zip, city, user_id) VALUES ('206 E Broadway Ave', '52556', 'Fairfield', 2);
-- Insert data into the Product table
INSERT INTO Review (comment, user_id, product_id) VALUES ('Good laptop!', 1, 1);
INSERT INTO Review (comment, user_id, product_id) VALUES ('Nice shirt!', 2, 2);
