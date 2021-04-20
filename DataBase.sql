Create table users (

NICKNAME varchar(100) UNIQUE,
PSSWORD varchar(100)
PSSWORD varchar(100),
ID NUMBER PRIMARY KEY

);

Create table conversation(

NICKNAME1 varchar(100) ,
NICKNAME2 varchar(100),
ID1 NUMBER(100),
ID2 NUMBER(100),
MESSAGE varchar(1000),
MOMENT DATE
MOMENT DATE,

CONSTRAINT PKconversation FOREIGN KEY (ID1, ID2) REFERENCES users(ID)

);

create table profile(
nombre varchar(100),
apellido1 varchar(100),
apellido2 varchar(100),
edad int,
sexo char(1));
edad NUMBER,
sexo char(1),
ID NUMBER(100) PRIMARY KEY REFERENCES users(ID)

);


Create table Images (

IMAGE BLOB(10000),
MOMENT DATE,
NICKNAMES Varchar(100)
ID NUMBER(100) PRIMARY KEY REFERENCES users(ID)


);

Create table recorrido (
  latitud_origen binary_double,
  longitud_origen binary_double,
  latitud_destino binary_double,
  longitud_destino binary_double,
  tiempoDeInicio timestamp,
  tiempoFinal timestamp

);


Create table actualizacion (
  wayPoints binary_double
  latitud binary_double,
  longitud binary_double

);

--Examples

Insert into users (NICKNAME,PSSWORD) Values ('Alfonso', '1234');
Insert into users (NICKNAME,PSSWORD) Values ('francisca', '4321');


