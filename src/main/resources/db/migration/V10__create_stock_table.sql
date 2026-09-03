create table public.stock
(
    available_stock double precision,
    created_by      integer,
    departure_stock double precision,
    enabled         boolean,
    product_id      integer not null
        constraint stock_product_id
            references public.product,
    reserved_stock  double precision,
    updated_by      integer,
    warehouse_id    integer not null
        constraint stock_warehouse_id
            references public.warehouse,
    created_at      timestamp(6),
    updated_at      timestamp(6),
    primary key (product_id, warehouse_id)
);