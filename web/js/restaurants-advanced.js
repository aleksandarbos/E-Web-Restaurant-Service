$(document).ready(function() {
	
	// DODAVANJE RESTORANA
	$('.add_restaurant').click(function() {	
		$('.changing_restaurant').fadeOut(500);
		$('.adding_restaurant').fadeIn(500, function() {
			$("html, body").animate({ scrollTop: $(document).height()-1000 }, 500);	
		});	
	});
	
	$('.adding_restaurant_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			exitAddRestaurant();
		});
	});
	
	// IZMENA RESTORANA
	$('.change_restaurant').click(function() {
		var elementRow = $(this).parents('table');
		prepareChangeRestaurant(elementRow);
		$('.adding_restaurant').fadeOut(500);
		$('.changing_restaurant').fadeIn(500, function() {
			$("html, body").animate({ scrollTop: $(document).height()-1000 }, 500);
		});
	});
	
	$('.changing_restaurant_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500);
		$('.changing_restaurant').fadeOut(500);
	});

	// DODAVANJE MENADZERA
	$('.add_manager').click(function() {
		$('.adding_restaurants').fadeOut(500, function() {
			$('.adding_manager').fadeIn(500);
		});
		$("html, body").animate({ scrollTop: $(document).height() }, 500);			
	});
	
	$('.check_password_form_new_manager').submit(function(e) {
		e.preventDefault();
		var self = this;
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if (password1 != password2) {
			alert("Unete lozinke Vam se ne poklapaju!");
		} else {
			$(self).unbind('submit').submit();
		}		
	});
	
	$('.add_manager_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			exitAddManager();
		});
	});
	
	// DODELA RESTORANA MENADZERU	
	$('.add_restaurants').click(function() {
		exitAddManager();
		var managerId = $(this).parents('tbody').find('.manager_id').text();
		if (prepareManagerRestaurants(managerId)) {
			$('.adding_restaurants').fadeIn(500, function() {
				$("html, body").animate({ scrollTop: $(document).height() }, 500 );
			});
		}
	});
	
	$('.add_restaurants_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			$('.adding_restaurants').fadeOut(500);
		});	
		
	});
});
////////////////////////   FUNKCIJE   \\\\\\\\\\\\\\\\\\\\\\\\\\\\

function exitAddRestaurant() {
	$('#photon').val('');
	$('#namen').val('');
	$('#typen').val('');
	$('#addressn').val('');
	$('#contactn').val('');
	$("html, body").animate({ scrollTop: 0 }, 500);
	$('.adding_restaurant').fadeOut(500);
}

function prepareChangeRestaurant(elementRow) {
	$('#namec').val($(elementRow).find('.nameo').text());
	$('#typec').val($(elementRow).find('.typeo').text());
	$('#addressc').val($(elementRow).find('.addresso').text());
	$('#contactc').val($(elementRow).find('.contacto').text());
	$('#changing_restaurant_id').val($(elementRow).find('.restaurant_id').text());
}

function exitAddManager() {
	$('#photo').val('');
	$('#type').val('restorana');
	$('#name').val('');
	$('#surmane').val('');
	$('#address').val('');
	$('#email').val('');
	$('#password1').val('');
	$('#password2').val('');
	$("html, body").animate({ scrollTop: 0 }, 500);
	$('.adding_manager').fadeOut(500);
}

function prepareManagerRestaurants(managerId) {
	$("#manager_adding_id").val(managerId);

	$.ajax({
		type: 'POST',
		url: 'ManagersServlet',
		async: 'false',
		dataType: 'text',
		data: "manager=" + managerId,
		success: function(data) {
			$("#pick_restaurant").val(data);
		},
		error: function(data) {
			$("#pick_restaurant").val(0);
		}
	})
	return true;
}