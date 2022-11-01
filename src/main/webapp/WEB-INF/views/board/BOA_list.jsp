<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<%@include file="index.jsp"%>
<%@include file="/resources/css/post.css"%>

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
					<tbody class=main>
					
					</tbody>
				</table>
				
				
				<!--검색버튼 -->
				 <div class='row'>
					<div class="col-lg-12">
						<form id='searchForm' action="/board/list" method="get">
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

					</ul>
				</div>
				<!--  end Pagination -->
			</div>
			<!-- end panelBody-->

			<div class="action-body">
					<input hidden="hidden" name="pageNum" value="">
					<input hidden="hidden" name="type" value="">
					<input hidden="hidden" name="keyword" value="">
			</div>
		
		
		<!-- Modal -->
      	<div class="modal" id="myModal">
        	<div class="modal-dialog">
          		<div class="modal-content">
            		<div class="modal-header">
              			<button type="button" class="close" data-dismiss="modal"></button>
              			<h4 class="modal-title" id="myModalLabel">알림</h4>
           		   </div>
            		<div class="modal-body">
                			<div>임시저장한 게시물이 있습니다.</div>
                			<div>이어서 작성하시겠습니까?</div>
            		</div>
					<div class="modal-footer">
        				<button id='modalModBtn' type="button" class="btn btn-primary">예</button>
        				<button id='modalRemoveBtn' type="button" class="btn btn-primary">아니오</button>
      				</div>         
       		</div>
          <!-- /.modal-content -->
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
	
	//글 리스트 가져오기
	var getList = function(){
		postService.listEntity(Criteria, function(pageDTO){
			var list = pageDTO.list;
			var cri = pageDTO.cri;
			
			
			//글목록 가져오기
			var str ="";
			for(var i=0;i<list.length;i++){
				str += "<tr>";
				str += "<td>"+list[i].b_id +"</td>";
				str += "<td><a class='getPost' href='" + list[i].post_id +"'>"+list[i].post_id +"</a></td>";
				str += "<td>" + list[i].name+ "</td>";
				str += "<td>" + list[i].dept_id+ "</td>"; 
				str += "<td>" + list[i].post_name+ "</td>"; 
				str += "<td>" + list[i].post_regdate+ "</td>";
				str += "<td>" + list[i].post_updatedate+ "</td>";  
				str += "</tr>";
			}
			
			//글 페이지 가져오기
			var pag = "";
			
			if(pageDTO.prev){
				pag +="<li class='paginate_button previous'>";
				pag += "<a href='" +(pageDTO.startPage -1) +"'>이전</a></li>";
			}
			
			for(var i=1;i<(pageDTO.endPage-pageDTO.startPage)+1;i++){
				var num = (pageDTO.endPage-pageDTO.startPage);
				pag += "<li class='paginate_button'>"
				pag += "<a href='"+ i + "'>"+ i + "</a>";
				pag +="</li>"
			}
			
			if(pageDTO.next){
				pag +="<li class='paginate_button next'>";
				pag += "<a href='"+ (pageDTO.startPage +1) +"'>이후</a></li>";
			}
			
			
			
			$(".main").html(str);//글 목록 가져오기
			$(".pagination").html(pag);//글 페이징 처리 뷰
			
		})
	}
	

	/* var searchForm = $("#searchForm");
	var formType = searchForm.find("select[name='type']");
	var formKeyword = searchForm.find("input[name='keyword']");
	var formPageNum = searchForm.find("input[name='pageNum']");  */
	
	
	var pageNum = $(".action-body").find("input[name='pageNum']");
	var keyword = $(".action-body").find("input[name='keyword']");
	var type = $(".action-body").find("input[name='type']");
	
	var Criteria ={
			pageNum: 1 || pageNum.val(),
			keyword: "1" || keyword.val(),
			type: "1" ||type.val()
	}
	
	 getList(); //글 리스트 및 페이지 가져오기
	
	
	
	
	
	
		//pagination
	  $(".pagination").on("click","li", function(e) {
					e.preventDefault();
					console.log($(this).find("a").attr("href"));		
		
		$(".action-body").find("input[name=pageNum]").attr('value',$(this).find("a").attr("href"));
		
		getList();
		
	   });
	
	

	 //새 게시물 등록 선택 시 register.jsp 이동
	  $("#registerBtn").on("click",function(e){
		  
		  
		//onload 됐을 때 emp_id값과 b_id에 맞는 temp_board데이터가 있으면 불러오기
		postService.temporalSelect(function(result){
			if(result){
				 $(".modal").show();
				 $("#modalRemoveBtn").on("click",function(){
					 $(".modal").hide();
					 location.href = "/board/new";
				 })
				 $("#modalModBtn").on("click",function(){
					 $(".modal").hide();
					 location.href ="/board/temporalview";
				 })
				 
			}
			else{
				location.href = "/board/new";
			}
		})
		
	  });//end register
	 
	 
	
		
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
	  $(".main").on("click","tr a", function(e){
		  	
			e.preventDefault();
			var post_id = $(this).attr("href");
			console.log(post_id);

			//history 테이블에 넣어서 읽음 표시하기
			postService.insertHistory({post_id:post_id});
			
			//get.jsp이동
			  $("#actionForm") .
				append("<input type='hidden' name='post_id' value='"+ $(this).attr("href")+ "'>");
			
			$("#actionForm").attr("action","/board/get");
			$("#actionForm").submit();  
		
	  });
	  
	
	
	
	 
	
	 
	  
	 //안읽은 게시물 bold처리추가하기
	/*  postService.getHistory(function(result){
		  console.log(result);
		  
		  
		  
		  for(var i=0;i<result.length;i++){
			  
			if(number !=(result[i].post_id)){
				$(number).closest("tr").css("font-weight","bold");
			}
				
		  }
		 
	  }) */
	
	    	
	  
});
</script>


