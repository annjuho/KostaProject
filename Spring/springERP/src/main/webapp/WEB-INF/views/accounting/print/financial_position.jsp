<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shopERP/accounting/css/accunting_print.css">
<link href="/shopERP/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-3 col-md-offset-2" id="print_btn_group">
			<button type="button" class="btn btn-primary">인쇄</button>
			<button type="button" class="btn btn-primary">Excel</button>
			<button type="button" class="btn btn-primary">PDF</button>
		</div>
	</div>
	<div class="container-fluid">
		<div class="col-md-10 col-md-offset-1">
			<div class="container-fluid" id="print_header">
				<div class="col-md-3 col-md-offset-3">
					<table class="accounting_print_table">
						<tr class="print_head">
							<td>재무상태표</td>
						</tr>
						<tr class="print_head_date">
							<td>제 7기 1월 1일~~~~~~~~~~</td>
						</tr>
						<tr class="print_head_date">
							<td>제 6기 1월 1일~~~~~~~~~~</td>
						</tr>
					</table>
				</div>
				<div class="col-md-3">
					<table class="table table-condensed table table-bordered"
						id="check_area">
						<tr class="print_check_head">
							<td rowspan="4">결재</td>
							<td colspan="2">담당</td>
							<td colspan="2">대리</td>
							<td colspan="2">과장</td>
						</tr>
						<tr class="print_head">
							<td rowspan="3" colspan="2"></td>
							<td rowspan="3" colspan="2"></td>
							<td rowspan="3" colspan="2"></td>
						</tr>
						<tr>
						</tr>
						<tr>
						</tr>
					</table>
				</div>
			</div>

			<div class="container-fluid" id="income_wrapper">
				<div class="col-md-8 col-md-offset-1">
					<table class="table table-condensed table table-bordered"
						id="income_state_table">
						<thead>
							<tr class="print_th">
								<th width="250px">재무제표표시명</th>
								<th colspan="2">제x기(기준)</th>
								<th colspan="2">제x기(비교)</th>
							</tr>
						</thead>
						<tr class="fi_print_type_td">
							<td>1.자산</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="fi_print_td_lv1">
							<td>1)유동자산</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>(1)당좌자산</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv3">
							<td>현금 및 현금성자산</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv3">
							<td>매출채권</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv3">
							<td>기타</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>(2)재고자산</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv3">
							<td>미착품</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv1">
							<td>2)비유동자산</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>(2)유형자산</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv3">
							<td>비품</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_total">
							<td>자산총계</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_type_td">
							<td>2.부채</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="fi_print_td_lv1">
							<td>1)유동부채</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>매입채무</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>미지급금</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>예수금</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>부가세예수금</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_total">
							<td>부채총계</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_type_td">
							<td>3.자본</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="fi_print_td_lv1">
							<td>1)이익잉여금</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv2">
							<td>미처분 이익 잉여금</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_lv3">
							<td>(당기순이익)</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_total">
							<td>자본총계</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="fi_print_td_total">
							<td>부채와자본총계</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
					</table>
					<div class="col-md-2 col-md-offset-9">날짜!!!!!!</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/shopERP/js/bootstrap.min.js"></script>
</body>
</html>