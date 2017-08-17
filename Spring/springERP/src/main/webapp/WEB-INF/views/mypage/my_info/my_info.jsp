<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Custom CSS -->
<link rel="stylesheet" href="/resources/mypage/css/my_info.css">
</head>
<body>

	<h2 class="page_title">개인정보 및 휴무신청</h2>
		
		<!-- 근태현황 조회 -->
		
		<div id="indolence" class="content-group">
		<h4>근태현황</h4>
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="row">
					<th class="col-sm-2">지각</th>
					<th class="col-sm-2">반차</th>
					<th class="col-sm-2">휴가</th>
					<th class="col-sm-2">연차</th>
					<th class="col-sm-2">결근</th>
				</tr>
			</thead>
			<tbody>
				<tr class="row">
					<td class="col-sm-2">${indolenceInfo.lateness }</td>
					<td class="col-sm-2">${indolenceInfo.half_annual }</td>
					<td class="col-sm-2">${indolenceInfo.vacation }</td>
					<td class="col-sm-2">${indolenceInfo.annual }</td>
					<td class="col-sm-2">${indolenceInfo.absence }</td>
				</tr>
			</tbody>
		</table>
		</div>
			
		
		<!-- 개인정보 수정 -->
			
		<div id="myinfo" class="content-group">
		<h4>개인정보</h4>
			<form:form role="form" action="/mypage/my_info/edit_info" method="POST" commandName="employee">
			<input type="hidden" name="emp_id" value="${employee.emp_id }"/>
			<input type="hidden" name="e_name" value="${employee.e_name }"/>
			<input type="hidden" name="e_hiredate" value="${employee.e_hiredate }"/>
			<input type="hidden" name="dept_id" value="${employee.dept_id }"/>
			<input type="hidden" name="job_id" value="${employee.job_id }"/>
			<input type="hidden" name="position_id" value="${employee.position_id }"/>
			<input type="hidden" name="duty_id" value="${employee.duty_id }"/>
			<input type="hidden" name="e_sal" value="${employee.e_sal }"/>
			<table class="table table-bordered">
				<tr>
					<td>사원번호</td>
					<td><span>${employee.emp_id }</span></td>
					<td>이름</td>
					<td><span>${employee.e_name }</span></td>
					<td>입사일</td>
					<td><span>${employee.e_hiredate }</span></td>
					<td>부서</td>
					<td><span>${employee.dept_id }</span></td>
				</tr>
				<tr>
					<td>직무</td>
					<td><span>${employee.job_id }</span></td>
					<td>직급</td>
					<td><span>${employee.position_id }</span></td>
					<td>직책</td>
					<td><span>${employee.duty_id }</span></td>
					<td>연봉</td>
					<td><span>${employee.e_sal }</span></td>
				</tr>
				<tr>
					<td colspan="2">나이</td>
					<td colspan="6">
						<input class="form-control" type="text" value="${employee.e_age }" name="e_age">
					</td>
				</tr>
				<tr>
					<td colspan="2">전화번호</td>
					<td colspan="6">
						<input class="form-control" type="text" value="${employee.phone_number }" name="phone_number">
					</td>
				</tr>
				<tr>
					<td colspan="2">이메일</td>
					<td colspan="6">
						<input class="form-control" type="text" value="${employee.e_email }" name="e_email">
					</td>
				</tr>
				<tr>
					<td colspan="2">주소</td>
					<td colspan="6">
						<input class="form-control" type="text" value="${employee.e_address }" name="e_address">
					</td>
				</tr>
				<tr>
					<td colspan="2">비밀번호</td>
					<td colspan="6">
						<input class="form-control" type="password" value="${employee.e_pwd }" name="e_pwd">
					</td>
				</tr>
			</table>
		    	<button type="submit" class="col-sm-3 btn btn-default">수정</button>
		    </form:form>
		</div>
		
		
		
		<!-- 휴가신청 -->
		
		<div id="holiday" class="content-group">
		<h4>휴가신청</h4>
		<form:form role="form" action="/mypage/my_info/indol_request" method="POST" commandName="indolRequest">
			
			<input type="hidden" name="emp_id" value="${employee.emp_id }"/>
			<div class="col-sm-3">
				<select class="form-control" name="request_type">
					<option selected>선택하세요</option>
					<option value="annual">연차</option>
					<option value="vacation">휴가</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input type="date" class="form-control" name="start_nowork_date">
			</div>
			<div class="col-sm-3">
				<input type="date" class="form-control" name="end_nowork_date">
			</div>
			<button type="submit" class="col-sm-3 btn btn-success">신청</button>
		</form:form>
		</div>

</body>
</html>