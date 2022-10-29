<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="../includes/header.jsp"%>
<%@include file="index.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">상세페이지</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

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
						value='<c:out value="${post.name }"/>' readonly="readonly">
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
				<button id='modifyBtn' class='btn btn-primary btn-xs pull-right'>글수정하기</button>


				<form id='operForm' action="/board/modify" method="get">
					<input type='hidden' id='post_id' name='post_id' 
						value='<c:out value="${post.post_id}"/>'>
					<input type='hidden' name='pageNum' 
						value='<c:out value="${cri.pageNum}"/>'> 
					<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='keyword'
						value='<c:out value="${cri.keyword}"/>'>
					<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
				</form>



			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->



<!--댓글 달 때 보여주는 창 -->
<div class='row'>
	<div class="col-lg-12">

		<!-- /.panel -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw">댓글</i> 
				<div class="form-group">
					<label></label> 
					<input class="form-control" name='r_content'
						value='<c:out value=""/>'>
				</div>
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>댓글등록</button>
			</div>


			<!-- /.panel-heading -->
			<div class="panel-body">
				<ul class="chat">

				</ul>
				<!-- ./ end ul -->
			</div>
			<!-- /.panel .chat-panel -->
			<div class="panel-footer"></div>
		</div>
	</div>
	<!-- ./ end row -->
</div>


			
	
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
$(document).ready(function () {
	
	//글 수정 버튼 클릭 시 수정폼으로 가기 
	$("#modifyBtn").on("click",function(){
		
				$("#operForm").submit();
	});
	
	
	//댓글등록 버튼 누를 시 reply/new 호출하기
	var addReplyBtn =  $("#addReplyBtn");
	
	addReplyBtn.on("click", function(){
		var formInsertContent = $(".panel").find("input[name='r_content']");
		
		var post ={
				r_content : formInsertContent.val()
		}
		
		
		replyService.addReply(post, function(result){
			
			alert(result);
			formInsertContent.val("");
		})
		
	});
	
	
	
});
	
</script>





<%@include file="../includes/footer.jsp"%>