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
<meta charset="UTF-8">
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
          	<option value="2">품의서</option>
          	<option value="3">휴가신청서</option>
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
          <button id="temporalBtn" type="submit" class="btn btn-default">임시저장</button>
        </form>
        
        
        
        	<!-- 임시저장 모달 구현 -->
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
        
        
        
        
        <script type="text/javascript">
        
        
	     //임시저장 버튼 클릭 시 임시저장 db저장하기 
	  /*  var temporalBtn = $("#temporalBtn");
	 
	    temporalBtn.on("click",function(){
	    	
	    	 var post = {
	 	            b_id: formInputBoard.val(),
	 	            post_name:formInputTitle.val(),
	 	            emp_id:formInputEmp.val(), //추후 로그인 세션으로 변경예정 
	 	            dept_id:formInputDept.val(),
	 	            post_content:formInputContent.val()
	 	          };
	    	 
	    	 postService.temporalPost(post, function(result){
	    		 alert("임시저장되었습니다");
	    		 form.find("input").val(""); 
	    		 form.find("textarea").val(""); 
	    		 location.href="/approval/list";
	    	 })
	    })
		
	    	
	  
}); */
        
        
        </script>
        

</body>
</html>