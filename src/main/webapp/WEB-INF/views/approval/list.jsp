<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>결재 내역 LIST 페이지</h1>
	<a href="approval_insert">결재내역</a>
	<table border="1" width="800">
		<tr>
			<th>#결재번호</th>
			<th>결재내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>결재날짜</th>
			<th></th>
		</tr>
		
		<c:forEach var="approval" items="${list }">
		
		<tr>	
			
		</tr>
		</c:forEach>
	</table>
	<br><br>

</body>
</html>