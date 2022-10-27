<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Detail Reservation</title>
</head>
<body>
	<h2>Detail Reservation Page</h2>
	
	<table>
		<thead>
			<tr>
				<th><c:out value="${event.book_id }"></c:out> </th>
				<th><c:out value="${event.book_title }"></c:out></th>
				<th><c:out value="${event.emp_id }"></c:out></th>
			</tr>
		</thead>
			<tr>
				<td>일정</td>
				<td><c:out value="${event.book_date } ${event.book_begin }시~${event.book_end }시"></c:out></td>
			</tr>
			
			<tr>
				<td>위치</td>
				<td><c:out value="위치정보 조인"></c:out></td>
			</tr>
			
			<tr>
				<td>상세설명</td>
				<td><c:out value="${event.book_content }"></c:out></td>
			</tr>
	</table>
	<br><br>
	
	<table>
		<tr>
			<th><a href="/booking/list"><c:out value="목록보기"></c:out></a></th>
			<th><a href="#"><c:out value="삭제"></c:out></a></th>
		</tr>
	</table>
	
</body>
</html>