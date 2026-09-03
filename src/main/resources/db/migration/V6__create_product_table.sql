create table public.product
(
    created_by     integer,
    enabled        boolean,
    id             integer not null
        primary key,
    purchase_price double precision,
    sell_price     double precision,
    updated_by     integer,
    created_at     timestamp(6),
    updated_at     timestamp(6),
    description    varchar(255),
    name           varchar(255)
);