//체크박스 삭제
$(function() {
	$("#deleteBtn").on('click', function() {
		var cmt = [];
		$("input[name=number_box]:checked").each(function() {
			cmt.push($(this).val());
		});
		var url = "/accounting/card/delete?cmt="+ cmt;
		if (cmt == "") {
			alert("삭제할 목록을 체크해주세요.");
		} else {
			$(location).attr('href', url);
		}
	})
	
//내용 수정 체크
	$('#updateBtn').click(function() {
		var val = '';
		$("input[name=number_box]:checked").each(function() {
			val = $(this).val();
		});
		if (val == "") {
			alert("수정할 내용을 체크해주세요.");
			return false;
		} else {
			$('#card_number_update').val(val);
		}
	});
});

// 체크박스 선택,해제
$(function() {
	$('#checkAll').click(function() {
		if (this.checked) {
			$('input[name=number_box]').each(function() {
				$(this).prop('checked', true);
			});
		} else {
			$('input[name=number_box').each(function() {
				$(this).prop('checked', false);
			});
		}
	});

})	

//************계좌번호검색 ************
$(function() {
$('.account_numbers_search').click(function() {
	$('.a_searchTable').empty();
	$('.search_account_number').val('');
	var url = "/Search/account/list";
	$.ajax({
		url : url,
		dataType : 'json',
		success: handler
	})
})

//검색된 계좌번호 사용하기
$('.useBtn').on('click', function() {
	var accountName = $('.search_account_number').val();
	var accountId = $('.accountHiddenid').val()
	$('.account_number').val(accountName);
	$('.accountHiddenids').val(accountId);	
})

//계정 테이블 내용 클릭시 
$('.a_searchTable').on('click', '.getValue', function() {	
	var accountName = $(this).find('.getaccountName').text();
	var accountId = $(this).find('.getaccountId').text();
	$('.search_account_number').val(accountName);
	$('.accountHiddenid').val(accountId);
})

//계좌번호 검색하기
$('.account_numbers').click(function() {	
	var diagnosis_number = $('#search_account_number').val();
	var url = "/Search/account/Idlist?account_id="+account_id;
	$('.a_searchTable').empty();
	$.ajax({
		url : url,
		dateType : 'json',
		success: handler	
	});
});

//계좌번호 검색 ajax 이벤트 처리
function handler(data) {
	var html = '<tr><th>계좌번호 아이디</th><th>계좌번호</th><th>계좌이름</th><th>계정번호</th><th>계좌내용</th><th>사용여부</th><th>비고</th></tr>';
	$.each(data, function(index, list) {
		html += '<tr class="getValue"><td class = "getaccountId">'+list.account_id+'</td>';
		html += '<td class="getaccountName">'+list.account_number+'</td>';
		html += '<td>'+list.account_name+'</td>';
		html += '<td>'+list.diagnosis_number+'</td>';
		html += '<td>'+list.account_detail+'</td>';
		html += '<td>'+list.use+'</td>';
		html += '<td>'+list.remarks+'</td>';		
		html += '</tr>';
	});
		$('.a_searchTable').append(html);
	}
})
//************계좌번호 검색 END************






//************계정검색 ************
$(function() {
$('.diagnosis_number_search').click(function() {
	$('.m_searchTable').empty();
	$('.search_diagnosis_number').val('');
	var url = "/Search/diagnosis/list";
	$.ajax({
		url : url,
		dataType : 'json',
		success: handler
	})
})

//검색된 계정 사용하기
$('.useBtn').on('click', function() {
	var diagnosisName = $('.search_diagnosis_number').val();
	$('.diagnosis_number').val(diagnosisName);
})

//계정 테이블 내용 클릭시 
$('.m_searchTable').on('click', '.getValue', function() {	
	var diagnosisName = $(this).find('.getDiagnosisName').text();
	$('.search_diagnosis_number').val(diagnosisName);
})

//계정 검색하기
$('.diagnosis_numbers').click(function() {	
	var diagnosis_number = $('.search_diagnosis_number').val();
	var url = "/Search/diagnosis/Idlist?diagnosis_number="+diagnosis_number;
	$('.m_searchTable').empty();
	$.ajax({
		url : url,
		dateType : 'json',
		success: handler	
	});
});

//계정거래 검색 ajax 이벤트 처리
function handler(data) {
	var html = '<tr><th>계정번호</th><th>계정명</th><th>사용구분</th><th>비고</th></tr>';
	$.each(data, function(index, list) {
		html += '<tr class="getValue"><td class="getDiagnosisName">'+list.diagnosis_number+'</td>';
		html += '<td>'+"["+list.diagnosis_number+"]"+list.diagnosis_name+'</td>';
		html += '<td>'+list.use+'</td>';
		html += '<td>'+list.remarks+'</td>';
		html += '</tr>'
	});
		$('.m_searchTable').append(html);
	}
})
//************계정검색 END************



//************사원번호 검색************
$(function() {
$('.emp_ids_search').click(function() {
	$('.e_searchTable').empty();
	$('.search_empId_number').val('');
	var url = "/Search/emp/list";
	$.ajax({
		url : url,
		dataType : 'json',
		success: handler
	})
})

//검색된 사원번호 사용하기
$('.useBtn').on('click', function() {
	var empIdName = $('.hiddenName').val();
	var empName = $('.search_empId_number').val();
	$('.emp_eName').val(empName);
	$('.hiddenIds').val(empIdName);		
})

//사원번호 테이블 내용 클릭시 
$('.e_searchTable').on('click', '.getValue', function() {	
	var empIdName = $(this).find('.getempId').text();
	var empName = $(this).find('.getename').text();
	$('.search_empId_number').val(empName);
	$('.hiddenName').val(empIdName);		
})

//사원번호 검색하기
$('.empIds').click(function() {	
	var empIdName = $('.search_empId_number').val();
	var url = "/Search/emp/Idlist?emp_id="+emp_id;
	$('.e_searchTable').empty();
	$.ajax({
		url : url,
		dateType : 'json',
		success: handler	
	});
});

//사워번호 검색 ajax 이벤트 처리
function handler(data) {
	var html = '<tr><th>사원번호</th><th>이름</th><th>부서번호</th><th>직급번호</th><th>직무번호</th><th>직책번호</th></tr>';
	$.each(data, function(index, list) {
		html += '<tr class="getValue"><td class="getempId">'+list.emp_id+'</td>';
		html += '<td class="getename">'+list.e_name+'</td>';
		html += '<td>'+list.dept_id+'</td>';
		html += '<td>'+list.position_id+'</td>';
		html += '<td>'+list.job_id+'</td>';
		html += '<td>'+list.duty_id+'</td>';
		html += '</tr>'
	});
		$('.e_searchTable').append(html);
	}
})
//************사워번호 검색END************
