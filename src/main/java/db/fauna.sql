create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) 
values ('predator', 3650, 1321-06-21);
insert into fauna(name, avg_age, discovery_date) 
values ('herbivores', 6140, 1021-01-11);
insert into fauna(name, avg_age, discovery_date) 
values ('birds', 4208, 1324-08-01);

select * from fauna where name like '%fish%';
select * from fauna where avg_age <= 10000 AND avg_age >= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < 1950-01-01;