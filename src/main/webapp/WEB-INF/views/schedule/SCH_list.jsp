<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resource/js/schedule.js"></script>
<meta charset="UTF-8">
<title>일정 관리</title>
</head>
<body>

		<div class="table-responsive">
		<table class="table align-middle">
			<thead id="calendarHead">
				<tr>
					<td>일</td>
					<td>월</td>
					<td>화</td>
					<td>수</td>
					<td>목</td>
					<td>금</td>
					<td>토</td>
				</tr>
			</thead>
			<tbody id="calendarBody">
				
			</tbody>
		</table>
	</div>

</body>
</html>