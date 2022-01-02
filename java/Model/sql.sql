-- WEB_Member 라는 이름으로 테이블 하나 생성
-- email, pw, tel, address
-- email을 pk
create table web_member
(
	email varchar2(50),
	pw varchar2(50) not null,
	tel varchar2(50) not null,
	address varchar2(50) not null,
	constraint web_email_pk primary key(email)
);

select * from web_member;


delete from web_member where email='ss1216';


-- Message를 저장할 수 있는 Table
create table web_message
(
	bnum number(30),
	send_name varchar2(50),
	receive_email varchar2(50),
	content varchar2(50),
	dates date,
	constraint web_bnum_pk primary key(bnum)
);

-- 시퀀스
create sequence msg_num_seq
start with 1
increment by 1
maxvalue 9999
nocycle
nocache;

create table web_board
(
	num number(10),
	writer varchar2(50),
	title varchar2(50),
	fileName varchar2(50),
	content varchar2(1000),
	day date,
	constraint board_num_pk primary key(num)
);

create sequence board_num_seq
start with 1
increment by 1
maxvalue 9999
nocycle
nocache;





