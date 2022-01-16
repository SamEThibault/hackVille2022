insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('User', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into sec_role (roleName)
values ('ROLE_ADMIN');
 
insert into sec_role (roleName)
values ('ROLE_USER');

insert into user_role (userId, roleId)
values (1, 1);

insert into user_role (userId, roleId)
values (2, 2);

INSERT INTO tasks (name, lenght, day) VALUES
('Math Homework', 2, 'Monday'),
('English Homework', 3, 'Tuesday'),
('French Quiz Study', 7, 'Thursday'),
('English Quiz', 7, 'Wednesday'),
('Physics Lab', 7, 'Friday'),
('French Book', 7, 'Friday'),
('Catch up in Java', 7, 'Friday');



