
// 즉시 실행 함수(프로퍼티를 갖는 객체로 리턴)
// 일정 CRUD, 일정 검색
var scheduleService = (function(){

    var csrf_token = $("meta[name='_csrf']").attr("content");
	var csrf_header = $("meta[name='_csrf_header']").attr("content");
  
    // 리스트 불러오기
    function getList(param, callback, error) {

        $.ajax({
            type: 'get',
            url: '/schedule/' + param.sch_group + "/" + param.selectedDate,
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function getList()


    // 일정 검색
    function search(param, callback, error) {
        $.ajax({
            type: 'get',
            url: '/schedule/search/' + param,
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function search()

    // 일정 상세 보기
    function getSchedule(param, callback, error) {
        $.ajax({
            type: 'get',
            url: '/schedule/' + param,
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function getSchedule()

    // 일정 등록
    function insertSchedule(param, callback, error) {

        $.ajax({
            type: 'post',
            url: '/schedule/new',
            data: JSON.stringify(param),
            beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
            },
            contentType : "application/json; charset=utf-8",
            success : function(result, status, xhr) {
                if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function insertschedule()

    // 일정 수정
    function updateSchedule(param, callback, error) {
        $.ajax({
            type: 'put',
            url: '/schedule/' + param.sch_id,
            data: JSON.stringify(param),
            beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
            },
            contentType : "application/json; charset=utf-8",
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function updateSchedule()

    // 일정 삭제
    function deleteSchedule(param, callback, error) {
        $.ajax({
            type: 'delete',
            url: '/schedule/' + param,
            beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
            },
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function deleteSchedule()

    // 메모 가져오기
    function getMemo(callback, error) {
        $.ajax({
            type: 'get',
            url: '/schedule/memo',
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function getMemo()

    // 메모 업데이트
    function updateMemo(param, callback, error) {
        $.ajax({
            type: 'put',
            url: '/schedule/memo',
            data: JSON.stringify(param),
            beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
            },
            contentType : "application/json; charset=utf-8",
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function updateMemo()

    // 근무 직원 리스트
    function getWorkerList(param, callback, error) {
        $.ajax({
            type: 'get',
            url: '/schedule/worker/' + param,
            success: function(result) {
                if (callback) {
					callback(result);
				}
            },
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
        })
    } // end function getMemo()

    return {
        getList: getList,
        search: search,
        getSchedule: getSchedule,
        insertSchedule: insertSchedule,
        updateSchedule: updateSchedule,
        deleteSchedule: deleteSchedule,
        getMemo: getMemo,
        updateMemo: updateMemo,
        getWorkerList: getWorkerList
    };

})();



// 캘린더 조작 함수

//list 페이지 로딩 시 실행
$(document).ready(function(){

    // 선택된 탭에 대한 정보를 저장
    var selectedTap;
		
	
    // 선택 일자, 선택 그룹을 저장하는 객체
    var listparam = {};
    listparam.selectedDate;
    listparam.sch_group;
    
    
    /* * * * * * * * * * * * * * * * * * *
            DB 출력 전 데이터 처리
    * * * * * * * * * * * * * * * * * * */
    // 페이지 로딩 시 선택된 그룹 값을 프로퍼티에 할당
    listparam.sch_group = $('.sch_group').val();
    
    // 월별, 주별, 일별 탭 선택 시 타입 변경
    $('.nav li').on("click", function() {
        $('.nav *').removeClass('active');
        $(this).children('a').addClass('active');
    });

    // 선택 날짜를 원하는 형태로 변경하여 사용하기 위한 변수('yyyy-MM-dd')
    var selectedDate;
    var year;
    var month;
    var day;
    
    // 선택 날짜를 Date 형식으로 저장하기 위한 변수
    var realDate;
    
    // 캘린더를 만들 때 필요한 요소 생성
    var makeDate = function() {
        
        if (selectedDate == undefined) {
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
            day = str[2];
        }
        

        realDate = new Date(year, month, day);
        
        listparam.selectedDate = selectedDate;
        
        
    } // end makeDate()


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
        // 근무자 확인 아이콘 생성을 위한 html 태그
        var workers = '<a id="workers" tabindex="0" class="btn"'
                    + 'data-bs-toggle="popover"' + 'data-bs-title="workerList"'
                    + 'data-bs-trigger="focus"' + 'data-bs-content="근무자 명단"'
                    + '>' + '<i class="fa fa-users btn" aria-hidden="true"></i></a>';
        
              

        // 1월, 12월에서 이동 시 년 단위 변경을 위한 변수
        var isChange;
        var changeY;

        // 시작주 칸 생성(지난달 날짜분)
        for (var i = prevDate - prevDay; i <= prevDate; i++) {
            dayCount++;
            makeCalendar += '<td class="prevDay ';

            let prevM = month - 1;
            isChange = false;
            if (prevM == 0) {
                prevM = 12;
                isChange = true;
            } else if (prevM>0 && prevM<10) {
                prevM = '0' + prevM;
            }

            if (isChange == true) {
                changeY = year - 1;
            } else {
                changeY = year;
            }
            
            makeCalendar += changeY + '-' + prevM + '-' + i + '">' + i +
                            workers + '</td>';
            
        }
        

        // 이번달 날짜만큼 칸 생성
        for (var i = 1; i <= nextDate; i++) {
            if(dayCount == 7) {
                makeCalendar += '</tr><tr class="week'+ weekCount +'">'
                dayCount = 0;
            }
            dayCount++;
            makeCalendar += '<td class="'+ year + '-' + month + '-';
            if (i<10) {
                makeCalendar += '0'
            }
            makeCalendar += i +'">' + i + workers + '</td>';
        }

         // 마지막주 칸 생성(다음달 날짜분)
        for (var i = 1; i < (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
            makeCalendar += '<td class="nextDay ';
            
            let nextM = eval(month) + 1;
            isChange = false;
            if (nextM == 13) {
                nextM = '01';
                isChange = true;
            } else if (nextM>0 && nextM<10) {
                nextM = '0' + nextM;
            }

            if (isChange == true) {
                changeY = year + 1;
            } else {
                changeY = year;
            }
            
            makeCalendar += year + '-' + nextM + '-0' + i +'">' + i 
                        + workers + '</td>';
        }

        // 캘린더 날짜칸 생성
          $('#calendarBody').html(makeCalendar);


    }

    
    // '월별' 클릭 시 캘린더 출력
    $('#month').on("click", function(e) {
        
        // 선택 탭에 대한 정보 저장
        selectedTap = $(this);

        // 기본 이벤트 차단
        e.preventDefault();

        // 선택일에 맞는 캘린더 생성
        makeDate();
        makeDOW();
        makeDOM();
        
          // 기준 날짜를 상단에 기입
        $('.refDate a').text(year + '-' + month);
        $('.refDate p').text(selectedDate);
          
        // DB에서 선택 일정에 맞는 데이터 가져오기
        getList();

        // 이전, 다음 버튼 월 단위로 변경
        $('a[aria-label]').removeClass("prevWeek nextWeek prevDay nextDay");
        $('a[aria-label=Previous]').addClass("prevMonth");
        $('a[aria-label=Next]').addClass("nextMonth");
        
         
    });// end month onclick(월별 캘린더 생성 후 데이터 가져오기)
    
    
    // '주별' 클릭 시 캘린더 생성
    $('#week').on("click", function(e) {

        // 선택 탭에 대한 정보 저장
        selectedTap = $(this);

        // 기본 이벤트 차단
        e.preventDefault();

        // 선택일에 맞는 캘린더 생성
        makeDate();
        makeDOW();
        makeDOM();

        // 선택 주 빼고 숨김 처리
        var selectedWeek = $('td[class=' + selectedDate + ']').parent();
        $('#calendarBody tr').not(selectedWeek).hide();
        
        // 선택 주차를 변수에 저장
        var weekNum = selectedWeek.attr("class").replace('week', '');

          // 기준 날짜를 상단에 기입
        $('.refDate a').text(year + '-' + month + ' ' + weekNum + '주차');
        $('.refDate p').text(selectedDate);
        
        // DB에서 선택 일정에 맞는 데이터 가져오기
        getList();
        
        // 이전, 다음 버튼 주 단위로 변경
        $('a[aria-label]').removeClass("prevMonth nextMonth prevDay nextDay");
        $('a[aria-label=Previous]').addClass("prevWeek");
        $('a[aria-label=Next]').addClass("nextWeek");
        
    }); // end week onclick(주별 캘린더 생성 후 데이터 출력)
    
    
     // '일별' 클릭 시 캘린더 생성
    $('#day').on("click", function(e) {

        // 선택 탭에 대한 정보 저장
        selectedTap = $(this);
       
        // 기본 이벤트 차단
        e.preventDefault();
        
        // 선택일에 맞는 캘린더 생성
        makeDate();
        makeCalendar = "";
        
        
          // 기준 날짜를 상단에 기입
        $('.refDate a').text(selectedDate);
        $('.refDate p').text(selectedDate);

        // 요일 정보 가져오기
        let dayNum = realDate.getDay();
        
        switch(dayNum) {
        case 0: dayNum = '일요일'; break;
        case 1: dayNum = '월요일'; break;
        case 2: dayNum = '화요일'; break;
        case 3: dayNum = '수요일'; break;
        case 4: dayNum = '목요일'; break;
        case 5: dayNum = '금요일'; break;
        case 6: dayNum = '토요일'; break;
        }
        
        // 선택 요일 출력
        $('.dayOfWeek').html('<td colspan="7">' + dayNum + '</td>')
        
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
                
                tHTML += '<tr><td class="timeline"><b>' + t 
                        + '</b></td><td class="' + t + '"></td><tr>';
            }
            
            return tHTML;
            
        })();
        
        // 선택 날짜를 출력할 칸 만들기
        $('#calendarBody').html('<tr class="'+selectedDate+'"></tr>' + timeline);
        
        // DB에서 선택 일정에 맞는 데이터 가져오기
        getList();
        
        // 이전, 다음 버튼 주 단위로 변경
        $('a[aria-label]').removeClass("prevMonth nextMonth prevWeek nextWeek");
        $('a[aria-label=Previous]').addClass("prevDay");
        $('a[aria-label=Next]').addClass("nextDay");
        
    }); // end day onclick(일별 캘린더 생성 후 데이터 출력)
   

     /* * * * * * * * * * * * * * * * * * *
        이전, 이후 버튼 클릭 시 달력 이동
    * * * * * * * * * * * * * * * * * * */
    
    // 전월 보기
    function prevMonth() {
        month = eval(month+'-1');
        
        if(month<=9 && month>0) {
            month = '0' + month;
        } else if(month <= 0) {
            year--;
            month = '12';
        }
    }
    
    // 익월 보기
    function nextMonth() {
        month = eval(month+'+1');

        if(month<=9) {
            month = '0' + month;
        } else if(month == 13) {
            year++;
            month = '01';
        }
    }
    
    
    
    $('.page-link').on("click", function(e){
        e.preventDefault();

        if($(this).hasClass("prevMonth")) {
            // 전월 보기
            
            prevMonth();

            selectedDate = year + '-' + month + '-' + day;
            $("#month").trigger("click");

        } else if($(this).hasClass("nextMonth")) {
            // 익월 보기
            
            nextMonth();
            
            selectedDate = year + '-' + month + '-' + day;
            $("#month").trigger("click");
            
        } else if($(this).hasClass("prevWeek")) {
            // 전주 보기
            
            day = eval(day+'-7');
            if (day <= 0) {
                let last = new Date(year, month-1, 0);
                day = last.getDate() - 7;
                prevMonth();
            } else if (day>0 && day<10) {
                day = '0' + day;
            }

            selectedDate = year + '-' + month + '-' + day;
            $("#week").trigger("click");
            
        } else if($(this).hasClass("nextWeek")) {
            // 다음주 보기
            
            day = eval(day+'+7');
            
            let last = new Date(year, month, 0);
            last = last.getDate();
            if (day < 10) {
                day = '0' + day;
            } else if(day > last) {
                day = '0' + (day - last);
                nextMonth();
            }

            selectedDate = year + '-' + month + '-' + day;
        
            $("#week").trigger("click");
            
        } else if($(this).hasClass("prevDay")) {
            // 전일 보기

            day = eval(day+'-1');
            if (day == 0) {
                day = new Date(year, month-1, 0).getDate();
                prevMonth();
            } else if(day>0 && day<10) {
                day = '0' + day;
            }

            selectedDate = year + '-' + month + '-' + day;
            $("#day").trigger("click");
            
        } else if($(this).hasClass("nextDay")) {
            // 익일 보기
            
            day = eval(day+'+1');
            let last = new Date(year, month, 0).getDate();
            if (day < 10) {
                day = '0' + day;
            } else if(day > last) {
                day = '01';
                nextMonth();
            }

            selectedDate = year + '-' + month + '-' + day;
            $("#day").trigger("click");
        }
        
    }); // 이전, 이후 버튼 클릭 시 달력 이동


    // 그룹 선택 시 값 변경
    $('.group').on("click", function(e){
        e.preventDefault();

        // 그룹 선택 결과 반영
        $('.sch_group').val($(this).attr("href"));
        listparam.sch_group = $('.sch_group').val();
        $('.sch_group').text($(this).text());

        // 선택된 탭 

    }); // 그룹 선택 시 값 변경



    /* * * * * * * * * * * * * * * * * * *
        버튼 클릭 시 직원 스케쥴 출력 이벤트
    * * * * * * * * * * * * * * * * * * */
    $('#calendarBody').on("click", "a", function(e) {
        e.preventDefault();

        let content = '';

        scheduleService.getWorkerList('dept', function(result){
           
            result.forEach((item) => {

                let arr1 = item.start_time.split(' ');
                let arr2 = arr1[1].split(':');

                
                content += item.name + ' (' + arr2[0] + ':' + arr2[1] + ') ';
                

                
            }); // end forEach 

            $('#workers').attr("data-bs-content", content);
            $('#workers').popover("show");
            
        }); // end getWorkerList()      

    }); // 버튼 클릭 시 직원 스케쥴 출력


    // 검색 결과 클릭 시 해당 일자로 이동
    $('.searchResult').on("click", "li", function(){
	    
        // 일정 시작일을 선택일 변수에 저장
	    selectedDate = ($(this).attr("class").split(' '))[0];
        // 해당 일자로 이동
        selectedTap.trigger("click");
	    	
    });


    /** getList를 통해 DB에서 데이터 받아오기 */
    function getList() {scheduleService.getList(listparam, function(list) {
           
        var html;
        
        list.forEach((item) => {
            html = "";

            if(item.sch_title != null) {
                html += '<tr>';
                html += '<td id="' + item.sch_id + '" class="eachSch">' + item.sch_title + '</td>';
                html += '</tr>';
                $('#calendarBody .' + item.sch_date).append(html);
            }
            // end if

        }) // end forEach
    });} // end getList
    

     // 기본으로 '월별' 캘린더가 클릭된 상태로 만듦
    $("#month").trigger("click");

}) // 캘린더 생성


	// 일정 CRUD 모달 관련
	$(document).ready(function() {
				
	    /* * * * * * * * * * * * * * * * * * *
	                일정 CRUD
	    * * * * * * * * * * * * * * * * * * */
	    
	    var sch_group = $('.modal').find(".selectedGroup");
	    var start_date= $('.modal').find("input[name='start_date']");
	    var end_date= $('.modal').find("input[name='end_date']");
	    var sch_title= $('.modal').find("input[name='sch_title']");
	    var sch_content = $('.modal').find("input[name='sch_content']");
	    var participant = $('.modal').find("input[name='participant']");
	    var book_id = $('.modal').find("input[name='book_id']");
	    
	    // 시작일, 종료일을 캘린더를 통해 선택 가능하도록 함
	    $(function(){
	    	// 날짜를 yyyy-MM-dd 형태로 출력하도록 지정
	    	$('#start_date').datepicker({
	    		dateFormat: 'yy-mm-dd',
	    		onSelect: function (date) {
	    			// start_date 이전 날짜 선택 불가하게 지정
	    			var endDate = $('#end_date');
	    			var startDate = $(this).datepicker('getDate');
	    			var minDate = $(this).datepicker('getDate');
	    			endDate.datepicker('setDate', minDate);
	    			startDate.setDate(startDate.getDate() + 30);
	    			endDate.datepicker('option', 'maxDate', startDate);
	    			endDate.datepicker('option', 'minDate', minDate)
	    		}
	    	});
	    	
	    	$('#end_date').datepicker({ dateFormat: 'yy-mm-dd' });
	    })
	    

	    // 일정 등록 버튼 클릭 시 이벤트
	    $('.newSchedule').on("click", function() {
	        
	        // 불필요한 버튼 숨김
	        $('.modal-footer *').show();
	        $('.modal-footer *').not('#modalCloseBtn').not('#schInsertBtn').hide();
	        
	        // 모달창 내용 비우고 현재 시간 기입하여 보여주기
	        $('.modal').find("input").val("");
	        $('.participant').show();
	        $('input[name*="date"]').val($('.refDate p').text());
	        $('.modal').modal("show");

	    }); // end newSchedule onclick
	    // 일정 등록 요청 생성
	    $('#schInsertBtn').on("click", function() {
	        
	        let schedule = {
	            sch_group: sch_group.val(),
	            start_date: (start_date.val().split(' '))[0],
	            end_date: (end_date.val().split(' '))[0],
	            sch_title: sch_title.val(),
	            participant: participant.val().split(", "),
	            sch_content: sch_content.val(),
	            dept_id: '<sec:authentication property="principal.employee.dept_id"/>',
	            emp_id: '<sec:authentication property="principal.username"/>',
	            book_id: book_id.val()
	        }
	        
	        scheduleService.insertSchedule(schedule, function(result){
	            
                
                // 등록 완료 시 모달 숨김
                $('.modal').modal("hide");
                
             	// 등록 성공 안내
                if (result == 'success') {
                    alert('정상적으로 등록되었습니다.');
                }
             	
             	// 등록 스케쥴의 시작일로 선택일자 변경
             	selectedDate = schedule.start_date;
                
                // 등록한 일정 표시를 위해 캘린더영역 새로 불러오기
                $("#month").trigger("click");
                
             	
	            
	        }) // end insertSchedule
	        
	    }); // end schInsertBtn onclick
	    
	    
	    // 개별 일정 클릭 시 이벤트
	    // eachSch onclick
	    $('#calendarBody').on("click", '.eachSch', function(e) {
	        
	        // 해당 일정 PK값 변수에 저장
	        let sch_id = $(this).attr("id");
	        
	        // 불필요한 버튼 숨긴 후 모달 표시
	        $('.modal-footer *').show();
	        $('#schInsertBtn').hide();
	        $('.participant').hide();
	        $('.modal').modal("show");
	        
	        // 선택한 일정 상세보기
	        scheduleService.getSchedule(sch_id, function(result){
	            
	            sch_group.val(result.sch_group);
	            start_date.val((result.start_date.split(" "))[0]);
	            end_date.val((result.end_date.split(" "))[0]);
	            sch_title.val(result.sch_title);
	            participant.val(result.participant);
	            sch_content.val(result.sch_content);
	            book_id.val(result.book_id);				
	            
	        }) // end getSchedule
	        
	        
	        // 일정 수정하기
	        $('#schUpdateBtn').on("click", function(e) {
	            
	            let schedule = {
	                    sch_id: eval(sch_id),
	                    sch_group: sch_group.val(),
	                    start_date: start_date.val(),
	                    end_date: end_date.val(),
	                    sch_title: sch_title.val(),
	                    sch_content: sch_content.val(),
	                    book_id: book_id.val()
	            }
	            
	            scheduleService.updateSchedule(schedule, function(result) {
	                
	                // 수정 완료 시 모달 숨김
	                $('.modal').modal("hide");
	                
	             	// 수정 성공 안내
	                if (result == 'success') {
	                    alert('정상적으로 수정되었습니다.');
	                }
	                
	                // 수정 반영을 위해 캘린더영역 새로 불러오기
	                $("#month").trigger("click");
	                
	            });// end updateSchedule
	            
	        }); // end schUpdate onclick
	        
	        
	        $('#schDeleteBtn').on("click", function(){
	            
	           scheduleService.deleteSchedule(sch_id, function(result) {
	                
	                // 작업 완료 시 모달 숨김
	                $('.modal').modal("hide");
	                
	             	// 삭제 성공 안내
	                if (result == 'success') {
	                    alert('정상적으로 삭제되었습니다.');
	                }
	                
	                // 삭제 반영을 위해 캘린더영역 새로 불러오기
	                $("#month").trigger("click");
	                
	             	
	            });// end deleteSchedule
	            
	        });
	        
	    }); // end each onclick
	    
	 	// 일정 모달에서 그룹 선택 시 값 변경
	    $('.addGroup').on("click", function(e){
	        e.preventDefault();

	        // 그룹 선택 결과 반영
	        $('.selectedGroup').val($(this).attr("href"));
	        $('.selectedGroup').text($(this).text());

	    });
	    
	    
	    // 모달창 닫기 이벤트
	    $("#modalCloseBtn").on("click", function(e){
	        $('.modal').modal("hide");
	    });
	    $(".close").on("click", function(e){
	        $('.modal').modal("hide");
	    });
	    
	    
	    
	    // 일정 검색 기능
	    $('.search input').on("keyup", function(e){
	    	//기본 이벤트 취소처리
	    	e.preventDefault();
	    	
	    	// 입력값 저장
	    	var text = $(this).val();
	    	
	    	// 입력값이 없을 경우 function 종료
	    	if(text == '' || text == null) {
	    		$('.searchResult').html('');
	    		return;
    		}
	    	
	    	// 검색 결과값을 저장할 변수 선언
	    	let resultList = '';
	    	
	    	// 입력값을 검색어로 검색 실행
	    	scheduleService.search(text, function(result){
	    	
	    		if (result.length >= 1) {
	    			result.forEach((item) => {
	    				
	    				// 일정 시작일 저장
	    				let date = new Date(item.start_date);
		    			
	    				// 일정 PK, 일정 제목, 일정 시작일 출력
		    			resultList += '<li class="' + item.start_date + '">';
		    			resultList += item.sch_title + ' ' + date.getFullYear() + '년 '+ date.getMonth() + '월 ' 
		    							+ date.getDate() + '일';
		    			resultList += '</li>';
		    			
		    		}); // end forEach()
		    	
	    		} // end if
	    		
	    	// 결과 목록을 출력
	    	$('.searchResult').html(resultList);
	    	
	    	}) // end search()
	    }); // end input keyup event
	    
	    
	    // 유효성 검사
	    
	    
	    
	});// 일정 CRUD 모달
	

		// 메모 작성 및 저장
		$(document).ready(function(){
			
			// 페이지 로드 시 DB에서 메모 불러오기
			scheduleService.getMemo(function(result){
				$('#memoArea').val(result);
			});
			
			// 메모장에 메모 입력 시 저장 버튼 없이도 데이터 저장(업데이트)
			$('#memoArea').on("keyup", function(){
				var memo = $(this).val();
				
				scheduleService.updateMemo(memo, function (result){
					
				});
				
			});
			
			
		}); // 메모 작성 및 저장
		