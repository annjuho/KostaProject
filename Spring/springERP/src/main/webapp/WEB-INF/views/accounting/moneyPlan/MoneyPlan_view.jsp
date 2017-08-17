<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<!-- CSS -->
<link href="/resources/accounting/css/account.css" rel="stylesheet">

<!-- JS -->
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
</head>
<body>

	<h2 class="page_title">자금계획현금조회</h2>

	<div class="mainContents">
		<!-- 카드리스트 -->
		<div class="container-fluid">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped"
					id="Card">
					<thead id="cardList">
						<tr class="mainTable">							
							<th><input type="checkbox"></th>
							<th>구분</th>
							<th>발생일자</th>						
							<th>발생기간</th>
							<th>자금계획번호</th>
							<th>금액</th>
							<th>계좌번호</th>
							<th>거래처</th>
							<th>비고</th>
						</tr>
					</thead>
					
					<tbody id="cardInfos">
					<c:forEach var="cash" items="${listModel}">
						<tr class="mainTable">
							<td><input type="checkbox"></td>													
							<td>${cash.typelist}</td>
							<td>${cash.start_date}</td>
							<td>${cash.periods}</td>
							<td>${cash.funds_id}</td>							
							<td>${cash.sums}</td>
							<td>${cash.account_number}</td>
							<td>${cash.customer_id}</td>
							<td>${cash.remarks}</td>							
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>