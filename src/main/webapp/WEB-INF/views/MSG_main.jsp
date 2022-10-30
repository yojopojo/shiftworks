<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
<!-- JQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	
	
	
<link rel="stylesheet" href="../../resources/css/messenger/messenger.css">
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

			<!-- 채팅방 목록 -->
			<section class="discussions">
				<div class="discussion search">
					<div class="searchbar">
						<i class="fa fa-search" aria-hidden="true"></i> <input type="text"
							placeholder="Search..."></input>
					</div>
				</div>
				<div class="discussion message-active">
					<div class="photo"
						style="background-image: url(https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80);">
						<div class="online"></div>
					</div>
					<div class="desc-contact">
						<p class="name">Megan Leib</p>
						<p class="message">9 pm at the bar if possible 😳</p>
					</div>
					<div class="timer">12 sec</div>
				</div>

				<div class="discussion">
					<div class="photo"
						style="background-image: url(http://e0.365dm.com/16/08/16-9/20/theirry-henry-sky-sports-pundit_3766131.jpg?20161212144602);">
						<div class="online"></div>
					</div>
					<div class="desc-contact">
						<p class="name">Dave Corlew</p>
						<p class="message">Let's meet for a coffee or something today
							?</p>
					</div>
					<div class="timer">3 min</div>
				</div>

				<div class="discussion">
					<div class="photo"
						style="background-image: url(https://images.unsplash.com/photo-1497551060073-4c5ab6435f12?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=667&q=80);">
					</div>
					<div class="desc-contact">
						<p class="name">Jerome Seiber</p>
						<p class="message">I've sent you the annual report</p>
					</div>
					<div class="timer">42 min</div>
				</div>

				<div class="discussion">
					<div class="photo"
						style="background-image: url(http://thomasdaubenton.xyz/portfolio/images/photo.jpg);">
						<div class="online"></div>
					</div>
					<div class="desc-contact">
						<p class="name">Thomas Dbtn</p>
						<p class="message">See you tomorrow ! 🙂</p>
					</div>
					<div class="timer">2 hour</div>
				</div>

				<div class="discussion">
					<div class="photo"
						style="background-image: url(https://images.unsplash.com/photo-1553514029-1318c9127859?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80);">
					</div>
					<div class="desc-contact">
						<p class="name">Elsie Amador</p>
						<p class="message">What the f**k is going on ?</p>
					</div>
					<div class="timer">1 day</div>
				</div>

				<div class="discussion">
					<div class="photo"
						style="background-image: url(https://images.unsplash.com/photo-1541747157478-3222166cf342?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=967&q=80);">
					</div>
					<div class="desc-contact">
						<p class="name">Billy Southard</p>
						<p class="message">Ahahah 😂</p>
					</div>
					<div class="timer">4 days</div>
				</div>

				<div class="discussion">
					<div class="photo"
						style="background-image: url(https://images.unsplash.com/photo-1435348773030-a1d74f568bc2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1050&q=80);">
						<div class="online"></div>
					</div>
					<div class="desc-contact">
						<p class="name">Paul Walker</p>
						<p class="message">You can't see me</p>
					</div>
					<div class="timer">1 week</div>
				</div>
			</section>


			<section class="chat">
				<div class="header-chat">
					<i class="icon fa fa-user-o" aria-hidden="true"></i>
					<p class="name">Megan Leib</p>
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
						class="icon send fa fa-paper-plane-o clickable" id="send" aria-hidden="true"></i>
				</div>
			</section>
		</div>
	</div>
	
	<script type="text/javascript" src="/resources/js/messenger/messenger.js"/>
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"/>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#send').on("click", function(e) {
			messengerService.sendMessage();
			$('.write-message').val('');
		});
	});
	
	var sock = new SockJS('http://localhost:8081/messenger/echo');
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	sock.onopen = onOpen;

	  function onMessage(msg){
	        var data = msg.date;
	        var sessionId = null; // 데이터를 보낸 사람
	        var message = null;

	        var arr = date.script(":");

	        for(var i=0; i<arr.length; i++){
	            console.log('arr[' + i + ']: ' + arr[i]);
	        }
	        
	        var cur_session = '${userid}'; //현재 세션에 로그인 한 사람
	        console.log("cur_session : " + cur_session);
	        
	        sessionId = arr[0];
	        message = arr[1];
	        
	        //로그인 한 클라이언트와 타 클라이언트를 분류하기 위함
	        if(sessionId == cur_session){
	            
	            var str = "<div class='col-6'>";
	            str += "<div class='alert alert-secondary'>";
	            str += "<b>" + sessionId + " : " + message + "</b>";
	            str += "</div></div>";
	            
	            $("#msgArea").append(str);
	        }
	        else{
	            
	            var str = "<div class='col-6'>";
	            str += "<div class='alert alert-warning'>";
	            str += "<b>" + sessionId + " : " + message + "</b>";
	            str += "</div></div>";
	            
	            $("#msgArea").append(str);
	        }
	        
	    }
	    //채팅창에서 나갔을 때
	    function onClose(evt) {
	        
	        var user = '${pr.username}';
	        var str = user + " 님이 퇴장하셨습니다.";
	        
	        $("#msgArea").append(str);
	    }
	    
	    //채팅창에 들어왔을 때
	    function onOpen(evt) {
	        
	        var user = '${pr.username}';
	        var str = user + "님이 입장하셨습니다.";
	        
	        $("#msgArea").append(str);
	    }
	    

	</script>
</body>
</html>
