-- =========================
-- DATABASE
-- =========================
CREATE DATABASE IF NOT EXISTS bestellsystem
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE bestellsystem;

-- =========================
-- USER
-- =========================
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- =========================
-- CUSTOMER
-- =========================
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    phone VARCHAR(50),
    email VARCHAR(150),
    address TEXT,
    type ENUM('PERSON', 'COMPANY') NOT NULL
);

-- =========================
-- PRODUCT
-- =========================
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    code VARCHAR(100) NOT NULL UNIQUE,
    price INT NOT NULL,
    stock INT NOT NULL
);

-- =========================
-- BASKET
-- =========================
CREATE TABLE basket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,

    CONSTRAINT fk_basket_product
        FOREIGN KEY (product_id)
        REFERENCES product(id)
        ON DELETE CASCADE
);

-- =========================
-- CART
-- =========================
CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL,
    note TEXT,
    date DATE NOT NULL,

    CONSTRAINT fk_cart_customer
        FOREIGN KEY (customer_id)
        REFERENCES customer(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_cart_product
        FOREIGN KEY (product_id)
        REFERENCES product(id)
        ON DELETE CASCADE
);
