CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    fecha_nac DATE,
    raza VARCHAR(255),
    peso INT,
    tiene_chip BOOLEAN,
    url_foto VARCHAR(255)
);