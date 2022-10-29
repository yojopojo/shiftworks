console.log("reply module....");

var replyService = (function(){
	
	function addReply(post, callback, error) {

		$.ajax({
			type : 'post',
			url : '/reply/new',
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
	
	
	
	
	function getReplyList(post, callback, error) {

		$.ajax({
			type : 'get',
			url : '/reply/'+post_id,
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
		addReply:addReply
		};
	
	
	
	
	
})();