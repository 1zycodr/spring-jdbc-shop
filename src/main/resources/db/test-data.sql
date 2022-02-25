INSERT INTO SHOP_USER (USERNAME, PASSWORD)
    VALUES ('anton', 'qwfqwhfilh'),
           ('amirlan', 'qwpfqpiwf'),
           ('evgeniy', 'qwfqfkpqkwfp'),
           ('nurbolat', 'qwfpqkpqif')
    ON CONFLICT DO NOTHING;

INSERT INTO SHOP_PRODUCT (TITLE, DESCRIPTION, PRICE)
    VALUES ('apple', 'awesome apple!', 150),
           ('milk', 'white milk, milk white', 350),
           ('chocolate', 'as dark as your soul', 400),
           ('rise', 'rise bruh', 750),
           ('potato', 'potato mutato', 270),
           ('cheese', 'ukrainian cheese. remember :(', 520);

INSERT INTO SHOP_ORDER (user_id, address, status, created_at, updated_at)
    VALUES (1, 'Russia, Moscow', 'in_delivery', now(), now()),
           (2, 'Kazakhstan, Almaty', 'in_delivery', now(), now()),
           (3, 'Kazakhstan, Karaganda', 'completed', now(), now()),
           (4, 'Ukraine, Harkov', 'completed', now(), now()),
           (2, 'Russia, Saint - Petersburg', 'payment', now(), now()),
           (4, 'Kazakhstan, Nur - Sultan', 'payment', now(), now());

-- INSERT INTO SHOP_ORDER_PRODUCTS (order_id, product_id, quantity)
--     VALUES (1, 1, 2),
--            (1, 2, 3),
--            (2, 3, 2),
--            (2, 4, 5),
--            (3, 6, 1),
--            (3, 5, 4),
--            (3, 3, 4),
--            (4, 6, 6),
--            (5, 2, 4),
--            (6, 2, 5)
--     ON CONFLICT DO NOTHING;
