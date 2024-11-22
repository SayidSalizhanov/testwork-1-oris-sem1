create table users
(
    id       serial primary key,
    name     varchar,
    login    varchar,
    password varchar
);

create table attempts
(
    id     serial primary key,
    login  varchar,
    time   timestamp,
    status boolean
);

create table weather_attempts
(
    id         serial primary key,
    user_login varchar,
    city       varchar
);