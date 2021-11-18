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
			<li>게시글번호</li>
			<li>저자</li>
			<li>제목</li>
			<li>내용</li>
			<li>조회수</li>
			<li>작성일자</li>
		</ul>
	</div>
	<table>
		<tbody>
			<c:if test="${empty replylist}">댓글없음</c:if>
			<c:if test="${not empty replyList }">
				<c:forEach var="replys" items="replyList">
					
				</c:forEach>
			</c:if>
		</tbody>
	</table>

</body>
</html>