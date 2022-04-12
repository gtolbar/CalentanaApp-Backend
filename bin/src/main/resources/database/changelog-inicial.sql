-- liquibase formatted sql

-- changeset gustavo:1
-- comment: Se crea tabla insumos primera vez
CREATE TABLE insumos(
	id INT PRIMARY KEY AUTO_INCREMENT,
    proveedor VARCHAR(30) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    producto VARCHAR(30) NOT NULL,
    comentario VARCHAR(255)  
);

-- changeset gustavo:2
-- comment: Se crea tabla de precio entrada primera vez
CREATE TABLE precio_ingresos(
	id INT PRIMARY KEY  AUTO_INCREMENT,
	precio INT UNSIGNED NOT NULL,
    comentario VARCHAR(255)  
);

-- changeset gustavo:3
-- comment: Se crea tabla de estado de insumos primera vez
CREATE TABLE estado_insumos(
	id INT PRIMARY KEY  AUTO_INCREMENT,
    cantidad INT UNSIGNED NOT NULL,
    fecha DATE NOT NULL,
    accion BOOLEAN,
	comentario VARCHAR(255),
	id_insumos INT NOT NULL,
		FOREIGN KEY(id_insumos) REFERENCES insumos(id),
	id_precio_ingresos INT NOT NULL,
		FOREIGN KEY(id_precio_ingresos) REFERENCES precio_ingresos(id)
        
);

-- changeset gustavo:4
-- comment: Se insertan datos de prueba
INSERT INTO insumos(proveedor,marca,producto,comentario) VALUE 
("Papa noel","saltin","galletas","Preuba 1"),("Supermercado","Doña arepa","harina","Prueba 2");


-- changeset gustavo:5
-- comment: Se insertan datos de prueba
INSERT INTO precio_ingresos(precio,comentario) VALUE 
("500","Prueba 1"),("700","Prueba 1"),("800","Prueba 1"),("900","Prueba 1");

-- changeset gustavo:6
-- comment: Se insertan datos de prueba
INSERT INTO estado_insumos(cantidad,fecha,accion,comentario,id_insumos,id_precio_ingresos) VALUE 
("40","2015-12-17",true,"Jejejej","2","1"),
("30","2015-12-19",false,"Jejejej","2","1"),
("60","2015-12-29",true,"Jejejej","1","1");

