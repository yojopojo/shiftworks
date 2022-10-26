<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery 스크립트 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Booking your Meetings here</title>
</head>
<body>
	<h2>insertBookingForm 입니다.</h2><br>
		<form action="/booking/new" method="post">
			book_id <input name="book_id" type="text"><br>
			rsc_id <input name="rsc_id" type="text"><br>
			emp_id <input name="emp_id" type="text"><br>
			dept_id <input name="dept_id" type="text"><br>
			예약일자 <input name="book_date" type="text"><br> 
			예약 시작시간 <input name="book_begin" type="text"><br> 
			예약명 <input name="book_title" type="text"><br> 
			예약내용 <textarea rows="6" cols="70" name="book_content"></textarea>
			<br>
			<br> <input type="submit" value="예약">
		</form>
		

	<!--javaScript 스크립트-->
	<script type="text/javascript" src="/resources/js/booking.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		console.log(bookingService);
		console.log("---------------------JS '***bookingService***' TESTING---------------------");
		
		bookingService.insertBooking(
			{book_id:10, rsc_id:"CFR307", emp_id:"SALES730", dept_id:"SALES", book_date:"2022-10-30", book_begin: 14, book_title:"test day2 to JSON", book_content:"plz..."}
		)
		
		
	});
	
	
	
	
	
	
	</script>
</body>
</html>