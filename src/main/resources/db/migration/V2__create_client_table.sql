create table public.client
(
    created_by integer,
    enabled    boolean,
    id         integer not null
        primary key,
    updated_by integer,
    created_at timestamp(6),
    updated_at timestamp(6),
    dni        varchar(255),
    first_name varchar(255),
    last_name  varchar(255)
);