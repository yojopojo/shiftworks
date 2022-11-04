document.write("<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js'><"+"/script>");
ment.write("<script type='text/javascript' src='/resources/js/messenger/service.js'><"+"/script>");
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
     	 $('.chat').fadeOut().fadeIn().show();
     	 $('.timer').css('font-size', '9px');
     	 console.log("room_id : " + $(this).attr("id"));
     	 
     	 // 지난 채팅 내역 가져옴
 /*    	 messengerService.getChat($(this).attr("id"), function(data){
     	 	if(data != null){
     		 	for(var i = 0; i < data.length; i++){
     		 		
     		 			
     	 		}
     	 	
     	 		$('.chat .header-chat .name').empty().append(data[0].chatRoom.room_name);
     	 	}
     	 });*/
     });
     
 });
     



/*
$(document).ready(function() {
 	var socket = null;

	console.log('js start');

	// 전송 버튼 눌렀을 때
	$('.send').on("click", function(e) {
		console.log("btn_send");
		sendMessage();
		$('.write-message').val('');
	});
		
	// 메시지를 입력하고 enter 키를 입력했을 때 
	$('.write-message').on("keypress", function(e) {
			
		if(e.keyCode == '13'){
			console.log("btn_send");
			sendMessage();
			$('.write-message').val('');
		}
	});	
});
	

function sendMessage(){
	console.log("Messenger Module......., sendMessage");
    socket.send($('.write-message').val());
    
    $('.chat').append("dd"); 
}

*/