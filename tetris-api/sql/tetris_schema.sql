drop database if exists tetris;
create database tetris;
use tetris;

create table `user` (
	user_id int primary key auto_increment,
    username varchar(50) not null,
    user_pass varchar (50) not null,
    user_role_id int not null,
    constraint fk_user_role_id
        foreign key (user_role_id)
        references user_role(user_role_id)
);

create table user_role (
	user_role_id int primary key auto_increment,
    user_role varchar(50) not null
);

create table score (
	score_id int primary key auto_increment,
    user_id int not null,
    score int not null,
    constraint fk_user_id
        foreign key (user_id)
        references `user`(user_id)
);

create table game (
	game_id int primary key auto_increment,
    game_name varchar(100) not null
);