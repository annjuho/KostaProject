<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>어음 목록</h2>
	<table class="table table-bordered table-hover new">
		<thead>
			<tr>
				<th>어음</th>
				<th>부서번호</th>
				<th>프로젝트번호</th>
				<th>거래처번호</th>
				<th>생성일</th>
				<th>만기일</th>
				<th>총액</th>
				<th>비고</th>
			</tr>			
		</thead>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.typelist}</td>
				<td>${list.dept_id }</td>
				<td>${list.proj_id }</td>
				<td>${list.customer_id }</td>
				<td>${list.red_date }</td>
				<td>${list.ex_date }</td>
				<td>${list.sums }</td>
				<td>${list.remarks }</td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>