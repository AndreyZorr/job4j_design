create table human (
    id serial primary key,
    name varchar(50),
    surname varchar(50),
    growth integer,
    weight integer
);

insert into human (name, surname, growth, weight) VALUES ('Mischa', 'Zavin', 183, 76);
insert into human (name, surname, growth, weight) VALUES ('Kira', 'Rikova', 178, 60);
insert into human (name, surname, growth, weight) VALUES ('Vik', 'Dinova', 180, 64);