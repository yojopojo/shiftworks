<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/resources/css/post.css">

<meta charset="UTF-8">
<title></title>
</head>

<div class="container">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">결재문서함</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
			
			<!--검색버튼 -->
				 <div class='row'>
					<div class="col-lg-12">
						<form id="searchForm">
							<select name='type' class="form-select" aria-label="Default select example">
								<option value=""
									<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
								<option value="T"
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
								<option value="C"
									<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
								<option value="TC"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>
									제목 or 내용
								</option>
							</select> 
							<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' />
							<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
							<button id='searchBtn' class='btn btn-primary'>검색 </button>
						</form>
					</div>
				</div>
			
				
				<!--메인 게시판-->
				<table id="boardTest" class="table table-striped table-bordered table-hover" border="1">
					<thead>
						<tr>
							<th>결재문서번호</th>
							<th>문서양식번호</th>
							<th>작성자</th>
							<th>결재제목</th>
							<th>결재내용</th>
							<th>결재상태</th>
							<th>결재일자</th>
						</tr>
					</thead>
					<tbody id="main">
						<c:forEach items="${pageMaker.list}" var="approval">
							<tr>
								<td><a class="getMyDoc" href='<c:out value="${approval.apr_id}"/>'>
									<c:out value="${approval.apr_id}" /></a>
								</td>
								<td><c:out value="${approval.af_id}" /></td>
								<td><c:out value="${approval.emp_id}" /></td>
								<td><c:out value="${approval.apr_title}" /></td>
								<td><c:out value="${approval.apr_content}" /></td>
								<td><c:out value="${approval.apr_status}" /></td>
								<td><c:out value="${approval.apr_signdate}" /></td>
							</tr>	
						</c:forEach>
					</tbody>
				</table>
				
				
				
				
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
				
				<form id='actionForm' action='/document/detail' method='get'>
					<input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' />
					<input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
					<input type='hidden' name='type' value='<c:out value="${pageMaker.cri.type}"/>' /> 	
				</form> 
				
				
				
			</div>
			<!-- end panelBody-->
		</div>
		<!--end panel  -->
	</div>
</div>
<!--end row-->
</div>

<script type="text/javascript" src="/resources/js/post.js"></script>
<script src="/resources/js/document.js" type="text/javascript"></script>
<script>
$(document).ready(function () {
	
	//글번호 클릭 시 세부내용 보기 
	$("#main").on("click"," td a", function(e){
			e.preventDefault();
			
			console.log($(this).attr("href"));
			 $("#actionForm") .
				append("<input type='hidden' name='post_id' value='"+ $(this).attr("href")+ "'>");
			$("#actionForm").submit();  
	})
	
	
			//검색 버튼 클릭 시 검색한 list 불러오기
			$("#searchBtn").on("click", function(e){
				e.preventDefault();
				
				var searchForm = $("#searchForm");
				
				 if (!searchForm.find("option:selected").val()) {
						alert("검색종류를 선택하세요");
						return false;
				}
				if (!searchForm.find("input[name='keyword']").val()) {
						alert("키워드를 입력하세요");
							return false;
				}
				
				//var pageNum = searchForm.find("input[name='pageNum']").val("1");
				var keyword = searchForm.find("input[name='keyword']").val();
				var type = searchForm.find("select[name='type']").val();
				
				var Criteria ={
						pageNum:$(this).attr("href") || 1,
						keyword: keyword,
						type: type 
				}
				
				console.log(keyword);
				console.log(type);
				
				
				
				 documentService.getList(Criteria, function(result){
					console.log(result); 
					
					$("#main").html('');
					var list = result.list;
					var str ="";
					for(var i=0;i<list.length;i++){
						console.log(list[i]);
						//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						//Date list[i].post_regdate = format.parse(list[i].post_regdate);
						//Date list[i].post_updatedate =format.parse(list[i].post_updatedate);
						
						str += "<tr>";
						str +="<td>"+list[i].b_id+"</td>";
						str +="<td><a class='getMyDoc' href='"+list[i].post_id+"'>"+list[i].post_id+"</td>";
						str +="<td>"+list[i].emp_id+"</td>";
						str +="<td>"+list[i].dept_id+"</td>";
						str +="<td>"+list[i].post_name+"</td>";
						str +="</tr>";
					}
					$("#main").html(str);
				}); 
				 			
			});
	
	
		//pagination
	  $(".paginate_button a").on("click", function(e) {
					e.preventDefault();
					console.log($(this).attr("href"));   
					var actionForm = $("#actionForm");
					
					var pageNum = actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					var keyword = actionForm.find("input[name='keyword']").val();
					var type = actionForm.find("input[name='type']").val();
					
					
					var Criteria ={
							pageNum:$(this).attr("href") || 1,
							keyword: keyword ||"empty",
							type: type ||"empty"
					}
					
					 console.log('click');
					
				
					
				//pageNum, keyword, type을 들고 controller로 가서 result 값 가져오기
				 documentService.getList(Criteria, function(result){
					console.log(result); 
					
					
					$("#main").html('');
					var list = result.list;
					var str ="";
					for(var i=0;i<list.length;i++){
						console.log(list[i]);
						//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						//Date list[i].post_regdate = format.parse(list[i].post_regdate);
						//Date list[i].post_updatedate =format.parse(list[i].post_updatedate);
						
						str += "<tr>";
						str +="<td>"+list[i].b_id+"</td>";
						str +="<td><a class='getMyDoc' href='"+list[i].post_id+"'>"+list[i].post_id+"</td>";
						str +="<td>"+list[i].emp_id+"</td>";
						str +="<td>"+list[i].dept_id+"</td>";
						str +="<td>"+list[i].post_name+"</td>";
						str +="</tr>";
					}
					
					$("#main").html(str);
				})
				
						
	   });//end pagination
	   
	
	
	
	
	


})//end script
</script>		

</html>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>