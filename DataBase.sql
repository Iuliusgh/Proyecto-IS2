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

Insert into users (NICKNAME,PSSWORD) Values ('Alfonso', '1234');
Insert into users (NICKNAME,PSSWORD) Values ('francisca', '4321');
