<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- JQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
					<label>작성 일자</label> <input class="form-control" name='apr_receivedate'
						value='<fmt:formatDate pattern="yyyy-MM-dd" 
			 			value="${approval.apr_receivedate }"/>' readonly="readonly">
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
				
				
				<button id ='signBtn' data-oper='1' class="btn btn-default update-status">승인</button>
				<button id = 'rejectBtn' data-oper='2' class="btn btn-default update-status">반려</button>
				<button id = 'commentBtn' data-oper='' class="btn btn-default">의견</button>
				
								
				<script type="text/javascript">
				
				 
				 $(document).ready(function () {
					
					// 승인 버튼 선택 시 결재 문서 상태를 승인으로 변경하고 전체 문서 리스트로 이동
					$(".update-status").on("click",function(e){
						e.preventDefault();
						var status = $(this).data('oper');
						$.ajax({
							url: "/approval/sign/" + ${approval.apr_id } +"?status=" + status,
							type: 'put',
							success: function(data){
								alert("처리가 완료되었습니다.");
								self.location="/approval/list"
							},error: function(err){
								alert("잘못된 요청입니다.")
							}
						})
					});
					
				})
				
				
				
				</script>
				

</body>
</html>