$(document).ready(function() {
	
	$('.change_friends').click(function() {
		window.location.replace("friends.html");		
	});
	
	$('.change_account').click(function() {
		fillChangeAcountData();
		$('.changing_account').fadeIn(500);
		$("html, body").animate({ scrollTop: $(document).height() }, 500);			
	});
			
	$('.changing_account_no').click(function() {
		$("html, body").animate({ scrollTop: 0 }, 500, function() {
			$('.changing_account').fadeOut(500);
		});
	});	
	
	$('.check_password_form_update').submit(function(e) {
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
});

function fillChangeAcountData() {
	$('#user_id').val($('#account_id').text());
	$('#photo').val($('#photo').text());
	$('#name').val($('#nameo').text());
	$('#surname').val($('#surnameo').text());
	$('#address').val($('#addresso').text());
	$('#email').val($('#emailo').text());
	$('#password1').val($('#passwordo').text());
	$('#password2').val($('#passwordo').text());
}