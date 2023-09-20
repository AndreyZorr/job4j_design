create table season(
id serial primary key,
name varchar(255),
temperature date,	
precipitation text
);
insert into season(name, temperature, precipitation) values('winter', '-20.4', 'snow');
update season set temperature = '-30';
delete from season;
