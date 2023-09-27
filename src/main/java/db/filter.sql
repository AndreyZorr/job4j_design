create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255), 
	expired_date timestamp, 
	price float,
	type_id int references type(id)
);

insert into type(name) values ('молоко'), ('шололад'), ('сыр');

insert into product(name, expired_date, price, type_id)
values ('черный', '28.09.2023', 30, 2),('домашнее', '26.09.2023', 240, 1), ('пастеризованное', '27.09.2023', 80, 1),
('маздам', '19.09.2023', 340, 3);

select * from product
join type on type_id = type.id
where type.name = 'сыр';

select * from product
like name '%мороженое%';

select * from product 
where expired_date < current_date;

select * from product
where price = (select max(price) from product);

select t.name as 'имя_типа', count(p.id) as 'количество'
from type t
join product p on p.type_id = t.id
group by t.name;

select * from product
join type on type_id = type.id
where type.name = 'молоко', 'сыр';

select t.name as 'тип продуктов', count(p.name) as 'количество'
from type t
join product p on p.type_id = t.id
group by t.name
having by count(p.id) < 10;

select p.name as 'продукт', t.name as 'тип'
from product p
join type t on p.type_id = t.id;