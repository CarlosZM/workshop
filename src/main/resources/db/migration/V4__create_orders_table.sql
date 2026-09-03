create table public.orders
(
    created_by      integer,
    delivery_fee    double precision,
    enabled         boolean,
    id              integer not null primary key,
    price           double precision,
    quantity        integer,
    taxes           double precision,
    updated_by      integer,
    created_at      timestamp(6),
    updated_at      timestamp(6),
    delivery_status varchar(255)
        constraint orders_delivery_status_check
            check ((delivery_status)::text = ANY
        ((ARRAY ['CREATED'::character varying, 'IN_TRANSIT'::character varying, 'FAILED'::character varying, 'DELIVERED'::character varying])::text[])),
    number          varchar(255),
    payment         varchar(255)
        constraint orders_payment_check
            check ((payment)::text = ANY
                   ((ARRAY ['CREDIT_CARD'::character varying, 'CASH'::character varying, 'DEBIT_CARD'::character varying, 'COUPON'::character varying])::text[])),
    payment_status  varchar(255)
        constraint orders_payment_status_check
            check ((payment_status)::text = ANY
                   ((ARRAY ['CREATED'::character varying, 'PENDING'::character varying, 'IN_PROCESS'::character varying, 'PAID'::character varying, 'FAILED'::character varying])::text[])),
    type            varchar(255)
        constraint orders_type_check
            check ((type)::text = ANY
                   ((ARRAY ['QUOTE'::character varying, 'PURCHASE'::character varying, 'SELL'::character varying])::text[]))
);