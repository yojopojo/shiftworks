<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

    
 <div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">상세페이지</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<!--게시글 상세 폼-->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		

			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<div class="form-group">
					<label>게시판번호</label> 
					<input class="form-control" name='b_id'
						value='<c:out value="${post.b_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>게시글번호</label> 
					<input class="form-control" name='post_id'
						value='<c:out value="${post.post_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>작성자</label> 
					<input class="form-control" name='name'
						value='<c:out value="${post.post_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>작성부서</label> <input class="form-control" name='dept_id'
						value='<c:out value="${post.dept_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>제목</label> <input class="form-control" name='post_name'
						value='<c:out value="${post.post_name}"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" rows="20" cols="150" name='post_content'
						readonly="readonly"><c:out value="${post.post_content}" /></textarea>
				</div>
				<div class="form-group">
					<label>작성일</label> 
					<input class="form-control" name='post_regdate'
						value='<c:out value="${post.post_regdate}"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>수정일</label> 
					<input class="form-control" name='post_updatedate'
						value='<c:out value=""/>' readonly="readonly">
				</div>
				<button id='listBtn' class='btn btn-primary btn-xs pull-right'>목록</button>
<!-- 게시글 상세 폼-->
			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->





<script>
$(document).ready(function () {
	
		$("#listBtn").on("click", function(){
			location.href = "myDoc/1";
		})
	
});

</script>