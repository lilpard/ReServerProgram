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
		<ul>
			<li>${board.no }번 게시글</li>
			<li>작성일 : ${board.postdate }</li>
			<li>작성자 : ${board.author }</li>
			<li>작성IP : ${board.ip }</li>
			<li>조회수 : ${board.hit }</li>
			<li>제목</li>
			<input type="text" name="title" value="${board.title}">
			<li>내용</li>
			<input type="content" name="content" value="${board.content}">
		</ul>
		<input type="button" value="목록" onclick="location.href='list.do'">
		<input type="button" value="삭제" onclick="fnNoticeDelete()">
		<script>
			function fnNoticeDelete(){
				if(confirm('게시글을 삭제할까요?')){
					location.href = 'delete.do?no=${board.no}';
				}
			}
		</script>
	</div>
	
	<hr>
	
	<form action="insertReply.do" method="post">
			<textarea rows="5" cols="30" name="content">댓글을 입력하세요</textarea>
			<input name="author" id="writer" placeholder="작성자">
			<button>작성</button>
			<br>
			<input type="hidden" name="no" value="${board.no}">
	</form>
	
	<div>
		<table border="1">
			<c:if test="${empty replyList}">
				<td colspan="4">작성된 댓글이 없습니다.</td>
			</c:if>
			<c:if test="${not empty replyList}">
				<c:forEach items="${replyList}" var="reply">
					<td>${reply.content}</td>
					<td>${reply.author}</td>
					<td>${reply.ip}</td>
					<td>${reply.postdate}</td>
				</c:forEach>
			</c:if>
		</table>
	</div>


</body>
</html>