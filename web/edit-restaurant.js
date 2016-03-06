// JavaScript Document

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

$(document).ready(function(e) {
	
		var paramEmail = getUrlParameter('email');
		var paramName = getUrlParameter('name');
		var paramContact = getUrlParameter('contact');	
		var paramAddress = getUrlParameter('address');		
		var paramDescription = getUrlParameter('description');
		
		$("#restaurantName").val(paramName);
		$("#restaurantDescription").val(paramDescription);
		$("#restaurantAddress").val(paramAddress);
		$("#restaurantContact").val(paramContact);
		$("#restaurantEmail").val(paramEmail);
	
});