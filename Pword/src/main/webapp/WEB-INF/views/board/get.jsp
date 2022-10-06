<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Get</title>
<link rel="stylesheet" href="/resources/css/get.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>

</head>
<body>
<h1>조회 페이지</h1>
	<div class="input_wrap">
		<label>no.</label>
		<input name="bno" readonly="readonly" value='<c:out value="${pageInfo.bno}"/>' >
	</div>
	<div class="input_wrap">
		<label>Title</label>
		<input name="title" readonly="readonly" value='<c:out value="${pageInfo.title}"/>' >
	</div>
	<div class="input_wrap">
		<label>Content</label>
		<textarea rows="3" name="content" readonly="readonly"><c:out value="${pageInfo.content}"/></textarea>
	</div>
	<div class="input_wrap">
		<label>Writer</label>
		<input name="writer" readonly="readonly" value='<c:out value="${pageInfo.writer}"/>' >
	</div>
	<div class="input_wrap">
		<label>RegDate</label>
		<input name="regdate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.regdate}"/>' >
	</div>
	<div class="input_wrap">
		<label>Update</label>
		<input name="updatetime" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.updatetime}"/>' >
	</div>		
	<div class="btn_wrap">
		<a class="btn" id="list_btn">List</a> 
		<a class="btn" id="modify_btn">Modify</a>
		<a class="btn" id="delete_btn">Delete</a>
	</div>
	<form id="infoForm" action="/board/modify" method="get">
		<input type="hidden" id="bno" name="bno" value='<c:out value="${pageInfo.bno}"></c:out>'>
		<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"></c:out>'>
		<input type="hidden" name="amount" value='<c:out value="${cri.amount}"></c:out>'>
		<input type="hidden" name="type" value="${cri.type }">
		<input type="hidden" name="keyword" value="${cri.keyword }">
	</form>
<script>
	let form = $("#infoForm");
	
	/* 목록 버튼 */
	$("#list_btn").on("click", function(e){
		form.find("#bno").remove();
		form.attr("action", "/board/list");
		form.submit();
	});
	
	/* 수정 버튼 */
	$("#modify_btn").on("click", function(e){
		form.attr("action", "/board/modify");
		form.submit();
	});	
	
	/* 삭제 버튼 */
	$("#delete_btn").on("click", function(e) {
		form.attr("action", "/board/delete");
		form.attr("method", "post");
		form.submit();
	});
</script>	
</body>
</html>