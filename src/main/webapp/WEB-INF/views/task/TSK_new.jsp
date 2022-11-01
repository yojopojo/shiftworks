<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/task.js"></script>
<link rel="stylesheet" href="/resources/css/task.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>업무 등록</title>
</head>
<body>

<!-- 업무 등록을 위한 입력 폼 -->
	<div class="newContainer">
		<div class="mb-3">
			<label for="dept_name" class="form-label">부서</label>
			<input type="text" class="form-control"
			id="dept_name" placeholder="부서명">
			<input type="hidden" class="form-control"
			id="dept_id" value="">
		</div>
		<div class="mb-3">
			<label for="task_title" class="form-label">제목</label>
			<input type="text" class="form-control"
			id="task_title" placeholder="글 제목">
		</div>
		<div class="mb-3">
		<!-- 세션 추가 후 수정 -->
			<label for="name" class="form-label">작성자</label>
			<input class="form-control" type="text" value="홍길동"
				id="name" readonly>
			<input class="form-control" type="hidden" value="U2946709"
				id="emp_id">
		</div>
		<div class="mb-3 form-check">
			<div>
				<input class="form-check-input" type="radio" name="notification"
					id="notification1" checked> <label
					class="form-check-label" for="notification1"> E-mail 알림 허용 </label>
			</div>
			<div>
				<input class="form-check-input" type="radio" name="notification"
					id="notification2"> <label class="form-check-label"
					for="notification2"> E-mail 알림 거부 </label>
			</div>
		</div>
		<div class="mb-3 form-check">
			<div>
				<input class="form-check-input" type="radio" name="t_private"
					id="t_private1" checked> <label
					class="form-check-label" for="t_private1"> 전체공개 </label>
			</div>
			<div>
				<input class="form-check-input" type="radio" name="t_private"
					id="t_private2"> <label class="form-check-label"
					for="t_private2"> 부서원에게만 공개 </label>
			</div>
		</div>
		<div class="mb-3">
			<label for="task_content" class="form-label">내용</label>
			<textarea class="form-control" id="task_content" rows="10"></textarea>
		</div>
		<div class="mb-3">
			<label for="formFileSm" class="form-label file">첨부파일</label>
			<input class="form-control form-control-sm" id="formFileSm" type="file">
		</div>
		<div class="confirm">
			<button id="submitBtn" type="submit" class="btn btn-primary mb-3">작성</button>
			<button id="resetBtn" type="reset"
				class="btn btn-outline-primary mb-3">취소</button>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			
			// 폼 제출(작성) 버튼 클릭 시 이벤트
			$('#submitBtn').on("click", function(e) {
				e.preventDefault();
				
				// 항목 체크에 따른 값 저장
				let isPrivate;
				let isNotification;
				if($('#t_private1').is(":checked")) {
					isPrivate = 'Y';
				} else {
					isPrivate = 'N';
				}
				if($('#notification1').is(":checked")) {
					isNotification = 'Y';
				} else {
					isNotification = 'N';
				}
				
				// 폼 입력값 객체에 대입
				var newTask = {
					dept_id: $('#dept_id').val(),
					task_title: $('#task_title').val(),
					task_content: $('#task_content').val(),
					// 세션 추가 후 아이디 부분 변경 필요
					emp_id: 'U3948709',
					t_private: isPrivate,
					notification: isNotification
				}

				// 객체 전달하여 DB에 저장 후 페이지 이동
				taskService.insertTask(newTask, function(result){
					// href 대신 replace 이용하여 히스토리 남지 않게 처리
					location.replace()="/task/pages/" + newTask.dept_id + "/empty/empty/1";
				});

			}); // end submit click event
			
			
			// 취소 버튼 클릭 시 이전 페이지(업무 목록)로 이동
			$('#resetBtn').on("click", function(){
				
				history.back();
				
			}); // end reset click event

		}); // end document ready function
	</script>

</body>
</html>