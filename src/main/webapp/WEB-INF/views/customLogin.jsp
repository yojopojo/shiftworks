<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Custom Login</h1>
	<!-- 에러 발생, 로그아웃 시 메시지 출력 -->
	<h3><c:out value="${ error }"/></h3>
	<h3><c:out value="${ logout }"/></h3>

	<!-- 로그인 폼 -->
	<form method="post" action="/login">
	
		<div>
			<input type="text" name="username" value="user0">
		</div>
		<div>
			<input type="password" name="password" value="pw0">
		</div>
		<div>
			<input type="submit">
		</div>
		<!-- 보안토큰 -->
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	
	</form>

	

</body>
</html>