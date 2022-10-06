<%@page import="com.astinel.domain.GuestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Modify</title>
</head>
<body>
<%
GuestVO read = (GuestVO)request.getAttribute("read");
long bno = read.getBno();
String btext = read.getBtext();
%>

no.<%=bno %><br>
content<br>
	<form action="/guest/modify" method="post">
		<input type="hidden" name='bno' value="<%=bno%>">
		<textarea name='btext'>
			<%=btext %>
		</textarea>
		<input type="submit" value="modify">
	</form>
</body>
</html>