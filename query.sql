--JPQL https://www.baeldung.com/spring-data-derived-queries
UPDATE `pattachitra`.`pe_order` SET `status` = 'CLOSED' WHERE (`od_id` = '15');
UPDATE `pattachitra`.`pe_order` SET `status` = 'CLOSED' WHERE (`od_id` = '16');
UPDATE `pattachitra`.`pe_order` SET `status` = 'NEW' WHERE (`od_id` = '1');

SET FOREIGN_KEY_CHECKS = 0;
drop table if exists account;
drop table if exists account_roles;
drop table if exists address;
drop table if exists book;
drop table if exists cart;
drop table if exists category;
drop table if exists order_detail;
drop table if exists orders;
drop table if exists pe_order;
drop table if exists permission;
drop table if exists person;
drop table if exists product_inventory;
drop table if exists role;
drop table if exists role_permissions;
drop table if exists product;
drop table if exists user_detail;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO category (name) VALUES ('Spring');
INSERT INTO category (name) VALUES ('Java');
INSERT INTO category (name) VALUES ('Web');

INSERT INTO book (title, isbn, author, description, year, price, category_id) VALUES ('Spring Boot 2 Recipes', '9781484227893','Marten Deinum', '', 2017, 37.44, 1);
INSERT INTO book (title, isbn,  author, description, year, price, category_id) VALUES ('Pivotal Certified Professional Core Spring 5 Developer Exam', '9781484251355', 'Iuliana Cosmina', '', 2020, 54.99, 1);
INSERT INTO book (title, isbn,  author, description, year, price, category_id) VALUES ('Java for Absolute Beginners', '9781484237779', 'Iuliana Cosmina','', 2018, 24.99, 2);
INSERT INTO book (title, isbn,  author, description, year, price, category_id) VALUES ('Clean Code', '9780132350884', 'Robert C. Martin','', 2008, 24.99, 2);
INSERT INTO book (title, isbn,  author, description, year, price, category_id) VALUES ('Agile Software Development', '9780135974445', 'Robert C. Martin','', 2002, 59.99, 2);
INSERT INTO book (title, isbn,  author, description, year, price, category_id) VALUES ('Refactoring', '9780201485677', 'Martin Fowler','', 2019, 33.99, 2);
INSERT INTO book (title, isbn,  author, description, year, price, category_id) VALUES ('Effective Java', '9780321356680', 'Joshua Bloch','', 2017, 29.99, 2);
