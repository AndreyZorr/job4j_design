create table devices(
	id serial primary key,
	name varchar(255),
	price float
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table devices_people(
	id serial primary key,
	devices_id int references devices(id),
	people_id int references people(id)
);

insert into people(name) values ('Вика'), ('Коля'), ('Марк'), ('Ярослав');

insert into devices(name, price) values('Смартфон', 34650),('Часы', 4100), ('Компьютер', 87689);

insert into devices_people (devices_id, people_id) values (1, 1), (1, 2);
insert into devices_people (devices_id, people_id) values (2, 1), (2, 2), (2, 3);
insert into devices_people (devices_id, people_id) values (3, 1);

select avg(price) from devices;

select p.name, avg(d.price)
from devices_people as dp
join people p on dp.people_id = p.id
join devices d on dp.devices_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
join people p on dp.people_id = p.id
join devices d on dp.devices_id = d.id
group by p.name;
having avg(d.price) > 5000;