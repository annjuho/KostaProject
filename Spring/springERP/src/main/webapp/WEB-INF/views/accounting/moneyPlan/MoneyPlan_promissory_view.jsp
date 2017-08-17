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

	<h2 class="page_title">자금계획전표조회</h2>

	<div class="mainContents">
		<form class="form-horizontal" action="">
			<table class="table table-bordered table-hover new" id="moneyList">
				<thead style="vertical-align: middle; text-align: center;">
					<tr>
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
				<c:forEach var="m" items="${listModel }">
					<tr class="mainTable">
						<td><input type="checkbox"></td>
						<td>${m.typelist}</td>
						<td>${m.start_date}</td>
						<td>${m.periods}</td>
						<td>${m.funds_id}</td>
						<td>${m.sums}</td>
						<td>${m.account_number}</td>
						<td>${m.customer_id}</td>
						<td>${m.remarks}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<!-- 메뉴 footar END -->
	<div class="footer footer-fixed" id="footer-Group"
		style="display: block;">
		<div class="wrapper-toolbar">
			<div class="pull-reft"></div>
			<div class="pull-right" id="button-Group">
				<button id="btn-footer-Save" class="btn btn-xs btn-default"
					type="button" name="">전표 목록조회</button>
				<button id="btn-footer-Save" class="btn btn-xs btn-default"
					type="Submit" name="">지출결의서 작성</button>
				<button id="btn-footer-Reset" class="btn btn-xs btn-default"
					type="Submit" name="">입금보고서 작성</button>
				<button id="btn-footer-Close" class="btn btn-xs btn-default"
					type="button">삭제</button>
			</div>
		</div>
	</div>
	<!-- 메뉴 footar END -->
	</div>
	<!-- 신규등록 END -->


</body>
</html>