CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers
values (1, 'Иван', 'Иванов', 38, 'Китай'),
(2, 'Петр', 'Петров', 42, 'Россия'),
(3, 'Семен', 'Семенов', 30, 'Вьетнам'),
(4, 'Кирил', 'Кирилов', 38, 'Китай'),
(5, 'Ольга', 'Ольгова', 40, 'Португалия');

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