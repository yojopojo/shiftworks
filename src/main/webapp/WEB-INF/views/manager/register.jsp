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
    <h1 class="page-header">employee Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Account Register</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

        <form role="form" action="/manager/register" method="post">
         	<input type="hidden" name="${_csrf.parameterName}"
    value="${_csrf.token}" />
          <div class="form-group">
            <label>사번</label> <input class="form-control" name='emp_id'>
          </div>
          <div class="form-group">
            <label>부서번호</label> <input class="form-control" name='dept_id'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
          <div class="form-group">
            <label>비밀번호</label> <input class="form-control" name='password'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
             <div class="form-group">
            <label>직급</label> <input class="form-control" name='position'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
          

         <!--  <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content'></textarea>
          </div> -->

          <div class="form-group">
            <label>사번</label> <input class="form-control" name='emp_id'
            	<%-- value='<sec:authentication property="principal.username"/>' --%>>
          </div>
          <button type="submit" class="btn btn-default">Submit
            Button</button>
          <button type="reset" class="btn btn-default">Reset Button</button>
        </form>

      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

</body>
</html>

<%@include file="../includes/footer.jsp"%>
