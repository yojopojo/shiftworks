console.log("Insert Booking Page's JS.....");

var bookingService = (function(){
	
	function insertBooking(bookingData, callback, error){
		console.log("*insertBooking Process*...........");
		
		$.ajax({
			type: 'post',
			url: 'booking/new',
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
	}
	
	return {name:"Reservation",
			insertBooking:insertBooking
			};
})();