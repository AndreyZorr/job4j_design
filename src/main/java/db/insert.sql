insert into roles(name) values('admin');
insert into rules(name) values('add');
insert into roles_rules(roles_id, rules_id) value (1,1);
insert into users(name, roles_id) values('Koly', 1);
insert into categories(name) values('Highest');
insert into states(name) values('At work');
insert into items(name, users_id, categories_id, states_id) values ('Error', 1, 1, 1);
insert into comments(comments, items_id) values ('Not true',1);
insert into attachs(attachs, items_id) values ('True',1);