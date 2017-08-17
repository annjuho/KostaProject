$(function(){
	$('input[name=shopList]:checked').each(function(){
		$(this).val();
	});
//	$.ajax({
//		url : "http://localhost:8000/orderCollect",
//		// cache : false,
//		type : "post",
//		dataType : 'xml',
//		data : {
//			step : 0,
//			step2 : 0
//		},
//		success : function(data) {
//			console.log(data);
//			var orderList = [];
//			
//			$(data).find('order_data').each(function() {
//				var html = '';
//				var json = {};
//
//				var ono = $(this).find('ordno').text();
//				var ordno = ono.slice(0, ono.length/2);
//				var orddt = $(this).find('orddt').text();
//				var nameOrder = $(this).find('nameOrder').text();
//				var settleprice = $(this).find('settleprice').text();
//				var phoneOrder = $(this).find('phoneOrder').text();
//
//				html += '<tr class="tablecenter">';
//				html += '<td><input type="checkbox" class="orderChecked" name="orderRow" value="'+ordno+'"></td>';
//				html += '<td>'+ordno+'</td>';
//				html += '<td>'+orddt+'</td>';
//				html += '<td>'+nameOrder+'</td>';
//				html += '<td>'+settleprice+'</td>';
//				html += '<td>'+phoneOrder+'</td>';
//				html += '</tr>';
//				
//				$('#tbody').append(html);
//
//			});
//	    }, 
//	    error : function(){
//	    	alert("실패");
//	    }
//
//	 });  

	$("input[name=orderRow]:checked").each(function() {
		alert($(this).val());
	});
})