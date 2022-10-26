use project_pension;

drop table board;
create table board(
	num			int				auto_increment		,	#글번호
	category	char(10)		not null					,	#카테고리
	uid			char(20)		not null					,	#작성자ID
    uName		char(20)		not null					,	#작성자명
	title			char(50)		not null					,	#글제목
	content		text				not null					,	#글내용
	views		int				not null	default 0	,	#조회수
    writeTM		timestamp	not null					,	#작성시간
	primary key (num)
);
desc board;

insert into board
(category, uid, uName, title, content, writeTM)
values
('notice', 'admin', '관리자', '공지사항입니다.', '공지사항 내용입니다.', now());
insert into board
(category, uid, uName, title, content, writeTM)
values
('review', 'sample', '샘플', '테스트 제목', '테스트중.', now());

update board set views = views + 1 where num = 1;

select num, uName, title, views, writeTM
from board where category = 'notice' order by num desc;
select num, uName, title, content, views, writeTM
from board where category = 'review' order by num desc;