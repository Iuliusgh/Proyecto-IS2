Create table users (

NICKNAME varchar(100) UNIQUE,
PSSWORD varchar(100),
ID NUMBER PRIMARY KEY

);

Create table conversation(

ID1 NUMBER(100),
ID2 NUMBER(100),
MESSAGE varchar(1000),
MOMENT DATE,

CONSTRAINT PKconversation FOREIGN KEY (ID1, ID2) REFERENCES users(ID)

);

create table profile(
nombre varchar(100),
apellido1 varchar(100),
apellido2 varchar(100),
edad NUMBER,
sexo char(1),
ID NUMBER(100) PRIMARY KEY REFERENCES users(ID)

);


Create table Images (

IMAGE BLOB(10000),
MOMENT DATE,
ID NUMBER(100) PRIMARY KEY REFERENCES users(ID)


);

--Examples

Insert into users (NICKNAME,PSSWORD) Values ('Alfonso', '1234');
Insert into users (NICKNAME,PSSWORD) Values ('francisca', '4321');


