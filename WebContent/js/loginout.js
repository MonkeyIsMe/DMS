/**
 * 
 */


$("#out").click(function () {
	logout();
});

function logout(){
	document.cookie = "account=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
	window.location.href = "login.html";
}

function reset(){
	$('#re').attr('href','QueryRoom');
}