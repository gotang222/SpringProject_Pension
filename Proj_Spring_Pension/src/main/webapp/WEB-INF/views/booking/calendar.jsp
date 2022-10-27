<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"%>
<%
request.setCharacterEncoding("UTF-8");

String decimalFormat = "#,###";
DecimalFormat df = new DecimalFormat(decimalFormat);

String dateFormat = "yyyy년 MM월 dd일 (E)";
SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

Calendar nowCal = Calendar.getInstance(); // 오늘 날짜 캘린더
String[] weekArr = {"일", "월", "화", "수", "목", "금", "토"};

int nowYear = nowCal.get(Calendar.YEAR);					// 오늘 연도
int nowMonth = nowCal.get(Calendar.MONTH);			// 오늘 월
int nowDate = nowCal.get(Calendar.DATE);					// 오늘 일
int nowDay = nowCal.get(Calendar.DAY_OF_WEEK);		// 오늘 요일

// //////////////////////// 달력 넘기기 처리 시작 ////////////////////////
int monthParam = 0; // 이전 월 또는 다음 월 버튼 파라미터
int nowPageYear = 0; // 현재 페이지 연도
int nowPageMonth = 0; // 현재 페이지 월

Calendar cal = Calendar.getInstance();

if (request.getParameter("monthParam") != null) {
	
	monthParam = Integer.parseInt(request.getParameter("monthParam"));
	nowPageYear = Integer.parseInt(request.getParameter("nowPageYear"));
	nowPageMonth = Integer.parseInt(request.getParameter("nowPageMonth"));
	
	// 이전 월로 이동
	if (monthParam ==  1) {
		
		if (nowPageMonth == 1) {
			cal.set(Calendar.YEAR, nowPageYear - 1);
			cal.set(Calendar.MONTH, 11);
		} else {
			cal.set(Calendar.YEAR, nowPageYear);
			cal.set(Calendar.MONTH, nowPageMonth - 2);
		}
	
	// 다음 월로 이동
	} else if (monthParam == 2) {
		
		if (nowPageMonth == 12) {
			cal.set(Calendar.YEAR, nowPageYear + 1);
			cal.set(Calendar.MONTH, 0);
		} else {
			cal.set(Calendar.YEAR, nowPageYear);
			cal.set(Calendar.MONTH, nowPageMonth);
		}
	}
	
} else {
	cal.set(Calendar.YEAR, nowYear); // 현재 연도로 초기화
	cal.set(Calendar.MONTH, nowMonth); // 현재 월로 초기화
}
// //////////////////////// 달력 넘기기 처리 끝 ////////////////////////

cal.set(Calendar.DATE, 1); // 1일로 초기화

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int date = cal.get(Calendar.DATE);
int day = cal.get(Calendar.DAY_OF_WEEK);

int lastDay = cal.getActualMaximum(Calendar.DATE); // 이번달의 마지막 날짜

%>
<c:set var="cal" value = ""></c:set>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>예약현황</title>
	<link rel="shortcut icon" href="#">
	<link rel="stylesheet" href="/resources/style/style_Common.css">
	<link rel="stylesheet" href="/resources/style/style_Booking.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/resources/script/booking/script_Booking.js"></script>
</head>
<body>


	<div id="wrap" class="calendarWrap">
		<div id="selectMonthArea" class="dFlex">
			<button type="button" id="lastMonthBtn">&lt;</button>
			<h1>
				<span id="nowPageYear"><%=year%></span>.
				<span id="nowPageMonth"><%=month + 1%></span>
			</h1>
			<button type="button" id="nextMonthBtn">&gt;</button>
		</div>
		<!-- div#selectMonthArea -->
		<p style="text-align: center">
			오늘 날짜 : <%=sdf.format(nowCal.getTime())%>
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
				<%
				// 달력 출력 부분 시작
				for (int i = 1; i <= lastDay; i++) {
					cal.set(Calendar.DATE, i);
					int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
					
					// 1일 이전 빈칸 처리
					if (i == 1) {
						for (int j = 1; j < dayWeek; j++) { out.print("<td></td>"); }
					}
					
					if (dayWeek == 1) { // 일요일부터 시작
						out.print("<tr>");
					}
					
					out.print("<td>");
					out.print("<h4>" + i + "</h4>");
					
					Calendar compareCal = Calendar.getInstance(); // 날짜 비교용 캘린더 객체
					compareCal.set(year, month, i);
					
					if (compareCal.before(nowCal)) { // 오늘 이전의 날짜
						out.print("<span>예약종료</span>");
					} else {
						%>
						<c:forEach var="objList" items="${list}">
							<c:set var="rName" value="${objList.rName}"></c:set>
							<c:set var="rPrice" value="${objList.rPrice}"></c:set>
							
							<c:set var="weekendPrice" value="20000"></c:set>
							
							<c:if test=""></c:if>
							
							
						</c:forEach>
						<%
						/* for (int j = 0; j < objList.size(); j++) {
							
							rVO = objList.get(j);
							
							String rName = rVO.getrName();
							int rPrice = rVO.getrPrice();
							
							// 주말 요금 +20000원
							int weekendPrice = 20000;
							if (dayWeek == 1 || dayWeek == 7) rPrice += weekendPrice;
							
							// 예약 여부 확인
							int rNum = rVO.getNum();
							dateFormat = "yyyy-MM-dd";
							sdf = new SimpleDateFormat(dateFormat);
							String bDate = sdf.format(compareCal.getTime());
							
							String chkBooking = "";
							if (bDAO.mtd_chkBooking(rNum, bDate)) {
								chkBooking = "booked";
							} else {
								chkBooking = "noBooked";
							}
							
							// 출력부분
							out.print("<p class='dFlex' style='justify-content: space-between'>");
							out.print("<a class='" + chkBooking + "'>" + rName + "</a>");
							out.print("<span>" + df.format(rPrice) + "</span></p>");
						} */
					}
					out.print("</td>");
					
					if (dayWeek == 7 && i < lastDay) { // 토요일 줄바꿈
						out.print("</tr>");
					}
					
					// 마지막일 이후 빈칸 처리
					if (i == lastDay) {
						for (int j = 0; j < 7 - dayWeek; j++) { out.print("<td></td>"); }
					}
					
				}
				// 달력 출력 부분 끝
				%>
			</tbody>
		</table>
		
		<%
		dateFormat = "yyyy-MM-";
		sdf = new SimpleDateFormat(dateFormat);
		String bDate = sdf.format(cal.getTime());

		String uid = null;
		if (session.getAttribute("uidKey") != null) {
			uid = (String)session.getAttribute("uidKey");
		}
		%>
		<input type="hidden" id="uid" name="uid" value="<%=uid%>">
		
		<form action="/booking/booking.jsp" id="bookingFrm">
			<input type="hidden" id="rName" name="rName" value="">
			<input type="hidden" id="bDate" name="bDate" value="<%=bDate%>">
		</form>
		
	</div>
	<!-- div#wrap -->

	
</body>
</html>