$(function() {
	  $(".stockRP_date").datepicker({
	    dateFormat: 'yy-mm-dd'
	  });
});
$(function() {
	$('#product_search').on('click', function() {
		$('.item_div').css("display", "block");
	})
	$('.i_closeBtn').on('click', function() {
		$('.item_div').css("display", "none");
	});
	$('#warehouse_search').on('click', function() {
		$('.warehouse_div').css("display", "block");
	});
	$('.w_closeBtn').on('click', function() {
		$('.warehouse_div').css("display", "none");
	});
	$('input').keyup(function() {
		if ($(this).val() != null) {
			$(this).next().addClass("glyphicon");
			$(this).next().addClass("glyphicon-ok");
			$(this).next().addClass("form-control-feedback");
		}
		if ($(this).val() == "") {
			$(this).next().removeClass("glyphicon");
			$(this).next().removeClass("glyphicon-ok");
			$(this).next().removeClass("form-control-feedback");
		}
	})
});