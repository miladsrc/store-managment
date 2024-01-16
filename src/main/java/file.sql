create table if not exists shareholder
(
    id            serial primary key,
    name          varchar(255),
    phone_number  varchar(255),
    national_code int
    );

create table if not exists brand
(
    id          serial primary key,
    name        varchar(255),
    website     varchar(255),
    description varchar(255)
    );


create table if not exists category
(
    id   serial primary key,
    name varchar(255),
    description(255
               )
    );

create table if not exists user
(
    id       serial primary key,
    name     varchar(255),
    username varchar(255),
    email    varchar(255),
    password varchar(255)
    );


create table if not exists product
(
    id             serial primary key,
    name           varchar(255),
    create_date    DATE,
    category_id_fk int,
    brand_id_fk    int,
    foreign key (category_id_fk) references category (id),
    foreign key (brand_id_fk) references brand (id)
    );


create table if not exists shareholder_brand
(
    shareholder_id_fk int,
    brand_id_fk       int,
    foreign key (shareholder_id_fk) references shareholder (id),
    foreign key (brand_id_fk) references brand (id)
    )

