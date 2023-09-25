create table human(
	id serial primary key,
	name varchar(255)
);

create table tv(
	id serial primary key,
	name text,
	size int,
	human_id int references human(id)
);

insert into human(name) values('Roma');

insert into tv(name, size, human_id) values ('rsc', 32, 1);
insert into tv(name, size, human_id) values ('rrr', 48, 1);
insert into tv(name, size, human_id) values ('sms', 108, 1);
insert into tv(name, size, human_id) values ('tlc', 32, 1);

select h.name, t.name, t.size
from tv as t join human as h on t.human = h.id;

select h.name as Имя, t.name as Телевизор, t.size as Размер
from tv t join human h on t.human_id = h.id; 

select h.name as "Имя владельца", t.name "Название телевизора", t.size as "Размер"
from tv t join human h on t.human_id = h.id;