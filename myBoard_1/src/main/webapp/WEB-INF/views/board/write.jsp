<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write 글작성</title>
</head>
<body>
<div id="root">
	<header>
		<%@include file="include/header.jsp" %><%-- 소스코드가 그대로 들어오는 것 : include   를 하는 이유는 동일한 코드를 공통되게 사용하기 위함  --%>
	</header>
	<nav>
		<%@include file="include/nav.jsp" %><%-- 소스코드가 그대로 들어오는 것 : include --%>
	</nav>

	<section id="container">
	<c:if test="${msg == null }">
		<form role="form" method="post" autocomplete="off">
			<p>
				<label for="title">글 제목</label>
				<input type="text" id="title" name="title"/>
			</p>
			<p>
				<label for="content">글 내용</label>
				<textarea id="content" name="content"></textarea>
			</p>
			<p>
				<label for="writer">작성자</label>
				<input type="text" id="writer" name="writer" value="${member.userName}" readonly="readonly"/>
			</p>
			<p>
				<button type="submit">작성</button>
			</p>
		</form>
	</c:if>
	
	<c:if test="${msg == false }">
		<p>로그인을 하셔야 글을 작성할 수 있습니다.</p>
		<p><a href="/">홈으로</a></p>
	</c:if>
	</section>
	<footer>
		<%@include file="include/footer.jsp" %> <%-- 소스코드가 그대로 들어오는 것 : include --%>
	</footer>
</div>
</body>
</html>