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
cantidad NUMERIC,
total VARCHAR,
fecha DATE, 
id_galleta INT,
FOREIGN KEY (id_galleta) REFERENCES galleta(id_galleta)
);

--Consulta que trae todas las ventas
SELECT g.nombre AS nombre_galleta, v.cantidad AS cantidad_vendida , v.fecha as fecha 
FROM venta v
JOIN galleta g ON v.id_galleta = g.id_galleta;

--Consulta que trae todas las ventas por fecha
SELECT DATE(fecha) AS fecha, g.nombre AS nombre_galleta, SUM(v.cantidad) AS cantidad_vendida
FROM venta v
JOIN galleta g ON v.id_galleta = g.id_galleta
GROUP BY DATE(fecha), g.nombre
ORDER BY DATE(fecha), g.nombre;


-- Tabla materia prima
--NO USADA ACTUALMENTA
CREATE TABLE materia_prima(
	id_materia_prima SERIAL PRIMARY KEY NOT NULL,
	ingrediente VARCHAR,
	peso VARCHAR
);





SELECT DATE(fecha) AS fecha, g.nombre AS nombre_galleta, SUM(v.cantidad) AS cantidad_vendida
FROM venta v
JOIN galleta g ON v.id_galleta = g.id_galleta
GROUP BY DATE(fecha), g.nombre
ORDER BY DATE(fecha), g.nombre;


-- Filtra las ventas de hoy
SELECT DATE(fecha) AS fecha, g.nombre AS nombre_galleta, SUM(v.cantidad) AS cantidad_vendida
FROM venta v
JOIN galleta g ON v.id_galleta = g.id_galleta
WHERE DATE(fecha) = CURRENT_DATE 
GROUP BY DATE(fecha), g.nombre
ORDER BY DATE(fecha), g.nombre;


--filtra las ventas de la semana
SELECT DATE(fecha) AS fecha, 
       g.nombre AS nombre_galleta, 
       SUM(v.cantidad) AS cantidad_vendida
FROM venta v
JOIN galleta g ON v.id_galleta = g.id_galleta
WHERE EXTRACT(WEEK FROM fecha) = EXTRACT(WEEK FROM CURRENT_DATE) -- Filtra las ventas de la semana actual
GROUP BY DATE(fecha), g.nombre
ORDER BY DATE(fecha), g.nombre;

--Filtra las ventas del mes
SELECT DATE(fecha) AS fecha, 
       g.nombre AS nombre_galleta, 
       SUM(v.cantidad) AS cantidad_vendida
FROM venta v
JOIN galleta g ON v.id_galleta = g.id_galleta
WHERE EXTRACT(MONTH FROM fecha) = EXTRACT(MONTH FROM CURRENT_DATE) -- Filtra las ventas del mes actual
GROUP BY DATE(fecha), g.nombre
ORDER BY DATE(fecha), g.nombre;

