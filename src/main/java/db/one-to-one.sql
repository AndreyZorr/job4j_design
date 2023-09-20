create table number (
	id serial primary key,
	number int
);

create table car(
	id serial primary key,
	name varchar(255),
	number_id int references number(id) unique
);