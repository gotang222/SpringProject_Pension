<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
<link rel="shortcut icon" href="#">
<link rel="stylesheet" href="/resources/style/style_Common.css">
<link rel="stylesheet" href="/resources/style/style_bbs/notice.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>${category}</h1>
		
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${list}">
					<tr>
					<c:if test="${category eq 'notice'}">
						<td>공지</td>
					</c:if>
					<c:if test="${!(category eq 'notice')}">
						<td>${row.num}</td>
					</c:if>
						<td><a href="/detail?num=${row.num}">${row.title} </a></td>
						<td>${row.uName}</td>
						<td>${row.writeTM}</td>
						<td>${row.views}</td>
					</tr>
				</c:forEach>
			</tbody>
		<c:if test="${(session_uid eq 'admin') || (!(category eq 'notice') and not empty session_uid)}">
			<tfoot>
				<tr>
					<td colspan="5">
						<a href="/write">글작성</a>
					</td>
				</tr>
			</tfoot>
		</c:if>
		</table>
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>