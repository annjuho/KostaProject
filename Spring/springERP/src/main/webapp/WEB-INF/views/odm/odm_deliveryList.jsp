<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/stock/css/stock.css" rel="stylesheet">
</head>
<body>

	<h2 class="page_title">배송리스트</h2>
	
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<!-- <th><input type="checkbox"></th> -->
				<th>배송번호</th>
				<th>주문번호</th>
				<!-- <th>송장번호</th> -->
				<th>수취인</th>
				<th>수취인주소</th>
				<th>배송상태</th>
			</tr>
		</thead>
		<c:forEach var="c" items="${list}">
			<tr class="localcenter">
				<!-- <td><input type="checkbox"></td> -->
				<td>${c.delivery_id}</td>
				<td>${c.order_id}</td>
				<%-- <td>${ }</td> --%>
				<td>${c.addressee}</td>
				<td>${c.addressee_address}</td>
				<td>${c.delivery_state}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>