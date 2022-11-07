<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page session="false" %>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>

<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">  
<!-- fullcalendar CDN -->  
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />  
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>  
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<!--javaScript 스크립트-->
<script type="text/javascript" src="/resources/js/booking.js"></script>
<script type="text/javascript">

document.addEventListener('DOMContentLoaded', function () {
    $(function () {
        var request = $.ajax({
            url: "/booking/cal2.json",
            method: "GET"
        });
        
        request.done(function (data) {
            console.log(data); //가져온 data 확인

            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
            	nowIndicator: true,
            	initialView: 'listWeek',
                /* headerToolbar: {
                    center: 'title',
                }, */
                eventBackgroundColor : "#1C3359",
                events:data,
            });

            calendar.render();
        });


        request.fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        });
    });

});




</script>



	<title>Home</title>
</head>
<body>
	<div class="container">
		<!-- <h1>
			Hello world!  
		</h1> -->
		
		<P>  현재시각 ${serverTime} 입니다. </P>
	
	
	<div class="row">

<!-- 		<div class="col">
		</div> -->


		<div class="col-5 card" style="background: white; height: 550px;"><!-- 1row 1번째 -->
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
						aria-current="page" href="#">주간 회의일정</a></li>
					<li class="nav-item"><a class="nav-link" href="/booking/cal">월간 회의일정</a></li>
					<li class="nav-item"><a class="nav-link" href="/booking/new">예약 바로가기</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
						<div id='calendar' style="height: 200px; font-size: 12px;"></div>
		</div> <!-- end 1row 1st -->
		
		<div class="col">
			
		</div> <!-- end col -->
		
		<div class="col-6" style="background: white; margin-top: 30px;"><!-- 1row 2번째 -->
				
				<div class="col">
				    <ul class="list-group">				    	
	  					<a href="/approval/list" style="text-decoration: none;"><li class="list-group-item d-flex justify-content-between align-items-center">   					 
	   					 	결재가 필요한 문서
	    					<span class="badge bg-primary rounded-pill">14</span> 
	  					</li></a>
	  					<a href="/approval/receivedList" style="text-decoration: none;"><li class="list-group-item d-flex justify-content-between align-items-center">
	    					결재 중인 문서
	    					<span class="badge bg-primary rounded-pill">2</span>
	 					</li></a>
	  					<a href="/approval/list" style="text-decoration: none;"><li class="list-group-item d-flex justify-content-between align-items-center">
	  						 반려된 문서
	    					<span class="badge bg-primary rounded-pill">1</span>
	 					</li></a>
					</ul>			    
			    </div>
				
				
				
				
				<%-- <ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Active</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
				
				<!-- 게시판 적용 -->
			<table class="table table-sm">
 				<thead>
					<tr>
						<th>예약번호</th>
						<th>예약명</th>
						<th>예약자</th>
						<th>예약일자</th>
						<th>예약시간</th>
					</tr>
				</thead>
				
				<c:forEach items="${event }" var="reserv">
					<tr>
						<td><c:out value="${reserv.book_id }"></c:out></td>
						<td><a href="/booking/${reserv.book_id}"><c:out value="${reserv.book_title }"></c:out></a></td>
						<td><c:out value="${reserv.emp_id }"></c:out></td>
						<td><c:set var="book_date" value="${reserv.book_date }"></c:set>
						<c:out value="${fn:substring(book_date,0,10) }"></c:out></td>
						<td><c:out value="${reserv.book_begin }시~${reserv.book_begin+2 }시"></c:out> </td>
					</tr>
				</c:forEach>
					
			</table> --%>
				
				
				
				
				
			</div>
	</div> <!-- end 1st row -->

	<div class="row" style="height: 100px;">
		between rowwwwwwwws
	</div>



	<div class="row">
		<div class="col-6 card" style="background: white; height: 600px;"><!-- 1row 1번째 -->
			<!-- <table>
				<tr>
					<td>1row 1번째</td>
				</tr>
				<tr>
					<td>테이블 어떻게 만들어...?</td>
				</tr>
			</table> -->
			
			 <div class="col">
				    <ul class="list-group">				    	
	  					<li class="list-group-item d-flex justify-content-between align-items-center">   					 
	   					 	결재가 필요한 문서
	    					<span class="badge bg-primary rounded-pill">14</span>
	  					</li>
	  					<li class="list-group-item d-flex justify-content-between align-items-center">
	    					결재 중인 문서
	    					<span class="badge bg-primary rounded-pill">2</span>
	 					</li>
	  					<li class="list-group-item d-flex justify-content-between align-items-center">
	  						 반려된 문서
	    					<span class="badge bg-primary rounded-pill">1</span>
	 					</li>
					</ul>			    
			    </div>
			
<!-- 				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">주간 회의일정</a></li>
					<li class="nav-item"><a class="nav-link" href="/booking/cal">월간 회의일정</a></li>
					<li class="nav-item"><a class="nav-link" href="/booking/new">예약 바로가기</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
						<div id='calendar' style="height: 200px; font-size: 13px;"></div> -->
		</div> <!-- end 1row 1st -->
		
		<div class="col">
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
	</div> <!-- end 2nd row -->













</div> <!-- end container -->
</body>
</html>
