create table public.order_product
(
    enabled        boolean,
    id             integer not null
        primary key,
    order_id       integer not null
        constraint order_fk_order_product references public.orders,
    product_id     integer,
    purchase_price double precision,
    quantity       double precision,
    sell_price     double precision,
    description    varchar(255),
    name           varchar(255)
);