<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<%
session.invalidate();
%>
<script>
	alert("로그아웃!");
	location.href = "/";
</script>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="shortcut icon" href="#">
<link rel="stylesheet" href="/resources/style/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
</head>
<body>
	<div id="wrap">
		
	</div>
	<!-- div#wrap -->
</body>
</html>