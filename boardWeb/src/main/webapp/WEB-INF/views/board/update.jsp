<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_Update Page</title>
</head>
<body>
<h2>내용 수정</h2>
<form:form modelAttribute="boardList" method="post">
	<table border="1">
		<tr>
			<th><form:label path="title">제목</form:label></th>
			<td>
				<form:input path="title" />
				<form:errors path="title"/>
			</td>	
		</tr>
		<tr>
			<th><form:label path="writer">작성자</form:label></th>
			<td>
				<form:input path="writer"/>
				<form:errors path="writer"></form:errors>
			</td>
		</tr>
		<tr>
			<th><form:label path="content">내용</form:label></th>
			<td>
				<form:input path="content"/> 
				<form:errors path="content"></form:errors>
			</td>
		</tr>	
	</table>
		<div>
			<input type="submit" value="등록">
			<a href='<c:url value="/board/list"></c:url>'>목록</a>
		</div>
</form:form>
</body>
</html>