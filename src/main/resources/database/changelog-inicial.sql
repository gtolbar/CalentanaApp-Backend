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
-- comment: Se crea tabla DE ROL
CREATE TABLE rol(
	id INT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion VARCHAR(50)
);

-- changeset gustavo:4
-- comment: Se crea tabla de USUARIO
CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    clave VARCHAR(255) NOT NULL,
    estado bit(1) NOT NULL
);

-- changeset gustavo:5
-- comment: Se crea tabla pivote usuario rol
CREATE TABLE usuario_rol(
	id_usuario INT NOT NULL,
	id_rol INT NOT NULL,
		FOREIGN KEY (id_usuario) REFERENCES usuario(id),
        FOREIGN KEY (id_rol) REFERENCES rol(id)	
    );

-- changeset gustavo:6
-- comment: Se crea tabla de estado de insumos primera vez
CREATE TABLE estado_insumos(
	id INT PRIMARY KEY AUTO_INCREMENT,
    cantidad INT UNSIGNED NOT NULL,
    fecha DATE NOT NULL,
    accion BOOLEAN,
	comentario VARCHAR(255),
	id_insumos INT NOT NULL,
		FOREIGN KEY(id_insumos) REFERENCES insumos(id),
	id_precio_ingresos INT NOT NULL,
		FOREIGN KEY(id_precio_ingresos) REFERENCES precio_ingresos(id)
        
);

-- changeset gustavo:7
-- comment: Se insertan datos de prueba
INSERT INTO insumos(proveedor,marca,producto,comentario) VALUE 
("Papa noel","saltin","galletas","Preuba 1"),("Supermercado","Doña arepa","harina","Prueba 2");


-- changeset gustavo:8
-- comment: Se insertan datos de prueba
INSERT INTO precio_ingresos(precio,comentario) VALUE 
("500","Prueba 1"),("700","Prueba 1"),("800","Prueba 1"),("900","Prueba 1");

