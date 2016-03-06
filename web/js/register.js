

function registerFun() {	
		
		var pswEquals = $('#pass1').val() == $('#pass2').val();
		var isEmpty = false;
		
		if(pswEquals == false){
			$().toastmessage('showErrorToast','Password fields not matching!');
			return false;
		}
		
		$('input[type="text"]').blur(function () {
		  if ($('input:text').is(":empty")) {
			if($(this).val() == "")
				isEmpty = true;
		  }
		});
		
		if(pswEquals == true && !isEmpty) {
			return true;
			$().toastmessage('showSuccessToast','Activation has been sent to your email address.');
		} else {
			return false;	
		}
		
}