<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/security/tags"
   prefix="sec"%>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Detail Reservation</title>
</head>
<body>

	<div class="container">
	<div class="col-12"><h2>예약 상세보기</h2></div>
 	
  	<div class="col-8">
	<table>
		
			<tr>
				<td><label>예약번호&ensp;<br></label></td>
				<td class="form-control" style="width: 300px;"><c:out value="${event.book_id }"></c:out></td>
			</tr>
			<tr>
				<td><label>예약명&ensp;</label></td>
				<td class="form-control" style="width: 500px;"><c:out value="${event.book_title }"></c:out></td>
			</tr>
			<tr>
				<td><label>예약자&ensp;</label></td>
				<td class="form-control" style="width: 300px;"><c:out value="${event.emp_id }"></c:out></td>
			</tr>
			<tr>
				<td><label>예약 일정&ensp;</label></td>
				<td class="form-control" style="width: 300px;"><c:set var="book_date" value="${event.book_date }"></c:set>
				<c:out value="${fn:substring(book_date,0,13) }">&ensp;</c:out>
				<c:out value="${event.book_begin }시~${event.book_begin+2 }시"></c:out></td>
			</tr>
			<tr>
				<td><label>예약 내용&ensp;</label></td>
				<td class="form-control" style="width: 500px; height: 150px;"><c:out value="${event.book_content }"></c:out></td>
			</tr>

	</table>
	<br><br>
	
	<table>
		<tr>
			<th><a href="/booking/list"><button id="listBtn" type="button" class="btn btn-primary">목록보기</button></a></th>
			<th><a href="#"><button id="removeBtn" type="button" class="btn btn-primary">예약 취소</button></a></th>
		</tr>
	</table>
	</div> <!-- end col-8 -->
	</div> <!-- end container -->
	
	
	
	
<%-- 	<table class="table table-hover">
        <colgroup>
            <col width=15%>
            <col width=70%>
            <col width=15%>
        </colgroup>
        <tr>
            <th>${event.book_id}</th>
            <th>${event.book_title }</th>
            <th>${event.emp_id }</th>
        </tr>
    </table>
    <table>
		<colgroup>
			<col width=50%>
			<col width=50%>
		</colgroup>
		<tr>
			<th>${event.book_date}</th>
			<th>${event.book_begin }</th>
		</tr>
		<colgroup>
			<col width=100%>
		</colgroup>
		<tr>
			<th>${event.book_content}</th>
		</tr>
	</table> --%>
</body>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>