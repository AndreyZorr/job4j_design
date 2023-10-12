create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace procedure delete_data(d_count integer, d_id integer)
language 'plpgsql'
as 
$$
    begin
	if d_count <= 0 THEN
    delete from products;
    end;
$$;

create or replace function f_delete_data(d_count integer, d_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
        if d_count <= 0 THEN
            delete from products;
			select delete count from products where id = d_id;
    end if;
    return result;
	end;
$$;