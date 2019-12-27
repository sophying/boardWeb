<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_List.jsp</title>
<style type="text/css">
	td{
		width: 250px;
	}
</style>
</head>
<body>
<table border="1">
	<tr>
		<th>No</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${boardList }" varStatus="loop">
		<tr>
			<td>${board.seq }</td>
		<%-- 	<td><a href="<c:url value="/board/read?seq=${board.seq }" />">${board.title }</a></td> --%>
			<td><a href="<c:url value="/board/read/${board.seq }" />">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.regDate }</td>
			<td>${board.cnt }</td>
		</tr>
	</c:forEach>
</table>
<a href="<c:url value="/board/write"/>">새 글</a>
</body>
</html>