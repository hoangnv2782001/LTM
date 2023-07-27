create database btl;

use btl;

create table floor(
   id integer auto_increment primary key,
   name varchar(50) not null,
   decription varchar(255) not null
);

create table room(
   id integer auto_increment primary key,
   name varchar(50) not null,
   area float not null,
   populationOfRoom integer not null,
   floor_id integer not null,
   foreign key(floor_id) references floor(id) on delete cascade
);