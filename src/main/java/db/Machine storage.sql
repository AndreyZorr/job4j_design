create table car_bodies(
	id serial primary key,
	name text
);

create table car_engines(
	id serial primary key,
	name text
);

create table car_transmissions(
	id serial primary key,
	name text
);

create table cars(
	id serial primary key,
	name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);


insert into car_bodies(name) 
values ('sedan'), ('coupe'), ('hatchback'), ('station_wagon'), ('cabriolet');

insert into car_engines(name)
values ('petrol'), ('diesel'), ('hybrid'), ('electric');

insert into car_transmissions(name)
values ('mechanical'), ('automatic');

insert into cars(name, body_id, engine_id, transmission_id)
values ('Peugeot 5008', 3, 1, 2), ('Ferrari Roma', 2, 1, 2), ('BMW X5M', 4, 2, 2), ('Lada Vesta', 4, 1, 1);

select c.name as car_name, cb.name as body_name, ce.name as engines_name, ct.name as transmissions_name
from cars as c
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.transmission_id = ct.id;


select cb. *
from car_bodies cb
left join cars c on cb.id = c.body_id
where c.id is null;

select ce.*
from car_engines ce
left join cars c on ce.id = c.engines_id
where c.id is null;

select ct.*
from car_transmissions ct
left join cars c on ct.id = c.transmissions_id
where c.id is null;
