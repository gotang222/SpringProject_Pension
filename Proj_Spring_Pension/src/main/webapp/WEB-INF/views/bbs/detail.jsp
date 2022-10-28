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
<link rel="stylesheet" href="/resources/style/bbs/style_detail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>글내용보기</h1>
		<table id="detailTbl">
			<tbody>
				<tr>
					<th colspan="2" class="title">제목 : ${detail.title}</th>
				</tr>
				<tr>
					<td>작성자 : ${detail.uName}</td>
					<td>
						조회수 : ${detail.views}
						작성시간 : ${detail.writeTM}
					</td>
				</tr>
				<tr>
					<td colspan="2" class="content">내용 : ${detail.content}</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" id="btnArea">
						<a href="/board?category=${detail.category}&nowPage=${nowPage}">목록으로</a>
						<c:if test="${session_uid eq detail.uid}">
							<a href="/modify?category=${detail.category}&num=${detail.num}&nowPage=${nowPage}">수정</a>
							<a href="/delete?category=${detail.category}&num=${detail.num}">삭제</a>
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>
		<!-- table#detailTbl -->
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>