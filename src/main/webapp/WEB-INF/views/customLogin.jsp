<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
=======
    pageEncoding="UTF-8"%>
>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<script
   src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
   integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
   crossorigin="anonymous"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
   integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
   crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/login.css">
<meta charset="UTF-8">
<title>shiftworks login page</title>
</head>
<script>
$(document).ready(function(){
	$(".btn-success").on("click", function(e){
	
		e.preventDefault();
	    
		$("form").submit();
	});
});
</script>

<c:if test="${param.logout != null}">
<script>
$(document).ready(function(){
	alert("로그아웃하였습니다.");
});
</script>
</c:if>  
<body>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Please Sign In</h3>
				</div>
				<div class="panel-body">
					<form role="form" method='post' action="/login">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="사번" name="username" type="text" autofocus>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="password" type="password" value="">
							</div>
							
							<a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
						</fieldset>						
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
=======
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
			<input type="text" name="username" value="user1">
		</div>
		<div>
			<input type="password" name="password" value="pw1">
		</div>
		<div>
			<input type="submit">
		</div>
		<!-- 보안토큰 -->
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	
	</form>

	

>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
</body>
</html>