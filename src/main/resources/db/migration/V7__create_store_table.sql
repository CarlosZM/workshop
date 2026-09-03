create table public.store
(
    created_by integer,
    enabled    boolean,
    id         integer not null
        primary key,
    updated_by integer,
    created_at timestamp(6),
    updated_at timestamp(6),
    logo       varchar(255),
    name       varchar(255),
    type       varchar(255)
);