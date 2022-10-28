console.log("schedule.js........");

// 즉시 실행 함수(프로퍼티를 갖는 객체로 리턴)
// 일정 CRUD, 일정 검색
var scheduleService = (function(){

  
    // 리스트 불러오기
    function getList(param, callback) {

        $.ajax({
            type: 'get',
            url: '/schedule/' + param.sch_group + "/" + param.selectedDate,
            success: function(result) {
                callback(result)
            }
        })
    } // end function getList()


    // 일정 검색
    function search(param, callback) {
        $.ajax({
            type: 'get',
            url: '/schedule/search/' + param,
            success: function(result) {
                callback(result)
            }
        })
    } // end function search()

    // 일정 상세 보기
    function getSchedule(param, callback) {
        $.ajax({
            type: 'get',
            url: '/schedule/' + param,
            success: function(result) {
                callback(result)
            }
        })
    } // end function getSchedule()

    // 일정 등록
    function insertSchedule(param, callback) {
        $.ajax({
            type: 'post',
            url: '/schedule/new',
            data: JSON.stringify(param),
            contentType : "application/json; charset=utf-8",
            success : function(result) {
                callback(result);
            }
        })
    } // end function insertschedule()

    // 일정 수정
    function updateSchedule(param, callback) {
        $.ajax({
            type: 'put',
            url: '/schedule/' + param,
            data: JSON.stringify(param),
            contentType : "application/json; charset=utf-8",
            success : function(result) {
                callback(result);
            }
        })
    } // end function updateSchedule()

    // 일정 삭제
    function deleteSchedule(param, callback) {
        $.ajax({
            type: 'delete',
            url: '/schedule/' + param,
            success : function(result) {
                callback(result);
            }
        })
    } // end function deleteSchedule()

    // 메모 가져오기
    function getMemo(callback) {
        $.ajax({
            type: 'get',
            url: '/schedule/memo',
            success: function(result) {
                callback(result);
            }
        })
    } // end function getMemo()

    // 메모 업데이트
    function updateMemo(param, callback) {
        $.ajax({
            type: 'put',
            url: '/schedule/memo',
            data: JSON.stringify(param),
            contentType : "application/json; charset=utf-8",
            success: function(result) {
                callback(result);
            }
        })
    } // end function updateMemo()

    return {
        getList: getList,
        search: search,
        getSchedule: getSchedule,
        insertSchedule: insertSchedule,
        updateSchedule: updateSchedule,
        deleteSchedule: deleteSchedule,
        getMemo: getMemo,
        updateMemo: updateMemo
    };

})();

