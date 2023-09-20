create table human(
	id serial primary key,
	name varchar(255)
);

create table gadget(
	id serial primary key,
	name varchar(255)
);

create table human_gadget(
	id serial primary key,
	human_id int references human(id),
	gadget_id int references gadget(id)
);

insert into human(name) values ('Igor');
insert into human(name) values ('Koly');
insert into human(name) values ('Vlad');

insert into gadget(name) values ('Watch');
insert into gadget(name) values ('Smartphone');
insert into gadget(name) values ('Console');

insert into human_gadget(human_id, gadget_id) values(1,2);
insert into human_gadget(human_id, gadget_id) values(1,2);
insert into human_gadget(human_id, gadget_id) values(2,1);
insert into human_gadget(human_id, gadget_id) values(2,2);
insert into human_gadget(human_id, gadget_id) values(2,3);
insert into human_gadget(human_id, gadget_id) values(3,2);