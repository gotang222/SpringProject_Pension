<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel="stylesheet" href="/resources/style/include/style_include.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/script/script.js"></script>
</head>
<body>
	<div id="headerWrap">
		<header id="header" class="dFlex">
			<div id="headerLogoArea">
				<a href="/">
					<img src="/resources/images/logo_header.png" alt="로고이미지" width="210">
				</a>
			</div>
			<!-- div#headerLogoArea -->
			
			<nav id="headerGnbArea">
				<ul id="mainMenu" class="dFlex">
					<li>
						<a href="#">객실안내</a>
						<ul class="subMenu">
							<li><a href="#">바다 객실 A호</a></li>
							<li><a href="#">바다 객실 B호</a></li>
						</ul>
					</li>
					
					<li>
						<a href="/calendar">예약안내</a>
						<ul class="subMenu">
							<li><a href="/calendar">예약현황</a></li>
						</ul>
					</li>
					
					<li>
                        <a href="/board?category=notice&nowPage=1">커뮤니티</a>
                        <ul class="subMenu">
                            <li><a href="/board?category=notice&nowPage=1">공지사항</a></li>
                            <li><a href="/board?category=review&nowPage=1">이용후기</a></li>
                        </ul>
                    </li>
				</ul>
			</nav>
			<!-- nav#headerGnbArea -->
			
			<div id="headerMemberArea">
				<ul id="MemberMenu" class="dFlex">
					<c:if test="${empty session_uid}">
	            		<li>
							<a href="/login">로그인</a>
						</li>
						<li>
							<a href="/join">회원가입</a>
						</li>
					</c:if>
	            	
	            	<c:if test="${not empty session_uid}">
	            	<c:set var="uid" value="${session_uid} }"></c:set>
	            		<li>
		            		<a href="/resources/logoutTest.jsp">로그아웃</a>
	            		</li>
	            		<li>
							<a href="/myPage?uid=${session_uid}">마이페이지</a>
	            		</li>
	            	</c:if>
				</ul>
			</div>
			<!-- div#headerMemArea -->
		</header>
		<!-- header#header -->
	</div>
	<!-- div#headerWrap -->
</body>
</html>