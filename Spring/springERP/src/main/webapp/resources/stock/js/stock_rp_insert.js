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
			html += '<td><input type="text"></td>';
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

				$(location).attr('href',  '/stock/rp/insert?product_id='+$(product_id).val()+'&stock_amount='+$(stock_amount).val()+'&type='+type);
			});
		});
		
	});