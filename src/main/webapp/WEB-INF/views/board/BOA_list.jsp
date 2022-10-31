<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<%@include file="index.jsp"%>
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
							<th>게시판번호</th>
							<th>게시글번호</th>
							<th>작성자</th>
							<th>작성부서</th>
							<th>제목</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					
						<c:forEach items="${pageMaker.list}" var="pageMaker">
						<tbody>
							<tr>
								<td><c:out value="${pageMaker.b_id}" /></td>
								<td><a class="getPost" href='<c:out value="${pageMaker.post_id}"/>'>
									<c:out value="${pageMaker.post_id}" /></a>
								</td>
								<td><c:out value="${pageMaker.name}" /></td>
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
				
				
				<!--검색버튼 -->
				 <div class='row'>
					<div class="col-lg-12">
						<form id='searchForm' action="/board/BOA_list" method="post">
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
						</form>
					</div>
				</div>
				

				<!--페이지 처리 뷰-->
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
							<li class="paginate_button next"><a href="${pageMaker.endPage +1 }">이후</a></li>
						</c:if>
					</ul>
				</div>
				<!--  end Pagination -->
			</div>
			<!-- end panelBody-->

			<form id='actionForm' action='/board/BOA_list' method='get'>
					<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
					<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
					<input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type}"/>'>
					<input type='hidden' name='keyword' value='<c:out value="${ pageMaker.cri.keyword}"/>'>
			</form> 
			
		


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
	 
	 
	 //pagination
	  $(".paginate_button a").on("click", function(e) {
					e.preventDefault();
					console.log('click');
					$("#actionForm").find("input[name='pageNum']").val($(this).attr("href"));
					$("#actionForm").submit();
	   });
		
	  
	  
	 //검색 버튼 클릭 시 검색한 list 불러오기
	 var searchForm = $("#searchForm");
	  
	  $("#searchBtn").on("click", function(e){
		  
		  if (!searchForm.find("option:selected").val()) {
				alert("검색종류를 선택하세요");
				return false;
			}
			if (!searchForm.find("input[name='keyword']").val()) {
				alert("키워드를 입력하세요");
				return false;
			}
			searchForm.find("input[name='pageNum']").val("1");
			searchForm.submit();
	  });
		
	  
	  
	  //글번호 클릭 시 get.jsp 이동하기
	 
	  $(".getPost").on("click",function(e){
		  	
		  console.log($(".getPost").attr("href"));
			e.preventDefault();
			var post_id = $(this).attr("href");
			console.log(post_id);

			//history 테이블에 넣어서 읽음 표시하기 추후 css에서 읽음 테이블안에 없을 시 bold 처리 필요 
			postService.insertHistory({post_id:post_id});
			
			//get.jsp이동
			  $("#actionForm") .
				append("<input type='hidden' name='post_id' value='"+ $(this).attr("href")+ "'>");
			
			$("#actionForm").attr("action","/board/getPost");
			$("#actionForm").submit();  
		
	  });
	
	    	
	  
});
</script>


