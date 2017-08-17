window.onload = function(){
	$("#createBtn").on("click", function(){
		document.writeForm.action = "draft_write";
		document.writeForm.submit();
	})
	
	$("#editBtn").on("click", function(){
		alert("hoho!");
		document.writeForm.action = "draft_edit";
		document.writeForm.submit();
	})
}

$(function(){

//결재자 검색
	var approvalName = '';
	
	//결재자 인풋창 초기화
	$('#approval_SearchKey').click(function(){
		$('#apSearchTable').empty();
		$('#ap_name_input').val('');
	})
	//결재자 사용 버튼
	$('.apUseBtn').on('click',function(){
		approvalName = $('#ap_name_input').val();
		$('#approvalName').val(approvalName);
	})
	
	//결재자 emp 검색
	$('#apSearchBtn').click(function(){
		var e_name = $('#ap_name_input').val();
		var url = "/groupware/sign/searchPeople?e_name="+e_name;
		$('#apSearchTable').empty();
		$.ajax({
			url : url,
			dataType : 'json',
			success : ap_handler
		});
	});
	
	// 결재자 emp 테이블 클릭
	$('#apSearchTable').on('click','.apGetValue',function(){
	    var $thischeck = $(this).find(".approvalCheck");
	    var allCheckBox = document.getElementsByName("apSelectEmp");
	    var approvalEmpId = '';
	    
	    $('#ap_name_input').val('');
	    approvalName = '';
	    
	    if($thischeck.is(":checked")){
	    	$thischeck.prop("checked", false);
	    } else {
	    	$thischeck.prop("checked", true);
	    }
	    
	    $.each(allCheckBox,function(index, item){
	    	if(item.checked){
	    		approvalEmpId += item.value + ", ";
	    	}
	    })
	    
	     $.each($(this).parent().find(".apGetValue"), function(index, item){
	    	if($(this).find(".approvalCheck").is(":checked")){
	    		approvalName += $(this).find(".apGetE_name").text() + ", ";
	    	}
	    });

	    $("#approval_emp").val(approvalEmpId.substring(0, approvalEmpId.length-2));
		$('#ap_name_input').val(approvalName.substring(0, approvalName.length-2));
	})
	
	
	
//참조자 검색
	var referenceName = '';
	
	//참조자 인풋창 초기화
	$('#reference_SearchKey').click(function(){
		$('#reSearchTable').empty();
		$('#re_name_input').val('');
	})
	//참조자 사용 버튼
	$('.reUseBtn').on('click',function(){
		referenceName = $('#re_name_input').val();
		$('#referenceName').val(referenceName);
	})
	
	//참조자 emp 검색
	$('#reSearchBtn').click(function(){
		var e_name = $('#re_name_input').val();
		var url = "/groupware/sign/searchPeople?e_name="+e_name;
		$('#reSearchTable').empty();
		$.ajax({
			url : url,
			dataType : 'json',
			success : re_handler
		});
	});
	
	// 참조자 emp 테이블 클릭
	$('#reSearchTable').on('click','.reGetValue',function(){
		var $thischeck = $(this).find(".referenceCheck");
		var allCheckBox = document.getElementsByName("reSelectEmp");
		var referenceEmpId = '';
		
		$('#re_name_input').val('');
		referenceName = '';
		
		if($thischeck.is(":checked")){
			$thischeck.prop("checked", false);
		} else {
			$thischeck.prop("checked", true);
		}
		
		$.each(allCheckBox,function(index, item){
			if(item.checked){
				referenceEmpId += item.value + ", ";
			}
		})
		
		$.each($(this).parent().find(".reGetValue"), function(index, item){
			if($(this).find(".referenceCheck").is(":checked")){
				referenceName += $(this).find(".reGetE_name").text() + ", ";
			}
		});
		
		$("#reference_emp").val(referenceEmpId.substring(0, referenceEmpId.length-2));
		$('#re_name_input').val(referenceName.substring(0, referenceName.length-2));
	})
})

function ap_handler(data){
	var html = '<tr><th>선택</th><th>직원번호</th><th>직원이름</th><th>부서</th></tr>';	
	$.each(data, function(index, list){
		html += '<tr class="apGetValue"><td><input type="checkbox" class="approvalCheck" name="apSelectEmp" value="'+list.emp_id+'"></td>';
		html += '<td>'+list.emp_id+'</td>';
		html += '<td class="apGetE_name">'+list.e_name+'</td>';
		html += '<td>'+list.dept_name+'</td></tr>';
	});
	$('#apSearchTable').append(html);
}

function re_handler(data){
	var html = '<tr><th>선택</th><th>직원번호</th><th>직원이름</th><th>부서</th></tr>';	
	$.each(data, function(index, list){
		html += '<tr class="reGetValue"><td><input type="checkbox" class="referenceCheck" name="reSelectEmp" value="'+list.emp_id+'"></td>';
		html += '<td>'+list.emp_id+'</td>';
		html += '<td class="reGetE_name">'+list.e_name+'</td>';
		html += '<td>'+list.dept_name+'</td></tr>';
	});
	$('#reSearchTable').append(html);
}