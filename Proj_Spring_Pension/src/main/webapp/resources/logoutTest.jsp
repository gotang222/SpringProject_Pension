<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="true"%>
<%
session.invalidate();
%>
<script>
	alert("๋ก๊ทธ์์!");
	location.href = "/";
</script>