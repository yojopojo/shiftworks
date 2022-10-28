<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">글수정</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <form role="form" action="/board/modify" method="post">
        <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
	    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
      
 
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
		<button type="submit" data-oper='modify' class="btn btn-default">글 수정하기</button>
  		<button type="submit" data-oper='list' class="btn btn-info">목록보기</button>
	  </form>
      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
	
	var formObj = $("#form");
	
	//글 수정하기 버튼 클릭 했을 때 값을 postVO 객체로 받아서 db에 update하기 
	  $('button').on("click", function(e){
		    
		    e.preventDefault(); 
		    
		    var operation = $(this).data("oper");
		    console.log(operation);
		    
		    if(operation === 'list'){
			      //move to list
			      formObj.attr("action", "/board/list").attr("method","get");
			      
			      var pageNumTag = $("input[name='pageNum']").clone();
			      var amountTag = $("input[name='amount']").clone();
			      var keywordTag = $("input[name='keyword']").clone();
			      var typeTag = $("input[name='type']").clone();      
			      
			      formObj.empty();
			      
			      formObj.append(pageNumTag);
			      formObj.append(amountTag);
			      formObj.append(keywordTag);
			      formObj.append(typeTag);	       
			    }
		    formObj.submit(); 
		  });
	

});
</script>
  

<%@include file="../includes/footer.jsp"%>
