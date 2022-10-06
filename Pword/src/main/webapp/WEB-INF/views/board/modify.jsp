<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Modify</title>
<link rel="stylesheet" href="/resources/css/get.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>

</head>
<body>
<h1>Modify page</h1>
	<form id="modifyForm" action="/board/modify" method="post">
		<div class="input_wrap">
			<label>no.</label>
			<input name="bno" readonly="readonly" value='<c:out value="${pageInfo.bno}"/>' >
		</div>
		<div class="input_wrap">
			<label>Title</label>
			<input name="title" value='<c:out value="${pageInfo.title}"/>' >
		</div>
		<div class="input_wrap">
			<label>Content</label>
			<textarea rows="3" name="content"><c:out value="${pageInfo.content}"/></textarea>
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
			<a class="btn" id="modify_btn">Submit</a>
			<a class="btn" id="cancel_btn">Cancel</a>
			<a class="btn" id="delete_btn">Delete</a>
		</div>
	</form>
	
	<form id="infoForm" action="/board/modify" method="get">
		<input type="hidden" id="bno" name="bno" value='<c:out value="${pageInfo.bno}"></c:out>'>
		<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"></c:out>'>
		<input type="hidden" name="amount" value='<c:out value="${cri.amount}"></c:out>'>
		<input type="hidden" name="type" value="${cri.type }">
		<input type="hidden" name="keyword" value="${cri.keyword }">
	</form>
	
	
<script>
	let form = $("#infoForm");		//페이지 이동 form(목록 페이지 이동, 조회 페이지 이동)
	let mForm = $("#modifyForm");	//페이지 데이터 수정 form
	
	/* 목록페이지 이동 버튼 */
	$("#list_btn").on("click", function(e){
		form.find("#bno").remove();
		form.attr("action", "/board/list");
		form.submit();
	});
	
	/* 수정하기 버튼 */
	$("#modify_btn").on("click", function(e){
		mForm.submit();
	});	
	
	/* 취소 버튼 */
	$("#cancel_btn").on("click", function(e){
		form.attr("action", "/board/get");
		form.submit();
	});
	
	/* 삭제 버튼 */
	$("#delete_btn").on("click", function(e) {
		form.attr("action", "/board/delete");
		form.attr("method", "post");
		form.submit();
	})
	
	
</script>	
</body>
</html>