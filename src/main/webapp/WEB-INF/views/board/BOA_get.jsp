<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<link rel="stylesheet" href="/resources/css/post.css">

<meta charset="UTF-8">

<title></title>
</head>
<div class="container">
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
				
				
				<!-- 목록 이전글, 다음글 보여주기-->
				<table class="table">
					<tbody>
						<tr>
							<th scope="row" class="pre_index">이전글</th>
						</tr>
						<tr>
							<th scope="row" class="post_index">다음글</th>	
						</tr>
					</tbody>
				</table>
			
			
				<button id='scrapBtn' class='btn btn-primary btn-xs pull-right'>스크랩하기</button>
				<!--게시글 상세 폼-->
				<div class="form-group">
					<label>게시판번호</label> <input class="form-control" name='b_id'
						value='<c:out value="${post.b_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>게시글번호</label> <input class="form-control" name='post_id'
						value='<c:out value="${post.post_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>작성자</label> <input class="form-control" name='name'
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
					<textarea class="form-control" rows="20" cols="150" name='post_content' readonly="readonly">
						<c:out value="${post.post_content}" />
					</textarea>
				</div>
				<div class="form-group">
					<label>작성일</label> 
					<input class="form-control" name='post_regdate' value='<c:out value="${post.post_regdate}"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>수정일</label> 
					<input class="form-control" name='post_updatedate' value='<c:out value=""/>' readonly="readonly">
				</div>
				<div class="form-group" hidden="hidden">
					<label>emp_id</label> <input class="form-control" name='emp_id'
						value='<c:out value="${post.emp_id }"/>' readonly="readonly">
				</div>
				<button id='modifyBtn' class='btn btn-primary btn-xs pull-right'>글수정하기</button>
				<button id="listBtn" class="btn btn-info">목록보기</button>


				<form id='operForm' action="/board/modify" method="get">
					<input type='hidden' id='post_id' name='post_id'
						value='<c:out value="${post.post_id}"/>'> 
					<input type='hidden' name='pageNum'  value='<c:out value="${cri.pageNum}"/>'> 
					<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='keyword'
						value='<c:out value="${cri.keyword}"/>'> 
					<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
				</form>
				<!-- 게시글 상세 폼-->



				<!--댓글 달 때 보여주는 창 -->
				<div class='row'>
					<div class="col-lg-12">

						<!-- /.panel -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<i class="fa fa-comments fa-fw">댓글</i>
								<div class="form-group">
									<label></label> 
									<input class="form-control" name='r_content' value='<c:out value=""/>'>
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
				<!-- /댓글 -->

			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->
</div>








<script type="text/javascript" src="/resources/js/post.js"></script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
	$(document).ready( function() {
		
		
						//form value 가져오기 
						var post_id = $(".panel-body").find("input[name='post_id']").val();
						var dept_id = $(".panel-body").find("input[name='dept_id']").val();
						var emp_id = $(".panel-body").find("input[name='emp_id']").val();
						var post_name = $(".panel-body").find("input[name='post_name']").val();
						var post_content = $(".panel-body").find("textarea[name='post_content']").val();
						var post_regdate = $(".panel-body").find("input[name='post_regdate']").val();

						//추후 scrap 에 regdate넣기 console.log(typeof(post_regdate));
						
						//csrf_token 가져오기
						var csrf_token = $("meta[name='_csrf']").attr("content");
						var csrf_header = $("meta[name='_csrf_header']").attr("content");
						

						//글 수정 버튼 클릭 시 수정폼으로 가기 
						$("#modifyBtn").on("click", function() {

							$("#operForm").submit();
						});//end modifyform

						//댓글 조회 자동 실행되기
						var replyUl = $(".chat") //새로 생긴 reply를 추가할 ul 태그
						replyService.getReplyList({post : post_id}, function(list) {
											var str = "";
											
											for (var i = 0; i < list.length; i++) {
												str += "<li class='left clearfix' data-reply_id='"+list[i].reply_id+"'>";
												str += "<div>" + list[i].r_writer + "</div>";
												str += "<div>" + list[i].r_content + "</div>";
												str += "<div>" + list[i].r_regdate + "</div>"; //추후 시간 바꾸기 
											}

											replyUl.html(str);

										});

						//댓글등록 버튼 누를 시 reply/new 호출하기
						var addReplyBtn = $("#addReplyBtn");

						addReplyBtn.on("click", function() {
							var formInsertContent = $(".panel").find(
									"input[name='r_content']");

							var post = {
								post_id : post_id,
								r_writer : "조현수", //나중에 sesssion 으로 변경해야함 
								r_content : formInsertContent.val()
							}

							replyService.addReply(post, function(result) {

								alert(result);
								formInsertContent.val("");
							});

						});//end addReply

						//스크랩하기 클릭 시 스크랩에 문서함에 저장하기 
						var scrapBtn = $('#scrapBtn');

						scrapBtn.on("click", function() {

							var post = {
								post_id : post_id,
								dept_id : dept_id,
								emp_id : emp_id,
								post_name : post_name,
								post_content : post_content,
								csrf_token:csrf_token,
					            csrf_header:csrf_header
							}

							postService.scrapPost(post, function(result) {
								alert("스크랩되었습니다!");
							});
						});

						//list버튼 클릭 시 목록이동
						$('#listBtn').on("click", function(e) {

							$("#operForm").attr("action", "/board/list");
							$(".form-group").empty();
							$("#operForm").submit();

						});
						
						
						
	});//end script
</script>





<%@include file="/WEB-INF/views/includes/footer.jsp"%>