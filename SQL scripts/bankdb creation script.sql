create table users(
	userid int primary key generated always as identity,
	firstname varchar(30),
	lastname varchar(30),
	username varchar(30),
	password varchar(20),
	isAdmin boolean default false,
	isEmployee boolean default false,
	phoneNumber numeric,
	streetnumber numeric,
	streetname varchar(30),
	city varchar(20),
	state varchar(2),
	zipCode numeric
);

drop table users;

create or replace function insert_basicuser(f_firstname varchar(30), f_lastname varchar(30), f_username varchar(30),f_password varchar(20), f_email varchar(50))
returns varchar(10) as $$
begin 
	insert into users(firstname, lastname, username, password,email) values (f_firstname, f_lastname, f_username, f_password, f_email);
	return 'Success';
end;
$$ language 'plpgsql'

select insert_basicuser('Sam', 'Funk', 'sfunk', 'password','sfunk@email.com');

select * from users where username = 'sfunk';
