create database Simulator;

create table  Ships (name varchar(20), maxWeight int(3), currentWeight int(3), 
                    maxSpeed int(2), cruiseSpeed int(2), position varchar(20),
                    destination char(1), order_id int(3), in_harbor boolean, 
                    harborName char(1));
create table  Harbor (name varchar(1), storage int(4));
create table Orders (order_id smallint not null auto_increment primary key, harbor char(1), destination1 char(1), destination2 char(1), cargo_weight int(2));

