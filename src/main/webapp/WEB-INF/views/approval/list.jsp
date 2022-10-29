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
	<a href="/approval/insert">결재문서 작성</a>
	<table border="1" width="800">
		<tr>
			<th>결재 번호</th>
			<th>결재 유형</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>결재명</th>
			<th>결재 내용</th>
			<th>결재 상태</th>
			<th>결재 의견</th>
			<th>결재 날짜</th>
		</tr>
		
		<c:forEach var="approval" items="${list }">
		
		<tr>	
			<td><c:out value="${approval.apr_id }"/></td>
			<td><c:out value="${approval.af_id }"/></td>
			<td><c:out value="${approval.emp_id }"/></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd"
			 value="${approval.apr_receivedate }"/></td>
			 <td><c:out value="${approval.apr_title}"/></td>
			<td><c:out value="${approval.apr_content }"/></td>
			<td><c:out value="${approval.apr_status }"/></td>
			<td><c:out value="${approval.apr_comment }"/></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" 
			 value="${approval.apr_signdate }"/></td>
		</tr>
		</c:forEach>
	</table>
	<br><br>

</body>
</html>