<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">게시판</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<button id ="previewBtn" type="button" class="btn btn-preview">미리보기</button>
				<button id="temporalBtn" type="button" class="btn btn-temporal">임시저장</button>

				<form id="form">
					<div class="form-group">
						<label>게시판명</label> <input class="form-control" name='b_id' value=1 readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>제목</label> <input class="form-control" name='post_name' />
					</div>
					
					<div class="form-group">
						<label>게시자</label> <input class="form-control" name='emp_id' value=""/>
					</div>
					
					<div class="form-group">
						<label>게시부서</label> <input class="form-control" name='dept_id' value=""/>
					</div>
					
					<div class="form-group">
						<label>게시일</label> <input class="form-control" name='regdate' value="2022/10/25" readonly="readonly"/>
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="20" cols="150" name='post_content'></textarea>
					</div>
					
					<div class="form-group">
						<label>수신부서</label> <input class="form-control" name='post_receivedept'  value=""/>
					</div>

					<button id="registerBtn" type="button" class="btn btn-primary" value="">게시하기</button>
					
				</form>

			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->


<script type="text/javascript" src="/resources/js/post.js"></script>
<script type="text/javascript">

$(document).ready(function () {
	
	var form = $("#form")
	var formInputBoard = form.find("input[name='b_id']");
	var formInputEmp = form.find("input[name='emp_id']");
	var formInputTitle = form.find("input[name='post_name']");
	var formInputDept = form.find("input[name='dept_id']");
	var formInputContent = form.find("textarea[name='post_content']");
	var formInputReceive = form.find("input[name='post_receivedept']");
	
	  $("#registerBtn").on("click",function(e){
	      
	      var post = {
	            b_id: 1,
	            post_name:formInputTitle.val(),
	            emp_id:1,
	            dept_id:formInputDept.val(),
	            post_content:formInputContent.val(),
	            post_receivedept:formInputReceive.val()
	          };
	      
	 
	       postService.add(post, function(result){
	        
	        alert(result);
	        
	        form.find("input").val(""); 
	      }); 
	      
	    });
		
	    	
	  
});
</script>
<%@include file="../includes/footer.jsp"%>