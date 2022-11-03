<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>admin</h1>
	
	<!-- 로그아웃 버튼 클릭 시 스프링 시큐리티가 로그아웃 처리 -->
	<form action="/customLogout" method="post">
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
		<button>로그아웃</button>
	</form>
	
	<!-- 로그인된 사용자의 정보 출력 -->
	<!-- 해당 property 참고하여 데이터 CRUD 전 사용자 인증에 이용 -->
	<p>principal: <sec:authentication property="principal"/></p>
	<p>사용자: <sec:authentication property="principal.employee"/></p>
	<p>사용자 아이디:<sec:authentication property="principal.username"/></p>
	<p>사용자 권한: <sec:authentication property="principal.employee.authList"/></p>
</body>
</html>