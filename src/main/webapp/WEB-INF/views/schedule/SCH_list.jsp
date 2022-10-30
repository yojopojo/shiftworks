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
								<td class="noPadding" colspan="7">
									<div>
										<ul class="nav nav-tabs">
											<li class="nav-item"><a id="month"
												class="nav-link active" aria-current="page" href="/month">월별</a></li>
											<li class="nav-item" aria-current="page"><a id="week"
												class="nav-link" href="/week">주별</a></li>
											<li class="nav-item" aria-current="page"><a id="day"
												class="nav-link" href="/day">일별</a></li>
										</ul>
									</div>
									<div class="dropdown">
										<button
											class="btn btn-outline-secondary dropdown-toggle sch_group"
											type="button" data-bs-toggle="dropdown" aria-expanded="false">
											그룹 선택</button>
										<ul class="dropdown-menu">
											<li><a class="dropdown-item" href="/my">내 일정</a></li>
											<li><a class="dropdown-item" href="/dept">부서 일정</a></li>
											<li><a class="dropdown-item" href="/comp">회사 일정</a></li>
										</ul>
									</div>
									<div class="newSchedule">
										<button type="button" class="btn btn-outline-secondary">일정
											등록</button>
									</div>
									<nav aria-label="Page navigation">
										<ul class="pagination">
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>
											<li class="page-item refDate"><a class="page-link"
												href="#"></a>
											<p></p></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</ul>
									</nav>
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



	<!-- 일정 등록 Modal -->
	<div class="modal fade" id="scheduleModal" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>그룹</label> <input class="form-control" name="sch_group"
						placeholder="그룹 입력 시 검색">
					</div>
					<div class="form-group">
						<label>시작일</label> <input class="form-control" name="start_date"
							placeholder="yyyy-MM-dd">
					</div>
					<div class="form-group">
						<label>종료일</label> <input class="form-control" name="end_date"
							placeholder="yyyy-MM-dd">
					</div>
					<div class="form-group">
						<label>제목</label> <input class="form-control" name="sch_title">
					</div>
					<div class="form-group">
						<label>참가자목록</label> <input class="form-control"
							name="participant" placeholder="이름 입력 시 검색">
					</div>
					<div class="form-group">
						<label>내용</label> <input class="form-control" name="sch_content">
					</div>
					<div class="form-group">
						<label>예약 회의실</label> <input class="form-control" name="book_id"
						placeholder="회의실 예약 코드 입력 시 검색">
					</div>
				</div>
				<div class="modal-footer">
					<button id='schInsertBtn' type="button" class="btn btn-primary">등록</button>
					<button id='schUpdateBtn' type="button" class="btn btn-primary">수정</button>
					<button id='schDeleteBtn' type="button" class="btn btn-danger">삭제</button>
					<button id='modalCloseBtn' type="button"
						class="btn btn-outline-secondary">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<script type="text/javascript">
	
	// 일정 CRUD 모달 관련
	$(document).ready(function() {
				
	    /* * * * * * * * * * * * * * * * * * *
	                일정 CRUD
	    * * * * * * * * * * * * * * * * * * */
	    
	    var sch_group = $('.modal').find("input[name='sch_group']");
	    var start_date= $('.modal').find("input[name='start_date']");
	    var end_date= $('.modal').find("input[name='end_date']");
	    var sch_title= $('.modal').find("input[name='sch_title']");
	    var sch_content = $('.modal').find("input[name='sch_content']");
	    var participant = $('.modal').find("input[name='participant']");
	    var book_id = $('.modal').find("input[name='book_id']");
	    

	    // 일정 등록 버튼 클릭 시 이벤트
	    $('.newSchedule').on("click", function() {
	        
	        // 불필요한 버튼 숨김
	        $('.modal-footer *').show();
	        $('.modal-footer *').not('#modalCloseBtn').not('#schInsertBtn').hide();
	        
	        // 모달창 내용 비우고 현재 시간 기입하여 보여주기
	        $('.modal').find("input").val("");
	        $('input[name*="date"]').val($('.refDate p').text());
	        $('.modal').modal("show");

	    }); // end newSchedule onclick
	    // 일정 등록 요청 생성
	    $('#schInsertBtn').on("click", function() {
	        
	        let schedule = {
	            sch_group: sch_group.val(),
	            start_date: start_date.val(),
	            end_date: end_date.val(),
	            sch_title: sch_title.val(),
	            participant: participant.val().split(","),
	            sch_content: sch_content.val(),
	            dept_id: 'dept',
	            emp_id: 'S8945709',
	            book_id: book_id.val()
	        }
	        
	        scheduleService.insertSchedule(schedule, function(result){
	            
                
                // 수정 완료 시 모달 숨김
                $('.modal').modal("hide");
                
             	// 등록 성공 안내
                if (result == 'success') {
                    alert('정상적으로 등록되었습니다.');
                }
                
                // 수정한 일정 표시를 위해 캘린더영역 새로 불러오기
                $("#month").trigger("click");
                
             	
	            
	        }) // end insertSchedule
	        
	    }); // end schInsertBtn onclick
	    
	    
	    // 개별 일정 클릭 시 이벤트
	    // eachSch onclick
	    $('#calendarBody').on("click", '.eachSch', function(e) {
	        
	        // 해당 일정 PK값 변수에 저장
	        let sch_id = $(this).attr("id");
	        console.log(sch_id);
	        
	        // 불필요한 버튼 숨긴 후 모달 표시
	        $('.modal-footer *').show();
	        $('#schInsertBtn').hide();
	        $('.modal').modal("show");
	        
	        // 선택한 일정 상세보기
	        scheduleService.getSchedule(sch_id, function(result){
	            
	            sch_group.val(result.sch_group);
	            start_date.val(result.start_date);
	            end_date.val(result.end_date);
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
	    
	    
	    // 모달창 닫기 이벤트
	    $("#modalCloseBtn").on("click", function(e){
	        $('.modal').modal("hide");
	    });
	    $(".close").on("click", function(e){
	        $('.modal').modal("hide");
	    });
	    
	    
	});// 일정 CRUD 모달
	
	
		// 세션 적용 후 test
		/* // 메모 작성 및 저장
		$(document).ready(function(){
			
			// 페이지 로드 시 DB에서 메모 불러오기
			$('#memoTable').text(scheduleService.getMemo(function(result){
				return result();
			}));
			
			// 메모장에 메모 입력 시 저장 버튼 없이도 데이터 저장(업데이트)
			$('#memoTable').on("keyup", function(){
				var memo = $(this).text();
				
				scheduleService.insertMemo(memo, function (result){
					
				});
				
			});
			
			
		}); // 메모 작성 및 저장 */
	
	
		
	</script>

</body>
</html>