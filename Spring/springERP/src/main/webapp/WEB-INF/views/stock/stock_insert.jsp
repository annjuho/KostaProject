<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(function(){
	$('#plusBtn').on('click',function(){
		var html = '<tr>';
		html += '<td><input type="checkbox" name="stockRow"></td>';
		html += '<td><select class="form-control" id="product_id" name="product_id">';
		html += '<c:forEach var="p" items="${list}">';
		html += '<option value="${p.product_id }">${p.product_id}</option>';
		html += '</c:forEach>';
		html += '</select>';
		html += '</td>';
		html += '<td><input type="text" class="form-control"></td>';
		html += '<td><select class="form-control" id="type" name="type">';
		html += '<option value="in">입고</option>';
		html += '<option value="out">출고</option>';
		html += '</select></td>';
		html += '</tr>';
		$('#myTable tr:last').after(html);
	});

	$('#addBtn').on('click',function(){
		$("input[name=stockRow]:checked").each(function() {
			var product_id = $(this).parent().next().children();
			var stock_amount = $(product_id).parent().next().children();
			var type = $(stock_amount).parent().next().children($('select option:selected')).val();

			$(location).attr('href',  '/stock/rp/insert?product_id='+$(product_id).val()+'&inout_amount='+$(stock_amount).val()+'&type='+type);
	
		});
	});
	
});
</script>
</head>
<body>

	<button id="plusBtn" class="btn btn-default">+</button>

	<table id="myTable" class="table table-bordered table-hover">
		<tr>
			<th><input type="checkbox"></th>
			<th>품목</th>
			<th>갯수</th>
			<th>구분</th>
		</tr>
	</table>

	<button id="addBtn" class="btn btn-default">입력</button>
	
</body>
</html>
