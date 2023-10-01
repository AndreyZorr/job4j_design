create table departament(
	id serial primary key,
	name varchar(255)
);

create table worker(
	id serial primary key,
	name varchar(255),
	departament_id int references departament(id)
);

insert into departament(name) 
values ('departament №1'), ('departament №2'), ('departament №3'), ('departament №4');

insert into worker(name, departament_id) 
values ('Oly', 1), ('Sascha', 3), ('Ira', 2), ('Yana', 4), ('Lescha', null), ('Vika', 1), ('Vlad', null), ('Gena', 1);

select * from worker w left join departament d on w.departament_id = departament_id;

select * from worker w left join departament d on w.departament_id = d.id;

select * from worker w left join departament d on w.departament_id = d.id where d.id is null;

select * from departament d left join worker w on d.id = w.departament_id;

select * from worker w right join departament d on w.departament_id = d.id;
select * from worker w left join departament d on w.departament_id = d.id where d.id is not null;

select * from departament d right join worker w on w.departament_id = d.id;

select * from worker w right join departament d on w.departament_id = d.id ;

select * from departament d full join worker w on w.departament_id = d.id;

select * from departament d cross join worker w;

select * from worker w left join departament d on w.departament_id = d.id where d.id is null;

select * from worker w right join departament d on w.departament_id = d.id;



create table teens(
	name varchar(255),
	gender varchar(32)
);

insert into teens(name, gender) 
values ('Vika', 'woman'),('Dima', 'man'), ('Irina', 'woman'), ('Nikita', 'man');

select t1.name as man, t2.name as woman
from teens t1
cross join teens t2
where t1.gender > t2.gender;