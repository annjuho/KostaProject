<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
<title>Insert title here</title>

<!-- 커스텀 -->
<link rel="stylesheet" href="/resources/hr/css/emp.css">
<script src="/resources/hr/js/hr.js" type="text/javascript"></script>

</head>
<body>
	<div class="add_basic">
		<div class="title">
			<span class="basic_title"><strong>부서등록</strong></span>
			<button type="button" class="closebtn close" id="closeBtn">
				<span>&times;</span>
			</button>
		</div>
		<br>
		<div class="container-fluid">
			<div class="col-md-12">
				<table class="table table-condensed table table-bordered">
					<thead class="basic_info_body">
					</thead>
				</table>
			</div>
		</div>

		<form:form class="form-horizontal" id="b_insert" action="/hr/hr_basic/basic_insert"
			method="post">
			<div class="form-group">
				<div class="container-fluid" id="basic_insert_form">
					<label id="insert_id_label" for="basic_id_input"
						class="col-sm-2 control-label">부서번호</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="basic_id"
							id="basic_id_input">
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-default" id="check_id">중복확인</button>
					</div>
					<label id="insert_name_label" for="basic_name_input"
						class="col-sm-2 control-label">부서명</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="basic_name_input" name="basic_name">
					</div>

					<input type="hidden" id="insert_type" name="basic_type"
						value="dept">

					<div class="col-sm-1">
						<button type="submit" class="btn btn-default">등록</button>
					</div>
				</div>
			</div>
		</form:form>
		
		
		<form:form class="form-horizontal" id="b_update" action="/hr/hr_basic/basic_update"
			method="post">
			<div class="form-group">
				<div class="container-fluid" id="basic_update_form">
					<label id="update_id_label" for="basic2"
						class="col-sm-2 control-label">부서번호</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="basic_id" id="basic2">
					</div>

					<label id="update_name_label" for="basic_name2"
						class="col-sm-2 col-sm-offset-1 control-label">부서명</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="basic_name" id="basic_name2">
					</div>

					<input type="hidden" id="del_type" name="basic_type"
						value="dept">

					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">수정</button>
					</div>
				</div>
			</div>
		</form:form>
		
		<form:form class="form-horizontal" id="b_update2" action="/hr/hr_basic/basic_del"
			method="post">
			<div class="form-group">
				<div class="container-fluid" id="basic_update_form2">
					<label id="del_id_label" for="basic_id3"
						class="col-sm-2 control-label">부서번호</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" name="basic_id" id="basic_id3">
					</div>
					<input type="hidden" id="update_type" name="basic_type"
						value="dept">
					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">삭제</button>
					</div>
				</div>
			</div>
		</form:form>
		
		<button class="closebtn btn btn-default col-md-2 col-md-offset-5">닫기</button>
	</div>



	<div class="container-fluid">
		<div class="col-md-8 col-md-offset-2">
			<table class="table table-bordered" id="basic_insert">
				<tr>
					<th>부서</th>
					<th>직급</th>
					<th>직무</th>
					<th>직책</th>
				</tr>
				<tr>
					<td><button type="button" class="btn btn-default" id="dept">등록</button></td>
					<td><button type="button" class="btn btn-default" id="position">등록</button></td>
					<td><button type="button" class="btn btn-default" id="job">등록</button></td>
					<td><button type="button" class="btn btn-default" id="duty">등록</button></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>