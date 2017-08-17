<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="erp-local-nav-title">재고관리</div>
	<div class="erp-local-nav">			
			<ul class="local">
				<li><a data-toggle="collapse" href="#stockMgt">재고수불부 관리</a>
					<ul id="stockMgt" class="collapse">
						<li><a href="/stock/rp/insert_form">재고수불부 입력</a></li>
						<li><a href="/stock/rp/stockRP_search">재고수불부</a></li>
					</ul>
				</li>
				<li><a href="/stock/rp/stock_list">재고현황</a></li>
			</ul>
	</div>
</body>
</html>