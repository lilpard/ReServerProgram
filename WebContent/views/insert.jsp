<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<form id="f" action="insert.do" method="post">
			<label for="writer">작성자</label>
			<input type="text" name="author" id="author"><br>
			<label for="title">제목</label>
			<input type="text" name="title" id="title"><br>
			<textarea rows="5" cols="30" name="content" placeholder="내용"></textarea><br><br>
			<button>저장하기</button>
			<input type="reset" value="다시작성">
			<input type="button" value="목록 이동" onclick="location.href='list.notice'"> 
		</form>
	</div>
	
	
</body>
</html>