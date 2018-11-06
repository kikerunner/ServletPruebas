/*DROP TABLE PERSONAS;*/

create table IF NOT EXISTS PERSONAS(
	codPersona INT IDENTITY,
	nombre varchar(25),
	apellido varchar(25)
);