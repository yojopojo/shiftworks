<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../board/index.jsp"%>

 <div class="container"> 
 <div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">문서함 메인페이지</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<!--메인페이지 폼-->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		

			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<div class="myDoc">
					<h3><a href="#">내가 쓴 게시물</a></h3>
					<ul class="scrapDoc">
					<iframe class="iframe" src="/WEB-INF/views/document/DOC_mydoclist.jsp"></iframe>
					</ul>
				</div>
				<div class="form-group">
					<h3><a>스크랩</a></h3>
					<ul class="scrapDoc">
					<iframe class="iframe" src="/WEB-INF/views/document/document/DOC_scraplist.jsp"></iframe>
					</ul>
				</div>
				<div class="form-group">
					<h3><a>부서문서함</a></h3>
					<ul class="deptDoc">
					<iframe class="iframe" src="/WEB-INF/views/document/DOC_deptdoclist.jsp"></iframe>
					</ul>
				</div>
				<div class="form-group">
					<ul class="myDoc">
					
					</ul>
				</div>
			
<!-- 메인페이지 폼-->
			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->





<script>
$(document).ready(function(){
	
	$(".myDoc").find("a").on("click", function(e){
		e.preventDefault();
		location.href ="/document//myDoc/1";
	})
	
	
	
	
});
</script>