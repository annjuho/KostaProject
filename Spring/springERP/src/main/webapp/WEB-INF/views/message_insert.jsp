<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<script src="/webjars/jquery/2.0.0/jquery.min.js"></script>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
<script src="/resources/hr/js/hr.js" type="text/javascript"></script>
<script src="/webjars/bootstrap/3.3.6/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/hr/css/emp.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/dist/css/bootstrap.min.css">


<!-- Custom Style -->
<link rel="stylesheet" href="/resources/common/css/common.css"><base>


<script type="text/javascript">
	$(function() {
 		$('#emp_Search').click(function() {
			$('#empTable').empty();
			$('#empModalData').empty();
			$('#receive_id').val('');
		}); 

		$('#findEMP').click(
			function() {
				$('#empTable').empty();
				$('#empModalData').empty();
				$('#receive_id').val('');
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
			$('#receive_id').val(emp_id);
		});
	});
</script>
<style type="text/css">
body {
	margin: 20px;
}
#emp_Search {
	float: right;
	margin-right: 15px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form-horizontal" id="send_message"
				action="/message/send_message" method="post">
				<input type="hidden" name="send_id" value="${emp_id }">
				<div class="form-group">
					<label for="emp_id_label" class="col-sm-2 control-label">TO</label>
					<button type="button" id="emp_Search" class="btn btn-default btn-xs"
							data-toggle="modal" data-target="#empSearch_modal">직원검색</button>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="receive_id"
							id='receive_id' value="${receive_id }">
				<!-- 			<button type="button" id="emp_Search" class="btn btn-default"
							data-toggle="modal" data-target="#empSearch_modal">직원검색</button> -->
					</div>
				</div>
				<div class="form-group">
					<label for="e_name_label" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="title">
					</div>
				</div>

				<div class="form-group">
					<label for="e_hiredate_label" class="col-sm-2 control-label">내용</label>
					<div class="col-sm-3">
						<textarea class="form-control" name="contents" rows="6"></textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-3 col-sm-offset-5">
						<button type="submit" class="btn btn-default">제출</button>
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
							class="form-control input-sm" id="keyword_input" name="e_name">
						<button id='findEMP' class="btn btn-sm">검색</button>
					</div>

					<table id="empTable" class="table table-bordered table-hover">

					</table>
					<div id="useBtnArea">
						<input type="text" id="empModalData"> <input type="button"
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