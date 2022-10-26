<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
<!-- <link rel="shortcut icon" href="#"> -->
<link rel="stylesheet" href="/resources/style/style_Common.css">
<link rel="stylesheet" href="/resources/style/style_bbs/notice.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
<style>
	a.now {
		font-weight: bold;
	}
</style>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>${category}</h1>
		
		<table id="boardTbl">
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
			<!-- 게시글이 없는 경우 시작 -->
			<c:if test="${empty list}">
				<tr><td colspan="5">게시글이 없습니다.</td></tr>
			</c:if>
			<!-- 게시글이 없는 경우 끝 -->
			
			<!-- 게시글 목록 출력 시작 -->
			<c:if test="${not empty list}">
				<c:forEach var="row" items="${list}">
					<tr>
					<c:if test="${category eq 'notice'}">
						<td>공지</td>
					</c:if>
					<c:if test="${!(category eq 'notice')}">
						<td>${row.num}</td>
					</c:if>
						<td><a href="/detail?num=${row.num}&nowPage=${pVO.nowPage}">${row.title}</a></td>
						<td>${row.uName}</td>
						<td>${row.writeTM}</td>
						<td>${row.views}</td>
					</tr>
				</c:forEach>
			</c:if>
			<!-- 게시글 목록 출력 끝 -->
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="2">
						전체 게시글 : ${pVO.totalRecord} 개
					</td>
				<!-- 글작성 버튼 시작 -->
				<c:if test="${(session_uid eq 'admin') || (!(category eq 'notice') and not empty session_uid)}">
					<td colspan="5">
						<a href="/write?category=${category}">글작성</a>
					</td>
				</c:if>
				<!-- 글작성 버튼 끝 -->
				</tr>
			</tfoot>
		</table>
		<!-- table#boardTbl -->
		
		<div id="pagingArea">
			<c:if test="${pVO.nowBlock > 1}">
			<c:set var="prevBlock" value="${pVO.pagePerBlock * (pVO.nowBlock - 1)}" />
			<a href="/board?category=${category}&nowPage=${prevBlock}">&lt;</a>
			</c:if>
			
			<span>
			<c:forEach var="i" begin="${pVO.pageStart}" end="${pVO.pageEnd}">
				<a href="/board?category=${category}&nowPage=${i}"
				<c:if test="${pVO.nowPage eq i}">class="now"</c:if>
				>${i}</a>
			</c:forEach>
			</span>
			
			<c:if test="${pVO.nowBlock < pVO.totalBlock}">
			<c:set var="nextBlock" value="${pVO.pagePerBlock * pVO.nowBlock + 1}" />
			<a href="/board?category=${category}&nowPage=${nextBlock}">&gt;</a>
			</c:if>
		</div>
		<!-- div#pagingArea -->
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>