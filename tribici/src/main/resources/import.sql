-- INSERTS para H2 - Sistema Tribici

-- Usuarios
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('Carlos García', 1001234567, '1234', 25.50);
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('María López', 1002345678, '5678', 50.00);
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('Juan Martínez', 1003456789, '9012', 15.75);
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('Ana Fernández', 1004567890, '3456', 100.00);
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('Pedro Sánchez', 1005678901, '7890', 5.25);

-- Estaciones
INSERT INTO estacion (numero, nombre, coordenadas, capacidad) VALUES (1, 'Estación Sol', 40.4168, 20);
INSERT INTO estacion (numero, nombre, coordenadas, capacidad) VALUES (2, 'Estación Retiro', 40.4152, 15);
INSERT INTO estacion (numero, nombre, coordenadas, capacidad) VALUES (3, 'Estación Atocha', 40.4067, 25);
INSERT INTO estacion (numero, nombre, coordenadas, capacidad) VALUES (4, 'Estación Plaza Mayor', 40.4155, 18);
INSERT INTO estacion (numero, nombre, coordenadas, capacidad) VALUES (5, 'Estación Cibeles', 40.4189, 22);

-- Bicicletas
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Trek', 'FX 3', 'NUEVA', 1);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Giant', 'Escape 2', 'USADA', 1);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Specialized', 'Sirrus', 'SEMINUEVO', 2);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Cannondale', 'Quick 4', 'NUEVA', 2);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Scott', 'Sub Sport', 'USADA', 3);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Orbea', 'Vector 20', 'AVERIADA', 3);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('BH', 'Silvertip', 'NUEVA', 4);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Merida', 'Crossway 100', 'SEMINUEVO', 4);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('Cube', 'Nature Pro', 'USADA', 5);
INSERT INTO bicicleta (marca, modelo, estado, esta_en) VALUES ('KTM', 'Life Track', 'NUEVA', 5);

-- Usos
INSERT INTO uso (fecha_inicio, fecha_fin, coste, bicicleta_id, usuario_id, inicio, fin) VALUES ('2026-01-05', '2026-01-05', 2.50, 1, 1, 1, 2);
INSERT INTO uso (fecha_inicio, fecha_fin, coste, bicicleta_id, usuario_id, inicio, fin) VALUES ('2026-01-06', '2026-01-06', 3.00, 2, 2, 1, 3);
INSERT INTO uso (fecha_inicio, fecha_fin, coste, bicicleta_id, usuario_id, inicio, fin) VALUES ('2026-01-07', '2026-01-07', 1.50, 3, 3, 2, 4);
INSERT INTO uso (fecha_inicio, fecha_fin, coste, bicicleta_id, usuario_id, inicio, fin) VALUES ('2026-01-07', '2026-01-07', 4.00, 4, 1, 2, 5);
INSERT INTO uso (fecha_inicio, fecha_fin, coste, bicicleta_id, usuario_id, inicio, fin) VALUES ('2026-01-08', '2026-01-08', 2.75, 5, 4, 3, 1);
INSERT INTO uso (fecha_inicio, fecha_fin, coste, bicicleta_id, usuario_id, inicio, fin) VALUES ('2026-01-08', NULL, 0.00, 7, 2, 4, NULL);
INSERT INTO uso (fecha_inicio, fecha_fin, coste, bicicleta_id, usuario_id, inicio, fin) VALUES ('2026-01-09', NULL, 0.00, 9, 5, 5, NULL);