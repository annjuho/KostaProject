<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#empSearch').on('click', function(event){
		self.location = "indol"
			+ '${pageMaker.makeQuery(1)}'
			+ "&searchType=null"
			+ "&keyword=" + $('#emp_name_input').val();
	});
});
$(function(){
	$('#update_indol_info_btn').click(function(){
		var val = '';
		$("input[name=id_box]:checked").each(function() {	
			val = $(this).val();
		});
		var url = "/hr/indol_info/indol_info_update${pageMaker.makeSearch(pageMaker.cri.page)}&emp_id="+val;
		if(val == ""){
			alert("수정할 것을 체크하시오.");
		}
		else{
			$(location).attr('href',url);
		}
	});
});
</script>
<!-- 커스텀 -->
<link rel="stylesheet" href="/resources/hr/css/emp.css">
<script src="/resources/hr/js/hr.js" type="text/javascript"></script>

</head>
<body>

	<h2 class="page_title">근태조회</h2>

	<div class="hr_body">
		<div class="pull-right">
			<div class="form-group">
				<label for="emp_name_input">이름</label> 
				<input type="text" class="input-sm" id="emp_name_input" name="emp_name">
				<button type="button" class="btn btn-default search_group" id="empSearch"><span class="fa fa-search"></span></button>
			</div>
		</div>
		<div class="container-fluid">
			<table class="table table-condensed table table-bordered">
				<thead>
					<tr class="indol_info_head">
						<th>수정체크</th>
						<th>사번</th>
						<th>이름</th>
						<th>지각</th>
						<th>결근</th>
						<th>휴가</th>
						<th>반차</th>
						<th>연차</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="IndolInfoViewVO">
						<tr class="indol_info_body">
							<td><input type="checkbox" class="upSelect check_id"
								name="id_box" value="${IndolInfoViewVO.emp_id }"></td>
							<td>${IndolInfoViewVO.emp_id }</td>
							<td>${IndolInfoViewVO.e_name }</td>
							<td>${IndolInfoViewVO.lateness }</td>
							<td>${IndolInfoViewVO.absence }</td>
							<td>${IndolInfoViewVO.vacation }</td>
							<td>${IndolInfoViewVO.half_annual }</td>
							<td>${IndolInfoViewVO.annual }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a
							href="indol${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="indol${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="indol${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>

				</ul>
			</div>
		</div>
		<button type="button" class="btn btn-default" id="update_indol_info_btn">수정</button>
	</div>

</body>
</html>