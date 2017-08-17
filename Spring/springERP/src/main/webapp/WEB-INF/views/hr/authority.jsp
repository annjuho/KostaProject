<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
$(function() {
		$('#emp_Search').click(function() {
		$('#empTable').empty();
		$('#empModalData').empty();
		$('#emp_id').val('');
	}); 

	$('#findEMP').click(
		function() {
			$('#empTable').empty();
			$('#empModalData').empty();
			$('#emp_id').val('');
			var e_name = $('#keyword_input').val();
			$.ajax({
						type:"POST",
						url:"/message/getEmpID",
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "POST"
						},
						dataType : 'json',
						data : JSON.stringify({
							e_name : e_name
						}),
						success : function(data){
							var str = "<tr class='table_head'> <th>직원번호</th> <th>직원이름</th> <th>부서명</th> </tr>";
							$.each(data,function(index,emp){
								str += "<tr class='table_data'><td class='getEmp'>"
									+ emp.emp_id
									+ "</td>"
									+ "<td>"
									+ emp.e_name
									+ "</td>"
									+ "<td>"
									+ emp.dept_name
									+"</td></tr>";
							});
							$("#empTable").html(str);
						}
			});
		}
	);
	
	$('#empTable').on('click','.table_data', function(){
		var emp_id = $(this).find('.getEmp').text();
		$('#empModalData').val(emp_id);
	});
	
	$('#empUse').on('click',function(){
		var emp_id = $('#empModalData').val();
		$('#emp_id').val(emp_id);
	});
});
</script>
<style type="text/css">
	.headLabel{
		font-size: large;
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-9 col-md-offset-1">
			<form:form class="form-horizontal" id="autority_set"
				action="/hr/autorityDept" method="post">
				<div class="form-group">
					<label for="autorityDept" class="col-sm-3 control-label headLabel">부서별 권한</label><br><br><br>
					<label for="dept_id" class="col-sm-2 control-label">부서</label>
					<div class="col-sm-2">
						<input type="text" id="dept_id" class="form-control"
							name="dept_id" value="">
					</div>
					<div class="col-sm-2">
						<button type="button" id="dept_Search" class="btn btn-default"
							data-toggle="modal" data-target="#deptSearch_modal">부서검색</button>
					</div>
					<label for="dept_authority" class="col-sm-2 control-label">권한명</label>
					<div class="col-sm-2">
						<input type="text" id="dept_authority" class="form-control"
							name="authorities" value="">
					</div>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">확인</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div id="deptSearch_modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">부서 검색</h4>
				</div>
				<div class="modal-body">
					<br>
					<table id="deptTable" class="table table-bordered table-hover">

					</table>
					<div id="useBtnArea">
						<input type="text" id="deptModalData" class="modal_id"> <input
							type="button" class="btn btn-default center useBtn" value="사용"
							data-dismiss="modal" id="deptUse">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<br><br><br><br>
	<div class="container-fluid">
		<div class="col-md-9 col-md-offset-1">
			<form:form class="form-horizontal" id="autority_set2"
				action="/hr/autorityPerson" method="post">
				<div class="form-group">
					<label for="autorityPerson" class="col-sm-3 control-label headLabel">개인별 권한</label><br><br><br>
					<label for="emp_id" class="col-sm-2 control-label">사번</label>
					<div class="col-sm-2">
						<input type="text" id="emp_id" class="form-control"
							name="emp_id" value="">
					</div>
					<div class="col-sm-2">
						<button type="button" id="emp_Search" class="btn btn-default"
							data-toggle="modal" data-target="#empSearch_modal">개인검색</button>
					</div>
					<label for="emp_authority" class="col-sm-2 control-label">권한명</label>
					<div class="col-sm-2">
						<input type="text" id="emp_authority" class="form-control"
							name="authorities" value="">
					</div>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">확인</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div id="empSearch_modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">직원 검색</h4>
				</div>
				<div class="modal-body">
					<br>
					<div class="form-group">
						<label for="search_contents">직원이름</label> <input type="text"
							class="input-sm" id="keyword_input" name="e_name">
						<button type="button" class="btn btn-default search_group" id="findEMP"><span class="fa fa-search"></span></button>
					</div>

					<table id="empTable" class="table table-bordered table-hover">

					</table>
					<div id="useBtnArea2">
						<input type="text" id="empModalData" class="modal_id"> <input type="button"
							class="btn btn-default center useBtn" value="사용"
							data-dismiss="modal" id="empUse">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>