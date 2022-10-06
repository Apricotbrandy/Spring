<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Write</title>
</head>
<body>

	<form action="/guest/write" method="post">
		<textarea rows="3" name="btext" placeholder="text"></textarea>
		<input type="submit" value="write">
	</form>

</body>
</html>