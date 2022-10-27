<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>All Booking List</h2>
	<h5><a href="/booking/list/${emp_id }"><c:out value="내 예약목록 보기"></c:out></a></h5>
	<div class="bookingList">
		<div class="list-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>예약번호</th>
						<th>예약명</th>
						<th>예약자</th>
						<th>예약일자</th>
					</tr>
				</thead>
				
				<c:forEach items="${event }" var="reserv">
					<tr>
						<td><c:out value="${reserv.book_id }"></c:out></td>
						<td><a href="/booking/${reserv.book_id}"><c:out value="${reserv.book_title }"></c:out></a></td>
						<td><c:out value="${reserv.emp_id }"></c:out></td>
						<td><c:out value="${reserv.book_date }"></c:out></td>
					</tr>				
				</c:forEach>
					
			</table>		
		</div>
	</div>
</body>
</html>