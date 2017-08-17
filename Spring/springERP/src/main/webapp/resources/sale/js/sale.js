$(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
})
$(function(){
	$('#excelBtn').click(function(){
		$(location).attr('href','/sale/sale_excel');
	})
})
$(function(){
		//체크 박스 전부 다체크
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
    	//선택 목록 삭제
    	$('#deleteBtn').on('click', function(){
			var array = [];
			$("input[name=id_box]:checked").each(function() {
				array.push($(this).val());	
			});
			var url = "/sale/sale_delete?array="+array;
			if(array == ""){
				alert("삭제할 목록을 체크하시오.");
			}else{
				$(location).attr('href',url);
			}
		})
		//뉴 버튼
		$('#newBtn').click(function(){
			$(location).attr('href', "/sale/sale_add");
		});
    	//선택 목록 수정
    	$('#updateBtn').click(function(){
    		var val = '';
    		$("input[name=id_box]:checked").each(function() {
				val = $(this).val();
			});
    		if(val == ""){
    			alert("수정할 것을 체크하시오.");
    			return false;
    		}else{
    			$('#sell_id_update').val(val);
    		}
    	});
    });