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
 <!-- <script
   src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
   integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
   crossorigin="anonymous"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
   integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
   crossorigin="anonymous"></script> -->
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
</head>
<body>
<div class = "container">
<h1>결재문서 작성</h1>

   <form id="insertForm" role="form" action="/approval/insert" method="post"> 
          <div class=""></div>
             <div>
                <label>결재 양식</label> 
                   <select name="af_id">
                      <option value="">선택하세요</option>
                      <option value="1">기안서</option>
                      <option value="2">품의서</option>
                      <option value="3">휴가신청서</option>
                   </select>
              </div>     
            
                      
             <!-- start /.row (파일 추가) -->      
             <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                	<div class="panel-heading"></div>
                    	 <!-- /.panel-heding  -->
                  			<div class="panel-body">
                    			<div class="form-group uploadDiv">
                        			<input type="file" name="uploadFile" multiple />
                    				</div>
                 <div class="uploadResult"> 
                      <ul>
                
                      </ul>
                 </div>
           
                  </div>
                  <!-- end panel body -->   
             </div>
                <!-- end panel body -->
           </div>
           <!-- end panel -->
      	</div>
     	 <!-- /.row -->


             <div >
               <label>작성자</label> 
                  <input class ="form-control" name='emp_id' readonly value="user1">
             </div>
          <div>
            <label>결재명</label> 
               <input class="form-control" name='apr_title'>
          </div>
          
          <div class="form-group">
               <label>결재 내용</label>
                  <textarea class="form-control" rows="3" name='apr_content' ></textarea>
          </div>
          <div>
             <label></label>
                <button id="aprLineBtn" type="button" class="">결재선 추가</button>   
          </div>
          
             <button type="submit" class="btn btn-default">제출하기</button>
             <button id="temporalBtn" type="button" class="btn btn-default">임시저장</button>
             <button id="load" type="button" class="btn btn-default">불러오기</button>
             <a class = "btn btn-default" href="/approval/list" role="button">취소</a>
             
             
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        
        
        
        <!-- 임시저장 모달 구현 -->
      <!-- Modal -->
         <div class="modal" id="myModal">
           <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                       <h4 class="modal-title" id="myModalLabel">임시저장 목록</h4>
                       </div>
               <div class="modal-body">
                  
               </div>
               <div class="modal-footer">
                  <button type="button" class="close" data-dismiss="modal">닫기</button>
                    <!-- <button id='modalRemoveBtn' type="button" class="btn btn-primary">닫기</button> -->
                  </div>         
                </div>
                <!-- /.modal-content -->
           </div>
           <!-- /.modal-dialog -->
         </div>
         <!-- /.modal -->
        
        
        
        
