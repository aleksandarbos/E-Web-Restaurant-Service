$(document).ready(function() {
	
	$('.add_friends').click(function() {
		window.location.replace("addfriend.html");	
	});
	
	$('.find_friend_no').click(function() {
		window.location.replace("friends.html");	
	});
	
	$('.find_friend_yes').click(function() {
		var name = $('#namef').val();
		var surname = $('#surnamef').val();
		var result_count = searchFriends(name, surname);
		if (result_count == 0) {
			$('.found_friends_none').fadeIn(500);
			$("html, body").animate({ scrollTop: $(document).height() }, 500);	
		} else if (result_count > 0) {
			$('.found_friends').fadeIn(500);
			$("html, body").animate({ scrollTop: $(document).height() }, 500);	
		}
	});	
	
	$('.add_friend').click(function() {
		var id = $(this).parents('tr').find('.friendId').text();		
		if (confirm('Dodati prijatelja u Vašu listu prijatelja?')) {
			if (addFriend(id)) {
				$("html, body").animate({ scrollTop: 0 }, 500, function() {
					location.reload();
				});
			}
		}
	});
	
	$('.delete_friend').click(function() {
		var id = $(this).parents('table').find('.friend_id').text();		
		if (confirm('Uklanjam prijatelja iz Vaše liste prijatelja?')) {
			if (deleteFriend(id)) {
				$(this).parents('.friend-panel').fadeOut();
			}
		}
	});
});

function exitSearchFriends() {
	$('.find_friend').fadeOut(500);
	$('.found_friends_none').fadeOut(500);
	$('.found_friends').fadeOut(500);
	$('#namef').val('');
	$('#surnamef').val('');
}

function deleteFriend(friendId) {
	/////////// Ovde se stvarno salju podaci!!!
	alert('brisem ' + friendId);
	return true;
}

function searchFriends(criteriaName, criteriaSurname) {
	/////////// Ovde se stvarno salju podaci!!!
	alert('trazim ' + criteriaName + ' ' + criteriaSurname);
	if (criteriaName == '' && criteriaSurname == '') {
		alert('Niste popunili nijedno polje za pretragu!');
		return -1;
	}
	return 2;
	/////////// Ovde se stvarno obradjuju podaci i popunjavaju odgovarajuca polja!!!
}

function addFriend(friendId) {
	/////////// Ovde se stvarno salju podaci!!!
	alert('dodajem ' + friendId);
	return true;
}