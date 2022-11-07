<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
<html>

<head></head>
<body>

	<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">사원 등록</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">

				<div class="panel-heading">계정 등록</div>
				<!-- /.panel-heading -->
				<div class="panel-body">

				<form role="form" action="/manager/register" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="form-group">
						<label>이름</label> <input class="form-control" name='name'<%-- value='<sec:authentication property="principal.username"/>' --%>>
					</div>
					<div class="form-group">
						<label>입사일</label> <input class="form-control" name='entry_date'<%-- value='<sec:authentication property="principal.username"/>' --%>>
					</div>
					<div class="form-group">
					<label>사번</label> <input class="form-control" name='emp_id'>
				</div>
				<div class="form-group">
					<label>부서번호</label> <input class="form-control" name='dept_id'<%-- value='<sec:authentication property="principal.username"/>' --%>>
				</div>
				<div class="form-group">
					<label>비밀번호</label> <input class="form-control" name='password'<%-- value='<sec:authentication property="principal.username"/>' --%>>
				</div>
				<div class="form-group">
					<label>직급</label> <input class="form-control" name='position'<%-- value='<sec:authentication property="principal.username"/>' --%>>
				</div>
				<div class="form-group">
					<label>생년월일</label> <input class="form-control" name='birthday'<%-- value='<sec:authentication property="principal.username"/>' --%>>
				</div>
				<div class="form-group">
					<label>주소</label> <input class="form-control" name='address'<%-- value='<sec:authentication property="principal.username"/>' --%>>
				</div>
				<div class="form-group">
					<label>모바일</label> <input class="form-control" name='mobile'<%-- value='<sec:authentication property="principal.username"/>' --%>>
				</div>
				<div class="form-group">
					<label>사내망 번호</label> <input class="form-control" name='internal'<%-- value='<sec:authentication property="principal.username"/>' --%>>
				</div>
				<div class="form-group">
					<label>이메일</label> <input class="form-control" name='email'<%-- value='<sec:authentication property="principal.username"/>' --%>>
			 </div>


					<!--  <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" rows="3" name='content'></textarea>
          </div> -->

					<button type="submit" class="btn btn-default">등록</button>
					<button type="reset" class="btn btn-default">초기화</button>
					
				</form>
			</div>
				<!--  end panel-body -->

			</div>
			<!--  end panel-body -->
		</div>
		<!-- end panel -->
	</div>
	<!-- /.row -->
</div>
</body>
</html>

<%@include file="../includes/footer.jsp"%>
