window.onload = function(){
	
	var draft_id = document.location.href.split("draft_view")[1];
	
	$.ajax({
		url : "/groupware/sign/approval"+draft_id,
		dataType : "json",
		success : function(data){
			$.ajax({
				url : "/approval",
				dataType : "text",
				success : function(emp_data){
					var getEmp_id;
					getEmp_id = emp_data;
					$.each(data, function(index, item){
						if(getEmp_id==item){
							var str = '<a href="/groupware/sign/draft_ok' + draft_id + '" class="btn btn-warning pull-right">결재확인</a>';
							$(".panel-title").before(str);
						}
					})
				}
			})
		}
	});
}

$(function(){
	
	$('#printBtn').click(function(){
		var draft_id = $(this).val();
		var newWindow = window.open('printPop'+draft_id, '프린트하기', 'width=800, height=1000, menubar=no, status=no, toolbar=no');
	});

})