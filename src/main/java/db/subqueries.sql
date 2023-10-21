CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers
values (1, 'Ivan', 'Ivanov', 38, 'China'),
(2, 'Petr', 'Petrov', 42, 'Russia'),
(3, 'Semen', 'Semenov', 30, 'Vietnam'),
(4, 'Kiril', 'Kirilob', 38, 'China'),
(5, 'Olga', 'Olgova', 40, 'Portugal');

select first_name, last_name, age
from customers
where age = (select min(age) from customers);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders(amount, customer_id)
values (3, 1),
(1, 2),
(4, 3);

select first_name, last_name, age 
from customers
where customers.id NOT IN (select orders.customer_id from orders);