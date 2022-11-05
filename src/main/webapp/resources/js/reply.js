console.log("reply module....");

var replyService = (function(){
	
	function addReply(post, callback, error) {

		$.ajax({
			type : 'post',
			url : '/reply/new',
			data : JSON.stringify(post),
			beforeSend : function(xhr){
                xhr.setRequestHeader(post.csrf_header, post.csrf_token);
            },
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
	
	
	
	
	function getReplyList(param, callback, error) {
		
		var post_id = param.post;
		console.log(post_id);
		
			$.ajax({
			type : 'get',
			url : '/reply/'+post_id+'.json',
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
		addReply:addReply,
		getReplyList:getReplyList
		};
	
	
	
	
	
})();