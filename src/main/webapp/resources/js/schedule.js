
//
$(document).ready(function(){

    // 즉시 실행 함수(프로퍼티를 갖는 객체로 리턴)
    // 일정 CRUD, 일정 검색
    var scheduleService = function(){

        
    // 리스트 불러오기
    function getList(param, callback) {

        // new Date()를 통해 현재 시스템 날짜 받아오기
        var today = new Date();

        // 받아온 시각을 원하는 형태로 변경('yyyy-MM-dd')
        var today = new Date();

        var year = today.getFullYear();
        var month = ('0' + (today.getMonth() + 1)).slice(-2);
        var day = ('0' + today.getDate()).slice(-2);

        var selectedDate = year + '-' + month  + '-' + day;

        // 별도로 출력 날짜를 지정한 경우
        if(param.selectedDate) {
            selectedDate = param.selectedDate;
        }

        // 선택된 그룹이 없을 경우
        if(typeof param.sch_group === 'undefined') {
            param.sch_group = 'all';
        }

        $.ajax({
            type: 'get',
            url: '/schedule/' + param.sch_group + "/" + param.selectedDate,
            success: callback(result)
        })
    } // end function getList()


    // 일정 검색
    function search(param, callback) {
        $.ajax({
            type: 'get',
            url: '/schedule/search/' + param,
            success: callback(result)
        })
    } // end function search()

    // 일정 상세 보기
    function getSchedule(param, callback) {
        $.ajax({
            type: 'get',
            url: '/schedule/' + param,
            success: callback(result)
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
                alert(result);
                location.href="redirect:/schedule/";
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
                alert(result);
                location.href="redirect:/schedule/";
            }
        })
    } // end function updateSchedule()


        return {
            getList: getList,
            search: search,
            getSchedule: getSchedule,
            insertSchedule: insertSchedule,
            updateSchedule: updateSchedule
        }
    }();
})


