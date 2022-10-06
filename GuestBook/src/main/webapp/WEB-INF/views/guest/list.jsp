<%@page import="com.astinel.domain.GuestVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.astinel.util.MysqlProc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest List</title>
<link rel="stylesheet" href="/resources/common.css" >
</head>
<body>
<h1>Guest Book</h1>
<h2>List</h2>
<table>
	<tr>
		<td>no.</td>
		<td>content</td>
	</tr>
	
<%
String sCurrentPageNum = request.getParameter("currentPage");
int currentPageNum = 1;
if(sCurrentPageNum != null){		
	currentPageNum = Integer.parseInt(sCurrentPageNum);
}


MysqlProc.dbInit();

int dataCount = MysqlProc.getDataCount();
int pageMaxNumber = (int)Math.ceil((double)dataCount / MysqlProc.BOARD_LIST_AMOUNT);


int totalBlock = (int)Math.ceil((double) pageMaxNumber / MysqlProc.BOARD_BLOCK_PAGE_AMOUNT);	
int currentBlockNo = (int)Math.ceil((double) currentPageNum / MysqlProc.BOARD_BLOCK_PAGE_AMOUNT);


MysqlProc.dbConnect();

int currentDataIndex = 0;
currentDataIndex = (currentPageNum - 1) * MysqlProc.BOARD_LIST_AMOUNT;
	
	Object o = request.getAttribute("list");
	List<GuestVO> list = (List<GuestVO>)o; 
	int l = list.size();
	System.out.println("================list.size====:"+l);
	for(int i=0;i<list.size();i++){
		Long bno = list.get(i).getBno();
		String btext = list.get(i).getBtext();
%>	
	<tr>
		<td><%=bno %></td>
		<td><a href="/guest/read?bno=<%=bno%>&currentPage=<%=currentPageNum%>"> <%=btext %> </a></td>
	<tr>
<%		
	}
%>
</table>
<br><br>
<%
int	blockStartNo = (currentBlockNo - 1) * MysqlProc.BOARD_BLOCK_PAGE_AMOUNT + 1;
int blockEndNo = currentBlockNo * MysqlProc.BOARD_BLOCK_PAGE_AMOUNT;

if(blockEndNo > pageMaxNumber){
	blockEndNo = pageMaxNumber;
}

int prevPage = 0;
int nextPage = 0;

boolean hasPrev = true;
if(currentBlockNo == 1){
	hasPrev = false;
}else{
	hasPrev = true;
	prevPage = (currentBlockNo - 1) * MysqlProc.BOARD_BLOCK_PAGE_AMOUNT;
}

boolean hasNext = true;
if(currentBlockNo < totalBlock){
	hasNext = true;
	nextPage = currentBlockNo * MysqlProc.BOARD_BLOCK_PAGE_AMOUNT + 1;
}else{
	hasNext = false;
}

if(hasPrev){
%>
	<a href="/guest/list?currentPage=<%=prevPage%>"> prev </a>
<%	
}

	for(int i = blockStartNo; i<= blockEndNo; i++){
		if(currentPageNum == i){
%>
			<%=i %>
<%
		} else {
%>						
			<a href="/guest/list?currentPage=<%=i %>"><%=i %></a>
<%
		}
	}
	
	if(hasNext){
%>
		<a href="/guest/list?currentPage=<%=nextPage%>">next</a>

<%
	}
	
%>





<br>
<!-- [ ] 글쓰기 페이지로 이동 -->
<a href="/guest/write">새글 쓰기</a>

</body>
</html>