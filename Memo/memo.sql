create talbe tbl_ejb_memo
(
	no number AUTO_INCREMENT primary key,
	writer varchar2(20),
	email varchar2(30),
	title varchar2(50),
	memo varchar2(500),
	wdate date
);

create sequence pcbsbill.ksi_memo_seq
start with 1
increment by 1
minvalue 0
nocache
nocycle
noorder;


//mysql

 create table tbl_ejb_memo(
	no int not null auto_increment,
	writer varchar(20) not null,
	email varchar(30) not null,
	title varchar(50) not null,
	memo text null,
	wdate timestamp not null default now(),
	primary key(no)
 );

