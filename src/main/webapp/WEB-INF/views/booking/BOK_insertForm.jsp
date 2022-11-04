<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!-- timePicker -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

    <!— Popperjs —>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.2/dist/umd/popper.min.js"
          crossorigin="anonymous"></script>
    <!— Tempus Dominus JavaScript —>
    <script src="https://cdn.jsdelivr.net/gh/Eonasdan/tempus-dominus@master/dist/js/tempus-dominus.js"
          crossorigin="anonymous"></script>

    <!— Tempus Dominus Styles —>
    <link href="https://cdn.jsdelivr.net/gh/Eonasdan/tempus-dominus@master/dist/css/tempus-dominus.css"
          rel="stylesheet" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Book your meetings here</title>
</head>
<body>
	<div class="container">
	<div class="col-12">회의실 예약</div>
	
	<div class="insertForm" id="insertForm">
			<table>
			<div class="form-body">
				<tr>
				<div class="form-group">
					<td>emp_id</td>
					<td><input name="emp_id" type="text" readonly="readonly" value="사원번호 자동생성"></td>
				</div>
				</tr>
				<tr>
				<div class="form-group">
					<td>dept_id</td> 
					<td><input name="dept_id" type="text" readonly="readonly" value="부서이름 생성"></td>
				</div>
				</tr>
				<tr>
					<td><label>자원 선택</label></td>
					<td>
					<select name="rsc_id" id="rsc_id">
					<option>----- 자원 -----</option>
					<option value="MTR101">회의실101</option>
					<option value="MTR202">회의실202</option>
					<option value="CFR305">컨퍼런스룸305</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>예약일자 선택</td>
					<td><input type="text" name="book_date" id="Date" placeholder="날짜를 선택하세요"><br></td>
				</tr>
				<tr>
					<td><label>시작 시간 선택&ensp;</label></td>
					<td>
					<select name="book_begin" id="book_begin">
						<option>----- 09:00-19:00 -----</option>
						<option value="09">09:00-11:00</option>
						<option value="11">11:00-13:00</option>
						<option value="13">13:00-15:00</option>
						<option value="15">15:00-17:00</option>
						<option value="17">17:00-19:00</option>
					</select>
					</td>
				</tr>
				<tr>
					<div class="form-group">
					<td>예약명</td>
					<td><input name="book_title" type="text" placeholder="제목을 입력하세요"><br></td>
					</div> 
				</tr>
				<tr>
					<div class="form-group">
					<td>예약내용</td>
					<td><textarea rows="6" cols="70" name="book_content" placeholder="내용을 입력하세요" ></textarea><br></td>
					</div>
				</tr>
				</table>
			
			<button id="submitBtn" type="button" class="btn btn-warning">예약</button>
			</div> <!-- end form-body class -->
			
	</div> <!-- end insertForm class -->


	<!-- <b><input id="datetimepicker" type="text" name="book_date"><br></b> -->
	</div> <!-- end container -->


	
	<!--javaScript 스크립트-->
	<script type="text/javascript" src="/resources/js/booking.js"></script>
	<script type="text/javascript">
	
	
	
	$(document).ready(function(){
		
		console.log(bookingService);
		console.log("---------------------JS '***bookingService***' TESTING---------------------");
		
		
		
		//날짜 선택 UI(datepicker)
		$(function() {
		    $( "#Date" ).datepicker({
		    	dateFormat: "yy-mm-dd"
		    });
		});
		
		
		
		//예약폼 데이터
		var form = $(".insertForm");
		var book_id = form.find("input[name='book_id']");
		var rsc_id = form.find("select[name='rsc_id']");
		var emp_id = form.find("input[name='emp_id']");
		var dept_id = form.find("input[name='dept_id']");
		var book_date = form.find("input[name='book_date']");
		var book_begin = form.find("select[name='book_begin']");
		var book_title = form.find("input[name='book_title']");
		var book_content = form.find("textarea[name='book_content']");
		
		//제출 버튼 클릭 시 bookingData에 데이터 JSON형식으로 저장, 예약 프로세스 진행 후 결과값 출력
		$('#submitBtn').on("click", function(e){
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
						if(result == "success"){
							alert("예약되었습니다");
							$(location).attr('href', '/booking/list');
						}else if(result =="fail"){
							alert("이미 예약된 시간입니다")
						}
					})//end insertBooking
					
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