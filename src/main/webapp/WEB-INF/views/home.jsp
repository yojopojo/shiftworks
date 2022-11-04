<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<h1><a href="/board/new">게시글 등록</a></h1>
<h1><a href="/board/list?b_id=1">공지사항</a></h1>
<h1><a href="/board/list?b_id=2">행사</a></h1>
<h1><a href="/board/list?b_id=3">자유게시판</a></h1>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
