/**
 * 
 */
 document.write("<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js'><"+"/script>");

 console.log("Messenger Module.......");
     
 $(document).ready(function() {
     var socket = null;
 
     console.log('js start');
     
     // 즉시 실행 함수 : 채팅방이 선택되지 않았을 때 채팅 내용이 보이지 않도록 함
     var init = function(){
     	$('.chat').hide();
     
     }();
 
     // 전송 버튼 눌렀을 때 메시지 전송
     $('.send').on("click", function(e) {
         console.log("btn_send");
         messengerService.sendMessage();
         $('.write-message').val('').focus();
     });
         
     // 메시지를 입력하고 enter 키를 입력했을 때 메시지 전송
     $('.write-message').on("keypress", function(e) {
             
         if(e.keyCode == '13'){
             console.log("btn_send");
             messengerService.sendMessage();
             $('.write-message').val('').focus();
         }
     });
     
     // 메뉴를 눌렀을 때
     $('.menu .items .item').on("click", function(e){
     
     	 $('.menu .items .item').each(function(index, element){
     	 	$(element).attr("class", "item");
     	 });
     	 
     	 $(this).attr("class", "item item-active");
     
     });
     
      
     // 채팅방 눌렀을 때
     $('.discussions .search').nextAll().on("click", function(e){
     	
     	// 각각의 채팅방 목록에 이벤트 추가
     	 $('.discussion').each(function(index, item){
     	 	
     	 	// 검색창이 있는 div에 이벤트 방지를 위한 조건
     	 	var classValue = $(item).attr("class");
     	 	if(classValue == 'discussion search'){     	 	
     	 		$(item).attr("class", "discussion search");
     	 	}else{
     	 		$(item).attr("class", "discussion");
     	 	}
     	 });
     	 
     	 // 검색창이 있는 div에 이벤트 방지를 위한 조건문
     	 // 선택된 채팅방에 선택 표시
     	 if($(this).attr("class") != 'discussion search'){ 
     		$(this).attr("class", "discussion message-active");
     		
     	 }
     	 
     	 // 채팅방의 크기 줄이고, 채팅 내용을 보여줌
     	 $('.discussions').css('width', '35%');
     	 $('.chat').fadeIn().show();
     	 $('.timer').css('font-size', '9px');
     	 
     	 
     	 // ajax로 채팅방 정보 가져오기
     	 $ajax
     });
    
 });
     
 var socket = new SockJS('http://localhost:8081/messenger/chat');
     
 socket.onmessage = onMessage;
 socket.onclose = onClose;
 socket.onopen = onOpen;
 
     
 // 서버로부터 메시지를 받았을 때
 function onMessage(msg) {		
     var data = msg.data;
     console.log("onMessage " + data);
     $(".messages-chat").append(data + "<br/>");
 }
     
 // 서버와 연결되었을때
 function onOpen(evt) {
     console.log("onOpen");
     
     $(".messages-chat").append("연결");
 }
     
 // 서버와 연결을 끊었을 때
 function onClose(evt) {
     console.log("onClose");
     
     $(".messages-chat").append("연결 끊김");
 }
     
     
 var messengerService = (function(){

     function sendMessage(){
        var message = $('.write-message').val();
        if(message != ""){
            socket.send(message);
        }
        //  console.log("Messenger Module......., sendMessage");
        //  var message = $('.write-message').val();
        //  if(message != ""){
        //      //socket.send(message);
        //      $.ajax({
        //          type : 'post',
        //          url : '/message/send',
        //          data : 
                 
        //      })
        }
    
     
 
     function add(reply, callback, error) {
         console.log("add reply...............");
 
         $.ajax({
             type : 'post',
             url : '/replies/new',
             data : JSON.stringify(reply),
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
     }//end add function
     
     function getList(param, callback, error) {
 
         var bno = param.bno;
         var page = param.page || 1;
 
         $.getJSON("/replies/pages/" + bno + "/" + page,
                 function(data) {
                     if (callback) {
                         //callback(data);
                         callback(data.replyCnt, data.list);
                     }
                 }).fail(function(xhr, status, err) {
             if (error) {
                 error();
             }
         });
    }//end getList function
    
    function remove(rno, callback, error) {
         $.ajax({
             type : 'delete',
             url : '/replies/' + rno,
             success : function(deleteResult, status, xhr) {
                 if (callback) {
                     callback(deleteResult);
                 }
             },
             error : function(xhr, status, er) {
                 if (error) {
                     error(er);
                 }
             }
         });
     }//end remove function
     
     function update(reply, callback, error) {
 
         console.log("RNO: " + reply.rno);
 
         $.ajax({
             type : 'put',
             url : '/replies/' + reply.rno,
             data : JSON.stringify(reply),
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
         });
     }
     
     
     function get(rno, callback, error) {
 
         $.get("/replies/" + rno, function(result) {
 
             if (callback) {
                 callback(result);
             }
 
         }).fail(function(xhr, status, err) {
             if (error) {
                 error();
             }
         });
     }//end get function
    
    
    
    function displayTime(timeValue) {
 
         var today = new Date();
 
         var gap = today.getTime() - timeValue;
 
         var dateObj = new Date(timeValue);
         var str = "";
 
         if (gap < (1000 * 60 * 60 * 24)) {
 
             var hh = dateObj.getHours();
             var mi = dateObj.getMinutes();
             var ss = dateObj.getSeconds();
 
             return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
                     ':', (ss > 9 ? '' : '0') + ss ].join('');
 
         } else {
             var yy = dateObj.getFullYear();
             var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
             var dd = dateObj.getDate();
 
             return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
                     (dd > 9 ? '' : '0') + dd ].join('');
         }
     };
     
     
     return {
         add: add,
         getList: getList,
         displayTime: displayTime,
         remove: remove,
         get: get,
         update: update,
         sendMessage: sendMessage
     };
 
 })();