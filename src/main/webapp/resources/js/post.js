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
	
	
	
	function getList(post, callback, error) {

		$.getJSON('/pages/'+type+"/"+ keyword+"/"+ pageNum,
			function(data) {
				if (callback) {
					callback(data);
				}
			}).fail( function(xhr, status, er) {
				if (error) {
					error();
				}
			});
	}
	
	return {
		add:add,
		getList: getList
		};
	
	
	
	
	
})();