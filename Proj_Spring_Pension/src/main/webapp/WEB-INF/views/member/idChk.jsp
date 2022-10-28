<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="true"%>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>ID중복확인</title>
		<link rel="shortcut icon" href="#">
		<link rel="stylesheet" href="/style/style_Member.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="/resources/script/member/script_join.js"></script>
	</head>
	<body>
		<div id="wrap_pop">
			<h1>${inputuid}</h1>
			<span>
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<c:choose>
					<c:when test="${null ne idChk.uid}">
						<c:set var="chkTxt" value="존재하는 아이디입니다"></c:set>
						<c:set var="btnTxt" value="ID 재입력"></c:set>
						<c:set var="idCheck" value="1"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="chkTxt" value="사용할 수 있는 아이디입니다"></c:set>
						<c:set var="btnTxt" value="사용하기"></c:set>
						<c:set var="idCheck" value="0"></c:set>
					</c:otherwise>
				</c:choose>
				<c:out value="${chkTxt}"></c:out>
			</span>
			<button type="button" id="popCloseBtn" value="${idCheck}">
				${btnTxt}
			</button>
			<%-- <h1><%= uid %></h1>
			<span>
				<%
				String chkTxt = "";
				String btnTxt = "";
				if (idCheck == 1) {
					chkTxt ="존재하는 아이디입니다";
					btnTxt = "ID 재입력";
				} else {
					chkTxt = "사용할 수 있는 아이디입니다";
					btnTxt = "사용하기";
				}
				out.print(chkTxt);
				%>
			</span>
			<button type="button" id="popCloseBtn" value="<%=idCheck%>">
				<%= btnTxt %>
			</button> --%>
		</div>
		<!-- div#wrap -->
	</body>
</html>