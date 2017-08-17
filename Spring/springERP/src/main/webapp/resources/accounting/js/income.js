$(function() {
	$(".income_date").datepicker(
			{
				dateFormat : 'yy-mm-dd',
				prevText : '이전 달',
				nextText : '다음 달',
				monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
						'9월', '10월', '11월', '12월' ],
				monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
						'8월', '9월', '10월', '11월', '12월' ],
				dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
				dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
				dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
				showMonthAfterYear : true,
				changeMonth : true,
				changeYear : true,
				yearSuffix : '년'
			});
});


//*********모달 검색 기능 ***********
//************부서검색 ************
$(function() {
	$('.dept_id_search').click(function() {
		$('.d_searchTable').empty();
		$('.search_dept_id').val('');
		var url = "/Search/hr/list";
		$.ajax({
			url : url,
			dataType : 'json',
			success : handler
		})
	})

	// 부서번호 사용하기
	$('.useBtn').on('click', function() {
		var deptid = $('.search_dept_id').val();
		var deptname = $('.search_dept_name').val()
		$('.dept_id').val(deptid);
		$('.dept_name').val(deptname);
	})

	// 부서 테이블 내용 클릭시
	$('.d_searchTable').on('click', '.getValue', function() {
		var deptid = $(this).find('.getdeptId').text();
		var deptname = $(this).find('.getdeptName').text();
		$('.search_dept_id').val(deptid);
		$('.search_dept_name').val(deptname);
	})

	// 부서번호 검색하기 - 사용안함 (부서 목록은 개수가 작기 때문에 불필요)
	/*
	 * $('.dept_ids').click(function() { var diagnosis_number =
	 * $('.search_dept_id').val(); var url =
	 * "/accounting/account/account_id_search?account_id="+account_id;
	 * $('.d_searchTable').empty(); $.ajax({ url : url, dateType : 'json',
	 * success: handler }); });
	 */

	// 부서번호 출력 ajax 이벤트 처리
	function handler(data) {
		var html = '<tr><th>부서번호</th><th>부서명</th></tr>';
		$.each(data, function(index, list) {
			html += '<tr class="getValue"><td class = "getdeptId">'
					+ list.dept_id + '</td>';
			html += '<td class="getdeptName">' + list.dept_name + '</td>';
			html += '</tr>';
		});
		$('.d_searchTable').append(html);
	}
})
//************부서 검색 END************

//************프로젝트 검색 Start ************
$(function() {
	$('.proj_id_search').click(function() {
		$('.p_searchTable').empty();
		$('.search_proj_id').val('');
		var url = "/Search/gw/list";
		$.ajax({
			url : url,
			dataType : 'json',
			success : handler
		})
	})

	// 프로젝트번호 사용하기
	$('.useBtn').on('click', function() {
		var projid = $('.search_proj_id').val();
		var projname = $('.search_proj_name').val()
		$('.proj_id').val(projid);
		$('.proj_name').val(projname);
	})

	// 프로젝트 테이블 내용 클릭시
	$('.p_searchTable').on('click', '.getValue', function() {
		var projid = $(this).find('.getproj_id').text();
		var projname = $(this).find('.getproj_name').text();
		$('.search_proj_id').val(projid);
		$('.search_proj_name').val(projname);
	})

	// 프로젝트 번호 검색하기
	$('.projIds').click(function() {
		var projid = $('.search_proj_id').val();
		var url = "/Search/gw/Idlist?proj_id=" + proj_id;
		$('.p_searchTable').empty();
		$.ajax({
			url : url,
			dateType : 'json',
			success : handler
		});
	});

	// 프로젝트 출력 ajax 이벤트 처리
	function handler(data) {
		var html = '<tr><th>프로젝트 번호</th><th>프로젝트 명</th><th>프로젝트 기간</th><th>프로젝트 시작일</th><th>프로젝트 종료일</th><th>직원번호</th></tr>';
		$.each(data, function(index, list) {
			html += '<tr class="getValue"><td class = "getproj_id">'
					+ list.proj_id + '</td>';
			html += '<td class="getproj_name">' + list.proj_name + '</td>';
			html += '<td>' + list.proj_period + '</td>';
			html += '<td>' + list.proj_start_date + '</td>';
			html += '<td>' + list.proj_end_date + '</td>';
			html += '<td>' + list.emp_id + '</td>';
			html += '</tr>';
		});
		$('.p_searchTable').append(html);
	}
})
//************프로젝트 검색 End************