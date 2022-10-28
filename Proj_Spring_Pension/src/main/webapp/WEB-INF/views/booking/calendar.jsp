<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>예약현황</title>
	<link rel="shortcut icon" href="#">
	<link rel="stylesheet" href="/style/style_Common.css">
	<link rel="stylesheet" href="/style/style_Booking.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/script/script_Booking.js"></script>
</head>
<body>

	<div id="wrap" class="calendarWrap">
		<h1>오늘 연도 ${nowYear}</h1>
		<h1>오늘 월 ${nowMonth}</h1>
		<h1>오늘 일 ${nowDate}</h1>
		<h1>오늘 요일 ${nowDay}</h1>
	</div>
	<!-- div#wrap -->
	

</body>
</html>