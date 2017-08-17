<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
<!-- 커스텀 -->
<link rel="stylesheet" href="/resources/hr/css/emp.css">
<script src="/resources/hr/js/hr.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	$('#empSearch').on('click', function(event){
		self.location = "indol_request"
			+ '${pageMaker.makeQuery(1)}'
			+ "&searchType=null"
			+ "&keyword=" + $('#emp_name_input').val();
	});
});
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
	
	$('#request_approve').on('click', function(){
		var array = [];
		$("input[name=id_box]:checked").each(function() {
			array.push($(this).val());	
		});
		var url = "/hr/indol_request/request_approve${pageMaker.makeSearch(pageMaker.cri.page)}&array="+array;
		if(array == ""){
			alert("삭제할 목록을 체크하시오.");
		}else{
			$(location).attr('href',url);
		}		
	});
});
</script>
</head>
<body>

	<h2 class="page_title">연차/휴가요청</h2>

	<div class="container-fluid">
		<div class="pull-right">
			<div class="form-group">
				<label for="emp_name_input">이름</label> <input type="text"
					class="input-sm" id="emp_name_input" name="emp_name">
				<button type="button" class="btn btn-default search_group" id="empSearch"><span class="fa fa-search"></span></button>
			</div>
		</div>
		<table class="table table-condensed table table-bordered">
			<thead>
				<tr class="indol_request_th">
					<th><input type="checkbox" id="checkAll"></th>
					<th>요청번호</th>
					<th>사번</th>
					<th>이름</th>
					<th>시작일</th>
					<th>종료일</th>
					<th>신청일</th>
					<th>타입</th>
					<th>승인여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="indolRequestViewVO">
					<tr class="indol_request_body">
						<td><input type="checkbox" class="upSelect check_id"
							name="id_box" value="${indolRequestViewVO.indol_request_id }"></td>
						<td>${indolRequestViewVO.indol_request_id }</td>
						<td>${indolRequestViewVO.emp_id }</td>
						<td>${indolRequestViewVO.e_name }</td>
						<td>${indolRequestViewVO.start_nowork_date }</td>
						<td>${indolRequestViewVO.end_nowork_date }</td>
						<td>${indolRequestViewVO.request_date }</td>
						<td>${indolRequestViewVO.request_type }</td>
						<td>${indolRequestViewVO.approve }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a
						href="indol_request${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="indol_request${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="indol_request${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>

			</ul>
		</div>
		<button type="button" class="btn btn-default" id="request_approve">승인</button>
	</div>
</body>
</html>