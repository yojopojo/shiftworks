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
<link rel="stylesheet" href="/resources/css/approval.css">
<meta charset="UTF-8">
<title>전자결재 메인</title>
</head>
<body>
			<div class="container">
			  <div class="row">
			    <div class="col">결재문서작성
			    	<div class="list-group">
			    		 <ul class="list-group list-group-flush">
			    		  	<a href="/approval/insert" class="list-group-item ">기안서 작성</a>
			    		  	<a href="/approval/insert" class="list-group-item ">품의서 작성</a>
			    		  	<a href="/approval/insert" class="list-group-item ">휴가신청서 작성</a>
			    		  	<a href="/approval/temporal" class="list-group-item ">임시저장 목록 불러오기</a>
						</ul>
			    	</div>
			    </div>
			    <!-- end of 결재문서작성  -->
			    
			    <div class="col">
				    <ul class="list-group">
	  					<a href="#" class="list-group-item d-flex justify-content-between align-items-center"/>
	   					 	테스트
	    					<span class="badge bg-primary rounded-pill">14</span>
	  					</a>
	  					<li class="list-group-item d-flex justify-content-between align-items-center">
	   					 	결재가 필요한 문서
	    					<span class="badge bg-primary rounded-pill">14</span>
	  					</li>
	  					<li class="list-group-item d-flex justify-content-between align-items-center">
	    					결재 중인 문서
	    					<span class="badge bg-primary rounded-pill">2</span>
	 					</li>
	  					<li class="list-group-item d-flex justify-content-between align-items-center">
	  						 반려된 문서
	    					<span class="badge bg-primary rounded-pill">1</span>
	 					</li>
					</ul>			    
			    </div>
			    <!-- end of 결재 상태 세부 목록 뷰 --> 
			  </div>
			  <!-- end of  main 가로 전체 -->
			  
			  <div class="row" id ="row2">
			    <div class="col">결재할 문서
			    	<div class="list-group">
	  					<a href="approval/get/${apr_id}" class="list-group-item" aria-current="true">
	   						 <div class="d-flex w-100 justify-content-between">
	     						 <h5 class="mb-1">List group item heading</h5>
	     							 <small>3 days ago</small>
	   				 		</div>
	    						<p class="mb-1">Some placeholder content in a paragraph.</p>
	    							<small>And some small print.</small>
	 					</a>
 					</div>			    			    
			    </div>
			    <!-- end of 결재할 문서 디테일 뷰 -->
			    
			    <div class="col">
			    	<label for="customRange3" class="form-label">결재 진행 상태</label>
						<input type="range" class="form-range" min="0" max="5" step="0.5" id="customRange3">
			    </div>
			  </div>
			</div>
</body>
</html>