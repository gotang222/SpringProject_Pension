<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>예약하기</title>
	<link rel="shortcut icon" href="#">
	<link rel="stylesheet" href="/resources/style/style_Common.css">
	<link rel="stylesheet" href="/resources/style/booking/Booking.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/resources/script/booking/script_Booking.js"></script>
</head>
<body>

	<div id="wrap" class="bookWrap">
		<form  id="bookFrm" method="post">
			<table id="bookTbl">
				<caption>* 표시는 필수 입력사항입니다.</caption>
				<tbody>
					<tr>
						<td>객실명</td>
						<td>
							${rName}
						</td>
					</tr>
					
					<tr>
						<td>이용일</td>
						<td class="accent">
							${bDate}
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button">날짜 변경하기(미구현)</button>
						</td>
					</tr>
					
					<tr>
						<td>*인원</td>
						<td>
							<input type="number" id="bPeople" name="bPeople"
								value="2" min="1" max="${rLimit}">
							<span class="guideTxt">최대인원 : ${rLimit}명</span>
						</td>
					</tr>
					
					<tr>
						<td>*예약자명</td>
						<td>
							<input type="hidden" id="uid" name="uid" value="${session_data.uid}">
							<input type="text" id="uName" name="uName"
							value="${session_data.uName}" maxlength="30">
							<span class="guideTxt">반드시 실명으로 입력해주세요.</span>
						</td>
					</tr>
					
					<tr>
						<td>*생년월일</td>
						<td>

							<input type="text" id="uBirth" name="uBirth"
							value="${session_data.uBirth}" maxlength="6" placeholder="생년월일">
							<span class="guideTxt">6자리 숫자로 입력해주세요. 예시) 930428</span>
						</td>
					</tr>
					
					<tr>
						<td>*연락처</td>
						<td>

							<input type="text" id="uPhone" name="uPhone"
							value="${session_data.uPhone}" maxlength="11" placeholder="연락처">
							<span class="guideTxt">숫자만 입력해주세요. 예) 01012345678</span>
						</td>
					</tr>
					
					<tr>
						<td>이메일</td>
						<td>
							<c:set var="uEmail" value="${session_data.uEmail}"></c:set>
							<c:set var="len" value="${fn:length(uEmail)}"></c:set>
							<c:if test="${not empty uEmail }">
								<c:set var="idxEmail" value="${fn:indexOf(uEmail,'@')}"></c:set>
								<c:set var="uEmail1" value="${fn:substring(uEmail,0,idxEmail)}"></c:set>
								<c:set var="uEmail2" value="${fn:substring(uEmail,idxEmail+1,len)}"></c:set>
							</c:if>
							<input type="text" id="uEmail1" name="uEmail"
							value="${uEmail1}">
							@
							<input type="text" id="uEmail2"
							value="${uEmail2}">
							
							<select id="selectEmail">
								<option value="">직접입력</option>
								<option>naver.com</option>
								<option>google.com</option>
								<option>daum.net</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td>예약요청사항</td>
						<td>
							<textarea name="uRequest" id="uRequest"
							rows="10" maxlength="200" placeholder="요청사항(최대 200자)"></textarea>
						</td>
					</tr>
					
					<tr>
						<td>결제금액</td>
						<td class="accent">
							${payPrice}
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button type="button" id="bookCalendarBtn"
							onclick="location.href='/calendar'">다시 선택하기</button>
							<button type="button" id="bookSubmitBtn">결제하기</button>
						</td>
					</tr>
				</tfoot>
			</table>
			<!-- table#bookTbl -->

			<input type="hidden" id="bDate" name="bbDate" value="${bDate}">
			<input type="hidden" name="rNum" value="${rNum}">
			<input type="hidden" name="rName" value="${rName}">
			<input type="hidden" id="payPrice" name="payPrice" value="${bMoney}">
		</form>
		<!-- form#bookFrm -->
	</div>
	<!-- div#wrap -->
	
</body>
</html>