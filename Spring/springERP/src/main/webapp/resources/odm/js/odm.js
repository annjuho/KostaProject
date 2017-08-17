//$(function() {
//	  $(".datepicker1").datepicker({
//	    dateFormat: 'yy-mm-dd'
//	  });
//});
/*수집버튼*/
$(function(){
	$('#collectBtn').on('click', function(){
	 		$("input[name=shopList]:checked").each(function() {
				var checks = $(this).val();
				
//				if(checks == 'godo'){
//					$.ajax({
//						url : "localhost:8000/orderCollect",
//						data : {
//							step :  1,
//							step2 : 0
//						},
//						dataType : 'xml',
//						success : function(data){
//							
//						}
//					})
//				}
//			});
		$(location).attr('href', '/odm/orderCollect?checks='+checks);
	 		/* $('.success').css("display","block"); */
			/* $('.failed').css("display","block"); */

		});
/* 	$('.closeBtn').click(function(){
		$('.xclose').css("display","none");
	}); */
	/* $('#successBtn').click(function(){
		$(location).attr("href","shoppingMallList.odm");
	}) */
});

});

