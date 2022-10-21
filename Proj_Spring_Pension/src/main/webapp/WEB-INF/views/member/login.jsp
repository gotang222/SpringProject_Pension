<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="shortcut icon" href="#">
<link rel="stylesheet" href="/resources/style/style_Common.css">
<link rel="stylesheet" href="/resources/style/member/style_login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/member/join.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>로그인</h1>
		<hr>
		<form method="post">
			아이디<input type="text" name="uid">
			비밀번호<input type="text" name="upw">
			<button>로그인</button>
		</form>
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>