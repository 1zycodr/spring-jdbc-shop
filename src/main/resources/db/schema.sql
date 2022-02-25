CREATE TABLE IF NOT EXISTS SHOP_USER (
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(100) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS SHOP_ORDER (
    id          SERIAL PRIMARY KEY,
    user_id     INT NOT NULL,
    address     VARCHAR(100),
    status      VARCHAR(20),
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES SHOP_USER(id)
                ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS SHOP_PRODUCT (
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price       INT NOT NULL
);

CREATE TABLE IF NOT EXISTS SHOP_ORDER_PRODUCTS (
    id          SERIAL PRIMARY KEY,
    order_id    INT NOT NULL,
    product_id  INT NOT NULL,
    quantity    INT DEFAULT 1,
    CONSTRAINT fk_product_order
        FOREIGN KEY(order_id)
            REFERENCES SHOP_ORDER(id)
                ON DELETE CASCADE,
    CONSTRAINT fk_order_product
        FOREIGN KEY(product_id)
            REFERENCES SHOP_PRODUCT(id)
                ON DELETE CASCADE
);
