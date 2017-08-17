<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/stock/css/stock_rp_list.css" rel="stylesheet">
</head>
<body>
<c:forEach var="s" items="${list }" varStatus="status">
	<div class="rp_div">
		<h3>재고수불부 [${status.index+1}]</h3>
		<p>거래처명 : ${s.customer_name }  / 품목명 : ${s.product_name }
		<span class="datespan">
		<c:if test="${ status.first}">${s.inout_date }</c:if> ~ <c:if test="${ status.last}">${s.inout_date }</c:if>
		</span></p>
		<table class="table table-bordered table-hover">
			<tr>
				<th>날짜</th>
				<th>거래처</th>
				<th>입고수량</th>
				<th>출고수량</th>
				<th>재고수량</th>
			</tr>
			<tr>
				<td colspan="4" style="color:red;text-align: center;"><strong>전월이월</strong></td>
				<td><strong>${s.stock_amount }</strong></td>
			</tr>
			<tr>
				<td>${s.inout_date }</td>
				<td>${s.customer_name }</td>
				<c:choose>
					<c:when test="${s.inout_type != 'out'}">
						<td>${s.inout_amount }</td>
						<td>0</td>
					</c:when>
					<c:otherwise>
						<td>0</td>
						<td>${s.inout_amount }</td>
					</c:otherwise>
				</c:choose>
				<td>${s.stock_amount }</td>
			</tr>
<!-- 			<tr>
				<td colspan="2" style="text-align: center;"><strong>[ 2016년 3월 월계 ]</strong></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><strong>[ 2016년 4월 월계 ]</strong></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><strong>누계</strong></td>
				<td></td>
				<td></td>
				<td></td>
			</tr> -->
		</table>
	</div>
	</c:forEach>
</body>
</html>