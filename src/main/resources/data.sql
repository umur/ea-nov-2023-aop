INSERT INTO users (id, email, first_name, last_name, password)
VALUES(1, "a@yahoo.com", "A", "Mostafa", "A");
INSERT INTO users (id, email, first_name, last_name, password)
VALUES(2, "b@yahoo.com", "B", "Mostafa", "B");
INSERT INTO users (id, email, first_name, last_name, password)
VALUES(3, "c@yahoo.com", "C", "Mostafa", "C");
INSERT INTO users (id, email, first_name, last_name, password)
VALUES(4, "d@yahoo.com", "D", "Mostafa", "D");
INSERT INTO users (id, email, first_name, last_name, password)
VALUES(5, "e@yahoo.com", "E", "Mostafa", "AE");
-----------------------------
INSERT INTO addresses (id, city, street, zip, user_id)
VALUES(1, "Cairo", "Street 1", "12345", 1);
INSERT INTO addresses (id, city, street, zip, user_id)
VALUES(2, "Cairo", "Street 2", "12345", 2);
INSERT INTO addresses (id, city, street, zip, user_id)
VALUES(3, "Cairo", "Street 3", "12345", 3);
INSERT INTO addresses (id, city, street, zip, user_id)
VALUES(4, "Cairo", "Street 4", "12345", 4);
INSERT INTO addresses (id, city, street, zip, user_id)
VALUES(5, "Cairo", "Street 5", "12345", 5);
-----------------------------
INSERT INTO categories
VALUES(1, "Category 1");
INSERT INTO categories
VALUES(2, "Category 2");
INSERT INTO categories
VALUES(3, "Category 3");
INSERT INTO categories
VALUES(4, "Category 4");
----------------------------
INSERT INTO products (id, name, price, category_id, rating)
VALUES(1, "FilteredProduct", 1000, 1, 4);
INSERT INTO products (id, name, price, category_id, rating)
VALUES(2, "Product 2", 200, 1, 4);
INSERT INTO products (id, name, price, category_id, rating)
VALUES(3, "Product 3", 1, 1, 4);
INSERT INTO products (id, name, price, category_id, rating)
VALUES(4, "Product 4", 1, 2, 4);
INSERT INTO products (id, name, price, category_id, rating)
VALUES(5, "ProductName 5", 1, 2, 4);
INSERT INTO products (id, name, price, category_id, rating)
VALUES(6, "ProductName 4", 1, 3, 4);
INSERT INTO products (id, name, price, category_id, rating)
VALUES(7, "ProductName 3", 1, 3, 4);
INSERT INTO products (id, name, price, category_id, rating)
VALUES(8, "ProductName 4", 1, 4, 4);
--------------------------------
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(1, 1, 1, "Comment 1");
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(2, 1, 2, "Comment 2");
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(3, 1, 3, "Comment 3");
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(4, 2, 4, "Comment 4");
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(5, 2, 5, "Comment 5");
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(6, 2, 1, "Comment 6");
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(7, 3, 2, "Comment 7");
INSERT INTO reviews (id, product_id, user_id, comment)
VALUES(8, 3, 3, "Comment 8");