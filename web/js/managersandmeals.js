$(document).ready(function() {		

	$(".integerinput").blur(function() {
		itIsNotAInteger(this);
	});	
	
	
	/* ****************  STRANICA SA JELIMA  ********************** */	
	// DODAVANJE JELA
	$('.add_meal').click(function() {
		$('.changing_meal').fadeOut(500, function() {
			$('.adding_meal').fadeIn(500);
		});
		$("html, body").animate({ scrollTop: $(document).height() }, 500);			
	});
	
	$('.adding_meal_yes').click(function() {
		if (addMeal()) {
			$("html, body").animate({ scrollTop: 0 }, 500, function() {
				location.reload();
			});
		}		
	});
	
	$('.adding_meal_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			exitAddMeal();		
		});		
	});
	
	// IZMENA JELA
	$('.change_meal').click(function() {
		var elementRow = $(this).parents('tr');
		prepareChangeMeal(elementRow);
		exitAddMeal();
		$('.changing_meal').fadeIn(500);
		$("html, body").animate({ scrollTop: $(document).height() }, 500);			
	});
	
	$('.changing_meal_yes').click(function() {
		if (changeMeal()) {
			$("html, body").animate({ scrollTop: 0 }, 500, function() {
				location.reload();
			});
		}		
	});
	
	$('.changing_meal_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			$('.changing_meal').fadeOut(500);			
		});
	});
	
});
////////////////////////   FUNKCIJE   \\\\\\\\\\\\\\\\\\\\\\\\\\\\


/* ****************  STRANICA SA JELIMA  ********************** */	
function exitAddMeal() {
	$('#namen').val('');
	$('#descriptionn').val('');
	$('#pricen').val('');
	$("html, body").animate({ scrollTop: 0 }, 500);
	$('.adding_meal').fadeOut(500);
}

function prepareChangeMeal(elementRow) {
	$('#namec').val($(elementRow).find('.nameo').text());
	$('#descriptionc').val($(elementRow).find('.descriptiono').text());
	$('#pricec').val($(elementRow).find('.priceo').text());
	$('#changing_meal_id').text($(elementRow).find('.meal_id').text());
	$('#pricec').css("background-color", "#FFF");
}

function addMeal() {
	/////////// Ovde se stvarno salju podaci!!!
	alert('dodajem jelo');
	return true;
}

function changeMeal() {
	var mealId = $('#changing_meal_id').text();
	/////////// Ovde se stvarno salju podaci!!!
	alert('menjam jelo ' + mealId);
	return true;
}