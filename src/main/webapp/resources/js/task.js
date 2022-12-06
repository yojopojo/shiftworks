var taskService = (function(){

    var csrf_token = $("meta[name='_csrf']").attr("content");
	var csrf_header = $("meta[name='_csrf_header']").attr("content");
    
    // 업무 리스트 불러오기
    function getList(param, callback, error) {

        $.ajax({
            type: 'get',
            url: "/task/pages/" + param.dept_id + "/" + param.type + "/" + param.keyword
                + "/" + param.pageNum,
            success: function(result) {
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
    } // end function getList()

    // 일정 상세 보기
    function getTask(param, callback, error) {
        $.ajax({
            type: 'get',
            url: "/task/pages/" + param.dept_id + "/" + param.type + "/" + param.keyword
            + "/" + param.pageNum + "/" + param.task_id,
            success: function(result) {
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
    } // end function getTask()

    // 일정 등록
    function insertTask(param, callback, error) {
       
        $.ajax({
            type: 'post',
            url: "/task/new",
            data: JSON.stringify(param),
            beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
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
    } // end function insertTask()

    // 일정 수정
    function updateTask(param, callback, error) {
        $.ajax({
            type: 'put',
            url: "/task/pages/" + param.dept_id + "/" + param.type + "/" + param.keyword
            + "/" + param.pageNum + "/" + param.task_id,
            data: JSON.stringify(param),
            beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
            },
            contentType : "application/json; charset=utf-8",
            success: function(result) {
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
    } // end function updateTask()

    // 일정 삭제
    function deleteTask(param, callback, error) {
        $.ajax({
            type: 'delete',
            url: "/task/" + param,
            beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
            },
            success: function(result) {
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
    } // end function deleteTask()

    return {
        getList: getList,
        getTask: getTask,
        insertTask: insertTask,
        updateTask: updateTask,
        deleteTask: deleteTask
    }
})();