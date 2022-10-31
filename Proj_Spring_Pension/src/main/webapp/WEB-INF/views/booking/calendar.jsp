
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>예약현황</title>
	<link rel="shortcut icon" href="#">
	<link rel="stylesheet" href="/resources/style/style_Common.css">
	<link rel="stylesheet" href="/resources/style/booking/Booking.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/resources/script/booking/script_Booking.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />

	<div id="wrap" class="calendarWrap">
		<div id="selectMonthArea" class="dFlex">
			<button type="button" id="lastMonthBtn">&lt;</button>
			<h1>
				<span id="nowPageYear">${year}</span>
				<span id="nowPageMonth">${nowPageMonth}</span>
			</h1>
			<button type="button" id="nextMonthBtn">&gt;</button>
		</div>
		<!-- div#selectMonthArea -->
		<p style="text-align: center">
			오늘 날짜 : ${today}
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
				<c:forEach var="taglist" items="${taglist}">
					${taglist}
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${null ne session_data.uName}">
			<c:set var = "uid" value="session_data.uName"></c:set>
		</c:if>

		<input type="hidden" id="uid" name="uid" value="${uid}">
		<form action="/booking" id="bookingFrm">
			<input type="hidden" id="rName" name="rName" value="${rName }">
			<input type="hidden" id="bDate" name="bDate" value="${bDate}">
			<input type="hidden" id="bMoney" name="bMoney" value="${bMoney}">
			<input type="hidden" id="bDay" name="bDay" value="">
		</form>
		
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>