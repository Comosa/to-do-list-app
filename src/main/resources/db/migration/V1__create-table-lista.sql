create table To_Do(

id bigint not null  auto_increment,
titulo varchar(150) not null,
descripcion varchar(300) not null,
Fecha_creacion varchar(20) not null,
Fecha_terminacion varchar(20) not null,
finalizada varchar(4),
estado varchar(10),
primary key(id)
);