/*바코드*/
$(function(){
	$('.barcodeBtn').on('click', function(){
		var product_id = $(this).val();
		var url = "/basic/product/barcode?product_id="+product_id;
		$(location).attr('href',url);
	});
})

/*품목등록, 품목수정 회색창*/
$(function() {
	$('#newBtn').on('click', function() {
		$('.add').css("display", "block");
	})
	$('#updateBtn').on('click', function() {
		$('.update').css("display", "block");
		/*$("input[name=id_box]:checked").each(function() {
			var upSelect = $(this).val();
			console.log(upSelect);
			var url = "upSelect.ba?upSelect=" + upSelect;
			$(location).attr('href', url);
		});*/
		$('.update').css("display", "block")
	})
	$('.closeBtn').click(function() {
		$('.xclose').css("display", "none");
	})
	
})
/*체크박스 클릭시 객체 가져오기*/
$(function(){
	$('.getCheckBox').on('click',function(){
		console.log('aaaa');
		var customer_id = $(this).val();
		var url = "/basic/customer/getCustomer?customer_id="+customer_id;
		$.ajax({
			url : url,
			type : 'post',
			dataType : 'json',
			success : function(data){
				$.each(data, function(index, list){
					$('#customer_id2').val(list.customer_id);
					$('#customer_name2').val(list.customer_name);
					$('#repre_name2').val(list.repre_name);
					$('#phone_number2').val(list.phone_number);
					$('#customer_address2').val(list.customer_address);
					$('#copy_bankbook2').val(list.copy_bankbook);
					$('#customer_email2').val(list.customer_email);
					$('#customer_fax2').val(list.customer_fax);
					$('#checkman2').val(list.checkman);
				})				
			}
		})
	})
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
})
/*등록 입력할 때 v표시*/
$(function() {
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
})
/*선택품목 삭제*/
$(function() {
	$(".productChecked").click(function() {
		//$('#searchTable').empty();
		$("input[name=productRow]:checked").each(function() {
			var checks = $(this).val();
			$(".product_id2").attr("value", checks);
		});
	});
	$("#deleteBtn").on('click', function() {
		$("input[name=productRow]:checked").each(function() {
			var checks = $(this).val();
			$(location).attr("href", "/basic/product/delete?checks=" + checks);
		});
	});

});
/*품목코드 중복검색*/
$(function(){
	$('#idCheck').on('click',function() {
		var productVal = $('#ptext').val();
		$('#search_product').val(productVal);
		$('#search_id').on('click',function(){
			var searchKey = $('#search_product').val();
	  		$.ajax({
				url : "/basic/product/codeJson?searchKey="+searchKey,
				type : "post",
				dataType : "json",
				success : function(data) {
					var html = "<tr><th>품목코드</th><th>품목명</th></tr>";
					$('#searchTable').empty();
					$('#useBtn').removeAttr('disabled');
					$.each(data, function(index, list) {
						if(list.product_id == searchKey){
							$('#useBtn').attr('disabled','disabled');
						}
						html += "<tr><td>" + list.product_id + "</td><td>" + list.product_name + "</td></tr>";
				});
					if(html == "<tr><th>품목코드</th><th>품목명</th></tr>"){
						html += "<tr><td colspan='2'> 해당코드는 사용가능합니다.</td></tr>";
						$('#useBtn').removeAttr('disabled');
					};
					$('#useBtn').on('click',function(){
						var searchKey = $('#search_product').val();	
							$('#ptext').val(searchKey);
							$('#myModal').modal('hide');
						});
					$('#searchTable').append(html);
					},
				error : function(){
					alert("실패!");
				}
			});
		})
	});
 	
});
/*바코드 새창띄우기*/
$(function(){
	$('#barcodeBtn').on('click',function(){
		window.open('./basic/view/basic_barcode.jsp','window','width=600,height=400,left=100, top=100, scrollbars=yes');
		return false;
	});
});

/*excel 다운로드*/
$(function(){
	$('#excelBtn').on('click',function(){
		location.href = "excelDown.ba";
	});
});
