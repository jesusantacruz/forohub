# ForoHub - Challenge Back End

¡Bienvenido al último desafío Challenge Back End!

## Descripción

ForoHub es un proyecto que simula el funcionamiento de un foro a nivel de back end, propuesto como challenge final para el curso Alura 

En este proyecto, replicaremos el proceso de un foro a nivel de back end, creando una API REST usando Spring. Nuestra API se centrará específicamente en los tópicos, y debe permitir a los usuarios realizar las siguientes acciones:

- Crear un nuevo tópico.
- Mostrar todos los tópicos creados.
- Mostrar un tópico específico.
- Actualizar un tópico.
- Eliminar un tópico.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (para pruebas)
- Maven

## Instrucciones SQL

Una vez ejecutado el proyecto proyecto, asegúrate de insertar los datos iniciales en la base de datos. 
Son necesarias para poder ingresar al API el password para todos los usuarios es 312321
Para ello, ejecuta las siguientes instrucciones SQL:

```sql
INSERT INTO users (username, pass, email) VALUES ('usuario1', '$2a$12$HgdfrAv1tRX3vMOWHW4Fxe7IoM49lK.D8YCbDFjVPwxX2NwLiGGJG','test@email.com');
INSERT INTO users (username, pass, email) VALUES ('usuario2', '$2a$12$HgdfrAv1tRX3vMOWHW4Fxe7IoM49lK.D8YCbDFjVPwxX2NwLiGGJG','test2@email.com');
INSERT INTO users (username, pass, email) VALUES ('usuario3', '$2a$12$HgdfrAv1tRX3vMOWHW4Fxe7IoM49lK.D8YCbDFjVPwxX2NwLiGGJG','test3@email.com');
INSERT INTO users (username, pass, email) VALUES ('usuario4', '$2a$12$HgdfrAv1tRX3vMOWHW4Fxe7IoM49lK.D8YCbDFjVPwxX2NwLiGGJG','test4@email.com');

INSERT INTO courses (name) VALUES ('Noticias');
INSERT INTO courses (name) VALUES ('Entretenimiento');
INSERT INTO courses (name) VALUES ('Juegos');