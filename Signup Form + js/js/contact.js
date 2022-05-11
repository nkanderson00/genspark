jQuery(document).ready(function($) {
	$("form").submit(function(e) {
		alert(`${$("#firstname").val()}, your request has been submitted. We will be outside your house shortly.`);
	});
});