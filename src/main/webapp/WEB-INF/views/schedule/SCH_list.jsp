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

	<div>
		<ul class="nav nav-tabs">
			<li class="nav-item"><a id="month" class="nav-link active"
				aria-current="page" href="#">월별</a></li>
			<li class="nav-item" aria-current="page"><a id="week"
				class="nav-link" href="#">주별</a></li>
			<li class="nav-item" aria-current="page"><a id="day"
				class="nav-link" href="#">일별</a></li>
		</ul>
	</div>


	<div class="table-responsive">
		<table>
			<tr>
				<td id="mainTable">
					<table class="table align-middle">
						<thead id="calendarHead">
							<tr>


							</tr>
							<tr>
								<td colspan="6">
									<nav aria-label="Page navigation">
										<ul class="pagination">
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
											<li class="page-item refDate"><a class="page-link"
												href="#"></a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</ul>
									</nav>
								</td>
								<td class="ddtd">
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
				<td id="memoTable">메모
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

        // 선택 날짜를 원하는 형태로 변경('yyyy-MM-dd')
        
        var selectedDate;
        var year;
        var month;
        var day;
        
        var makeDate = function() {
        	
        	if (selectedDate == 'undefined') {
        		// 날짜가 선택되지 않은 경우
        		
        		var today = new Date();
        		year = today.getFullYear();
                month = ('0' + (today.getMonth() + 1)).slice(-2);
                day = ('0' + today.getDate()).slice(-2);
                selectedDate = year + '-' + month  + '-' + day;
                
        	} else {
        		// 날짜가 선택된 경우
        		let str = selectedDate.split('-');
        		year = str[0];
        		month = str[1];
        		
        	}
        	
        }


        

        


        /* * * * * * * * * * * * * * * * * * *
					캘린더 틀 생성
		* * * * * * * * * * * * * * * * * * */

       
        // 요일 로우 생성
        var makeDOW = function() {
        	$('.dayOfWeek').html('<td>일</td>'+
        			'<td>월</td>'+'<td>화</td>'+'<td>수</td>'+'<td>목</td>'+'<td>금</td>'+'<td>토</td>');
        }

        
        // 월별 날짜칸 생성
        var makeDOM = function() {
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
            var dayCount;
            // 각 주마다 넘버링 할 수 있도록 count
            var weekCount;
        	dayCount = 0;
        	weekCount = 0;
        	makeCalendar = "";
        	makeCalendar = '<tr class="week0">';
        	// 시작주 칸 생성(지난달 날짜분)
            for (var i = prevDate - prevDay; i <= prevDate; i++) {
            	dayCount++;
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
            	if(dayCount == 7) {
            		makeCalendar += '</tr><tr class="week'+ ++weekCount +'">'
            		dayCount = 0;
            	}
            	dayCount++;
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
         	
        	// 캘린더 날짜칸 생성
         	$('#calendarBody').html(makeCalendar);
        }
        
        
        // '월별' 클릭 시 캘린더 출력
        $('#month').on("click", function(e) {
        	e.preventDefault();
        	makeDOW();
        	makeDOM();
         	
        	// DB에서 선택 일정에 맞는 데이터 가져오기
			getList();
			
			// 이전, 다음 버튼 월 단위로 변경
			$('a[aria-label]').removeClass("prevWeek nextWeek prevDay nextDay");
			$('a[aria-label=Previous]').addClass("prevMonth");
			$('a[aria-label=Next]').addClass("nextMonth");
			
         	
        });// end month onclick(월별 캘린더 생성 후 데이터 가져오기)
        
        
        
        // '주별' 클릭 시 캘린더 생성
        $('#week').on("click", function(e) {
        	e.preventDefault();
        	makeDOW();
        	makeDOM();
   	
        	// 선택 주 빼고 숨김 처리
        	var selectedWeek = $('td[class=' + selectedDate + ']').parent();
        	$('#calendarBody tr').not(selectedWeek).hide();
        	
        	// DB에서 선택 일정에 맞는 데이터 가져오기
        	getList();
        	
        	// 이전, 다음 버튼 주 단위로 변경
        	$('a[aria-label]').removeClass("prevMonth nextMonth prevDay nextDay");
			$('a[aria-label=Previous]').addClass("prevWeek");
			$('a[aria-label=Next]').addClass("nextWeek");
        	
        }); // end week onclick(주별 캘린더 생성)
        
        
     	// '일별' 클릭 시 캘린더 생성
    	$('#day').on("click", function(e) {
        	e.preventDefault();
        	makeCalendar = "";
        	
        	let d = today.getDay();
        	
        	switch(d) {
        	case 0: d = '일요일'; break;
        	case 1: d = '월요일'; break;
        	case 2: d = '화요일'; break;
        	case 3: d = '수요일'; break;
        	case 4: d = '목요일'; break;
        	case 5: d = '금요일'; break;
        	case 6: d = '토요일'; break;
        	}
        	
        	// 선택 요일 출력
        	$('.dayOfWeek').html('<td colspan="7">' + d + '</td>')
        	
        	// 왼쪽에 타임라인 출력
        	var timeline = (function() {
        		
        		let t = "";
        		let tHTML = "";
        		
        		// 시간을 hh:mm 형태로 저장
        		for(let i=0; i<24; i++) {
        			if(i<10) {
            			t = '0' + i + ':00';
        			} else {
        				t = i + ':00';
        			}
        			
        			tHTML += '<li><b>' + t + '</b></li>';
        		}
        		
        		return tHTML;
        		
        	})();
        	
        	// 선택 날짜를 출력할 칸 만들기
        	$('#calendarBody').html('<tr><td><ul class="timeline">' + timeline + '</ul></td>'
        		+ '<td colspan="7" class="' + selectedDate + '"></td></tr>');
        	
        	// DB에서 선택 일정에 맞는 데이터 가져오기
        	getList();
        	
        	// 이전, 다음 버튼 주 단위로 변경
        	$('a[aria-label]').removeClass("prevMonth nextMonth prevWeek nextWeek");
			$('a[aria-label=Previous]').addClass("prevDay");
			$('a[aria-label=Next]').addClass("nextDay");
        	
        }); // end day onclick(일별 캘린더 생성)
        
        
     	
     	/* * * * * * * * * * * * * * * * * * *
     			DB 출력 전 데이터 처리
     	* * * * * * * * * * * * * * * * * * */
     	// 별도로 출력 날짜를 지정하지 않은 경우
        if(typeof listparam.selectedDate === 'undefined') {
            listparam.selectedDate = selectedDate;
        }

        // 기준 날짜를 상단에 기입
        $('.refDate a').text(listparam.selectedDate);

        // 선택된 그룹이 없을 경우
        if(typeof listparam.sch_group === 'undefined') {
            listparam.sch_group = 'all';
        }
        
     	/* * * * * * * * * * * * * * * * * * *
			이전, 이후 버튼 클릭 시 달력 이동
		* * * * * * * * * * * * * * * * * * */
		$('.page-link').on("click", function(){
			
			if($(this).hasClass(prevMonth)) {
				
			}
			
		}); // 이전, 이후 버튼 클릭 시 달력 이동
		
        
        
	
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
	    		} else {
	    			html +="<tr></tr>"
	    			$('#calendarBody .' + item.sch_date).append(html);
	    		}
	    		// end if ~ else
	    		
	    	}) // end forEach   	
	    });} // end getList
	    

     	// 기본으로 '월별' 캘린더가 클릭된 상태로 만듦
		$("#month").trigger("click");
		
	
	}) // end document ready

</script>

</body>
</html>