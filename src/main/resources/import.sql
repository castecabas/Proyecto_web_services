/* REGIONES*/
INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida');

/* PRODUCTOS */
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Val',500,'2020-05-04');
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('H&S',1200,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('CAFI Aspirina',4200,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Alka-seltzer X 60',60000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Apronax X50 275Mg',28000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Cicatricure X 60 Gr',60000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('X-Ray Gel 30 Gr',28000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Lubriderm X 200Ml',17000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Gaviscon Doble X 300Ml',60000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Dolex X 90Ml',15000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Asepxia Gen X50 Gr',18000,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Vitamina c MK naranja',41600,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Shot B suplemento',37900,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Centrum silter X30',36550,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Leche de magnesia',8150,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Lumbal forte',15180,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Bonfiest plus X6',19300,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Allegra 150ml',80750,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Genfar kids Cetirizina alergias 60ml',28750,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Pancreatina simeticona MK',61700,NOW());
INSERT INTO productos (Nombre,Precio,create_at) VALUES ('Mareol X12',8250,NOW());

/* Facturas */
INSERT INTO facturas (Cliente_id,descripcion,Tipo_entrega,create_at) VALUES (1,'Medicamentos Basicos','Efectivo',NOW());
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(1,3,2);
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(1,10,1);

INSERT INTO facturas (Cliente_id,descripcion,Tipo_entrega,create_at) VALUES (2,'Medicamentos Basicos','Tarjeta de Crédito',NOW());
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(2,1,2);
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(2,4,10);
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(2,3,5);
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(2,1,6);

INSERT INTO facturas (Cliente_id,descripcion,Tipo_entrega,create_at) VALUES (3,'Medicamentos Basicos','Efectivo',NOW());
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(3,1,7);

INSERT INTO facturas (Cliente_id,descripcion,Tipo_entrega,create_at) VALUES (4,'Medicamentos Basicos','Eectivo',NOW());
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(4,3,5);
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(4,3,8);

INSERT INTO facturas (Cliente_id,descripcion,Tipo_entrega,create_at) VALUES (5,'Medicamentos Basicos','Tarjeta de Crédito',NOW());
INSERT INTO facturas_producto(factura_id,Cantidad,producto_id) VALUES(5,10,9);