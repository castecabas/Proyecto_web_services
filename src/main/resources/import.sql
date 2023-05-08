
INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida');

INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(1,'Camilo', 'Guzmán', 'profesor@gmail.com', '2018-01-01');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(2,'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(1,'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(3,'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(4,'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(4,'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(2,'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(1,'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(5,'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(6,'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(7,'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (region_id,nombre, apellido, correo, create_at) VALUES(8,'Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');


INSERT INTO Productos (Nombre,Precio,create_at) VALUES ('Val',500,'2020-05-04');
INSERT INTO Productos (Nombre,Precio,create_at) VALUES ('H&S',1200,NOW());

INSERT INTO Facturas (Cliente_id,descripcion,Tipo_entrega,create_at) VALUES (1,'Medicamentos Basicos','Efectivo',NOW());

INSERT INTO Facturas_Producto(Cantidad,factura_id,producto_id) VALUES(3,1,2);


