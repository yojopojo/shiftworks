<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shiftworks_messenger</title>

<!-- icon을 사용하기 위함 -->
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Montserrat'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>
<link rel="stylesheet"
	href="../../resources/css/messenger/messenger.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<script type="text/javascript" src="/resources/js/messenger/event.js" />
<script type="text/javascript" src="/resources/js/messenger/sockjs.js" />
<script type="text/javascript" src="/resources/js/messenger/service.js" />
<script type="text/javascript">

$(document).ready(function() {
	/* var socket = null;

	console.log('js start');

	// 전송 버튼 눌렀을 때
	$('.send').on("click", function(e) {
		console.log("btn_send");
		messengerService.sendMessage();
		$('.write-message').val('');
	});
		
	// 메시지를 입력하고 enter 키를 입력했을 때 
	$('.write-message').on("keypress", function(e) {
			
		if(e.keyCode == '13'){
			console.log("btn_send");
			messengerService.sendMessage();
			$('.write-message').val('');
		}
	});	
});
	
var socket = new SockJS('http://localhost:8081/messenger/echo');
	
socket.onmessage = onMessage;
socket.onclose = onClose;
socket.onopen = onOpen;

	
// 서버로부터 메시지를 받았을 때
function onMessage(msg) {
		
	var data = msg.data;
	console.log("onMessage " + data);
	$("#text").append(data + "<br/>");
}
	
// 서버와 연결을 끊었을 때
function onOpen(evt) {
	console.log("onClose");
	
	$("#text").append("연결 끊김");
}
	
// 서버와 연결을 끊었을 때
function onClose(evt) {
	console.log("onClose");
	
	$("#text").append("연결 끊김");
}
	
function sendMessage(){
	console.log("Messenger Module......., sendMessage");
    socket.send($('.write-message').val());
    
    $('.chat').append("dd");
}	 */
</script>
</head>
<body>
	<!-- partial:index.partial.html -->

	<div class="container">
		<div class="row">
			<nav class="menu">
				<ul class="items">
					<!-- <li class="item"><i class="fa fa-home" aria-hidden="true"></i>
					</li> -->
					<li class="item"><i class="fa fa-user" aria-hidden="true"></i>
					</li>
					<!-- <li class="item"><i class="fa fa-pencil" aria-hidden="true"></i>
					</li> -->
					<li class="item item-active"><i class="fa fa-commenting"
						aria-hidden="true"></i></li>
					<li class="item"><i class="fa fa-folder-o" aria-hidden="true"></i>
					</li>
					<!-- 	<li class="item"><i class="fa fa-cog" aria-hidden="true"></i>
					</li> -->
				</ul>
			</nav>

			<!-- 왼쪽 : 채팅방 목록 -->
			<!-- 검색창 -->
			<section class="discussions">
				<div class="discussion search">
					<div class="searchbar">
						<i class="fa fa-search" aria-hidden="true"></i> <input type="text"
							placeholder="Search..."></input>
					</div>
				</div>
				
				<!-- ChatRoom DB에서 채팅방 리스트 출력 -->
				<c:forEach items="${chatRoomList}" var="chatRoom">
		
					<div class="discussion" id="${chatRoom.room_id }" >
						<div class="photo"
							style="background-image: url(http://e0.365dm.com/16/08/16-9/20/theirry-henry-sky-sports-pundit_3766131.jpg?20161212144602);">
							<div class="online"></div>
						</div>
						<div class="desc-contact">
							<p class="name">${chatRoom.room_name }</p>
							<p class="message">${chatRoom.lastchat }</p>
						</div>
						<div class="timer" id="timer_${chatRoom.room_id }"></div>
						<script type="text/javascript">
							
							var time = '${chatRoom.lastchat_time }';
							var lastchat = new Date(time).toISOString();
							
							var timeago = moment(lastchat).fromNow();
							console.log(timeago);
							
							document.getElementById("timer_${chatRoom.room_id }").innerText = timeago;
					
						</script>
						
					</div>
				</c:forEach>
			</section>


			<section class="chat">
				<div class="header-chat">
					<i class="icon fa fa-user-o" aria-hidden="true"></i>
					<p class="name"></p>
					<i class="icon clickable fa fa-ellipsis-h right" aria-hidden="true"></i>
				</div>


				<div class="messages-chat">
					<div class="message">
						<div class="photo"
							style="background-image: url(https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80);">
							<div class="online"></div>
						</div>
						<p class="text">Hi, how are you ?</p>
					</div>
					<div class="message text-only">
						<p class="text">What are you doing tonight ? Want to go take a
							drink ?</p>
					</div>
					<p class="time">14h58</p>
					<div class="message text-only">
						<div class="response">
							<p class="text">Hey Megan ! It's been a while 😃</p>
						</div>
					</div>
					<div class="message text-only">
						<div class="response">
							<p class="text">When can we meet ?</p>
						</div>
					</div>
					<p class="response-time time">15h04</p>
					<div class="message">
						<div class="photo"
							style="background-image: url(https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80);">
							<div class="online"></div>
						</div>
						<p class="text">9 pm at the bar if possible 😳</p>
					</div>
					<p class="time">15h09</p>
				</div>
				<div class="footer-chat">
					<i class="icon fa fa-paperclip clickable" style="font-size: 25pt;"
						aria-hidden="true"></i> <input type="text" class="write-message"
						placeholder="Type your message here"></input> <i
						class="icon send fa fa-paper-plane-o clickable" aria-hidden="true"></i>
				</div>
			</section>
		</div>
	</div>
</body>
</html>
