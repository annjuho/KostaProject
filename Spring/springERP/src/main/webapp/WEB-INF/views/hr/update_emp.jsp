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
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-8 col-md-offset-2">
			<!--?${_csrf.parameterName}=${_csrf.token }" enctype="multipart/form-data" -->
			<form:form class="form-horizontal" id="emp_insert"
				action="/hr/emp/update?${_csrf.parameterName}=${_csrf.token }" method="post" enctype="multipart/form-data">
				<input type='hidden' name='page' value="${cri.page}">
				<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
				<input type='hidden' name='searchType' value="${cri.searchType}">
				<input type='hidden' name='keyword' value="${cri.keyword}">
				<div class="form-group">
					<label for="passss" class="col-sm-2 control-label">암호</label>
					<div class="col-sm-3">
						<input type="password" class="form-control" name="e_pwd" id="passss">
					</div>
					<input type="hidden" name="emp_id" value="${employeeVO.emp_id }">
				</div>

				<div class="form-group">
					<label for="enaeeem" class="col-sm-2 control-label">이름</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_name"
							value="${employeeVO.e_name }" id="enaeeem">
					</div>
					<label for="ageeee"
						class="col-sm-2 col-sm-offset-1 control-label">나이</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_age"
							value="${employeeVO.e_age }" id="ageeee">
					</div>
				</div>

				<div class="form-group">
					<label for="hdateee" class="col-sm-2 control-label">입사일</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_hiredate"
							placeholder="YYYY-MM-DD" value="${employeeVO.e_hiredate }" id="hdateee">
					</div>
					<label for="salsal"
						class="col-sm-2 col-sm-offset-1 control-label">연봉</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_sal"
							value="${employeeVO.e_sal }" id="salsal">
					</div>
				</div>

				<div class="form-group">
					<label for="mailmail" class="col-sm-2 control-label">이메일</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="e_email"
							value="${employeeVO.e_email }" id="mailmail">
					</div>
					<label for="pnumpnum"
						class="col-sm-2 col-sm-offset-1 control-label">전화번호</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="phone_number"
							value="${employeeVO.phone_number }" id="pnumpnum">
					</div>
				</div>

				<div class="form-group">
					<label for="adr" class="col-sm-2 control-label">주소</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="e_address"
							value="${employeeVO.e_address }" id="adr">
					</div>
				</div>

				<div class="form-group">
					<label for="dept_id" class="col-sm-2 control-label">부서</label>
					<div class="col-sm-5">
						<input type="text" id="dept_id" class="form-control"
							name="dept_id" value="${employeeVO.dept_id }">
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
							id="position_id" value="${employeeVO.position_id }">
					</div>
					<div class="col-sm-2">
						<button type="button" id="position_Search" class="btn btn-default"
							data-toggle="modal" data-target="#positionSearch_modal">직급검색</button>
					</div>
				</div>

				<div class="form-group">
					<label for="job_id" class="col-sm-2 control-label">직무</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="job_id" id="job_id"
							value="${employeeVO.job_id }">
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
							id="duty_id" value="${employeeVO.duty_id }">
					</div>
					<div class="col-sm-2">
						<button type="button" id="duty_Search" class="btn btn-default"
							data-toggle="modal" data-target="#dutySearch_modal">직책검색</button>
					</div>
				</div>

				 <div class="form-group">
					<label for="ppic" class="col-sm-2 control-label">프로필사진</label>
					<div class="col-sm-8">
						<input type="file" name="uploadFile" id="ppic"/>
					</div>
				</div>
				<%-- <c:if test="${employeeVO.e_profile_pic != null}">
					<c:set var="path" value="${employeeVO.getPath() }"></c:set>
					<img alt="" src="${path }">
				</c:if> --%>
				
				<div class="form-group">
					<div class="col-sm-3 col-sm-offset-5">
						<button type="submit" class="btn btn-default">제출</button>
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