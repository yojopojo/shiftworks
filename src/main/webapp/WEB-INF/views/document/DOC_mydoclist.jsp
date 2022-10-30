<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../board/index.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">내가 쓴 게시물</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table id="boardTest" class="table table-striped table-bordered table-hover" border="1">
					<thead>
						<tr>
							<th>게시판번호</th>
							<th>게시글번호</th>
							<th>작성자</th>
							<th>작성부서</th>
							<th>제목</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					
					<c:forEach items="${list}" var="post">
						<tbody>
							<tr>
								<td><c:out value="${post.b_id}" /></td>
								<td><a class="getMyDoc" href='<c:out value="${post.post_id}"/>'>
									<c:out value="${post.post_id}" /></a>
								</td>
								<td><c:out value="${post.emp_id}" /></td>
								<td><c:out value="${post.dept_id}" /></td>
								<td><c:out value="${post.post_name}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${post.post_regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${post.post_updatedate}" /></td>
							</tr>
						</tbody>
						</c:forEach>
				</table>
				
				<form id='actionForm' action='/document/detail' method='get'>
					<input type='hidden' name='emp_id' value='${list[0].emp_id}'>
			</form> 
				
			</div>
			<!--end panel-body-->
		</div>
		<!--end panel  -->
	</div>
</div>
<!--end row-->


<script>
$(document).ready(function () {
	
	//글번호 클릭 시 세부내용 보기 
	$(".getMyDoc").on("click",function(e){
			e.preventDefault();
			
			
			 $("#actionForm") .
				append("<input type='hidden' name='post_id' value='"+ $(this).attr("href")+ "'>");
			
			
			$("#actionForm").submit();  
	})


})
	

</script>		



<%@include file="../includes/footer.jsp"%>