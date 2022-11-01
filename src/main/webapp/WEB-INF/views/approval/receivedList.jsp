<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
</head>
<body>

<h1>결재할 문서함</h1>
	<a href="/approval/list">전체 문서함</a>
	
	<table border="1" width="800">
		<tr>
			<th>결재 번호</th>
			<th>결재 유형</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>결재명</th>
			<th>결재 내용</th>
			<th>결재 상태</th>
			<th>결재 의견</th>
			<th>결재 날짜</th>
		</tr>
		
		<c:forEach var="approval" items="${list }">
		
		<tr>	
			<td><c:out value="${approval.apr_id }"/></td>
			<td><c:out value="${approval.af_id }"/></td>
			<td><c:out value="${approval.emp_id }"/></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd"
			 	value="${approval.apr_receivedate }"/></td>
			 <td><a href="/approval/get?apr_id=${approval.apr_id}">
			 <c:out value="${approval.apr_title}"/></a></td>
			<td><c:out value="${approval.apr_content }"/></td>
			<td><c:out value="${approval.apr_status }"/></td>
			<td><c:out value="${approval.apr_comment }"/></td>
			<td><fmt:formatDate pattern="yyyy-MM-dd" 
			 value="${approval.apr_signdate }"/></td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	
				<!-- 페이징 처리 뷰-->
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous">
							<a href="${pageMaker.startPage -1}">이전</a></li>
						</c:if>
						 <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button  ${pageMaker.cri.pageNum == num ? "active":""} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next">
							<a href="${pageMaker.endPage +1 }">이후</a></li>
						</c:if>
					</ul>
				</div>
				<!--  end Pagination -->

			<form id='actionForm' action='/approval/list' method='get'>
					<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
					<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
			</form> 
			
		
		
			<script type="text/javascript">
			
			
			//pagination
			var actionForm = $("#actionForm");
			
			  $(".paginate_button a").on("click", function(e) {
							e.preventDefault();
							console.log('click');
							$("#actionForm").find("input[name='pageNum']").val($(this).attr("href"));
							$("#actionForm").submit();
			   });
			  
			  // 결재 상세 내역 보기 이후 첫 페이지 이동시 원래 보던 페이지 고정 => 다시 확인
			  $(".move")
				.on("click",function(e) {
							e.preventDefault();
							actionForm.append("<input type='hidden' name='bno' value='"
											+ $(this).attr("href")+ "'>");
							actionForm.attr("action","/approval/get");
							actionForm.submit();
						});

		</script>		
	
</body>
</html>