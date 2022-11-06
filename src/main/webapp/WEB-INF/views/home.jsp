<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page session="false" %>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
	<title>Home</title>
</head>
<body>
	<div class="container">
		<h1>
			Hello world!  
		</h1>
		
		<P>  The time on the server is ${serverTime}. </P>
	
	
	<div class="row">
		<div class="col-5 card" style="background: red;">1row 1번째
			<!-- <table>
				<tr>
					<td>1row 1번째</td>
				</tr>
				<tr>
					<td>테이블 어떻게 만들어...?</td>
				</tr>
			</table> -->
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Active</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
			</div>
		
		<div class="col-2">
			공간
		</div>
		
		<div class="col-5 card" style="background: red;">1row 2번째
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Active</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
			</div>
	</div>















</div>
</body>
</html>
