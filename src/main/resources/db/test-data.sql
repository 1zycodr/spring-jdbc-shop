INSERT INTO SHOP_USER
    VALUES (1, 'anton', 'qwfqwhfilh'),
           (2, 'amirlan', 'qwpfqpiwf'),
           (3, 'evgeniy', 'qwfqfkpqkwfp'),
           (4, 'nurbolat', 'qwfpqkpqif')
    ON CONFLICT (id) DO UPDATE SET username=excluded.username,
                                   password=excluded.password;

INSERT INTO SHOP_PRODUCT
    VALUES (1, 'apple', 'awesome apple!', 150),
           (2, 'milk', 'white milk, milk white', 350),
           (3, 'chocolate', 'as dark as your soul', 400),
           (4, 'rise', 'rise bruh', 750),
           (5, 'potato', 'potato mutato', 270),
           (6, 'cheese', 'ukrainian cheese. remember :(', 520)
    ON CONFLICT (id) DO UPDATE SET title=excluded.title,
                                   description=excluded.description,
                                   price=excluded.price;

INSERT INTO SHOP_ORDER (id, user_id, address, status, created_at, updated_at)
    VALUES (1, 1, 'Russia, Moscow', 'in_delivery', now(), now()),
           (2, 2, 'Kazakhstan, Almaty', 'in_delivery', now(), now()),
           (3, 3, 'Kazakhstan, Karaganda', 'completed', now(), now()),
           (4, 4, 'Ukraine, Harkov', 'completed', now(), now()),
           (5, 2, 'Russia, Saint - Petersburg', 'payment', now(), now()),
           (6, 4, 'Kazakhstan, Nur - Sultan', 'payment', now(), now())
    ON CONFLICT (id) DO UPDATE SET user_id=excluded.user_id,
                                   address=excluded.address,
                                   status=excluded.status,
                                   created_at=excluded.created_at,
                                   updated_at=excluded.updated_at;

INSERT INTO SHOP_ORDER_PRODUCTS
    VALUES (1, 1, 1, 2),
           (2, 1, 2, 3),
           (3, 2, 3, 2),
           (4, 2, 4, 5),
           (5, 3, 6, 1),
           (6, 3, 5, 4),
           (7, 3, 3, 4),
           (8, 4, 6, 6),
           (9, 5, 2, 4),
           (10, 6, 2, 5)
    ON CONFLICT (id) DO UPDATE SET order_id=excluded.order_id,
                                   product_id=excluded.product_id,
                                   quantity=excluded.quantity;