<script type="text/javascript">
      
        /* * * * * * * * * * * * * * * * * * *
              임시저장 관련
      * * * * * * * * * * * * * * * * * * */
        
        $(document).ready(function(){
           
           //임시저장 버튼 클릭 시 임시저장 db저장하기 
           var form = $('#insertForm')
           var temporalBtn = $("#temporalBtn");
           var csrf_token = $("meta[name='_csrf']").attr("content");
           var csrf_header = $("meta[name='_csrf_header']").attr("content");
           
           temporalBtn.on("click",function(e){
              
              e.preventDefault();
              
               var post = {
                       'af_id': form.find('select[name="af_id"]').val(),
                       'emp_id': form.find('input[name="emp_id"]').val(),
                       'temp_title': form.find('input[name="apr_title"]').val(),
                       'temp_content': form.find('textarea[name="apr_content"]').val(),
                       csrf_token:csrf_token,
                       csrf_header:csrf_header
                     };
               
               $.ajax({
                  url:"/approval/temporal",
                  type:'post',
                  data: JSON.stringify(post),
                  beforeSend : function(xhr){
                      xhr.setRequestHeader(post.csrf_header, post.csrf_token);
                  },
                  contentType: "application/json; charSet=UTF-8",
                  success: function(result){
                     alert("임시저장이 완료되었습니다.");
                     self.location="/approval/list"
                  },error: function(xhr){
                     alert("잘못된 요청입니다.")
                     
                  }
                  
               })
           })
           
           // 임시저장 글 목록 모달창으로 불러오기
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
                    // 임시저장 목록(<ul>태그) 반목문으로 출력
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
           
            // 임시저장 모달창 닫기 이벤트
          $("#modalCloseBtn").on("click", function(e){
              $('.modal').modal("hide");
          });
           
          $(".close").on("click", function(e){
              $('.modal').modal("hide");
          }); 
          
          //  불러오기 버튼 누르면 임시저장 DB 목록 가져오기
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
        
        
        /* * * * * * * * * * * * * * * * * * *
          파일 업로드 관련
      * * * * * * * * * * * * * * * * * * */
       /*  $(document).ready(function(e){
        
           var formObj = $("form[role='form']");
           
           $("button[type='submit']").on("click", function(e){
              
              e.preventDefault();
              console.log("submit clicked");
              
           });
        });
        
        var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
         var maxSize = 5242880; //5MB
      
       function checkExtension(fileName, fileSize){
        
           if(fileSize >= maxSize){
              alert("파일 사이즈 초과");
                return false;
           }
        
           if(regex.test(fileName)){
                alert("해당 종류의 파일은 업로드할 수 없습니다.");
                return false;
           }
        
           return true;
         }
         
       var csrfHeaderName = "${_csrf.headerName}"; 
       var csrfTokenValue = "${_csrf.token}";
      
       
       $("input[type='file']").change(function(e){

           var formData = new FormData();
        
           var inputFile = $("input[name='uploadFile']");
        
           var files = inputFile[0].files;
        
          for(var i=0; i < files.length; i++){

                if(!checkExtension(files[i].name, files[i].size)){
                  return false;
                }
                
                formData.append("uploadFile", files[i]);         
          }
        
          $.ajax({
              url: "/uploadAjaxAction",
                processData: false, 
                contentType: false,
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
                },
                data:formData,
                type: "POST",
                dataType:"json",
               success: function(result){
                  console.log(result); 
                  //showUploadResult(result);
                }
           });  // $.ajax  
         });   */
        
        
        
        
        
        
        /* * * * * * * * * * * * * * * * * * *
             결재선 추가 관련
      * * * * * * * * * * * * * * * * * * */
        
       
        <!-- 결재선 모달 구현 -->
      <!-- Modal -->
         /* <div class="modal" id="myModal">
           <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                       <h4 class="modal-title" id="myModalLabel">결재선 선택</h4>
                       </div>
               <div class="modal-body">
                  
               </div>
               <div class="modal-footer">
                  <button id='modalaprLineBtn' type="button" class="btn btn-primary">선택 완료</button>
                  <button type="button" class="close" data-dismiss="modal">닫기</button>
                  </div>         
                </div>
                <!-- /.modal-content -->
           </div>
           <!-- /.modal-dialog -->
         </div>
         <!-- /.modal --> */
        
        
         
         
         
         
        
        
        
        /* * * * * * * * * * * * * * * * * * *
              입력창 유효성 검사
      * * * * * * * * * * * * * * * * * * */
        
      // 결재양식 ,결재명, 결재내용 미선택 시 멘트 출력
      /* $(function(){
         
         $('.check','.form-control').on('change', function(){
            
            var checkText = "";
            var thisVal = $(this).val();   
            
            switch ($(this).attr("name")) {
               case "af_id":
                  if (thisVal == '선택') {
                     checkText = "결재양식을 선택해주세요.";
                  }
                  break;

               case "apr_title":
                  if (thisVal.lengh == 0) {
                     checkText = "결재명을 작성하세요.";
                  } else if (Space_Check.test(thisVal) == true) {
                     checkText = "공백이 들어갈 수 없습니다.";
                  } else if (thisVal.length > 10) {
                     checkText = "10글자 내로 입력해주세요.";
                  }
                  break;
               case "apr_content":   
                  if (thisVal.lengh == 0) {
                     checkText = "결재 내용을 작성하세요.";
                  } else if (Space_Check.test(thisVal) == true) {
                     checkText = "공백이 들어갈 수 없습니다.";
                  } 
                  break;                  
        
                          
               if(checkText != ""){
                  $(this).siblings("p").html(checkText);
                  $(this).siblings("p").addClass("vali");
                  $(this).siblings("p").slideDown();
               } else {
                  $(this).siblings("p").slideUp(function(){
                  $(this).removeClass("vali");
                     });
                   }
                      });
                      
                      
                  });   
               
                 // 유효성 모두 만족
               if($("check").length == 0) {}            
        
            }
             */
            
         
           
           
   
</script>
        
</div>
</body>
</html>