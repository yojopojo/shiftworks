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
	<h1>결재문서 작성</h1>
	<form id="insertForm" role="form" action="/approval/insert" method="post">
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
          <button id="temporalBtn" type="button" class="btn btn-default">임시저장</button>
          <button id="load" type="button">불러오기</button>
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
						
            		</div>
					<div class="modal-footer">
        				<button id='modalRemoveBtn' type="button" class="btn btn-primary">닫기</button>
      				</div>         
       		</div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
        
        
        
        
        <script type="text/javascript">
      
        
        
        $(document).ready(function(){
        	
        	//임시저장 버튼 클릭 시 임시저장 db저장하기 
        	var form = $('#insertForm')
    	    var temporalBtn = $("#temporalBtn");
    	 
    	    temporalBtn.on("click",function(e){
    	    	
    	    	e.preventDefault();
    	    	
    	    	 var post = {
    	 	            'af_id': form.find('select[name="af_id"]').val(),
    	 	            'emp_id': form.find('input[name="emp_id"]').val(),
    	 	            'temp_title': form.find('input[name="apr_title"]').val(),
    	 	            'temp_content': form.find('textarea[name="apr_content"]').val(),
    	 	          };
    	    	 
    	    	 $.ajax({
    	    		 url:"/approval/temporal",
    	    		 type:'post',
    	    		 data: JSON.stringify(post),
    	    		 contentType: "application/json; charSet=UTF-8",
    	    		 success: function(result){
    	    			 alert("임시저장이 완료되었습니다.");
    	    			 self.location="/approval/list"
    	    		 },error: function(xhr){
    	    			 alert("잘못된 요청입니다.")
    	    			 
    	    		 }
    	    		 
    	    	 })
    	    })
    	    
    	    var modal = $(".modal");
    	    
    	    $('#load').on('click',function(e){

    	    	e.preventDefault();
    	    	
    	    	$.ajax({
    	    		url:"/approval/tempList?emp_id=" + form.find('input[name="emp_id"]').val(),
    	    		type: 'get',
    	    		success:function(result){
    	    			console.log(result)
    	    			
    	    			var body = $('.modal-body');
    	    			
    	    			// 모달 바디 초기화
    	    			body.empty();
    	    			body.append("<ul>")
    	    			$.each(result, function(index, item){
    	    				console.log(item)
    	    				var str = '<li><a href="/approval/tempSelect/' +item.temp_id +'" class="tempBtn">' + 	    				
    	    				 item.temp_title + '</a></li>';
    	    				body.append(str);
    	    			})
    	    			body.append("</ul>")
    	    		}
    	    	})

			    $(".modal").modal("show")

    	    })
    	    
			   // 모달창 닫기 이벤트
		    $("#modalCloseBtn").on("click", function(e){
		        $('.modal').modal("hide");
		    });
    	    
		    $(".close").on("click", function(e){
		        $('.modal').modal("hide");
		    }); 
    		
            $(document).on("click", ".tempBtn", function(e) {
            	e.preventDefault();
                
            	$.ajax({
            		url:$(this).attr('href'),
            		type:'get',
            		success:function(result){
            			console.log(result)
            			form.find('select[name="af_id"]').val(result.af_id)
    	 	            form.find('input[name="emp_id"]').val(result.emp_id)
    	 	            form.find('input[name="apr_title"]').val(result.temp_title)
    	 	            form.find('textarea[name="apr_content"]').val(result.temp_content)
    	 	            alert("불러오기 완료")
    			        $('.modal').modal("hide");
            		}
            	})
            });
    	    	
    	  
    }); 
        	
        	
        	

        
        
        
	   
        
        
</script>
        

</body>
</html>