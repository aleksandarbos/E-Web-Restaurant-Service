$(document).ready(function() {	

	$(".integerinput").blur(function() {
		itIsNotAInteger(this);
	});	
	
	// IZMENA RESTORANA
	$('.change_restaurant').click(function() {	
		prepareChangeRestaurant();		
		$('.making_tables').fadeOut(500);
		$('.changing_restaurant').fadeIn(500, function() {
			$("html, body").animate({ scrollTop: $(document).height()-1000 }, 500);	
		});		
	});
	
	$('.changing_restaurant_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			$('.changing_restaurant').fadeOut(500);
		});
	});
	
	// IZMENA JELOVNIKA
	$('.change_menu').click(function() {	
		window.location.replace("./MealsServlet");			
	});
	
	// POSTAVLJANJE RASPOREDA STOLOVA
	$('.make_tables').click(function() {
		$('.changing_restaurant').fadeOut(500);
		$('.making_tables').fadeIn(500, function() {	
			$("html, body").animate({ scrollTop: $(document).height() }, 500);	
		});
	});
	
	$('.making_tables_yes').click(function() {
		makeTables();
	});
	
	$('.making_tables_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			$('.making_tables').fadeOut(500);
		});
	});	
	
	// efekti sa stolovima
	$('.restaurant-tables td').hover(function(){
		$(this).css('cursor', 'pointer');
	});
	
	$('.restaurant-tables td').click(function(){
		var elementLocal = this;
		if ($(elementLocal).css('background-color') == 'rgb(51, 51, 51)') {
			$(elementLocal).css('background-color', 'rgb(255, 204, 102)');
		} else if ($(elementLocal).css('background-color') == 'rgb(255, 204, 102)') {
			$(elementLocal).css('background-color', 'rgb(51, 51, 51)');
		}
	});
});

////////////////////////   FUNKCIJE   \\\\\\\\\\\\\\\\\\\\\\\\\\\\

function prepareChangeRestaurant() {
	$('#namec').val($('#namer').text());
	$('#typec').val($('#typer').text());
	$('#addressc').val($('#addressr').text());
	$('#contactc').val($('#contactr').text());
	$('#changing_restaurant_id').val($('#restaurant_id').text());
}

function makeTables() {
	/////////// Ovde se stvarno salju podaci!!!
	var selected = '';
	$('.restaurant-tables-define td').each(function(index, selectedElement) {
		if ($(selectedElement).css('background-color') == 'rgb(255, 204, 102)') {
			selected += ' ' + (index+1);
		}
	});
	
	alert('postavljam stolove ' + selected);
	return true;
}