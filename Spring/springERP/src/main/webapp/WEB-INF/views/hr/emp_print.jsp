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

<script src="/webjars/jquery/2.0.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/hr/css/emp.css">

<script src="/resources/hr/js/hr.js" type="text/javascript"></script>

	<script type="text/javascript">
		var fnPrint = function() {
			window.print();
		};
	</script>


<title>Insert title here</title>
</head>
<body>
	<table class="table table-condensed table table-bordered">
		<thead>
			<tr class="emp_info_head">
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
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="empViewVO">
				<tr class="emp_info_body">
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" name="print" value="프린트" onClick="fnPrint()">
</body>
</html>