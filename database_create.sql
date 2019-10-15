DROP TABLE IF EXISTS line_item;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR NOT NULL,
    description VARCHAR
);

CREATE TABLE supplier
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR NOT NULL,
    description VARCHAR
);

CREATE TABLE product
(
    id           SERIAL PRIMARY KEY,
    category_id  INTEGER REFERENCES product_category (id),
    supplier_id  INTEGER REFERENCES supplier (id) ON DELETE CASCADE,
    name         VARCHAR NOT NULL,
    description  VARCHAR,
    def_price    FLOAT,
    def_currency VARCHAR
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    email    VARCHAR NOT NULL
);

CREATE TABLE cart
(
    id       SERIAL PRIMARY KEY,
    currency VARCHAR NOT NULL,
    user_id  INTEGER REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE line_item
(
    id         SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES product(id) ON DELETE CASCADE,
    quantity   INTEGER,
    order_id   INTEGER REFERENCES cart(id) ON DELETE CASCADE
);

