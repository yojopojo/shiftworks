/**
 * 
 */

var messengerService = (function () {

    var csrf_token = $("meta[name='_csrf']").attr("content");
	var csrf_header = $("meta[name='_csrf_header']").attr("content");

    function getChat(param, callback, error) {
  
        $.ajax({
            type: 'GET',
            url: '/messenger/chat/room/' + param,
            dataType: 'json',
            success: function (data, status, xhr) {
                if (callback) {
                    callback(data);
                }
            },
            error : function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }

        });

    } // end getChat function


    

   function sendChat(chat, callback, error) {
	console.log("chatService.sendChat");
    	
    	$.ajax({
    		type: 'POST',
    		url: '/messenger/send',
    		data : JSON.stringify(chat),
			contentType : 'application/json; charset=utf-8',
    		beforeSend : function(xhr){
                xhr.setRequestHeader(csrf_header, csrf_token);
            },
    		success: function (result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error : function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
    	})
    
        socket.send(chat);    

}



return {
    getChat: getChat,
    sendChat: sendChat
};

}) ();


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
     
//     $(".messages-chat").append("연결");
 }
     
 // 서버와 연결을 끊었을 때
 function onClose(evt) {
     console.log("onClose");
     
 //    $(".messages-chat").append("끊김");
 }
