<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글수정 페이지</title>
<!-- <link rel="shortcut icon" href="#"> -->
<link rel="stylesheet" href="/resources/style/style_Common.css">
<link rel="stylesheet" href="/resources/style/style_bbs/notice.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>글수정</h1>
		<form method="post">
			<div id="writeArea">
				<select name="category">
					<option value="notice">공지사항</option>
					<option value="review">이용후기</option>
				</select>
				<input type="text" id="title" name="title" value="${detail.title}" placeholder="제목을 입력하세요.">
				<textarea id="content" name="content" placeholder="내용을 입력하세요.">${detail.content}</textarea>
			</div>
			<button>작성</button>
			<!-- div#writeArea -->
		</form>
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>