<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_Read Page</title>
</head>
<body>
<h2>상세보기</h2>
<table border="1">
	<tr>
		<th>제목</th>
		<td>
		
			${boardList.title }
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			${boardList.writer }
		</td>		
	</tr>
	<tr>
		<th>작성일</th>
		<td>
			${boardList.regDate }
		</td>	
	</tr>
	<tr>
		<th>내용</th>
		<td>
			${boardList.content }
		</td>	
	</tr>
</table>
		<div> 
		<a href='<c:url value="/board/list"></c:url>'>글목록</a>
		<a href='<c:url value="/board/update?seq=${boardList.seq }"></c:url>'>수정</a>
		<a href='<c:url value="/board/delete?seq=${boardList.seq }"></c:url>'>삭제</a>
			<!-- <button id="listBtn">글목록</button> -->
			<!-- <button id="updateBtn" >수정</button>
			<button id="deleteBtn" >삭제</button> -->
		</div>

</body>
</html>