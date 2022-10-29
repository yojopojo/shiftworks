<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<h5><a href="/booking/new"><c:out value="예약하기"></c:out></a></h5><br>
	
	<div class="bookingList">
		 <div class="list-body">
			<table class="table table-sm">
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
						<td><c:out value="${reserv.book_date } ${reserv.book_begin }시"></c:out></td>
						<%-- <td><fmt:formatDate pattern="yyyy-MM-dd" value="${reserv.book_date}"/></td> --%>
					</tr>				
				</c:forEach>
					
			</table>
			

		
		
<%-- 					<div class="pull-right">
				<ul class="pagination">
				
					<c:if test="${pageMaker.prev }">
						<li class="paginate_button previous"><a href="#">Previous</a></li>
					</c:if>
					
					<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						<li class="paginate_button"><a href="#"> ${num} </a> </li>
					</c:forEach>
					<c:if test="${pageMaker.next }">
						<li class="paginate_button"><a href="#">Next</a></li>
					</c:if>
				</ul>
			</div>	 --%>
		
		
		
		
		
		
		
		
		
		
		
		</div>
	</div>
</body>
</html>