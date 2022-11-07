<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<html>
<link rel="stylesheet" href="/resources/css/detail.css">
<body>
<div class="container">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Account Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">계정 정보</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<div class="form-group">
					<label>사번</label> <input class="form-control" name='emp_id'
						value='<c:out value="${employee.emp_id }"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>부서명</label> <input class="form-control" name='dept_name'
						value='<c:out value="${employee.dept_name }"/>' readonly="readonly">
				</div>
						<div class="form-group">
					<label>직급</label> <input class="form-control" name='position'
						value='<c:out value="${employee.position }"/>' readonly="readonly">
				</div>
						<div class="form-group">
					<label>이름</label> <input class="form-control" name='name'
						value='<c:out value="${employee.name }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>생년월일</label> <input class="form-control" name='birthday'
						value='<c:out value="${employee.birthday }"/>' readonly="readonly">
				</div>
					<div class="form-group">
					<label>모바일</label> <input class="form-control" name='mobile'
						value='<c:out value="${employee.mobile }"/>' readonly="readonly">
				</div>
					<div class="form-group">
					<label>사내망</label> <input class="form-control" name='internal'
						value='<c:out value="${employee.internal }"/>' readonly="readonly">
				</div>
					<div class="form-group">
					<label>이메일</label> <input class="form-control" name='email'
						value='<c:out value="${employee.email }"/>' readonly="readonly">
				</div>
					<div class="form-group">
					<label>주소</label> <input class="form-control" name='address'
						value='<c:out value="${employee.address }"/>' readonly="readonly">
				</div>
					<div class="form-group">
					<label>입사일</label> <input class="form-control" name='entry_date'
						value='<c:out value="${employee.entry_date }"/>' readonly="readonly">
				</div>
				
				

				<%-- <div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly"><c:out value="${Account.content}" /></textarea>
				</div> --%>

	<%-- 			<div class="form-group">
					<label>부서번호</label> <input class="form-control" name='dept_id'
						value='<c:out value="${employee.detp_id }"/>' readonly="readonly">
				</div> --%>
				
				<sec:authentication property="principal" var="pinfo"/>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<c:if test="${pinfo.username eq employee.emp_id }">
						<button data-oper='modify' class="btn btn-default">수정</button>
					</c:if>
				</sec:authorize>
				

				<button data-oper='list' class="btn btn-default">목록</button>
		
				<form id='operForm' action="/manager/modify" method="get">
					<input type='hidden' id='emp_id' name='emp_id'
						value='<c:out value="${employee.emp_id}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='keyword'
						value='<c:out value="${cri.keyword}"/>'> <input
						type='hidden' name='type' value='<c:out value="${cri.type}"/>'>`

				</form>



			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->
<script type="text/javascript">

	$(document).ready(function () {
		
		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function (e) {
			operForm.attr("action","/manager/modify").submit();
			
		});
		
		$("button[data-oper='list']").on("click", function (e) {
			operForm.find('#emp_id').remove();
			operForm.attr("action","/manager/list");
			operForm.submit();
		
		});
	});

</script>

<%-- <div class='row'>
	<div class="col-lg-12">
		<!-- /.panel -->
		<div class="panel panel-default">			
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> Reply
				<sec:authentication property="principal" var="pinfo"/>
				<sec:authorize access="isAuthenticated()">
					<c:if test="${pinfo.username eq Account.writer }">
						<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New	Reply</button>
					</c:if>
				</sec:authorize>
			</div>
			
			<!-- /.panel-heading -->
			<div class="panel-body">
				<ul class="chat">

				</ul>
				<!-- ./ end ul -->
			</div>
			<!-- /.panel .chat-panel -->

			<div class="panel-footer"></div>
		</div>
	</div>
	<!-- ./ end row -->
</div> --%>



<!-- Modal -->
<!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label> <input class="form-control" name='reply'
						value='New Reply!!!!'>
				</div>
				<div class="form-group">
					<label>Replyer</label> <input class="form-control" name='replyer'
						value='replyer'>
				</div>
				<div class="form-group">
					<label>Reply Date</label> <input class="form-control"
						name='replyDate' value='2018-01-01 13:13'>
				</div>

			</div>
			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
				<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
			</div>
		</div>
		/.modal-content
	</div>
	/.modal-dialog
</div>
/.modal

<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
	$(document).ready(function() {
		
		var emp_idValue = '<c:out value="${employee.emp_id}"/>';
		var replyUL = $(".chat");
		
		showList(1);
	    
		function showList(page){
			
			console.log("show list " + page);
		    
		    replyService.getList({emp_id:emp_idValue,page: page|| 1 }, function(list) {//json값이 넘어옴
		      
		    //console.log("replyCnt: "+ replyCnt );
		    console.log("list: " + list);
		    console.log(list);
		    
		    /* if(page == -1){
		      pageNum = Math.ceil(replyCnt/10.0);
		      showList(pageNum);
		      return;
		    } */
		      
		     var str="";
		     
		     if(list == null || list.length == 0){
		       return;
		     }
		     
		     for (var i = 0, len = list.length || 0; i < len; i++) {
		       str +="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
		       str +="  <div><div class='header'><strong class='primary-font'>["
		    	   +list[i].rno+"] "+list[i].replyer+"</strong>"; 
		       str +="    <small class='pull-right text-muted'>"
		           +replyService.displayTime(list[i].replyDate)+"</small></div>";
		       str +="    <p>"+list[i].reply+"</p></div></li>";
		     }
		     
		     replyUL.html(str);		     
		    // showReplyPage(replyCnt);
		 
		   });//end function		     
		}//end showList
		
		
		var modal = $(".modal");
	    var modalInputReply = modal.find("input[name='reply']");
	    var modalInputReplyer = modal.find("input[name='replyer']");
	    var modalInputReplyDate = modal.find("input[name='replyDate']");
	    
	    var modalModBtn = $("#modalModBtn");
	    var modalRemoveBtn = $("#modalRemoveBtn");
	    var modalRegisterBtn = $("#modalRegisterBtn");
	    
	    $("#modalCloseBtn").on("click", function(e){	    	
	    	modal.modal('hide');
	    });
	    
	    $("#addReplyBtn").on("click", function(e){
	      
	      modal.find("input").val("");
	      modalInputReplyDate.closest("div").hide();
	      modal.find("button[id !='modalCloseBtn']").hide();
	      
	      modalRegisterBtn.show();
	      
	      $(".modal").modal("show");
	      
	    });	    

	    modalRegisterBtn.on("click",function(e){	      
	      var reply = {
	            reply: modalInputReply.val(),
	            replyer: modalInputReplyer.val(),
	            emp_id: emp_idValue
	          };
	      replyService.add(reply, function(result){
	        
	        alert(result);
	        
	        modal.find("input").val("");
	        modal.modal("hide");
	        
	        showList(1);
	        //showList(-1);
	        
	      });	      
	    });
	    
	    
	  //댓글 조회 클릭 이벤트 처리 
	    $(".chat").on("click", "li", function(e){
	      
	      var rno = $(this).data("rno");
	      
	      replyService.get(rno, function(reply){
	      
	        modalInputReply.val(reply.reply);
	        modalInputReplyer.val(reply.replyer);
	        modalInputReplyDate.val(replyService.displayTime( reply.replyDate))
	        .attr("readonly","readonly");
	        modal.data("rno", reply.rno);
	        
	        modal.find("button[id !='modalCloseBtn']").hide();
	        modalModBtn.show();
	        modalRemoveBtn.show();
	        
	        $(".modal").modal("show");
	            
	      });
	    });
	  
	    modalModBtn.on("click", function(e){
	    	  
	     	  var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};
	     	  
	     	  replyService.update(reply, function(result){
	     	        
	     	    alert(result);
	     	    modal.modal("hide");
	     	    showList(pageNum);
	     	    
	     	  });
	     	  
	     	});
	  
	    modalRemoveBtn.on("click", function (e){
	     	  
	     	  var rno = modal.data("rno");
	     	  
	     	  replyService.remove(rno, function(result){
	     	        
	     	      alert(result);
	     	      modal.modal("hide");
	     	      showList(pageNum);
	     	      
	     	  });
	     	  
	     	});//end modalRemoveBtn click
	    
	});
</script> -->

</div>
</body>
</html>



<%@include file="../includes/footer.jsp"%>
