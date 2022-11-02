console.log("document module...")

var documentService = (function(){

  	
	function getList(param, callback, error) {

	    var page = param.page || 1;
	    
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