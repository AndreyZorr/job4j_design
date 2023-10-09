create table employee (
    id serial primary key,
    name varchar(50)
);

insert into employee (name) values ('Александр Семов'), ('Роман Ников');

create table salary (
    id serial primary key,
    name varchar(50)
);

insert into salary (name) values ('Большая'), ('Маленькая');

create table job_title (
    id serial primary key,
    name varchar(200),
    salary_id integer references authors(id)
);

insert into job_title (name, salary_id) 
values ('Водитель', 1), ('Разработчик', 1), ('Директор', 1), ('Продавец', 2);

create table job (
    id serial primary key,
    active boolean default true,
    job_title_id integer references job_title(id),
    employee_id integer references employee(id)
);

insert into job (job_title_id, employee_id) 
values (1,2), (1, 1), (2, 2);

create view show_job as 
select e.name as employee, count(s.name), s.name 
from employee as e
join job j on e.id = j.employee_id
join job_title jt on j.job_title_id = jt.id
join salary s on j.salary_id = s.id
group by (e.name, s.name) having count(s.name) >= 2;