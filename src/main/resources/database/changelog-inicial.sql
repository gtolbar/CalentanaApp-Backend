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
CREATE TABLE precio_ingreso(
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
	id_precio_ingreso INT NOT NULL,
		FOREIGN KEY(id_precio_ingreso) REFERENCES precio_ingreso(id)
        
);