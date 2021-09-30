create table users(
	userid int primary key generated always as identity,
	firstname varchar(30),
	lastname varchar(30),
	username varchar(30),
	password varchar(20),
	isAdmin boolean,
	isEmployee boolean,
	phoneNumber numeric,
	streetnumber numeric,
	streetname varchar(30),
	city varchar(20),
	state varchar(2),
	zipCode numeric
);

create or replace function insert_basicuser(f_firstname varchar(30), f_lastname varchar(30), f_username varchar(30),f_password varchar(20))
returns varchar(10) as $$
begin 
	insert into users(firstname, lastname, username, password) values (f_firstname, f_lastname, f_username, f_password);
	return 'Success';
end;
$$ language 'plpgsql'

select insert_basicuser('Sam','Funk', 'sfunk', 'P4ssw0rd');
select insert_basicuser('Tom','Smith', 'tsmith', 'P4ssw0rd');
select insert_basicuser('Cameron','Funk', 'cfunk', 'P4ssw0rd');

select * from users;
