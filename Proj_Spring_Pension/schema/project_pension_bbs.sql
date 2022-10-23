use project_pension;

drop table board;
create table board(
	num			int				auto_increment		,	#글번호
	category		char(10)		not null					,	#카테고리
	uid			char(20)		not null					,	#작성자ID
    uName		char(20)		not null					,	#작성자명
	title			char(50)		not null					,	#글제목
	content		text			not null					,	#글내용
	views			int				not null	default 0	,	#조회수
    writeTM		timestamp	not null					,	#작성시간
	constraint primary key (num)
);
desc board;

