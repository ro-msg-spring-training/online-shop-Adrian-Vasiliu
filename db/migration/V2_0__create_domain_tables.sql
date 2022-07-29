CREATE TABLE IF NOT EXISTS supplier
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS product_category
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(50),
    price     DOUBLE PRECISION,
    weight    DOUBLE PRECISION,
    category  INT NOT NULL references product_category (id),
    supplier  INT NOT NULL references supplier (id),
    image_url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS location
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(50),
    address_country VARCHAR(50),
    address_city    VARCHAR(50),
    address_county  VARCHAR(50),
    address_street  VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS stock
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    product  INT NOT NULL references product (id),
    location INT NOT NULL references location (id),
    quantity INT
);

CREATE TABLE IF NOT EXISTS customer
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    username      VARCHAR(50),
    user_password VARCHAR(50),
    email_address VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS order_product
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    shipped_from    INT NOT NULL references location (id),
    customer        INT NOT NULL references customer (id),
    created_at      DATETIME,
    address_country VARCHAR(50),
    address_city    VARCHAR(50),
    address_county  VARCHAR(50),
    address_street  VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS order_detail
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    order_product INT NOT NULL references order_product (id),
    product       INT NOT NULL references product (id),
    quantity      INT
);

CREATE TABLE IF NOT EXISTS revenue
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    location INT NOT NULL references location (id),
    date     DATE,
    sum      INT
);
