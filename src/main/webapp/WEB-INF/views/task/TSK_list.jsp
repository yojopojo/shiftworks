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
<title>업무 관리</title>
</head>
<body>



	<table class="table">
		<thead>
			<tr>
				<td colspan="4">
					<div class="dropdown">
						<button class="btn btn-outline-secondary dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">
							전체</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">부서1</a></li>
							<li><a class="dropdown-item" href="#">부서2</a></li>
							<li><a class="dropdown-item" href="#">부서3</a></li>
						</ul>
						<button type="button" class="btn btn-outline-secondary new">작성</button>
					</div>
					<form class="d-flex" role="search">
						<input id="searchForm" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button id="searchButton" class="btn btn-outline-primary"
							type="submit">검색</button>
					</form>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="no">글 번호</td>
				<td class="title">제목</td>
				<td class="writer">작성자</td>
				<td class="hasFile">파일</td>
			</tr>
			<c:forEach items="${dto.list}" var="task">
				<tr class="goDetail" id="${task.task_id}">
					<td><c:out value="${task.task_id}"/></td>
					<td><c:out value="${task.task_title}"/></td>
					<td><c:out value="${task.name}"/></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item disabled"><a class="page-link">이전</a></li>
							<li class="page-item"><a class="page-link" href="/">1</a></li>
							<li class="page-item"><a class="page-link" href="/">2</a></li>
							<li class="page-item"><a class="page-link" href="/">3</a></li>
							<li class="page-item"><a class="page-link" href="/">다음</a></li>
						</ul>
					</nav>
				</td>
			</tr>
		</tfoot>
	</table>

<script type="text/javascript">

	$(document).ready(function () {
		
		// 작성 버튼 클릭 시 새 글(업무) 작성 화면으로 이동
		$('.new').on("click", function(){
			location.href="/task/new";
		})
		
		// 업무 게시글 로우 클릭 시 해당 게시글 상세 페이지로 이동
		$('tbody').on("click", ".goDetail", function(){
			// 부서별 조회 기능, 검색 기능, 페이지 넘버링 추가 시 변경 필요
			location.href="/task/pages/all/empty/empty/1/" + $(this).attr("id");
		})
		
	}); //end document ready

</script>>

</body>
</html>