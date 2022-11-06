<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>

<head><%@include file="../includes/header.jsp"%></head>
<body class="container">


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">employee Modify</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">employee Modify</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      <form role="form" action="/manager/modify" method="post">
      <input type="hidden" name="${_csrf.parameterName}"
    value="${_csrf.token}" />
<%--         <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
        <input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
	    <input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'> --%>
      
 
<div class="form-group">
  <label>소속 부서 번호</label> 
  <input class="form-control" name='dept_id' 
     value='<c:out value="${employee.dept_id }"/>' readonly="readonly">
</div>

<div class="form-group">
  <label>이름</label> 
  <input class="form-control" name='name' 
    value='<c:out value="${employee.'name' }"/>' >
</div>

<%-- <div class="form-group">
  <label>Text area</label>
  <textarea class="form-control" rows="3" name='content' ><c:out value="${employee.content}"/></textarea>
</div> --%>

<div class="form-group">
  <label>직급</label> 
  <input class="form-control" name='position'
    value='<c:out value="${employee.position}"/>' readonly="readonly">            
</div>

<%-- <div class="form-group">
  <label>RegDate</label> 
  <input class="form-control" name='regDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${employee.regdate}" />'  readonly="readonly">            
</div>

<div class="form-group">
  <label>Update Date</label> 
  <input class="form-control" name='updateDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${employee.updateDate}" />'  readonly="readonly">            
</div>
 --%>
          
<%-- <sec:authentication property="principal" var="pinfo"/>
	<sec:authorize access="isAuthenticated">
		<c:if test="${pinfo.username eq employee.writer }">
			  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  			<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
		</c:if>
	
	</sec:authorize> --%>

  <button type="submit" data-oper='list' class="btn btn-info">List</button>
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


	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/manager/remove");
	      
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action", "/manager/list").attr("method","get");
	      
	   /*    var pageNumTag = $("input[name='pageNum']").clone();
	      var amountTag = $("input[name='amount']").clone();
	      var keywordTag = $("input[name='keyword']").clone();
	      var typeTag = $("input[name='type']").clone();      
	      
	      formObj.empty();
	      
	      formObj.append(pageNumTag);
	      formObj.append(amountTag);
	      formObj.append(keywordTag);
	      formObj.append(typeTag);	        */
	    }
	    
	    formObj.submit();
	  });

});
</script>
  

</body>
</html>



<%@include file="../includes/footer.jsp"%>
