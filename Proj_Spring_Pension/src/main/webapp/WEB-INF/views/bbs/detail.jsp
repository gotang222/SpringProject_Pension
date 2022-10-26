<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<!-- <link rel="shortcut icon" href="#"> -->
<link rel="stylesheet" href="/resources/style/style_Common.css">
<link rel="stylesheet" href="/resources/style/style_bbs/notice.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>글내용보기</h1>
		<p>작성자 : ${detail.uName}</p>
		<p>제목 : ${detail.title}</p>
		<p>내용 : ${detail.content}</p>
		<p>조회수 : ${detail.views}</p>
		<p>작성시간 : ${detail.writeTM}</p>
		<a href="/board?category=${detail.category}&nowPage=${nowPage}">목록으로</a>
		<c:if test="${session_uid eq detail.uid}">
			<a href="/modify?category=${detail.category}&num=${detail.num}&nowPage=${nowPage}">수정</a>
			<a href="/delete?category=${detail.category}&num=${detail.num}">삭제</a>
		</c:if>
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>