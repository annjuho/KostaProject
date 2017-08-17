<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
<link href="/resources/odm/css/odm.css" rel="stylesheet"> 
<!-- <script src="/resources/odm/js/orderList.js"></script>-->
<script type="text/javascript">
$(function(){
	function statusAjax(ordno){
		alert(step+" and "+step2);
		 $.ajax({
			url : "http://localhost:8000/orderStatus",
			type : "post",
			async : false,
			data : {
				ordno : ordno,
				step : step,
				step2 : step2
			},
			success : function(data){
				alert(data);
				listsAjax(status);

			},
			error : function(){
				alert("주문 상태변경 실패!");
			}
		});  
	}

	function listsAjax(status){
		alert(step+" and "+step2);
		$('#tbody').empty();
		$.ajax({
			url : "http://localhost:8000/orderCollect",
			// cache : false,
			type : "post",
			async: false,
			dataType : 'xml',
			data : {
				step : step,
				step2 : step2
			},
			success : function(data) {
				console.log(data);
				var orderList = [];
				var itemList = [];
				
				$(data).find('order_data').each(function() {
					var html = '';
					var json = {};
	
					var ono = $(this).find('ordno').text();
					var ordno = ono.slice(0, ono.length/2);
					var orddt = $(this).find('orddt').text();
					var nameOrder = $(this).find('nameOrder').text();
					var settleprice = $(this).find('settleprice').text();
					var phoneOrder = $(this).find('phoneOrder').text();	
					var nameReceiver = $(this).find('nameReceiver').text();
					var address = $(this).find('address').text();
					var deliverycode = $(this).find('deliverycode').text();
					
					json.order_id = ordno;
					json.order_date = orddt;
					json.client_name = nameOrder;
					json.settlement_price = settleprice;
					json.client_phonenumber = phoneOrder;
					json.addressee = nameReceiver;
					json.addressee_address = address;
					json.invoice_number = deliverycode;

					orderList.push(json);
					
					html += '<tr class="tablecenter">';
					html += '<td><input type="checkbox" class="orderChecked" name="orderRow" value="'+ordno+'"></td>';
					html += '<td>'+ordno+'</td>';
					html += '<td>'+orddt+'</td>';
					html += '<td>'+nameOrder+'</td>';
					html += '<td>'+settleprice+'</td>';
					html += '<td>'+phoneOrder+'</td>';
					html += '</tr>';
					
					$('#tbody').append(html);
	
				});
				$(data).find('item_data').each(function() {
					var json = {};
					
					var ordno = $(this).find('ordno').text();
					var goodscd = $(this).find('goodscd').text();
					var ea = $(this).find('ea').text();
					var istep =  $(this).find('istep').text();
					var price = $(this).find('price').text();

					json.order_id = ordno;
					json.product_id = goodscd;
					json.order_amount = ea;
					json.status = istep;
					
					itemList.push(json);
				});
				if(status == "odm1"){
					$('#Btn').empty();
					var html = '';
					
					html += '<input type="button" id="confirmBtn" class="btn btn-default" value="입금처리">';
					
					$('#Btn').append(html);
				}
				if(status == 'odm2'){
					$('#Btn').empty();
					var html = '';
					
					html += '<input type="button" id="readyBtn" class="btn btn-default" value="배송준비">';
					html += '<input type="button" id="addBtn" class="btn btn-default" value="송장등록">';
					
					$('#Btn').append(html);
				}
				//console.log(orderList);
				// $.ajaxSettings.traditional = true;
				if(step == 0 && step2 == 0){
					 $.ajax({
							url : '/odm/orderListAdd',
							type : 'post',
							async : false,
		 					data : {
								orderList : JSON.stringify(orderList),
								itemList : JSON.stringify(itemList)
							},
							success : function(data){
								if(data == '0'){
									alert('orderlistAdd실패');
								}
								alert(data);

							},
							error : function(){
								alert("orderListAdd실패!")
							}
						}); 
				}

		    }, 
		    error : function(){
		    	alert("실패");
		    }
	
		 });
	}
	function deliveryInsert(ordno, status){
		$.ajax({
			url : "/odm/deliveryInsert",
			type : "post",
			aynsc : false,
			data : {
				order_id : ordno,
				status : status
			},
			success : function(data){
				alert(data);
			}
		});
	}
	
	alert("<c:out value='${checks}'/>");  
	var step = 0;
	var step2 = 0;
	var status = "odm1";
	
		$("#status").on("change", function(){
			
			if($(this).val() == "odm1"){
				step = 0;
				step = 0;
				status = "odm1";
			}
			if($(this).val() == "odm2"){
				step = 1;
				step2 = 0;
				status = "odm2";
			}
			listsAjax(status);
		}); 
		
		if("<c:out value='${checks}'/>" == 'godo'){
			listsAjax(status);
		}
		$('#Btn').on('click','#confirmBtn',function(){
			$('input[name=orderRow]:checked').each(function(){
				var ordno = $(this).val();
	 			 statusAjax(ordno);
			});
		});
		$('#Btn').on('click','#readyBtn',function(){
			$('input[name=orderRow]:checked').each(function(){
				var ordno = $(this).val();
				var status = "ready";
				deliveryInsert(ordno, status);
	 			statusAjax(ordno);
			});
		});
		
		$('#Btn').on('click','#addBtn',function(){
			$('input[name=orderRow]:checked').each(function(){
				var ordno = $(this).val();
				var status = "shipping";
					deliveryInsert(ordno, status);
					$.ajax({
						url : "http://localhost:8000/orderStatus",
						type : "post",
						data : {
							ordno : $(this).val(),
							step : 3,
							step2 : 0,
							dvcode : '753-'+$(this).val()
						},
						success : function(data){
							alert(data);
							
							listsAjax(status);
						},
						error : function(){
							alert("송장등록 상태변경 실패!");
						}
					});
			});
		});
		
});
</script>
</head>
<body>
<div id="a"></div>
	<h2 class="page_title">주문리스트</h2>
	<select id="status" class="form-control">
		<option value="odm1">주문접수</option>
		<option value="odm2">입금확인</option>
	</select>
	<hr>
	<table id="odmTable" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>주문번호</th>
				<th>주문일시</th>
				<th>주문자명</th>
 				<th>결제금액</th>
 				<th>연락처</th>
			</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
	<div class="buttongroup" id="Btn">
<!-- 		<input type="button" id="checkBtn" class="btn btn-default" value="발주확인"> -->
<!-- 		<input type="button" id="confirmBtn" class="btn btn-default" value="입금처리">
		<input type="button" id="addBtn" class="btn btn-default" value="송장등록">
		<input type="button" id="sendBtn" class="btn btn-default" value="송장전송"> -->
	</div>
</body>
</html>