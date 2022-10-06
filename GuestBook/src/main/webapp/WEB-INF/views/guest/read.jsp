<%@page import="com.astinel.domain.GuestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest read</title>
</head>
<body>
<%
	GuestVO read = (GuestVO)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext();
%>	
<h1>CONTENT</h1>

<p>no.<%=bno %></p>
<p>Text</p>
<div><%=btext %></div>

<div>
<!-- [ ] 글삭제로 이동. 글번호를 넘겨야함. -->		
<a href="/guest/del?bno=<%=bno%>">Delete</a>		
<!-- [ ] 글 수정으로 이동. 글번호를 넘겨야함. -->		
<a href="/guest/modify?bno=<%=bno%>">Modify</a>		
<!-- [ ] 글 리스트로 이동. -->		
<a href="/guest/list">List</a>
</div>
		
</body>
</html>