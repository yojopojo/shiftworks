<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">  
<!-- fullcalendar CDN -->  
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />  
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>  
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>

<script>
      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        /* var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        }); */
        
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	
        	events:function(callback){
        		
        		$.ajax({
        			type: 'GET',
        			url: 'booking/cal/3',
        			succes: function(data){
        				var events =[];
        				console.log("ajax 실행중......................");
        				if(data != null){
        					events.push({
            					title: data.book_title,
            					start: data.book_date,
            					color: 'red'
        					});
        				}
        			}
        		})//end ajax
        		
        	}//end events function
        	
         	  /* eventSources: [

        		    // your event source
        		     {
        		      url: '/booking/cal/3', // use the `url` property
        		      color: 'yellow',    // an option!
        		      textColor: 'black'  // an option!
        		    }

        		    // any other sources...
        		  ] */
        	
        	
        	// events: '/booking/cal'
/*         	   events: [
        	    {
        	      title  : '구매팀 워크샵',
        	      start  : '2022-11-11'
        	    },
        	    {
        	      title  : '해외영업팀 출장',
        	      start  : '2022-11-05',
        	      end    : '2022-11-07'
        	    },
        	    {
        	      title  : '인사팀 오전 회의',
        	      start  : '2022-11-09T12:30:00',
        	      allDay : false // will make the time show
        	    }
        	  ] */
       	   /* events: [
       	    {
       	      title  : ,
       	      start  : 
       	    }
       	  ] */
       	});
        
        calendar.render();
        
      });

</script>


<title>Checkout with Booking Calendar</title>
</head>
<body>
	


	
<h2>Booking Calendar</h2>
<div id='calendar'></div>






























</body>
</html>