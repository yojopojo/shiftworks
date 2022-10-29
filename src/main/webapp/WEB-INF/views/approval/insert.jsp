<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>Insert title here</title>
</head>
<body>
	<h1>결재문서 작성</h1>
	<form role="form" action="/approval/insert" method="post">
          <div class="form-group">
          <div>
          <label>결재 양식</label> 
          <select name="af_id">
          	<option value="">선택하세요</option>
          	<option value="1">기안서</option>
          	<option value="3">휴가신청서</option>
          	<option value="2">품의서</option>
          </select>
          <div>
            <label>작성자</label> <input class="form-control" name='emp_id' readonly value="user1">
          </div>
          <div>
            <label>결재명</label> <input class="form-control" name='apr_title'>
          </div>

          <div class="form-group">
            <label>결재 내용</label>
            <textarea class="form-control" rows="3" name='apr_content'></textarea>
          </div>
          
          <button type="submit" class="btn btn-default">제출하기</button>
          <button type="submit" class="btn btn-default">임시저장</button>
        </form>

</body>
</html>