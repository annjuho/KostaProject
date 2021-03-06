<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

 <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<!-- Custom CSS -->
   
</head>
<body>
	<h2>구매 현황 목록</h2>
	<table class="table table-bordered table-hover new">
		<thead>
			<tr>
				<th>구매번호</th>
				<th>거래처명</th>
				<th>품목명</th>
				<th>구매금액</th>
				<th>수량</th>
				<th>구매일자</th>
				<th>입고창고</th>
				<th>지급방법</th>
			</tr>			
		</thead>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.buy_id}</td>
				<td>${list.customer_name }</td>
				<td>${list.product_name }</td>
				<td>${list.buy_price }</td>
				<td>${list.buy_amount }</td>
				<td>${list.buy_date }</td>
				<td>${list.warehouse_name }</td>
				<td>${list.pay_type }</td>		
			</tr>
		</c:forEach>
	</table>
</body>
</html>