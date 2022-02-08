CREATE DATABASE customer_order;

CREATE TABLE customer_order.order_group (
    id bigint NOT NULL,
    customer_id bigint NOT NULL,
    create_date date NOT NULL,
    PRIMARY KEY (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE customer_order.order_item (
    id bigint NOT NULL,
    order_group_id bigint NOT NULL,
    item_id varchar(128) NOT NULL,
    item_count bigint NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO customer_order.order_group (customer_id, create_date) VALUES
(1, '2022-01-01'),
(2, '2022-01-01'),
(3, '2022-01-01');

INSERT INTO customer_order.order_item
(id, order_group_id, item_id, item_count) VALUES
(1, 1, 'item_1', 1),
(2, 2, 'item_1', 2),
(3, 2, 'item_2', 2),
(4, 3, 'item_1', 1),
(5, 3, 'item_2', 1),
(6, 3, 'item_3', 1),
(7, 3, 'item_4', 1),
(8, 4, 'item_1', 1);
