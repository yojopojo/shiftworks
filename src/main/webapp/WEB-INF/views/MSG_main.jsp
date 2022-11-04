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

<link rel="stylesheet" href="../../resources/css/messenger/messenger.css">

<!-- icon을 사용하기 위함 -->
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Montserrat'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>


<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<link rel="stylesheet" href="../../resources/css/messenger/messenger.css">

<script type="text/javascript" src="../../resources/js/messenger/service.js" />
<script type="text/javascript" src="../../resources/js/messenger/sockjs.js" />
<!-- <script type="text/javascript" src="../../resources/js/messenger/event.js" /> -->
<script type="text/javascript"></script>
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
						
							if(time != ""){
								console.log("시간 : " + time);
								var lastchat = new Date(time);
								
								var timeago = moment(lastchat).fromNow();
								console.log(timeago);
							
								document.getElementById("timer_${chatRoom.room_id }").innerText = timeago;
							}
							
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
					<!-- <div class="message">
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
					<p class="time">15h09</p> -->
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
	
	
<script type="text/javascript">

$(document).ready(function() {
	
	
    var socket = null;
    
    console.log('js start');
    
    // 즉시 실행 함수 : 채팅방이 선택되지 않았을 때 채팅 내용이 보이지 않도록 함
    var init = function(){
    	$('.chat').hide();
    	 $('.timer').each(function(index, item){
      		if($('.timer').text != ""){
      			console.log($(item).text());
      		}else{
      			console.log("e");
      		}
      	
      	});
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
    	 $('.chat').fadeOut().fadeIn().show();
    	 $('.timer').css('font-size', '9px');
    	 console.log("room_id : " + $(this).attr("id"));
    	 
    	  // 지난 채팅 내역 가져옴
    	 messengerService.getChat(parseInt($(this).attr("id")), function(data){
    	 	if(data != null){
    	 		console.log(data);
    		 	for(var i = 0; i < data.length; i++){
    		 		
    		 		//if(data[i].emp_id != )
    		 		var content = '<div class="message" id="msg_'+ data[i].chat_id + '">' +
    		 		'<div class="photo" style="background-image: url(https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80);">' +
    		 		'<div class="online"></div></div>' + 
    		 		'<p class="text">'+ data[i].content + '</p>	</div>';
    		 		
    		
    		 		$(".messages-chat").append(content);
    		 		
    		 		//data[i].sendtime;
    		 			
    	 		}
    	 	
    	 		$('.chat .header-chat .name').empty().append(data[0].chatRoom.room_name);
    	 	}
    	 });  
    });
    
});
    
</script>
</body>
</html>
