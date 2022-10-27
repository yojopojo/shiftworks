<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<h2>게시판 명</h2>
<div id ="boardName">
<h3><a href="1">공지사항</a></h3>
<h3><a href="2">행사</a></h3>
<h3><a href="3" name="aa">자유게시판</a></h3>
<h3><a href="4">자료실</a></h3>
</div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

