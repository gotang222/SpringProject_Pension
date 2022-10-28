<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

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
<c:set var="calendarVO" value="calendarVO"></c:set>
	<div id="wrap" class="calendarWrap">
		<div id="selectMonthArea" class="dFlex">
			<button type="button" id="lastMonthBtn">&lt;</button>
			<h1>
				<span id="nowPageYear">${calendarVO.year}</span>
				<span id="nowPageMonth">${calendarVO.month+1}</span>
			</h1>
			<button type="button" id="nextMonthBtn">&gt;</button>
		</div>
		<!-- div#selectMonthArea -->
		<p style="text-align: center">
			오늘 날짜 : ${calendarVO.getNowCalTime()}
		</p>
		
		<div id="tblHeadArea" class="dFlex">
			<div>예약 가능, 예약 완료 안내</div>
			<div>가격 보기 체크박스</div>
		</div>
		<!-- div#tblHeadArea -->
		
		<table id="calendarTbl">
			<tbody>
				<tr>
					<th>일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토</th>
				</tr>

		
	</div>
	<!-- div#wrap -->
	
	<iframe src="/iframe/iframe_footer.jsp" id="iframe_footer" scrolling="no"></iframe>
	
</body>
</html>