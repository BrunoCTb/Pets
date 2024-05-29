insert into petsecommercedb.user values (55, "admin", "admin@gmail.com", "123")

insert into petsecommercedb.role values (1, "ROLE_USER")
insert into petsecommercedb.role values (2, "ROLE_ADMIN")

insert into petsecommercedb user_roles values (2, 55)
