/**
 * sockjs
 * 소켓 통신과 관련된 이벤트
 */
 
 
 var socket = new SockJS('http://localhost:8081/messenger/chat');
     
 socket.onmessage = onMessage;
 socket.onclose = onClose;
 socket.onopen = onOpen;
 

 // 서버로부터 메시지를 받았을 때
 function onMessage(msg) {		
     var data = msg.data;
     printChat(msg);
     console.log("onMessage " + data);
    // $(".messages-chat").append(data + "<br/>");
 }
   
 // 서버와 연결되었을때
 function onOpen(evt) {
     console.log("onOpen");
     
     //$(".messages-chat").append("연결" + "<br/>");
 }
     
 // 서버와 연결을 끊었을 때
 function onClose(evt) {
     console.log("onClose");
     
     //$(".messages-chat").append("끊김" + "<br/>");
 }
     