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
	<a href="insertForm.do">새글 작성</a>	<br>
	전체 게시글 : ${total }
	<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>저자</td>
					<td>제목</td>
					<td>조회수</td>				
					<td>작성일자</td>				
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list }">
					 <tr>
					 	<td colspan="5">게시물이 없습니다.</td>
					 </tr>
				</c:if>
				<c:if test="${not empty list}">
					<c:forEach var="board" items="${list}">
						<tr>
							<td>${board.no }</td>
							<td>${board.author }</td>
							<td><a href="selectView.do?no=${board.no}">${board.title }</a></td>
							<td>${board.hit }</td>
							<td>${board.postdate }</td>
						</tr>			
					</c:forEach>
				</c:if>
			</tbody>
		</table>
</body>
</html>