-- User/Role

-- default roles
insert into petsecommercedb.role values (1, "ROLE_USER")
insert into petsecommercedb.role values (2, "ROLE_ADMIN")

-- admin user
insert into petsecommercedb.users values (55, "admin", "admin@gmail.com", "123")

-- join admin user with role admin
insert into petsecommercedb.user_roles values (2, 55)

----------------------------------

-- Product/Category

-- default categories
insert into petsecommercedb.product_category values
(1, "cachorros", null),
(2, "gatos", null),
(3, "coelhos", null);

