$(document).ready(function() {
	
	checkSession();
	
	$(".integerinput").blur(function() {
		itIsNotAInteger(this);
	});	
	
	$(".rate_restaurant").click(function() {
		var origin = this;
		$('.rating_restaurant').fadeOut(function() {
			$('.rate_restaurant').not(origin).fadeIn() 
		});				
		$(origin).fadeOut(function() {
			$(origin).parents('td').find('.rating_restaurant').fadeIn();
		});
	});
	
	$('.rate_no').click(function(e) {
		e.preventDefault();
		$(this).parents('td').find('.rating_restaurant').fadeOut(function(){
			$(this).parents('td').find('.rate_restaurant').fadeIn();
		});
	});	
	
	$('.rate_yes').click(function(e) {
		e.preventDefault();
		var form = $(this).parents('td').find('.rating_restaurant');
		var value = $(this).parents('td').find('.rate_value').val();
		if (value > 5 || value == 0)
			alert('Ocena mora viti u intervalu od 1 do 5!');
		else {
			$(form).unbind('submit').submit();
		}
	});
	
	///KREIRANJE NOVOG NALOGA
	$('.check_password_form').submit(function(e) {
		e.preventDefault();
		var self = this;
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		if (password1 != password2) {
			alert("Unete lozinke Vam se ne poklapaju!");
		} else {
			$(self).unbind('submit').submit();
			alert("Na Vašu e-mail adresu poslata je poruka sa linkom za aktivaciju naloga.");
		}		
	});	
	
});

/////////////////////    POZITIVAN CEO BROJ	 //".integerinput"
function itIsNotAInteger(loc) {
	if (isNaN($(loc).val()) || $(loc).val() < 0 || ($(loc).val() % 1 != 0)) {
		alert('Pogrešan unos! Unesite pozitivan ceo broj.');
		$(loc).css("background-color", "#900");
		return false;
	} else
		$(loc).css("background-color", "#FFF");
	return true;
}

function checkSession() {
	var url = window.location.pathname;
	if (url == "/ISA-project/signin.html" || url == "/ISA-project/signup.html" || url == "/ISA-project/") {
		return;
	} else {
		$.ajax({
			type: 'POST',
			url: 'LogInServlet',
			async: 'false',
			data: 'provera=' + 'user',
			dataType: "text",
			success: function(data) {
				if (data == "odjavljen") {
					window.location.href="signin.html";
					alert("Niste prijavljeni. Molimo Vas, prijavite se.");
				}
			},
		})
	}
}