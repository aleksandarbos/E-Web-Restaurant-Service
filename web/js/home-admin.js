// JavaScript Document
$(document).ready(function(e) {
	
	var email = $("#restaurantName").val();
	var contact = $("#restaurantContact").val();
	var address = $("#restaurantAddress").val();
	var descrition = $("#restaurantDescription").val();
	var name = $("#restaurantName").val();
	
	$( "assignRestaurant" ).each( function( index, element ){
    	console.log( $( this ).text() );
		$.ajax({
				type: 'POST',
				url: 'ManagersServlet',
				data: {
					"manager": "getRestaurantId",
					"pick_restaurant":  $( this ).text(),
					"manager_id": contact,
				},
				success: function(data) { 
					//loginMessage(data);
					alert('restoraunt id data: ' + data); 
				},
				error: function () {
					//loginMessage(data);
				},
				contentType: "application/json",
				dataType: 'text/plain'
			});		
	});
	$('.userForm').on("click",function() {
		alert(this.id);
		
		$.ajax({
			type: 'POST',
			url: 'ManagersServlet',
			data: {
				"manager": "getRestaurantId",
				"pick_restaurant": name,
				"manager_id": contact,
			},
			success: function(data) { 
				//loginMessage(data);
				alert('restoraunt id data: ' + data); 
			},
			error: function () {
				//loginMessage(data);
			},
			contentType: "application/json",
			dataType: 'text/plain'
		});		
	}); 

});

