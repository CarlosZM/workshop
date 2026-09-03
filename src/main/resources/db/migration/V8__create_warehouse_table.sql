create table public.warehouse
(
    created_by  integer,
    enabled     boolean,
    id          integer not null
        primary key,
    store_id    integer not null constraint warehouse_fk_store references public.store,
    updated_by  integer,
    created_at  timestamp(6),
    latitude    bigint,
    longitude   bigint,
    updated_at  timestamp(6),
    alias       varchar(255),
    name        varchar(255),
    street_name varchar(255)
);