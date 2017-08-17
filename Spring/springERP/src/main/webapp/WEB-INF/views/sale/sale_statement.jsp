<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/shopERP/css/accunting_print.css">
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
							<td>손익계산서</td>
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
						<tr class="print_type_td">
							<td>1.매출</td>
							<td></td>
							<td>aa</td>
							<td></td>
							<td></td>
						</tr>
						<tr class="print_td">
							<td>상품매출</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>상품매출환입및에누리</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>상품매출할인</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>제품매출</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>용역매출</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>2.매출원가</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>상품매출원가</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>기초재고액</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>당기매입액</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>기말재고액</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>제품매출원가</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>기초재고액</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>당기매입액</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>기말재고액</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>3.매출총이익</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>4.판매비 및 일반관리비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>직원급여</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>복리후생비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>여비교통비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>접대비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>통신비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>소모품비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>보험료</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>지급수수료</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>도서인쇄비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>광고선전비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>견본비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>잡비</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>5.영업손익</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>6.영업외수익</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>수입수수료</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>7.영업외비용</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>이자비용</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_td">
							<td>잡손실</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>8.법인세비용차감전순손익</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
							<td>aa</td>
						</tr>
						<tr class="print_type_td">
							<td>당기순이익</td>
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