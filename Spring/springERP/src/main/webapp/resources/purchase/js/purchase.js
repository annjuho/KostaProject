$(function(){
	$('.purchase_date').datepicker({
		showButtonPanel : true,
		dateFormat : "yy-mm-dd",
		changeYear : true,
		changeMonth : true
	});
})




// purchase/css/js 폴더에 있던 purchase.js 소스. 사용안됐길래 주석처리해놈

//$(function(){
//	$('#item_search').click(function(){
//		$('.item_div').css("display","block")
//	})
//	$('#item_closeBtn').click(function(){
//		$('.item_div').css("display","none")
//	})
//	$('#customer_search').click(function(){
//		$('.customer_div').css("display","block")
//	})
//	$('#customer_closeBtn').click(function(){
//		$('.customer_div').css("display","none")
//	})
//})
//$(function(){
//	$('input').keyup(function(){
//		if($(this).val() != null){
//			$(this).next().addClass("glyphicon");
//			$(this).next().addClass("glyphicon-ok");
//			$(this).next().addClass("form-control-feedback");
//		}if($(this).val() == ""){
//			$(this).next().removeClass("glyphicon");
//			$(this).next().removeClass("glyphicon-ok");
//			$(this).next().removeClass("form-control-feedback");
//		}
//	})
//	$('#detail_search').click(function(){
//		$('.hide_detail').css("display","block");
//	})
//	$('#simple_search').click(function(){
//		$('.hide_detail').css("display","none");
//	})
//})
//$(function(){
//	$('.purchase_date').datepicker({
//	    dateFormat: 'yy-MM-dd'
//	  });
//})
//function fn_add(){	
//	window.open("./purchase/view/purchase_add.jsp","구매입력","width=1000, height=800");
//}