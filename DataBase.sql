Create table users (

NICKNAME varchar(100) UNIQUE,
PSSWORD varchar(100)

);

Create table conversation(

NICKNAME1 varchar(100) ,
NICKNAME2 varchar(100),
MESSAGE varchar(1000),
MOMENT DATE

);

create table profile(
nombre varchar(100),
apellido1 varchar(100),
apellido2 varchar(100),
edad int,
sexo char(1));

Create table Images (

IMAGE BLOB(10000),
MOMENT DATE,
NICKNAME Varchar(100)


);

--Examples

Insert into users (NICKNAME,PSSWORD) Values ('Alfonso', '1234');
Insert into users (NICKNAME,PSSWORD) Values ('francisca', '4321');


