create table schoolboy(
    id serial primary key,
    name varchar(255)
);

create table textbook(
    id serial primary key,
    name varchar(255),
    schoolboy_id int references schoolboy(id)
);

insert into schoolboy(name) values ('Ivan');
insert into textbook(name, schoolboy_id) VALUES ('mathematics', 1);

select * from textbook;

select * from schoolboy where id in (select schoolboy_id from textbook);

