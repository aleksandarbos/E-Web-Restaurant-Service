$(document).ready(function() {
	
	$('.open_restaurant').click(function() {
		$('#restaurant_details').fadeOut(500);	
		var selectedDiv = this;
		setUpRestaurant(selectedDiv);
		$('#restaurant_details').fadeIn(500, function() {
			$("html, body").animate({ scrollTop: $(document).height()-1250 }, 500);		
		});
	});
	
	$('.reserve_restaurant').click(function() {
		var restaurantId = $('#opened_restaurant_id').text();
		window.location.replace("restaurants-reservation.html");	
	});	
	
	$('.close_restaurant').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			$('#restaurant_details').fadeOut(500);
		});		
	});
		
	/* ****************  STRANICA SA REZERVACIJOM  ********************** */	
	$('.reservation_no').click(function() {
		window.location.replace("restaurants.html");	
	});	
	
	$('.reservation_friends_no').click(function() {
		window.location.replace("restaurants.html");	
	});
	
	$('.reservation_termin_yes').click(function() {
		$('.reservation_table').fadeOut(500);	
		if (calculateFreeTables()) {
			$('.reservation_table').fadeIn(500);	
			$("html, body").animate({ scrollTop: 800 }, 500);			
		}
	});
	
	$('.reservation_yes').click(function() {
		if (makeReservation()) {	
			alert('Rezervacija je uspešno izvršena!');
			$('.reservation_termin').fadeOut(500);	
			$('.reservation_table').fadeOut(500);	
			$('.reservation_friends').fadeIn(500);	
		} else {
			alert('Došlo je do greške. Molimo Vas, pokušajte ponovo.!');
		}
	});
		
	$('.reservation_friends_yes').click(function() {
		if (inviteFriends()) {		
			alert('Prijatelji su uspešno pozvani!');
			window.location.replace("restaurants.html");
		} else {
			alert('Došlo je do greške. Molimo Vas, pokušajte ponovo.!');
		}
	});	
	
	// PONASANJE STOLOVA
	$('.restaurant-tables td').hover(function(){
		var elementLocal = this;
		if ($(elementLocal).css('background-color') == 'rgb(153, 204, 153)') {	// na rapolaganju
			$(elementLocal).css('cursor', 'pointer');
		} else if ($(elementLocal).css('background-color') == 'rgb(102, 153, 255)') { // odabran
			$(elementLocal).css('cursor', 'pointer');
		}
	});
	
	$('.restaurant-tables td').click(function(){
		var elementLocal = this;
		if ($(elementLocal).css('background-color') == 'rgb(153, 204, 153)') {
			$(elementLocal).css('background-color', 'rgb(102, 153, 255)');
		} else if ($(elementLocal).css('background-color') == 'rgb(102, 153, 255)') {
			$(elementLocal).css('background-color', 'rgb(153, 204, 153)');
		}
	});
});
////////////////////////   FUNKCIJE   \\\\\\\\\\\\\\\\\\\\\\\\\\\\

function setUpRestaurant(selectedRestaurant) {
	var restaurantId = $(selectedRestaurant).find('.restaurant_id').text();
	
	$('#opened_restaurant_id').text(restaurantId);
	$('#namer').text($(selectedRestaurant).find('.nameo').text());
	$('#typer').text($(selectedRestaurant).find('.typeo').text());
	$('#addressr').text($(selectedRestaurant).find('.addresso').text());
	$('#phoner').text($(selectedRestaurant).find('.phoneo').text());
	
	
	alert('ocene restrana ' + restaurantId);
	/////////// Ovde se stvarno salju podaci!!!
	var reteUniversal = 2.0;
	var ratePersonal = 3.3;
	/////////// Ovde se stvarno obradjuju podaci i popunjavaju odgovarajuca
	$('#rateur').text(reteUniversal);
	$('#ratemr').text(ratePersonal);
	
	// postaviti lokaciju na mapi
	
	// postaviti meni
}

function calculateFreeTables() {
	/////////// Ovde se stvarno salju podaci!!!
	alert('trazim stolove');
	/////////// Ovde se stvarno obradjuju podaci i popunjavaju odgovarajuca
	return true;
}

function makeReservation() {
	/////////// Ovde se stvarno salju podaci!!!
	var selected = '';
	$('.restaurant-tables-define td').each(function(index, selectedElement) {
		if ($(selectedElement).css('background-color') == 'rgb(102, 153, 255)') {
			selected += ' ' + (index+1);
		}
	});
	
	alert('postavljam stolove ' + selected);
	return true;
}

function inviteFriends() {
	/////////// Ovde se stvarno salju podaci!!!
	alert('pozivam prijatelje');
	return true;	
}