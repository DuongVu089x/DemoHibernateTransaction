function confirmForMedium() {
	clearErrorMessage();
	if (!checkVaildMedium(getObject("medium"))) {
		return false;
	}
	return true;
}
function clearErrorMessage() {
	$("div.error").each(function(index) {
		$(this).html("");
	});
}
function checkVaildMedium(object) {
	$('.error-message').each(function(index) {
		$(this).empty();
		$(this).addClass('alert-hide');
	});
	var flag = true;
	if (object.username.trim().length < 2
			|| object.username.trim().length > 255) {
		showMessage("username", "Uername must be between 2 to 255");
		flag = false;
	}
	if (object.password.trim().length < 2
			|| object.password.trim().length > 255) {
		showMessage("password", "Password must be between 2 to 255");
		flag = false;
	}
	return flag;
}
function showMessage(field, message) {
	$("#error-" + field).append("<p>" + message + "</p>");
}
function getObject(div) {
	var object = {
		username : $('#' + div + ' #username').val(),
		password : $('#' + div + ' #password').val()
	}
	return object;
}

function removeTabActive() {
	$(".tab-pane").each(function(index) {
		$(this).removeClass("active");
	});
	$(".nav.nav-tabs li").each(function(index) {
		$(this).removeClass("active");
	});
}

$(document).ready(function() {
	removeTabActive();
	var url = window.location.pathname;
	if (url.indexOf('low') > 0) {
		$("#tab-low").addClass('active');
		$("div#low").addClass('active');
	} else if (url.indexOf('medium') > 0) {
		$("#tab-medium").addClass('active');
		$("div#medium").addClass('active');
	} else if (url.indexOf('high') > 0) {
		$("#tab-high").addClass('active');
		$("div#high").addClass('active');
	} else if (url.indexOf('impossible') > 0) {
		$("#tab-impossible").addClass('active');
		$("div#impossible").addClass('active');
	}
});