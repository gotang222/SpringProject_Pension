<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글작성 페이지</title>
<!-- <link rel="shortcut icon" href="#"> -->
<link rel="stylesheet" href="/resources/style/style_Common.css">
<link rel="stylesheet" href="/resources/style/bbs/style_write.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
</head>
<body>
	<jsp:include page="/resources/include/header.jsp" flush="true" />
	<div id="wrap">
		<h1>글작성</h1>
		<form method="post">
			<table id="writeTbl">
				<tbody>
					<tr>
						<th id="titleArea" colspan="2">
							<input type="text" id="title" name="title" placeholder="제목을 입력하세요.">
						</th>
					</tr>
					<tr>
						<td>
							카테고리 : <input type="text" id="category" name="category" value="${category}" readonly>
						</td>
						<td>
							작성자 : ${session_uid}
						</td>
					</tr>
					<tr>
						<td id="contentArea" colspan="2">
							<textarea id="content" name="content" placeholder="내용을 입력하세요."></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" id="btnArea">
							<button>작성</button>
						</td>
					</tr>
				</tfoot>
			</table>
			<!-- table#writeTbl -->
		</form>
	</div>
	<!-- div#wrap -->
	<jsp:include page="/resources/include/footer.jsp" flush="true" />
</body>
</html>