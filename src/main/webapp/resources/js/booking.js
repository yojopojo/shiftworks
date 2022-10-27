console.log("Insert Booking Page's JS.....");

var bookingService = (function(){
	
	function insertBooking(bookingData, callback, error){
		console.log("*insertBooking Process*...........");
		
		$.ajax({
			type: 'post',
			url: '/booking/new',
			data: JSON.stringify(bookingData),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})
	}//end insertBooking
	
	function listBookingCal(callback, error){
		$.get("/booking/cal", function(result){
			if(callback){
				callback(result);
			}
	}).fail(function(xhr, status, err){
		if(error){
			error();
		}
	});
	}//end listBookingCal
	
	function listBookingCall(callback, error){
		$.getJSON("/booking/cal", function(JSONdata){
			if(callback){
				callback(JSONdata);
			}
	}).fail(function(xhr, status, err){
		if(error){
			error();
		}
	});
	}//end listBookingCal
	
	
	
	return {name:"Reservation",
			insertBooking:insertBooking,
			getCalList:listBookingCal,
			getCal:listBookingCall
			};
})();