<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/schedule.js"></script>
<link rel="stylesheet" href="/resources/css/schedule.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>일정 관리</title>
</head>
<body>


	<div class="table-responsive">
		<table>
			<tr>
				<td id="mainTable">
					<table class="table align-middle">
						<thead id="calendarHead">
							<tr>
								<ul class="nav nav-tabs">
									<li class="nav-item"><a id="month" class="nav-link active"
										aria-current="page" href="#">월별</a></li>
									<li class="nav-item" aria-current="page"><a
										id="week" class="nav-link" href="#">주별</a></li>
									<li class="nav-item" aria-current="page"><a
										id="day" class="nav-link" href="#">일별</a></li>
								</ul>
							</tr>
							<tr>
								<td colspan="6" class="refDate"></td>
								<td>
									<div class="dropdown">
										<button class="btn btn-secondary dropdown-toggle sch_group"
											type="button" data-bs-toggle="dropdown" aria-expanded="false">
											그룹 선택</button>
										<ul class="dropdown-menu">
											<li><a class="dropdown-item" href="#">내 일정</a></li>
											<li><a class="dropdown-item" href="#">부서 일정</a></li>
											<li><a class="dropdown-item" href="#">회사 일정</a></li>
										</ul>
									</div>
								</td>
							</tr>
							<tr class="dayOfWeek"></tr>
						</thead>
						<tbody id="calendarBody">

						</tbody>

					</table>
				</td>
				<td id="memoTable">
					<p>메모내용</p>
				<td>
			</tr>

		</table>

	</div>


	<script type="text/javascript">

	//list 페이지 로딩 시 실행
	$(document).ready(function(){
		
	
		// 선택 일자, 선택 그룹을 저장하는 객체
	    var listparam = {};
	    listparam.selectedDate;
	    listparam.sch_group;
	    
	    // 월별, 주별, 일별 탭 선택 시 타입 변경
	    $('.nav li').on("click", function() {
	    	$('.nav *').removeClass('active');
	    	$(this).children('a').addClass('active');
	    });

        // 현재 시각을 원하는 형태로 변경('yyyy-MM-dd')
        var today = new Date();

        var year = today.getFullYear();
        var month = ('0' + (today.getMonth() + 1)).slice(-2);
        var day = ('0' + today.getDate()).slice(-2);

        var selectedDate = year + '-' + month  + '-' + day;


        /* * * * * * * * * * * * * * * * * * *
					캘린더 생성
		* * * * * * * * * * * * * * * * * * */
 	    // 저번달 마지막날 날짜, 요일 구하기
        var startDay = new Date(year, month - 1, 0);
        var prevDate = startDay.getDate();
        var prevDay = startDay.getDay();

        // 이번달 마지막날 날짜, 요일 구하기
        var endDay = new Date(year, month, 0);
        var nextDate = endDay.getDate();
        var nextDay = endDay.getDay();

        // 캘린더 html 저장 변수
        var makeCalendar;
        // 일주일마다 테이블 로우를 새로 만들 수 있도록 count
        var weekCount;
        
        // 요일 로우 생성
        var makeDOW = function() {
        	$('.dayOfWeek').html('<td>일</td>'+
        			'<td>월</td>'+'<td>화</td>'+'<td>수</td>'+'<td>목</td>'+'<td>금</td>'+'<td>토</td>');
        }
        
        
        // '월별' 클릭 시 캘린더 출력
        $('#month').on("click", function(e) {
        	makeCalendar = "";
        	weekCount = 0;
        	e.preventDefault();
        	makeDOW();
        	makeCalendar = '<tr>';
         	// 시작주 칸 생성(지난달 날짜분)
            for (var i = prevDate - prevDay; i <= prevDate; i++) {
            	weekCount++;
                makeCalendar += '<td class="prevDay ';
                if(month == '01') {
                	makeCalendar += (year - 1);
                } else {
                	makeCalendar += year;
                }
                
                makeCalendar +=  '-' + month + '-' + i + '">' + i + '</td>';
            }
        	// 이번달 날짜만큼 칸 생성
            for (var i = 1; i <= nextDate; i++) {
            	if(weekCount == 7) {
            		makeCalendar += '</tr><tr>'
            		weekCount = 0;
            	}
            	weekCount++;
            	makeCalendar += '<td class="'+ year + '-' + month + '-';
            	if (i<10) {
            		makeCalendar += '0'
            	}
            	makeCalendar += i +'">' + i + '</td>'
            }
        	
         	// 마지막주 칸 생성(다음달 날짜분)
            for (var i = 1; i < (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
            	makeCalendar += '<td class="nextDay ';
            	
            	if(month == '12') {
            		makeCalendar += (year+1);
            	} else {
            		makeCalendar += year;
            	}
            	
            	makeCalendar += '-' + month + '-0' + i +'">' + i + '</td>'
            }
         	
         	$('#calendarBody').html(makeCalendar);
         	
			getList();
         	
        });// end month onclick(월별 캘린더 생성 후 데이터 가져오기)
        
        
        // '주별' 클릭 시 캘린더 생성
        $('#week').on("click", function(e) {
        	makeCalendar = "";
        	weekCount = 0;
        	e.preventDefault();
        	
        	
        }); // end week onclick(주별 캘린더 생성)
     	
     	/* * * * * * * * * * * * * * * * * * *
     			DB 출력 전 데이터 처리
     	* * * * * * * * * * * * * * * * * * */
     	// 별도로 출력 날짜를 지정하지 않은 경우
        if(typeof listparam.selectedDate === 'undefined') {
            listparam.selectedDate = selectedDate;
        }

        // 기준 날짜를 상단에 기입
        $('.refDate').text(listparam.selectedDate);

        // 선택된 그룹이 없을 경우
        if(typeof listparam.sch_group === 'undefined') {
            listparam.sch_group = 'all';
        }
	
		// getList를 통해 DB에서 데이터 받아오기
	   	function getList() {scheduleService.getList(listparam, function(list) {
	    	
	    	var html;
	    	
	    	list.forEach((item) => {
	    		html = "";
	
	    		if(item.sch_title != null) {
	    			
	    			html += '<tr>';
		    		html += '<td class="eachSch">' + item.sch_title + '</td>';
		    		html += '</tr>';
		    		$('#calendarBody .' + item.sch_date).append(html);
	    		} // end if
	    		
	    	}) // end forEach   	
	    });} // end getList
	    

     	// 기본으로 '월별' 캘린더가 클릭된 상태로 만듦
		$("#month").trigger("click");
		
	
	}) // end document ready

</script>

</body>
</html>