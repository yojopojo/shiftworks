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
	
	
	function scrapPost(post, callback, error) {
		
	
		$.ajax({
			type : 'post',
			url : '/board/scrap',
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
	
	
	
	function temporalPost(post, callback, error) {
		
	
		$.ajax({
			type : 'post',
			url : '/board/temporal',
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
		scrapPost:scrapPost,
		temporalPost:temporalPost
		};
	
	
	
	
	
})();