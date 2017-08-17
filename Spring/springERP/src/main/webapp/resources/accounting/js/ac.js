//체크박스 삭제
$(function() {
	$("#deleteBtn").on('click', function() {
		var count = [];
		$("input[name=number_box]:checked").each(function() {
			count.push($(this).val());
		});
		var url = "/accounting/account/delete?count="+ count;
		if (count == "") {
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
			$('#account_number_update').val(val);
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
});


//계정검색 
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






// 작은 검색창 인풋창 초기화
/*
$(function() {
	$('#account_numbers').click(function() {
		$('#m_searchTable').empty();
		$('#search_account_number').val('');
	})
	// 작은 검색창 사용버튼
	$('.useBtn').click(function() {
		var accountName = $('#search_account_number').val();
		$('#account_number').val(accountName);
	})
	// 작은 검생창 테이블 클릭
	$('#m_searchTable').click(function() {
		var accountName = $(this).find('.getAccountName').text();
		$('#search_account_number').val(accountName);
	})

	// 검색창 검색
	$('#warehouseID').click(function() {
		var account_id = $('#search_account_number').val();
		var url = "accountList.ac?account_detail=" + account_id;
		$('#m_searchTable').empty();
		$.ajax({
			url : url,
			dataType : 'json',
			success : handler
		});
	});
	function handler(data) {
		var html = '<tr><th>계좌번호</th><th>계좌명</th><th>계정정보</th></tr>';
		$.each(data, function(index, list) {
			html += '<tr class="getValue"><td class="getAccountName">'
					+ list.account_number + '</td>';
			html += '<td>' + list.account_name + '</td>';
			html += '<td>' + list.account_detail;
			+'</td>';
		});
		$('#m_searchTable').append(html);
	}
})*/