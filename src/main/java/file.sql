create table if not exists shareholder
(
    id
    serial
    primary
    key,
    name
    varchar
(
    255
),
    phone_number varchar
(
    255
),
    national_code int
    );

create table if not exists brand
(
    id
    serial
    primary
    key,
    name
    varchar
(
    255
),
    website varchar
(
    255
),
    description varchar
(
    255
)
    );


create table if not exists category
(
    id
    serial
    primary
    key,
    name
    varchar
(
    255
),
    description
(
    255
)
    );

create table if not exists user
(
    id
    serial
    primary
    key,
    name
    varchar
(
    255
),
    username varchar
(
    255
),
    email varchar
(
    255
),
    password varchar
(
    255
)
    );


create table if not exists product
(
    id
    serial
    primary
    key,
    name
    varchar
(
    255
),
    create_date DATE,
    category_id_fk int,
    brand_id_fk int,
    foreign key
(
    category_id_fk
) references category
(
    id
),
    foreign key
(
    brand_id_fk
) references brand
(
    id
)
    );


create table if not exists shareholder_brand
(
    shareholder_id_fk
    int,
    brand_id_fk
    int,
    foreign
    key
(
    shareholder_id_fk
) references shareholder
(
    id
),
    foreign key
(
    brand_id_fk
) references brand
(
    id
)
    )

--query

    1-
    INSERT INTO users
(
    name,
    username,
    email,
    password
) values
(
    ?,
    ?,
    ?,
    ?
);

2-
    insert into shareholder(name,phone_number,national_code)values ()

3-
update shareholder
set name          = 'javad',
    phone_number  = '123134',
    national_code = 123432
where id = 3;

4-
delete
from shareholder
where id = ?;

5-
    insert into product(name, create_date, category_id_fk, brand_id_fk) values(????)

6-
select shareholder.name, b.name
from shareholder
         inner join shareholder_brand sb on shareholder.id = sb.shareholder_id_fk
         inner join brand b on b.id = sb.brand_id_fk
GROUP BY shareholder.id, shareholder.name, phone_number, national_code, shareholder_id_fk, brand_id_fk, b.id, b.name,
         website, description
having shareholder.id = 10

7-
select brand.name, s.name
from brand
         inner join shareholder_brand sb on brand.id = sb.brand_id_fk
         join shareholder s on s.id = sb.shareholder_id_fk
group by brand.id,brand.name, s.name
HAVING brand.id = 3

8-
update shareholder_brand
set shareholder_id_fk = ? , brand_id_fk = ?
where shareholder_id_fk = ? and brand_id_fk =