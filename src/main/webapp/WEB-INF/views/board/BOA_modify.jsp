<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="../includes/header.jsp"%>
<%@include file="/WEB-INF/views/board/index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<link rel="stylesheet" href="/resources/css/post.css">

<meta charset="UTF-8">

<title></title>
</head>

<div class ="container">
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">글수정</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
  	<div class="panel panel-body">
  
    <div class="panel panel-default">
 		<button id ="previewBtn" type="button" class="btn btn-primary">미리보기</button>
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
			<label>작성부서</label> 
			<input class="form-control" name='dept_id'
				value='<c:out value="${post.dept_id }"/>' readonly="readonly">
		</div>
		<div class="form-group">
			<label>제목</label> 
			<input class="form-control" name='post_name'
				value='<c:out value="${post.post_name}"/>'>
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" rows="20" cols="150" name='post_content'>
			<c:out value="${post.post_content}" /></textarea>
		</div>
		<div class="form-group">
			<label>작성일</label> 
			<input class="form-control" name='post_regdate'
				value= <fmt:formatDate pattern = "yyyy/MM/dd" value = "${post.post_regdate}" /> readonly="readonly">
		</div>
		<div class="form-group">
			<label>수정일</label> 
			<input class="form-control" name='post_updatedate' readonly="readonly"
			value= <fmt:formatDate pattern = "yyyy/MM/dd" value = "${post.post_updatedate}" />>
		</div>
		<div class="form-group">
			<label>수신부서</label> 
			<input class="form-control" name='post_receivedept' value = "${post.post_receivedept}"/>
		</div>
		<button id="modifyBtn" class="btn btn-primary">글 수정하기</button>
  		<button id="listBtn" class="btn btn-primary">목록보기</button>
      </div>
   	
   	
   	<!--데이터 넘기는 form-->
   	<form id="actionform" action="/board/list" method="get">
        <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
	    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
      </form>

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
</div>

<script type="text/javascript" src="/resources/js/post.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	var formObj = $(".form-group");
	var actionform = $('#actionform');
	
	
	//글 수정하기 버튼 클릭 했을 때 값을 postVO 객체로 받아서 db에 update하기 
	  $('#modifyBtn').on("click", function(e){
		  
		var post_id = formObj.find("input[name='post_id']").val();
		var post_name = formObj.find("input[name='post_name']").val();
	 	var post_content = formObj.find("textarea[name='post_content']").val();
		var post_receivedept = formObj.find("input[name='post_receivedept']").val();
		    
		  var post ={
		    		post_id:post_id,
		    		post_name:post_name,
		    		post_content:post_content,
		    		post_receivedept:post_receivedept
		    }
		  
		    e.preventDefault(); 
		    
		    postService.updatePost(post, function(result){
		    	alert(result);
		    	 formObj.empty();
		    	actionform.submit();
		    });
		    
	  });
	
	//목록 버튼 클릭 시 BOA_list.jsp 로 이동
	$('#listBtn').on("click",function(e){
			     
			      formObj.empty();
			      actionform.submit();
	});
	
	
	
	
});//end script
</script>
  

<%@include file="../includes/footer.jsp"%>