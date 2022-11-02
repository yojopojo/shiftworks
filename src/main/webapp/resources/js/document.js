console.log("document module...")

var documentService = (function(){

  	//myDoc 게시물 리스트 받아오기
	function getList(param, callback, error) {

	    $.getJSON("/document/myDoc/" + param.pageNum + "/" + param.type +"/"+param.keyword +".json",
	        function(data) {
	    	
	          if (callback) {
	            callback(data);
	            
	          }
	        }).fail(function(xhr, status, err) {
	      if (error) {
	        error();
	      }
	    });
	  
	  }
	  
	  
	  
	  
	  return{
	  getList:getList
	  }


})();