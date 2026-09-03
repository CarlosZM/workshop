create table public.address
(
    created_by  integer,
    enabled     boolean,
    id          integer not null
        primary key,
    updated_by  integer,
    user_id     integer not null
        constraint address_fk_client
            references public.client,
    created_at  timestamp(6),
    latitude    bigint,
    longitude   bigint,
    updated_at  timestamp(6),
    alias       varchar(255),
    name        varchar(255),
    street_name varchar(255)
);