<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<!-- <a href="/guest/getList?currentPage=1">방명록가기</a> -->
<a href="/guest/list">방명록가기</a>

</body>
</html>
