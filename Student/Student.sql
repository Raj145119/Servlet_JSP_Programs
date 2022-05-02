create table Student5(
id number(10) primary key,
name varchar2(30) not null,
email_id varchar2(20) not null unique,
gender varchar(10)not null,
branch_id number(10),
foreign key (branch_id) references Department(department_id)
);

create table Department(
department_id number(10)primary key,
department_name varchar2(20),
hod_name   varchar2(20) not null
);

desc Department;
delete from Student5 where id=104;


insert into Student5 (id,name,email_id,gender,branch_id) values (((select nvl(max(id),100)+1 from Student5)),'ba','gghjdj@g','male',10001);

insert into Student5 (id,name,email_id,gender,branch_id) values (1,'ba','gg2jdj@g','male',10002);

insert into Department (department_id ,department_name,hod_name) values((select nvl(max(department_id),1000)+1 from Department),'mca','mk');
select * from Department;


Login

create table stu_login(
id number(10)primary key,
name varchar2(30) not null,
login_id varchar2(30) not null unique,
login_password varchar2(30) not null,
role varchar2(20)
);
select nvl(max(id),1000)+1 from Student5;
select nvl(max(id),1000)+1 from stu_login;
select nvl(max(department_id),1000)+1 from Department;
insert into stu_login values(1001,'surendra','sis','123','super');
insert into stu_login values(1002,'gagan','nit','124','admin');
insert into stu_login values(1003,'gita','u3','125','user');
commit;
select * from stu_login where login_id='sis' and login_password='123';
