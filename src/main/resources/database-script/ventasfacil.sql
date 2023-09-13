CREATE DATABASE ventasfacil;

USE ventasfacil;

CREATE TABLE articulos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2),
    marca VARCHAR(255),
    modelo VARCHAR(255),
    fechaRegistro DATE
);

CREATE TABLE servicios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2),
    unidadMedida VARCHAR(255),
    frecuencia INT,
    fechaRegistro DATE
);