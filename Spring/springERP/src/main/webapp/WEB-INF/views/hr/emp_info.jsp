<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	function fn_insert_emp(){
		location.href="/hr/emp/insert";
	}
</script>
<script type="text/javascript">
	$(function(){
		$('#empSearch').on('click', function(event){
			self.location = "emp"
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
    	
    	$('#delete_emp_btn').on('click', function(){
			var array = [];
			$("input[name=id_box]:checked").each(function() {
				array.push($(this).val());	
			});
			//array="+array+"&"
			var url = "/hr/emp/emp_delete${pageMaker.makeSearch(pageMaker.cri.page)}&array="+array;
			if(array == ""){
				alert("삭제할 목록을 체크하시오.");
			}else{
				$(location).attr('href',url);
			}		
		});
		
    	$('#update_emp_btn').click(function(){
    		var val = '';
    		$("input[name=id_box]:checked").each(function() {
				val = $(this).val();
			});
    		var url = "/hr/emp/emp_update${pageMaker.makeSearch(pageMaker.cri.page)}&emp_id="+val;
    		if(val == ""){
    			alert("수정할 것을 체크하시오.");
    		}
    		else{
    			$(location).attr('href',url);
    		}
    	});
    	
    	
    	
    	$('#print_emp_btn').click(function(){
    		var newWindow = window.open("about:blank")
    		var url = "/hr/emp/emp_print";
    		newWindow.location.href=url;
    	});
    	
    	$('#pic_show_btn').click(function(){
    		$("#pic_area").empty();
    		var emp_id = '';
    		
    		$("input[name=id_box]:checked").each(function() {
				emp_id = $(this).val();
			});
    		
    		$.ajax({
				type:"POST",
				url:"/hr/emp/showPic",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'json',
				data : JSON.stringify({
					emp_id : emp_id
				}),
				success : function(data){
					var str='';
					if(data.e_profile_pic!=null){
						str+="<img alt='' src='"+data.fullPath+"'>";
						$("#pic_area").html(str);
					}
				}
			});
    	});	
    });
</script>
<style type="text/css">
ul {
	list-style: none;
	padding: 0;
	margin: 0;
}
</style>
</head>
<body>

	<h2 class="page_title">직원조회</h2>

	<div class="hr_body">
		<div class="pull-right">
			<div class="form-group search_group">
				<label for="emp_name_input" class="search_group">이름</label> <input type="text"
					class="input-sm search_group" id="emp_name_input" name="emp_name">
					<button type="button" class="btn btn-default search_group" id="empSearch"><span class="fa fa-search"></span></button>
			</div>
		</div>
		<div class="container-fluid">
			<table class="table table-condensed table table-bordered">
				<thead>
					<tr class="emp_info_head">
						<th><input type="checkbox" id="checkAll"></th>
						<th>사번</th>
						<th>이름</th>
						<th>나이</th>
						<th>입사일</th>
						<th>부서명</th>
						<th>연봉</th>
						<th>주소</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>직급명</th>
						<th>직무명</th>
						<th>직책명</th>
						<th>권한</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="empViewVO">
				<%-- 	<fmt:parseDate value="${empViewVO.e_hiredate}" var="hiredate" pattern="YYYY-MM-dd HH:MM:ss"/> --%>
					
						<tr class="emp_info_body">
							<td><input type="checkbox" class="upSelect check_id"
								name="id_box" value="${empViewVO.emp_id }"></td>
							<td>${empViewVO.emp_id }</td>
							<td>${empViewVO.e_name }</td>
							<td>${empViewVO.e_age }</td>
							<td>${empViewVO.e_hiredate }</td>
							<td>${empViewVO.dept_name }</td>
							<td>${empViewVO.e_sal }</td>
							<td>${empViewVO.e_address }</td>
							<td>${empViewVO.e_email }</td>
							<td>${empViewVO.phone_number }</td>
							<td>${empViewVO.position_name }</td>
							<td>${empViewVO.job_name }</td>
							<td>${empViewVO.duty_name }</td>
							<td>${empViewVO.authorities }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a
							href="emp${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="emp${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="emp${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>

				</ul>
			</div>
		</div>
		<button type="button" class="btn btn-default" id="insert_emp_btn"
			onclick="fn_insert_emp()">신규등록</button>
		<button type="button" class="btn btn-default" id="update_emp_btn">수정</button>
		<button type="button" class="btn btn-default" id="delete_emp_btn">삭제</button>
		<button type="button" class="btn btn-default" id="pic_show_btn"
			data-toggle="modal" data-target="#show_pic">프로필사진</button>
		<button type="button" class="btn btn-default" id="print_emp_btn">인쇄</button>
	</div>
	<div id="show_pic" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">프로필사진</h4>
			</div>
			<div class="modal-body">
				<br>
				<div id="pic_area">
					
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</body>
</html>