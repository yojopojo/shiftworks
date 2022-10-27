<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<button id='registerBtn' type="button" class="btn btn-xs pull-right">
					새 게시물 등록</button>
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table id="boardTest" class="table table-striped table-bordered table-hover" border="1">
					<thead>
						<tr>
							<th>테이블번호</th>
							<th>게시글번호</th>
							<th>작성자</th>
							<th>작성부서</th>
							<th>제목</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					
						<c:forEach items="${pageMaker.list}" var="pageMaker">
						<tbody ="dddd">
							<tr>
								<td><c:out value="${pageMaker.b_id}" /></td>
								<td><c:out value="${pageMaker.post_id}" /></td>
								<td><c:out value="${pageMaker.emp_id}" /></td>
								<td><c:out value="${pageMaker.dept_id}" /></td>
								<td><c:out value="${pageMaker.post_name}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${pageMaker.post_regdate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${pageMaker.post_updatedate}" /></td>
							</tr>
						</tbody>
						</c:forEach> 
					
				</table>

				 <div class='row'>
					<div class="col-lg-12">
						<div id='searchForm'>
							<select name='type'>
								<option value=""
									<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
								<option value="T"
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
								<option value="W"
									<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
								<option value="TW"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>
									제목 or 작성자
								</option>
							</select> 
							<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' />
							<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
							<button id='searchBtn' class='btn btn-default'>검색 </button>
						</div>
					</div>
				</div>
				
				<%-- <form id='actionForm' action='/board/pages/' method='post'>
					<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
					<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
					<input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type}"/>'>
					<input type='hidden' name='keyword' value='<c:out value="${ pageMaker.cri.keyword}"/>'>
				</form> --%>

				<!--페이지 처리 뷰-->
				<div class='pull-right'>
					<ul class="pagination">
						 <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button  ${pageMaker.cri.pageNum == num ? "active":""} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a href="${pageMaker.endPage +1 }">Next</a></li>
						</c:if>
					</ul>
				</div>
				<!--  end Pagination -->
			</div>
			<!-- end panelBody-->


			<!-- Modal  추가 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리가 완료되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save changes</button>
						</div>
					</div>
					<!--modal-content-->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->


		</div>
		<!--  end panel -->
	</div>
	<!-- end class -->
</div>
<!-- /.row -->

<script type="text/javascript" src="/resources/js/post.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	
	var searchForm = $("#searchForm");
	var formType = searchForm.find("select[name='type']");
	var formKeyword = searchForm.find("input[name='keyword']");
	var formPageNum = searchForm.find("input[name='pageNum']");
	
	
	
	 //새 게시물 등록 선택 시 register.jsp 이동
	  $("#registerBtn").on("click",function(e){
	      location.href = "/board/new";
	      
	    });
	
	//검색 버튼 클릭 시 검색 조건에 맞는 데이터 불러와서 출력하기 
	$("#searchBtn").on("click", function(e){
		
		$('#boardTest').find("td").remove();
		
		var post= {
				type: formType.val(),
				keyword : formKeyword.val(),
				pageNum: formPageNum.val()
		};
		
		
		console.log(post.type);
		console.log(post.keyword);
		console.log(formPageNum.val());
		
	    postService.getListWithSearch(post, function(result){
	    	
	    	console.log(result.list["1"].b_id)
	    	console.log(result.list["1"].post_name);
			
			  for(var i=0;i<result.list.length;i++){
				$('#dddd').append("<tr><td align='center'>" +result.list[i+""].b_id + "</td>" +
									"<td>" + result.list[i+""].post_id + "</td>" +
									"<td>" + result.list[i+""].emp_id + "</td>"+
									"<td>" + result.list[i+""].dept_id + "</td>"+
									"<td>" + result.list[i+""].post_name +"</td>"+
									"<td>" + result.list[i+""].post_regdate+"</td>"+
									"<td>" + result.list[i+""].post_updatedate+"</td></tr>");  
		 	}  
			
		}); 
		
	   
	
		
	});
		
	
	

	    	
	  
});
</script>


<%@include file="../includes/footer.jsp"%>
