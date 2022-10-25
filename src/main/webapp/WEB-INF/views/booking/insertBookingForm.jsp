<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking your Meetings here</title>
</head>
<body>
	<h2>insertBookingForm 입니다.</h2>
	<form action="/booking/new" method="post">
		예약일자 <input name="book_date" type="text"><br>
		예약 시작시간 <input name="book_begin" type="text"><br>
		예약명 <input name="book_title" type="text"><br>
		예약내용 <textarea rows="6" cols="70" name="book_content"></textarea>
		
		<br><br>
		<input type="submit" value="예약">
	</form>
</body>
</html>