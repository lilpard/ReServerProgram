<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			setTimeout(function(){
				location.href='list.do';
			}, 3000);
		});
	</script>
</head>
<body>


	<h1>3초후에 목록으로 넘어갑니다.</h1>
	<div>지금 목록으로 가고싶으면 아래 버튼을 누르세요</div>
	<input type="button" value="목록으로 가기" onclick="location.href='list.do'">

</body>
</html>