<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>회원정보 수정</title>
		<link rel="shortcut icon" href="#">
		<link rel="stylesheet" href="/resources/style/style_Common.css">
		<link rel="stylesheet" href="/resources/style/style_Member.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="/resources/script/member/script_join.js"></script>
	</head>
	<body>

		<div id="wrap" class="dFlex modifyWrap">
			
			<div id="myPageArea">
				<h1>회원정보 수정</h1>
				<h1></h1>
				<form  id="modifyFrm" method="post">
					<input type="hidden" name="uid" id="uid" value="${data.uid}">
					<table id="joinTbl">
						<caption>* 표시는 필수 입력사항입니다.</caption>
						<tbody>
							<tr>
								<td>*아이디</td>
								<td>${data.uid}</td>
							</tr>
							<tr>
								<td>*비밀번호</td>
								<td>
									<input type="password" id="upw"
										name="upw" maxlength="20">
									<label>
										<input type="checkbox" id="showPwChk">
										비밀번호 보기
									</label>
									<p id="pwGuideTxt" class="guideTxt">
										3~20자의 영문 대소문자, 숫자, 특수기호(_),(-),(!),(@)만 사용 가능합니다.
									</p>
								</td>
							</tr>
							<tr>
								<td>*비밀번호 확인</td>
								<td>
									<input type="password" id="upw2"
										maxlength="30">
									<span id="upw2ChkTxt"></span>
								</td>
							</tr>
							<tr>
								<td>*이름</td>
								<td>${data.uName}</td>
							</tr>
							<tr>
								<td>*생년월일</td>
								<td>
									<input type="text" id="uBirth" name="uBirth" 
									maxlength="6" value="${data.uBirth}">
									<span class="guideTxt">생년월일 6자리를 입력해주세요. 예시) 930428</span>
								</td>
							</tr>
							<tr>
								<td>*연락처</td>
								<td>
									<input type="text" id="uPhone" name="uPhone" 
									maxlength="11" value="${data.uPhone}">
									<span class="guideTxt">숫자만 입력해주세요. 예시) 01012345678</span>
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>
									<c:set var="uEmail" value="${data.uEmail}"></c:set>
									<c:set var="len" value="${fn:length(uEmail)}"></c:set>
									<c:if test="${not empty uEmail }">
										<c:set var="idxEmail" value="${fn:indexOf(uEmail,'@')}"></c:set>
										<c:set var="uEmail1" value="${fn:substring(uEmail,0,idxEmail)}"></c:set>
										<c:set var="uEmail2" value="${fn:substring(uEmail,idxEmail+1,len)}"></c:set>
									</c:if>

									<input type="text" id="uEmail1" name="uEmail" value="${uEmail1}">
									@
									<input type="text" id="uEmail2" value="${uEmail2}">
									<select id="selectEmail">
										<option value="">직접입력</option>
										<option>naver.com</option>
										<option>google.com</option>
										<option>daum.net</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td>
									<c:set var="uGender" value="${data.uGender}"></c:set>
									<c:set var="noChk" value="checked"></c:set>
									<c:choose>
										<c:when test="${not empty uGender}">
											<c:choose>
												<c:when test="${uGender eq '1'}">
													<c:set var="mailChk" value="checked"></c:set>
												</c:when>
												<c:when test="${uGender eq '2'}">
													<c:set var="femailChk" value="checked"></c:set>
												</c:when>
											</c:choose>
										</c:when>
									</c:choose>
									<label>
										선택 안함 <input type="radio" name="uGender"
										value="" ${noChk}>
									</label>
									&nbsp;&nbsp;
									<label>
										남 <input type="radio" name="uGender"
										value="1" ${mailChk}>
									</label>
									&nbsp;&nbsp;
									<label>
										여 <input type="radio" name="uGender"
										value="2" ${femailChk}>
									</label>
								</td>
							</tr>
							<tr>
								<td>우편번호</td>
								<td>
									<input type="text" id="uZipcode" name="uZipcode"
									maxlength="7" readonly value="${data.uZipcode}">
									<button type="button" id="findZipBtn">우편번호 찾기</button>
								</td>
							</tr>
							<tr>
								<td>주소</td>
								<td>
									<input type="text" id="uAddr" name="uAddr"
										maxlength="100" value="${data.uAddr}">
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="2">
									<button type="button" id="modifySubmitBtn">수정하기</button>
									<button type="button" onclick="resign()">회원 탈퇴하기</button>
								</td>
							</tr>
						</tfoot>
					</table>
					<!-- table#joinTbl -->
				</form>
				<!-- form#modifyFrm -->
			</div>
			<!-- div#myPageArea -->
		</div>
		<!-- div#wrap -->
		
	</body>
</html>