-- changeset gustavo:9
-- comment: Se insertan datos de prueba
INSERT INTO estado_insumos(cantidad,fecha,accion,comentario,id_insumos,id_precio_ingresos) VALUE 
("30","2021-01-01",true,"Sin comentarios","1","1"),
("40","2021-01-03",false,"Sin comentarios","2","3"),
("50","2021-01-05",true,"Sin comentarios","1","2"),
("60","2021-01-07",false,"Sin comentarios","2","1"),
("40","2021-01-09",true,"Sin comentarios","1","3"),
("50","2021-01-11",true,"Sin comentarios","2","2"),
("30","2021-01-13",false,"Sin comentarios","1","1"),
("40","2021-01-15",true,"Sin comentarios","2","3"),
("50","2021-01-17",false,"Sin comentarios","1","2"),
("60","2021-01-19",true,"Sin comentarios","2","2"),
("40","2021-01-21",true,"Sin comentarios","1","2"),
("50","2021-01-23",false,"Sin comentarios","2","2"),
("60","2021-01-25",true,"Sin comentarios","1","2"),
("40","2021-01-27",false,"Sin comentarios","2","2"),
("50","2021-01-29",true,"Sin comentarios","1","3"),
("30","2021-01-31",true,"Sin comentarios","2","3"),
("40","2021-02-02",false,"Sin comentarios","1","3"),
("50","2021-02-04",true,"Sin comentarios","2","3"),
("30","2021-02-06",false,"Sin comentarios","1","3"),
("40","2021-02-08",true,"Sin comentarios","2","1"),
("50","2021-02-10",true,"Sin comentarios","1","3"),
("60","2021-02-12",false,"Sin comentarios","2","2"),
("40","2021-02-14",true,"Sin comentarios","1","2"),
("50","2021-02-16",false,"Sin comentarios","2","2"),
("30","2021-02-18",true,"Sin comentarios","1","2"),
("40","2021-02-20",true,"Sin comentarios","2","3"),
("50","2021-02-22",false,"Sin comentarios","1","3"),
("30","2021-02-24",true,"Sin comentarios","2","3"),
("40","2021-02-26",false,"Sin comentarios","1","1"),
("50","2021-02-28",true,"Sin comentarios","2","3"),
("60","2021-03-02",true,"Sin comentarios","1","2"),
("40","2021-03-04",false,"Sin comentarios","2","2"),
("50","2021-03-06",true,"Sin comentarios","1","2"),
("30","2021-03-08",false,"Sin comentarios","2","2"),
("40","2021-03-10",true,"Sin comentarios","1","3"),
("50","2021-03-12",true,"Sin comentarios","2","3"),
("60","2021-03-14",false,"Sin comentarios","1","1"),
("40","2021-03-16",true,"Sin comentarios","2","3"),
("50","2021-03-18",false,"Sin comentarios","1","2"),
("30","2021-03-20",true,"Sin comentarios","2","2"),
("30","2021-03-22",true,"Sin comentarios","1","2"),
("40","2021-03-24",false,"Sin comentarios","2","2"),
("50","2021-03-26",true,"Sin comentarios","1","4"),
("60","2021-03-28",false,"Sin comentarios","2","4"),
("40","2021-03-30",true,"Sin comentarios","1","1"),
("50","2021-04-01",true,"Sin comentarios","2","3"),
("30","2022-01-31",true,"Sin comentarios","2","3"),
("30","2022-02-01",true,"Sin comentarios","1","1"),
("40","2022-02-02",false,"Sin comentarios","2","3"),
("50","2022-02-03",true,"Sin comentarios","1","2"),
("60","2022-02-04",false,"Sin comentarios","2","1"),
("40","2022-02-05",true,"Sin comentarios","1","3"),
("50","2022-02-06",true,"Sin comentarios","2","2"),
("30","2022-02-07",false,"Sin comentarios","1","1"),
("40","2022-02-08",true,"Sin comentarios","2","3"),
("50","2022-02-09",false,"Sin comentarios","1","2"),
("60","2022-02-10",true,"Sin comentarios","2","2"),
("40","2022-02-11",true,"Sin comentarios","1","2"),
("50","2022-02-12",false,"Sin comentarios","2","2"),
("60","2022-02-13",true,"Sin comentarios","1","2"),
("40","2022-02-14",false,"Sin comentarios","2","2"),
("50","2022-02-15",true,"Sin comentarios","1","3"),
("30","2022-02-16",true,"Sin comentarios","2","3"),
("40","2022-02-17",false,"Sin comentarios","1","3"),
("50","2022-02-18",true,"Sin comentarios","2","3"),
("30","2022-02-19",false,"Sin comentarios","1","3"),
("40","2022-02-20",true,"Sin comentarios","2","1"),
("50","2022-02-21",true,"Sin comentarios","1","3"),
("60","2022-02-22",false,"Sin comentarios","2","2"),
("40","2022-02-23",true,"Sin comentarios","1","2"),
("50","2022-02-24",false,"Sin comentarios","2","2"),
("30","2022-02-25",true,"Sin comentarios","1","2"),
("40","2022-02-26",true,"Sin comentarios","2","3"),
("50","2022-02-27",false,"Sin comentarios","1","3"),
("30","2022-02-28",true,"Sin comentarios","2","3"),
("40","2022-03-01",false,"Sin comentarios","1","1"),
("50","2022-03-02",true,"Sin comentarios","2","3"),
("60","2022-03-03",true,"Sin comentarios","1","2"),
("40","2022-03-04",false,"Sin comentarios","2","2"),
("50","2022-03-05",true,"Sin comentarios","1","2"),
("30","2022-03-06",false,"Sin comentarios","2","2"),
("40","2022-03-07",true,"Sin comentarios","1","3"),
("50","2022-03-08",true,"Sin comentarios","2","3"),
("60","2022-03-09",false,"Sin comentarios","1","1"),
("40","2022-03-10",true,"Sin comentarios","2","3"),
("50","2022-03-11",false,"Sin comentarios","1","2"),
("30","2022-03-12",true,"Sin comentarios","2","2"),
("30","2022-03-13",true,"Sin comentarios","1","2"),
("40","2022-03-14",false,"Sin comentarios","2","2"),
("50","2022-03-15",true,"Sin comentarios","1","4"),
("60","2022-03-16",false,"Sin comentarios","2","4"),
("40","2022-03-17",true,"Sin comentarios","1","1"),
("50","2022-03-18",true,"Sin comentarios","2","3"),
("30","2022-03-19",true,"Sin comentarios","2","3"),
("50","2022-03-20",false,"Sin comentarios","1","3"),
("30","2022-03-21",true,"Sin comentarios","2","3"),
("30","2022-03-22",false,"Sin comentarios","1","3"),
("40","2022-03-23",true,"Sin comentarios","2","1"),
("50","2022-03-24",true,"Sin comentarios","1","3"),
("60","2022-03-25",false,"Sin comentarios","2","2"),
("40","2022-03-26",true,"Sin comentarios","1","2"),
("50","2022-03-27",false,"Sin comentarios","2","2"),
("30","2022-03-28",true,"Sin comentarios","1","2"),
("50","2022-03-29",true,"Sin comentarios","2","3"),
("30","2022-03-30",false,"Sin comentarios","1","3"),
("30","2022-03-31",true,"Sin comentarios","2","3"),
("40","2022-04-01",false,"Sin comentarios","1","1"),
("50","2022-04-02",true,"Sin comentarios","2","3"),
("60","2022-04-03",true,"Sin comentarios","1","2"),
("40","2022-04-04",false,"Sin comentarios","2","2"),
("50","2022-04-05",true,"Sin comentarios","1","2"),
("30","2022-04-06",false,"Sin comentarios","2","2");

-- changeset gustavo:10
-- comment: Se insertan roles
INSERT INTO rol(id, nombre, descripcion) VALUES 
("1", "ADMIN", "Administrador"),
("2", "USER", "Usuario"),
("3", "DBA", "Admin de bd");

