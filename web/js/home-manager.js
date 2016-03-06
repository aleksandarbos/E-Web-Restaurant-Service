// JavaScript Document

var json = ["0"];

$(document).ready(function(e) {
	
	$.ajax({
		type: 'GET',
		url: 'TablesServlet',
		success: function(data) { 
			//alert("recieved data: " + data);
			json = data.split(',');
			
			$('#restaurantTable td').each(function(index, selectedElement) {
					var currTd = $(this);
					$(json).each(function(index2,value) {	
						if (value == index+1) {
							currTd.css("background-color", "#39C");
						}
					});
				});	
		},
		error: function () {
		},
		contentType: "text/plain",
		dataType: 'text'
	});		
	
	
	$('#restaurantTable td').click(function() {
		var myCol = $(this).index();
		var $tr = $(this).closest('tr');
		var myRow = $tr.index();
		
		for (var i=0; i<json.length; i++)
			{
				json[i] = parseInt(json[i], 10);
			}


		if($(this).css('background-color') == "rgba(0, 0, 0, 0)"){
			//console.log("table:" +( myCol+1 + myRow*7));
			$(this).css("background-color", "#39C");
			json.push(myCol+1 + myRow*7);
		} else {
			$(this).css("background-color", "rgba(0, 0, 0, 0)");
			var index = json.indexOf(myCol+1 + myRow*7);
			if (index > -1) {
    			json.splice(index, 1);
			}	
		}
	});
	
	$('#submitTableConf').click(function () {
		$.ajax({
			type: 'POST',
			url: 'TablesServlet',
			data: '{"json": "' + json + '"}',
			success: function(data) { 
				$().toastmessage('showSuccessToast',"Successfuly configured tables.");
				alert("Succesfully configured restaurant tables!");
			},
			error: function () {
			},
			contentType: "application/json",
			dataType: 'json'
		});		
	
	});
	
});

function colorInitTables(json) {
	$('#restaurantTable td').blur(function () {
		var myCol = $(this).index();
		var $tr = $(this).closest('tr');
		var myRow = $tr.index();

		for(i = 0; i < 7*7; i++) {	//7*7 tables
			for(j = 0; j < 7; j++) {
				for(k = 0; k < json.length; k++) {
					if(i*7+1+j == json[k]) {
						$('#restaurantTable tr:"'+i+'" td:nth-child("'+j+'")').css("background-color", "#39C");
						return;	
					}	
				}
			}
		}
	});
	$('td').blur();
}