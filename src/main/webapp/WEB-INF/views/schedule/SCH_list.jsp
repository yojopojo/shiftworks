<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<script type="text/javascript" src="/resources/js/schedule.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/css/schedule.css">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
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

	<div class="search" role="search">
		<input class="form-control me-2" type="search" placeholder="일정 검색"
			aria-label="Search">
		<ul class="searchResult">

		</ul>
	</div>

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
											type="button" data-bs-toggle="dropdown" aria-expanded="false"
											value="all">그룹 선택</button>
										<ul class="dropdown-menu">
											<li><a class="dropdown-item group" href="my">내 일정</a></li>
											<li><a class="dropdown-item group" href="dept">부서 일정</a></li>
											<li><a class="dropdown-item group" href="comp">회사 일정</a></li>
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
				<td id="memoTable">
						<label for="memoArea" class="form-label">메모</label>
						<textarea class="form-control" id="memoArea"
							rows="25"></textarea>
				<td>
			</tr>

		</table>

	</div>



	<!-- 일정 Modal -->
	<div class="modal fade" id="scheduleModal" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<label>일정 그룹 &nbsp;</label>
					<button
						class="btn btn-outline-secondary dropdown-toggle selectedGroup"
						type="button" data-bs-toggle="dropdown" aria-expanded="false"
						value="my">내 일정</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item addGroup" href="my">내 일정</a></li>
						<li><a class="dropdown-item addGroup" href="dept">부서 일정</a></li>
						<li><a class="dropdown-item addGroup" href="comp">회사 일정</a></li>
					</ul>
					<div class="form-group">
						<label>시작일</label> <input type="text" class="form-control"
							name="start_date" id="start_date">
					</div>
					<div class="form-group">
						<label>종료일</label> <input type="text" class="form-control"
							name="end_date" id="end_date">
					</div>
					<div class="form-group">
						<label>제목</label> <input class="form-control" name="sch_title">
					</div>
					<div class="form-group participant">
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



</body>
</html>