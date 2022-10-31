<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>
<%@include file="index.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">새로운 글 등록</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading"></div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<button id ="previewBtn" type="button" class="btn btn-primary">미리보기</button>
				<button id="temporalBtn" type="button" class="btn btn-primary">임시저장</button>

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
						<label>게시일</label> <input class="form-control" name='post_regdate' value="" readonly="readonly"/>
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
	var formInputRegdate = form.find("input[name='post_regdate']");
	
	var today = new Date();
	formInputRegdate.attr("value",today);
	
	
	
	
	
	//글 등록 버튼 클릭 시 post db에 저장하기 
	  $("#registerBtn").on("click",function(e){
	      
	      var post = {
	            b_id: 1,
	            post_name:formInputTitle.val(),
	            emp_id:formInputEmp.val(), //추후 로그인 세션으로 변경예정 
	            dept_id:formInputDept.val(),
	            post_content:formInputContent.val(),
	            post_receivedept:formInputReceive.val()
	          };
	      
	 
	       postService.add(post, function(result){
	        
	        alert(result);
	        
	        form.find("input").val(""); 
	        form.find("textarea").val(""); 
	      }); 
	      
	    });//end register
	    
	
	    
	    
	  //임시저장 버튼 클릭 시 임시저장 db저장하기 
	   var temporalBtn = $("#temporalBtn");
	 
	    temporalBtn.on("click",function(){
	    	
	    	 var post = {
	 	            b_id: 1,
	 	            post_name:formInputTitle.val(),
	 	            emp_id:formInputEmp.val(), //추후 로그인 세션으로 변경예정 
	 	            dept_id:formInputDept.val(),
	 	            post_content:formInputContent.val()
	 	          };
	    	 
	    	 postService.temporalPost(post, function(result){
	    		 alert("임시저장되었습니다");
	    		 form.find("input").val(""); 
	    		 form.find("textarea").val(""); 
	    	 })
	    })
		
	    	
	  
});
</script>
<%@include file="../includes/footer.jsp"%>