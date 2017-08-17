$(function(){
	totalSums();
	$(document).on('keyup','.sums',totalSums);
})
function totalSums(){
	var total = 0;
	$('.sums').each(function(){
		total = total + parseInt($(this).val());
		$('#totalSums').val(total);
	});
}
$(function(){
	$('#use').on('click', function(){
		var array = [];
		$("input[name=id_box]:checked").each(function() {
			array.push($(this).val());	
		});
		var url = "/accounting/moneymanagement/useMoney?array="+array;
		if(array == ""){
			alert("삭제할 목록을 체크하시오.");
		}else{
			$(location).attr('href',url);
		}		
	})
});
$(function() {
	$("#first-tab").on('click', function() {
		$('#second-tabs').css('display', 'none');
		$('#first-tabs').css('display', 'block');
	})
	$("#second-tab").on('click', function() {
		$('#first-tabs').css('display', 'none');
		$('#second-tabs').css('display', 'block');
	})
});
$(function() {
	$('.tbody').on('click','input[type=button]',function(){		
		var html = '';
		html += '<tr class="inoutMoneylist">';
		html += '<td><input type="checkbox"></td>';
		html += '<td class="button">';
		html += '<input type="button"class="btn btn-default btn-sm saleListAdd" value="▼"/>';
		html += '</td>';
		html += '<td><input type="text" value=""></td>';
		html += '<td><input type="text" value=""></td>';
		html += '<td><input type="text" value=""></td>';
		html += '<td><input type="text" name="" value="" class="sums"></td>';
		html += '<td><input type="text" name="" value="0"></td>';
		html += '<td><input type="text" name="" value=""></td>';
		html += '<td><input type="text" name="" value=""></td>';
		html += '<td><input type="text" name="" value=""></td>';
		html += '</tr>';
		$('#tbodyTable').append(html);
	})
	//입금 삽입!!!!
	$("#moneyplanselect").click(function() {
		$('#cardInfos').empty();
		if($('#first-tabs').css('display') == 'block'){
			$.ajax({
				url : '/accounting/moneymanagement/allListIn',
				dataType : 'json',
				success : function(data) {
					var content = "";
					$.each(data, function(index, list) {
						content += '<tr>';
						content += '<td><input type="checkbox" name="id_box" value="'+list.funds_id+'"></td>';
						content += '<td>' + list.typelist + '</td>';
						content += '<td>' + list.start_date + '</td>';
						content += '<td>' + list.periods + '</td>';
						content += '<td>' + list.funds_id + '</td>';
						content += '<td>' + list.sums + '</td>';
						content += '<td>' + list.account_number + '</td>';
						content += '<td>' + list.customer_id + '</td>';
						content += '<td>' + list.remarks + '</td>';
						content += '</tr>';
					})
					$('#cardInfos').append(content);
				}
			})
		}else if($('#second-tabs').css('display') == 'block'){
			$.ajax({
				url : '/accounting/moneymanagement/allListOut',
				dataType : 'json',
				success : function(data) {
					var content = "";
					$.each(data, function(index, list) {
						content += '<tr>';
						content += '<td><input type="checkbox" name="id_box" value="'+list.funds_id+'"></td>';
						content += '<td>' + list.typelist + '</td>';
						content += '<td>' + list.start_date + '</td>';
						content += '<td>' + list.periods + '</td>';
						content += '<td>' + list.funds_id + '</td>';
						content += '<td>' + list.sums + '</td>';
						content += '<td>' + list.account_number + '</td>';
						content += '<td>' + list.customer_id + '</td>';
						content += '<td>' + list.remarks + '</td>';
						content += '</tr>';
					})
					$('#cardInfos').append(content);
				}
			})
		}
	});
});