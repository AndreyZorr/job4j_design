create table products(
	id serial primary key,
	name varchar(50),
	producer varchar(50),
	count integer default 0,
	price integer
);

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = tax * 0.2 + price
        where id = select id from inserted;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();
	
create or replace function  tax1()
    returns trigger as
$$
    BEGIN
        new.prise = new.price * 0.2 + new.price
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax1_trigger
    before insert on products
    for each row
    execute procedure tax1();

	
create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function history_of_price()
    returns trigger as
$$
    BEGIN
        insert into products(name, price, date)
		values (new.name, new.price, new.date, time)
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger history_of_price_trigger
after insert on products 
for each row
execute procedure history_of_price;