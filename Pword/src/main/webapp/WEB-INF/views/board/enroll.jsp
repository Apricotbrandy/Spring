<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Enroll</title>
<link rel="stylesheet" href="/resources/css/get.css">
</head>
<body>
<h1>Enroll page</h1>
<form action="/board/enroll" method="post">
	<div class="input_wrap">
		<label>Title</label>
		<input name="title">
	</div>
	<div class="input_wrap">
		<label>Content</label>
		<textarea rows="3" name="content"></textarea>
	</div>
	<div class="input_wrap">
		<label>Writer</label>
		<input name="writer">
	</div>
	<input class="btn" type="submit" value="enroll">
	<!-- <button class="btn">Enroll</button> -->
	<a class="btn" href="/board/list">List</a>
</form>
</body>
</html>