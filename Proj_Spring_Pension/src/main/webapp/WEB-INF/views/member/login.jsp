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
<script src="/resources/script/member/script_login.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>로그인</h1>
			<form method="post" id="loginFrm" class="dFlex">
				<div id="inputArea">
					<input type="text" id="uid" name="uid" form="loginFrm"
					maxlength="20" placeholder="아이디" autofocus>
					<input type="password" id="upw" name="upw" form="loginFrm"
					maxlength="20" placeholder="비밀번호">
				</div>
				<!-- div#inputArea -->
				
				<div id="loginBtnArea">
					<button type="button" id="loginBtn">로그인</button>
				</div>
				<!-- div#loginBtnArea -->
			</form>
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>