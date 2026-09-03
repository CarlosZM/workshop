create table public.users
(
    created_by   integer,
    enabled      boolean,
    id           integer not null primary key,
    updated_by   integer,
    created_at   timestamp(6),
    last_sign_in timestamp(6),
    updated_at   timestamp(6),
    password     varchar(255),
    user_name    varchar(255),
    roles        varchar(255)[]
);