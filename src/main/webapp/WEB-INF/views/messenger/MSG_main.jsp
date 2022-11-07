<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />


<title>Shiftworks_messenger</title>

<!-- icon을 사용하기 위함 -->
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Montserrat'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>

<!-- JQuery 라이브러리 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- autocomplete  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- timeago 라이브러리 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.js"></script>

<!-- socket 라이브러리 -->
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<!-- 실시간 검색을 위한 라이브러리 -->
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

  
<!-- custom style -->
<link rel="stylesheet" href="/resources/css/messenger.css">

<script type="text/javascript" src="/resources/js/messenger/service.js" />
<script type="text/javascript" src="/resources/js/messenger/sockjs.js" />
<!-- <script type="text/javascript" src="../../resources/js/messenger/event.js" /> -->

<script type="text/javascript"></script>
</head>
<body class="container">
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

					<div class="discussion" id="${chatRoom.room_id }">
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
							}else{
								$('.discussion .timer').hide();
							}
							
						</script>

					</div>
				</c:forEach>
			</section>


			<section class="chat">
				<div class="header-chat">
					<i class="icon fa fa-user-o" aria-hidden="true"></i>
					<p class="name" id="name"></p>
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
					<i class="icon fa fa-paperclip clickable" style="font-size: 25pt;" aria-hidden="true"></i> 
					<input type="text" class="write-message" placeholder="Type your message here"></input> 
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<i class="icon send fa fa-paper-plane-o clickable" aria-hidden="true"></i>
				</div>
			</section>
		</div>
	</div>


	<sec:authentication property="principal.username" var="login_id" />



	<script type="text/javascript">

$(document).ready(function() {

	// 로그인된 사번 
	var login_id = "<c:out value='${login_id}'/>";
	
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
		sendEvent();
    });
 
    
    // 메시지를 입력하고 enter 키를 입력했을 때 메시지 전송
    $('.write-message').on("keypress", function(e) {
            
        if(e.keyCode == '13'){
            console.log("btn_send");
            sendEvent();
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
    	
    	// 각각의 채팅방 목록에 클릭 이벤트 추가
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
    	 $('.chat').hide().fadeIn(500).show();
    	 $('.timer').css('font-size', '9px');
    	 console.log("room_id : " + $(this).attr("id"));
    	 
    	 // 선택된 채팅방의 지난 채팅 내역 가져옴
    	 messengerService.getChat(parseInt($(this).attr("id")), function(data){
 
    		$('.messages-chat').empty(); 
    		
    	 	if(data != null){
    	 		console.log(data);
    		 	for(var i = 0; i < data.length; i++){
    		 		printChat(data[i]);
    		 	}
    	 		$('.chat .header-chat .name').empty().append(data[0].chatRoom.room_name); 
    	 	}
    	 });  
    });
    
    
  /*   $('.search').autocomplete({
    	source:function(request, response){
    		
    		$.ajax({
    			type: 'get',
    			url: '/messenger/chat',
    			dataType: 'json'
    			
    		})
    		
    	}
    })	//end search
     */
    function sendEvent(){
    	// 채팅 내용 가져오기
        var content =  $('.write-message').val();
        console.log("전송 버튼 클릭 이벤트 : content : " + content);
       
        if(content != ""){
        // room_id 가져오기
        var room_id = $('.chat .header-chat .name').attr('id').substr(5);
        console.log("전송 버튼 클릭 이벤트 : room_id : " + room_id);
        
        // 현재 시간 구하기
        const d = new Date();
		const timestamp = new Date(+d + 3240 * 10000).toISOString().replace('T', ' ').replace(/\..*/, '');
        console.log("전송 버튼 클릭 이벤트 : sendtime : " + timestamp);	
        
        
        
        var chat = {
	            content: $('.write-message').val(),
	            sendtime: timestamp,
	            sender: login_id,
	            room_id: room_id
	          };
     
        messengerService.sendChat(chat, function(result){
        	console.log("메시지 전송 결과 : " + result);
        	
        	if(result == 'success'){       		
        		printChat(chat);
        	}
        	
        });
        
        // 채팅 입력창 비우고 포커스
        $('.write-message').val('').focus();

        }
        
        var vScrollDown = $('.messages-chat').prop('scrollHeight');
    	$('messages-chat').scrollTop(vScrollDown);
    }
    
 function printChat(chat){
	 
	 $('.chat .header-chat .name').attr('id', "chat_" + chat.room_id);
	 
	 // 채팅 내용이 있을 때만 출력
	 if(chat.content != null){

			// 상대방의 채팅 내용
		if(chat.sender != login_id){
			var content = '<div class="message" id="msg_'+ chat.chat_id + '">' +
			'<div class="photo" style="background-image: url(https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80);">' +
			'<div class="online"></div></div>' + 
			'<p class="text">'+ chat.content + '</p>	</div>' +
			'<p class="time">' + chat.sendtime.substr(0,16) + '</p>';
			$(".messages-chat").append(content);
		 		
	 	}else{	// 나의 채팅 내용
	 		var content = '	<div class="message text-only">' +
	 			'<div class="response">' +
	 			'<p class="text">'+ chat.content +'</p>' +
	 			'</div></div>' +
	 			'<p class="response-time time">' + chat.sendtime.substr(0,16) + '</p>';
	 		$(".messages-chat").append(content);
	 	}
			
		$(".messages-chat").animate({ scrollTop: $(".messages-chat")[0].scrollHeight });
	}
}
 
});


</script>
</body>
</html>
