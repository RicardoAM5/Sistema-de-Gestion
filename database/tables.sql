--Tabla usuario--
CREATE TABLE usuario(
	id_usuario SERIAL,
	usuario VARCHAR,
	contrasenia VARCHAR
);
--Tabla galleta--
CREATE TABLE galleta(
 id_galleta SERIAL PRIMARY KEY NOT NULL,
 nombre VARCHAR,
 cantidad VARCHAR,
 precio_unitario VARCHAR,
 precio_kilo VARCHAR,
imagen_base64 VARCHAR,
 descripcion VARCHAR
);
--Tabla inventario--
CREATE TABLE inventario(
id_inventario SERIAL PRIMARY KEY NOT NULL, 
cantidad VARCHAR,
id_galleta INT,
FOREIGN KEY (id_galleta) REFERENCES galleta(id_galleta)
);
--Tabla venta--
CREATE TABLE venta(
id_venta SERIAL PRIMARY KEY NOT NULL,
cantidad VARCHAR,
total VARCHAR,
fecha timestamp, 
id_galleta INT,
FOREIGN KEY (id_galleta) REFERENCES galleta(id_galleta)
);

-- Tabla materia prima
--NO USADA ACTUALMENTA
CREATE TABLE materia_prima(
	id_materia_prima SERIAL PRIMARY KEY NOT NULL,
	ingrediente VARCHAR,
	peso VARCHAR
);






