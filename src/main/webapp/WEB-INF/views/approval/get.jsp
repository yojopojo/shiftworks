<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>결재 문서 상세보기</h1>
	<a href="/approval/list">결재문서 내역</a>
				<div class="form-group">
					<label>결재번호</label> <input class="form-control" name='apr_id'
						value='<c:out value="${approval.apr_id }"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>결재명</label> <input class="form-control" name='apr_title'
						value='<c:out value="${approval.apr_title }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>결재 유형</label> <input class="form-control" name='af_id'
						value='<c:out value="${approval.af_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>작성자</label> <input class="form-control" name='emp_id'
						value='<c:out value="${approval.emp_id }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>결재 내용</label>
					<textarea class="form-control" rows="3" name='apr_content'
						readonly="readonly"><c:out value="${approval.apr_content}" /></textarea>
				</div>
				

				<button data-oper='' class="btn btn-default">승인</button>
				<button data-oper='' class="btn btn-default">반려</button>
				<button data-oper='' class="btn btn-default">의견</button>
				

</body>
</html>