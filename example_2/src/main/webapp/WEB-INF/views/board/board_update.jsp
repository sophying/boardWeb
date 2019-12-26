<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/menu.jsp" %>
	<h2>Board Read 페이지 입니다.</h2>
	<a href="${path }/board/writer_page">글쓰기</a>
	<form name="updateform" method="POST" action="${path }/board/update.do">  <!-- controller  -->
		<div>글번호</div>
		<div>
			<input name="bno" value="${data.bno }" type="text" readonly="readonly" />
		</div>
		<div>작성자</div>
		<div>
			<input name="writer" value="${data.writer }" type="text" readonly="readonly" />
		</div>
		<div>게시글 제목 : </div>
		<div>
			<input name="title" value="${data.title }" type="text"/>
		</div>
		<div>게시글 내용 : </div>
		<div>
			<textarea name="content" rows="5" cols="50">${data.content }</textarea>
		</div>
		<div>조회수</div>
		<div>
			<input name="viewcnt" value="${data.viewcnt }" type="text" readonly="readonly" />
		</div>
		<div>작성일자</div>
		<div>
			<input type="submit" value="글수정" />
			<input type="reset" value="리셋" />
			<button id="listBtn">글목록</button>
		</div>
	</form>
<script type="text/javascript">

		$("listBtn").click(function() {
			$(location).attr("href", "./board/board_list.jsp")
		});
		
</script>
</body>
</html>