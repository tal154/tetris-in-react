drop database if exists tetris_test;
create database tetris_test;
use tetris_test;

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

delimiter //
create procedure set_known_good_state()
begin
	delete from score;
	delete from `user`;
	
	alter table score auto_increment=1;
	alter table `user` auto_increment=1;
    
    insert into `user` (username, user_pass, user_role_id) values
		('name', 'pass', 1),
		('name2', 'pass2', 1);
        
	insert into score (user_id, score) values
		(1, 100),
        (2, 200);
end//
delimiter ;