<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<script src="/resources/sale/js/sale.js" type="text/javascript"></script>
<script src="/resources/sale/js/sale_chart.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
</head>
<body>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<!-- 	<div class="item_div">
		<div class="title">
			<span class=""><strong>품목코드검색</strong></span>
			<button type="button" class="close" id="item_closeBtn"><span>&times;</span></button>
		</div>
		<form class="form-horizontal" action="">
			<div class="form1">
				<div class="form-group has-feedback">				
					<label for="product_id" class="col-sm-2 control-label"><strong>품목코드</strong></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="product_id">
						<button class="btn btn-default btn-sm" type="submit"><span class="fa fa-search"></span></button>
						<span></span>					
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="customer_div">
		<div class="title">
			<span class=""><strong>거래처검색</strong></span>
			<button type="button" class="close" id="customer_closeBtn"><span>&times;</span></button>
		</div>
		<form class="form-horizontal" action="">
			<div class="form1">
				<div class="form-group has-feedback">
					<div class="radio">
						<label class="radio-inline">
	  						<input type="radio" name="search" id="simple_search" value="option1">간편검색
						</label>
						<label class="radio-inline">
	  						<input type="radio" name="search" id="detail_search" value="option2">상세검색
						</label>
					</div>
					<label for="product_id" class="col-sm-2 control-label"><strong>거래처코드</strong></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="product_id">
						<span></span>					
					</div>
					<div class="hide_detail">
						<label for="product_id" class="col-sm-2 control-label"><strong>거래처명</strong></label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="product_id">
							<span></span>					
						</div>
						<label for="product_id" class="col-sm-2 control-label"><strong>대표자명</strong></label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="product_id">
							<span></span>					
						</div>
						<label for="product_id" class="col-sm-2 control-label"><strong>핸드폰번호</strong></label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="product_id">
							<span></span>					
						</div>
						<label for="product_id" class="col-sm-2 control-label"><strong>email</strong></label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="product_id">
							<span></span>					
						</div>
						<label for="product_id" class="col-sm-2 control-label"><strong>FAX</strong></label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="product_id">
							<span></span>					
						</div>
						<label for="product_id" class="col-sm-2 control-label"><strong>담당자</strong></label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="product_id">
							<button class="btn btn-default btn-sm" type="submit"><span class="fa fa-search"></span></button>
							<span></span>					
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>customer_div End
	<table class="table table-bordered table-hover new">
		<tr>
			<td>기준일자</td>
			<td><input type="text" id="purchase_date" name="" id=""> ~ <input type="text" id="purchase_date" name="" id=""></td>
		</tr>
		<tr>
			<td>거래처</td>
			<td><input type="text" id="" name=""><button id="customer_search" class="btn btn-default btn-sm"><span class="fa fa-search"></span></button></td>
		</tr>
		<tr>
			<td>기타</td>			
			<td><input type="text" id="" name=""><button id="item_search" class="btn btn-default btn-sm"><span class="fa fa-search"></span></button></td>
		</tr>
	</table>
	<div class="buttongroup">
		<input type="button" id="searchBtn" class="btn btn-default" value="검색">
	</div> -->
</body>
</html>