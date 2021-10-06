--- Create User Table
create table users(
	userid int primary key generated always as identity,
	firstname varchar(30),
	lastname varchar(30),
	username varchar(30),
	password varchar(20),
	isAdmin boolean default false,
	isEmployee boolean default false,
	email varchar(50),
);


create or replace function insert_basicuser(f_firstname varchar(30), f_lastname varchar(30), f_username varchar(30),f_password varchar(20), f_email varchar(50))
returns varchar(10) as $$
begin 
	insert into users(firstname, lastname, username, password,email) values (f_firstname, f_lastname, f_username, f_password, f_email);
	return 'Success';
end;
$$ language 'plpgsql'



create or replace function update_user(f_firstname varchar(30), f_lastname varchar(30), f_username varchar(30),f_password varchar(20), f_isAdmin boolean, f_isEmployee boolean, f_email varchar(50), f_userid int )
returns varchar(10) as $$
begin 
	update users set firstname = f_firstname, lastname = f_lastname, username = f_username, password = f_password, isAdmin = f_isAdmin, isEmployee = f_isEmployee, email = f_email where userid = f_userid;
	return 'success';
end
$$ language 'plpgsql'

---Create Account Table

create table accounts (
	accountid int primary key generated always as identity,
	created_at timestamp with time zone default current_timestamp,
	ownerid int,
	balance double precision,
	isApproved boolean default false
);

alter table accounts add
      FOREIGN KEY(ownerid) 
	  REFERENCES users(userid)
	  ON DELETE cascade;


create or replace function insert_account(f_ownerid int, f_balance double precision)
returns varchar(10) as $$
begin 
	insert into accounts (ownerid, balance) values (f_ownerid, f_balance);
	return 'success';
end
$$ language 'plpgsql'


create or replace function update_account (f_accountid int, f_balance double precision, f_isApproved boolean)
returns varchar(10) as $$
begin 
	update accounts set balance= f_balance, isApproved = f_isApproved where accountid = f_accountid;
	return 'success';
end
$$ language 'plpgsql'


--- Create Junction Table

create table user_junction_account(
	userid int references users(userid) on delete cascade,
	accountid int references accounts(accountid) on delete cascade,
	constraint junction_key primary key (userid,accountid)
)


create or replace function insert_junction (accountNum int , userNum int)
returns varchar(10) as $$
begin 
	insert into user_junction_account (userid, accountid) values (userNum, accountNum);
	return 'success';
end
$$ language 'plpgsql'

