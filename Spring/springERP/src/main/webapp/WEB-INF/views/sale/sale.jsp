<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="erp-local-nav-title">판매관리</div>
	<div class="erp-local-nav">
		<ul class="local">
			<li><a href="/sale/sale_check">판매조회</a></li>
			<li><a href="/sale/sale_add">판매입력</a></li>
			<li><a href="/sale/sale_search">판매현황</a></li>
			<li><a href="/sale/sale_accounts">판매처별 정산</a></li>	
			<li><a class="" data-target="#five" data-toggle="collapse" href="javascript:;">사입관리</a>
				<ul id="five" class="collapse">
					<li><a href="/sale/companyBuy/companyBuy_check">사입 이력 조회</a></li>
					<li><a href="/sale/companyBuy/companyBuy_add">입고 상품 등록</a></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>