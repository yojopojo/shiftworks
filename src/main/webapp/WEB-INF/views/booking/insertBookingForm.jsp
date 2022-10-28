<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book your meetings here</title>
</head>
<body>
	<h2>insertBookingForm 입니다.</h2><br>
	
	<div class="insertForm" id="insertForm">
			<div class="form-body">
				<div class="form-group">book_id <input name='book_id' type="text"><br></div>
				<div class="form-group">rsc_id <input name="rsc_id" type="text"><br></div>
				<div class="form-group">emp_id <input name="emp_id" type="text"><br></div>
				<div class="form-group">dept_id <input name="dept_id" type="text" value=""><br></div>
				<div class="form-group">예약일자 <input name="book_date" type="text"><br></div>
				<div class="form-group">예약 시작시간 <input name="book_begin" type="text"><br></div> 
				<div class="form-group">예약명 <input name="book_title" type="text"><br></div> 
				<div class="form-group">예약내용 <input name="book_content" type="text"><br></div>
				<button id="submitBtn" type="button" class="btn btn-warning">예약</button>
			</div>
	</div>
	
	<!--javaScript 스크립트-->
	<script type="text/javascript" src="/resources/js/booking.js"></script>
	<script type="text/javascript">
	
	
	
	$(document).ready(function(){
		
		console.log(bookingService);
		console.log("---------------------JS '***bookingService***' TESTING---------------------");
		
		var form = $(".insertForm");
		var book_id = form.find("input[name='book_id']");
		var rsc_id = form.find("input[name='rsc_id']");
		var emp_id = form.find("input[name='emp_id']");
		var dept_id = form.find("input[name='dept_id']");
		var book_date = form.find("input[name='book_date']");
		var book_begin = form.find("input[name='book_begin']");
		var book_title = form.find("input[name='book_title']");
		var book_content = form.find("input[name='book_content']");
				
		$('#submitBtn').on("click", function(e){
			//console.log("book_id: "+book_id+"입니다");
			var bookingData = {
					book_id: book_id.val(),
					rsc_id: rsc_id.val(),
					emp_id: emp_id.val(),
					dept_id: dept_id.val(),
					book_begin: book_begin.val(),
					book_date: book_date.val(),
					book_title: book_title.val(),
					book_content: book_content.val(),
			};
			
			bookingService.insertBooking(bookingData, function(result){
						alert("RESULT: "+result);
						$(location).attr('href', '/booking/list');
					})
		
		
		/* bookingService.insertBooking(
				{book_id:15, rsc_id:"CFR307", emp_id:"SALES12", dept_id:"SALES", book_date:"2022-11-3", 
					book_begin: 14, book_title:"test day2 : JSON", book_content:"plz..."}
				,function(result){
				alert("RESULT: "+result);
			}
		) */
		
	});
	
	});
	
	
	
	
	</script>
</body>
</html>