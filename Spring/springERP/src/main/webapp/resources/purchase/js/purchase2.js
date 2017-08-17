$(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
})
$(function(){
    	$('#checkAll').click(function(){
    		if(this.checked){
    			$('input[name=id_box]').each(function(){
    				$(this).prop('checked',true);
    			});
    		}else{
    			$('input[name=id_box]').each(function(){
    				$(this).prop('checked',false);
    			});
    		}        	
    	});
    	$('#deleteBtn').on('click', function(){
			var array = [];
			$("input[name=id_box]:checked").each(function() {
				array.push($(this).val());	
			});
			var url = "/purchase/purchase_delete?array="+array;
			if(array == ""){
				alert("삭제할 목록을 체크하시오.");
			}else{
				$(location).attr('href',url);
			}		
		})
		$('#newBtn').click(function(){
			$(location).attr('href', "/purchase/purchase_add");
		});
    	$('#updateBtn').click(function(){
    		var val = '';
    		$("input[name=id_box]:checked").each(function() {
				val = $(this).val();
			});
    		if(val == ""){
    			alert("수정할 것을 체크하시오.");
    			return false;
    		}else{
    			$('#buy_id_update').val(val);
    	}
    });
});
$(function(){
	$('#item_search').click(function(){
		$('.item_div').css("display","block")
	})
	$('#item_closeBtn').click(function(){
		$('.item_div').css("display","none")
	})
	$('#customer_search').click(function(){
		$('.customer_div').css("display","block")
	})
	$('#customer_closeBtn').click(function(){
		$('.customer_div').css("display","none")
	})
	$('#detail_search').click(function(){
		$('.hide_detail').css("display","block");
	})
	$('#simple_search').click(function(){
		$('.hide_detail').css("display","none");
	})
	$('#excelBtn').click(function(){
		$(location).attr('href','/purchase/purchase_excel');
	})
	$('#excelBtn2').click(function(){
		$(location).attr('href','/purchase/purchase_excelUp');
	})
})
$(function(){
	//거래처 인풋창 초기화
	$('#customer_SearchKey').click(function(){
		$('#searchTable').empty();
		$('#search_customerID').val('');
	})
	//거래처 사용 버튼
	$('.useBtn').on('click',function(){
		var customerName = $('#search_customerID').val();
		$('#customer_id').val(customerName);
	})
	
	//거래처 테이블 클릭
	$('#searchTable').on('click','.getValue',function(){
		var customerName = $(this).find('.getCustomerName').text();
		$('#search_customerID').val(customerName);
	})
	
	// 거래처 검색
	$('#customerID').click(function(){
		var customer_id = $('#search_customerID').val();
		var url = "/purchase/customer_id_search?customer_id="+customer_id;
		$('#searchTable').empty();
		$.ajax({
			url : url,
			dataType : 'json',
			success : handler
		});
	});
	function handler(data){
		var html = '<tr><th>거래처 코드</th><th>거래처명</th><th>담당자</th></tr>';	
		$.each(data, function(index, list){
			html += '<tr class="getValue"><td class="getCustomerName">'+list.customer_id+'</td>';
			html += '<td>'+list.customer_name+'</td>';
			html += '<td>'+list.repre_name+'</td>';
		});
		$('#searchTable').append(html);
	}
	//품목 인풋창 초기화
	$('#product_SearchKey').click(function(){
		$('#p_searchTable').empty();
		$('#search_productID').val('');
	})
	//품목 사용 버튼
	$('.useBtn').on('click',function(){
		var productName = $('#search_productID').val();
		$('#product_id').val(productName);
	})
	//품목 테이블 클릭
	$('#p_searchTable').on('click','.p_getValue',function(){
		var productName = $(this).find('.p_getCustomerName').text();
		$('#search_productID').val(productName);
	})
	//품목 검색
	$('#productID').click(function(){
		var product_id = $('#search_productID').val();
		var url = "/purchase/product_id_search?product_id="+product_id;
		$('#p_searchTable').empty();
		$.ajax({
			url : url,
			dataType : 'json',
			success : p_handler
		});
	});
	function p_handler(data){
		var html = '<tr><th>품목 코드</th><th>품목명</th><th>원산지</th></tr>';	
		$.each(data, function(index, list){
			html += '<tr class="p_getValue"><td class="p_getCustomerName">'+list.product_id+'</td>';
			html += '<td>'+list.product_name+'</td>';
			html += '<td>'+list.made_in+'</td>';
		});
		$('#p_searchTable').append(html);
	}
	
	//창고 인풋창 초기화
	$('#warehouse_SearchKey').click(function(){
		$('#w_searchTable').empty();
		$('#search_warehouseID').val('');
	})
	//창고 사용 버튼
	$('.useBtn').on('click',function(){
		var warehouseName = $('#search_warehouseID').val();
		$('#warehouse_id').val(warehouseName);
	})
	//창고 테이블 클릭
	$('#w_searchTable').on('click','.w_getValue',function(){
		var warehouseName = $(this).find('.w_getCustomerName').text();
		$('#search_warehouseID').val(warehouseName);
	})
	//창고 검색
	$('#warehouseID').click(function(){
		var warehouse_id = $('#search_warehouseID').val();
		var url = "/purchase/warehouse_id_search?warehouse_id="+warehouse_id;
		$('#w_searchTable').empty();
		$.ajax({
			url : url,
			dataType : 'json',
			success : w_handler
		});
	});
	function w_handler(data){
		var html = '<tr><th>창고 코드</th><th>창고명</th><th>창고위치</th></tr>';	
		$.each(data, function(index, list){
			html += '<tr class="w_getValue"><td class="w_getCustomerName">'+list.warehouse_id+'</td>';			html += '<td>'+list.warehouse_name+'</td>';
			html += '<td>'+list.warehouse_loc+'</td>';
		});
		$('#w_searchTable').append(html);
	}
})

