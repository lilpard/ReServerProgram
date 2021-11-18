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
	<table>
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
				 게시물이 없습니다.
			</c:if>
			<c:forEach var="board" items="list">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>