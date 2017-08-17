<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form-horizontal" id="emp_insert"
				action="/hr/emp/emp_insert?${_csrf.parameterName}=${_csrf.token }" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="emp_id" class="col-sm-2 control-label">사번</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="emp_id" id='emp_id'>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-default" id='emp_check'>중복확인</button>
					</div>
					<label for="e_pass" class="col-sm-2 control-label">암호</label>
					<div class="col-sm-3">
						<input type="password" class="form-control" name="e_pwd" id="e_pass">
					</div>
				</div>

				<div class="form-group">
					<label for="nameeee" class="col-sm-2 control-label">이름</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_name" id="nameeee">
					</div>
					<label for="ageeee"
						class="col-sm-2 col-sm-offset-1 control-label">나이</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_age" id="ageeee">
					</div>
				</div>

				<div class="form-group">
					<label for="hdateee" class="col-sm-2 control-label">입사일</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_hiredate"
							placeholder="YYYY-MM-DD" id="hdateee">
					</div>
					<label for="salllll"
						class="col-sm-2 col-sm-offset-1 control-label">연봉</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_sal" id="salllll">
					</div>
				</div>

				<div class="form-group">
					<label for="maillllllll" class="col-sm-2 control-label">이메일</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_email" id="maillllllll">
					</div>
					<label for="pnummmm"
						class="col-sm-2 col-sm-offset-1 control-label">전화번호</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="phone_number" id="pnummmm">
					</div>
				</div>

				<div class="form-group">
					<label for="adreee" class="col-sm-2 control-label">주소</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="e_address" id="adreee">
					</div>
				</div>

				<div class="form-group">
					<label for="dept_id" class="col-sm-2 control-label">부서</label>
					<div class="col-sm-5">
						<input type="text" id="dept_id" class="form-control"
							name="dept_id">
					</div>
					<div class="col-sm-2">
						<button type="button" id="dept_Search" class="btn btn-default"
							data-toggle="modal" data-target="#deptSearch_modal">부서검색</button>
					</div>
				</div>

				<div class="form-group">
					<label for="position_id" class="col-sm-2 control-label">직급</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="position_id"
							id="position_id">
					</div>
					<div class="col-sm-2">
						<button type="button" id="position_Search" class="btn btn-default"
							data-toggle="modal" data-target="#positionSearch_modal">직급검색</button>
					</div>
				</div>

				<div class="form-group">
					<label for="job_id" class="col-sm-2 control-label">직무</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="job_id" id="job_id">
					</div>
					<div class="col-sm-2">
						<button type="button" id="job_Search" class="btn btn-default"
							data-toggle="modal" data-target="#jobSearch_modal">직무검색</button>
					</div>
				</div>

				<div class="form-group">
					<label for="duty_id" class="col-sm-2 control-label">직책</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="duty_id"
							id="duty_id">
					</div>
					<div class="col-sm-2">
						<button type="button" id="duty_Search" class="btn btn-default"
							data-toggle="modal" data-target="#dutySearch_modal">직책검색</button>
					</div>
				</div>

				<div class="form-group">
					<label for="pro_pic" class="col-sm-2 control-label">프로필사진</label>
					<div class="col-sm-8">
						<input type="file" name="uploadFile" id="pro_pic"/>
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
	<!-- 모달 -->
	<!-- dept -->
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
	<!-- position -->
	<div id="positionSearch_modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">직급 검색</h4>
				</div>
				<div class="modal-body">
					<br>
					<table id="positionTable" class="table table-bordered table-hover">

					</table>
					<div id="useBtnArea">
						<input type="text" id="positionModalData" class="modal_id"> <input
							type="button" class="btn btn-default center useBtn" value="사용"
							data-dismiss="modal" id="positionUse">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<!-- job -->
	<div id="jobSearch_modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">직무 검색</h4>
				</div>
				<div class="modal-body">
					<br>
					<table id="jobTable" class="table table-bordered table-hover">

					</table>
					<div id="useBtnArea">
						<input type="text" id="jobModalData" class="modal_id"> <input type="button"
							class="btn btn-default center useBtn" value="사용"
							data-dismiss="modal" id="jobUse">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<!-- duty -->
	<div id="dutySearch_modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">직책 검색</h4>
				</div>
				<div class="modal-body">
					<br>
					<table id="dutyTable" class="table table-bordered table-hover">

					</table>
					<div id="useBtnArea">
						<input type="text" id="dutyModalData" class="modal_id"> <input
							type="button" class="btn btn-default center useBtn" value="사용"
							data-dismiss="modal" id="dutyUse">
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