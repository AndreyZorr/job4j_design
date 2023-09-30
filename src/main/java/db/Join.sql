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
values ('departament в„–1'), ('departament в„–2'), ('departament в„–3'), ('departament в„–4');

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


 *Используя left и right join написать запросы, которые давали бы одинаковый результат*

select * from worker w left join departament d on w.departament_id = d.id where d.id is null;

select * from worker w right join departament d on w.departament_id = d.id;

*Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары*

create table teens(
	name varchar(255),
	gender varchar(32)
);

insert into teens(name, gender) 
values ('Vika', 'woman'),('Dima', 'man');

select t1.name as a, t2.name b
from teens t1 cross join teens t2; 
