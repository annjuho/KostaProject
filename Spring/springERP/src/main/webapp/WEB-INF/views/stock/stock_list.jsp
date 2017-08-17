<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재고현황</title>
<link href="/resources/basic/css/basic_productList.css" rel="stylesheet">
</head>
<body>
<h2 class="page_title">재고현황</h2>
<table class="table table-bordered table-hover center">
		<thead>
			<tr>
				<th>품목번호</th>
				<th>품목명</th>
				<th>재고수량</th>
				<th>창고명</th>
				<th>창고위치</th>
			</tr>
		</thead>
		<c:forEach var="s" items="${list }">
			<tr>
				<td>${s.product_id }</td>
				<td>${s.product_name }</td>
				<td>${s.stock_amount }</td>
				<td>${s.warehouse_name }</td>
				<td>${s.warehouse_loc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>