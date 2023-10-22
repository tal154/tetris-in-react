drop database if exists tetris;
create database tetris;
use tetris;

create table user_role (
	user_role_id int primary key auto_increment,
    user_role varchar(50) not null
);

create table `user` (
	user_id int primary key auto_increment,
    username varchar(50) not null,
    user_pass varchar (50) not null,
    user_role_id int not null,
    constraint fk_user_role_id
        foreign key (user_role_id)
        references user_role(user_role_id)
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

insert into user_role (user_role) values
	('user'),
    ('admin');

insert into `user` (username, user_pass, user_role_id) values
		('TAL', 'pass', 1),
        ('CAL', 'pass', 1),
        ('ACE', 'pass', 1),
        ('BIL', 'pass', 1),
        ('CSL', 'pass', 1),
        ('DAN', 'pass', 1),
        ('ELA', 'pass', 1),
		('MJL', 'pass2', 1);
        
	insert into score (user_id, score) values
		(1, 100),
        (2, 1000),
        (3, 200),
        (4, 340),
        (5, 280),
        (5, 1200),
        (6, 1400),
        (7, 400),
        (8, 300),
        (8, 900),
        (2, 200);