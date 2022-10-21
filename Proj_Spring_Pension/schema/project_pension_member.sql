use project_pension;

drop table member;
create table member (
num			int				auto_increment	,	#번호
uid			char(20)		not null				,	#아이디
upw			char(20)		not null				,	#비밀번호
uName		char(20)		not null				,	#이름
uBirth		char(10)		not null				,	#생일
uPhone		char(11)		not null				,	#연락처
uEmail		char(100)									,	#이메일
gender		char(2)										,	#성별
uZipcode	char(8)										,	#우편번호
uAddr		char(100)									,	#주소
joinTM		timestamp 	not null				,	#가입시간
constraint primary key (uid),
constraint unique (num)
);
desc member;

insert into member
(uid		, upw	, uName		, uBirth		, uPhone			, joinTM)
values
('admin'	, '1234'	, '관리자'		, '999999'	, '01012345678'	, now());

select * from member order by num;




