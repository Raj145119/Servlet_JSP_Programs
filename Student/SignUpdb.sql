create table signup_user
(id number(10) primary key,
name varchar2(50) not null,
login_id varchar2(50) not null unique ,
login_password varchar2(50) not null,
mobile varchar2(15) not null unique ,
otp varchar2(10) not null,
is_active varchar2(10) not null);

insert into signup_user(id,name,login_id,login_password,mobile,otp,is_active)
values((select nvl(max(id),100) +1 from signup_user ),
'surendra','sis','123','9009442844','1234','no');

insert into signup_user(id,name,login_id,login_password,mobile,otp,is_active)
values((select nvl(max(id),100) +1 from signup_user ),
'gagan','nit','123','7987234544','1234','no');

commit;
select * from signup_user;

update signup_user set is_active='yes'
where  mobile='9009442844' and otp='1334'; 

update signup_user set is_active='yes'
where  mobile='9009442844' and otp='1234'; 


select * from signup_user
where login_id='sis' and login_password='123' and is_active='yes';

select * from signup_user
where login_id='nit' and login_password='123' and is_active='yes';

insert into signup_user(id,name,login_id,login_password,mobile,otp,is_active)
values((select nvl(max(id),100) +1 from signup_user ),
?,?,?,?,?,'no');
