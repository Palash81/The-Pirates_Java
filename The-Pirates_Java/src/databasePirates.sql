create database Simulator;
use Simulator;

create table  Ships (name varchar(20), maxWeight int(3), currentWeight int(3), 
                    maxSpeed int(2), cruiseSpeed int(2),
                    destination char(1), order_id int(3), in_harbor boolean, 
                    harborName char(1), position_X int(2), postion_Y int(2));
create table  Harbor (name varchar(1), storage int(4));
create table Orders (order_id smallint not null auto_increment primary key, harbor char(1), destination1 char(1), destination2 char(1), cargo_weight int(2));


insert into harbor (name, storage)
VALUES  ('A', 50),
        ('B', 50),
        ('C', 50),
        ('D', 50),
        ('E', 50);

select * from harbor;

insert into ships (name, maxWeight, currentWeight, maxSpeed, cruiseSpeed, destination, order_id, in_harbor, harborName, position_X, position_Y)
VALUES  ('JonssonCargo', 50, 0, 20, 15, default, default, 1, 'A',0 ,0),
        ('MotherRussia', 35, 0, 18, 13, default, default,  1, 'A', 0,0),
        ('AkerstromShipping', 32, 0, 19, 14, default, default, 1, 'B', 0,0),
        ('NordicExpress', 25, 0, 20, 15, default, default,  1, 'B', 0,0),
        ('FarEastCargo', 50, 0, 18, 12, default, default,  1, 'C', 0,0),
        ('Evergreen', 45, 0, 20, 15, default, default,  1, 'C', 0,0),
        ('CasablancaExpress', 40, 0, 20, 10, default, default,  1, 'D', 0,0),
        ('RotterdamGreen', 35, 0, 18, 12, default, default, 1, 'D', 0,0),
        ('HamburgSud', 25, 0, 18, 13, default, default, 1, 'E', 0,0),
        ('OceansExpress', 50, 0, 20, 15, default, default, 1, 'E', 0,0);

insert into orders(order_id, harbor, destination1, destination2, cargo_weight)
VALUES  (100, 'A', 'B', null, 15),
        (101, 'B', 'C', null, 5),
        (102, 'C', 'D', null, 10),
        (103, 'A', 'B', null, 8),
        (104, 'A', 'B', null, 9),
        (105, 'A', 'B', null, 7);

