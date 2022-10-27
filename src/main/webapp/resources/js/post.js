console.log("Post module..");

var postService = (function(){
	
	function add(post, callback, error) {

		$.ajax({
			type : 'post',
			url : '/board/new',
			data : JSON.stringify(post),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		})
	}
	
	
	
	  
	  
	  
	  
	
	
	function getListWithSearch(post, callback, error) {
		
		console.log('/board/pages/'+post.pageNum +'/' +post.type+'/'+post.keyword);
		$.ajax({
			type : 'post',
			url : '/board/pages/'+post.pageNum +'/' +post.type+'/'+post.keyword+".json",
			data : JSON.stringify(post),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		})
	}
	
	

	return {
		add:add,
		getListWithSearch:getListWithSearch
		};
	
	
	
	
	
})();