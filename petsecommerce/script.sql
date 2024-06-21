-- User/Role

-- default roles
insert into petsecommercedb.role values (1, "ROLE_USER")
insert into petsecommercedb.role values (2, "ROLE_ADMIN")

-- admin user
insert into petsecommercedb.users values (55, "admin", "admin@gmail.com", "123")

-- join admin user with role admin
insert into petsecommercedb.user_roles values (2, 55)

----------------------------------
-- default categories
insert into petsecommercedb.product_category (id, name, image) values
(1, "cachorros", null),
(2, "gatos", null),
(3, "coelhos", null);

-- Product/Category
INSERT INTO petsecommercedb.product (id, name, color, size, offer, image, price, discount_price, previous_price, initial_offer, expiration_offer, category_id) values
(1, "Cama para Cachorros", "Azul", "Grande", TRUE, "https://example.com/images/cama_cachorros.jpg", 150.00, 120.00, 150.00, '2024-06-01', '2024-06-15', 1),
(2, "Arranhador para Gatos", "Bege", "Médio", TRUE, "https://example.com/images/arranhador_gatos.jpg", 200.00, 180.00, 200.00, '2024-06-01', '2024-06-15', 2),
(3, "Casinha para Coelhos", "Verde", "Pequeno", TRUE, "https://example.com/images/casinha_coelhos.jpg", 100.00, 80.00, 100.00, '2024-06-01', '2024-06-15', 3);


