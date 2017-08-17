<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<h2 class="page_title">기초잔액등록</h2>

	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li role="presentation" class="active"><a data-target="#moneyList-1" id="basic-tab2" role="tab"	data-toggle="tab" aria-controls="moneyList-1" aria-expanded="true">재무재표별</a></li>
		<li role="presentation" class=""><a data-target="#moneyList-2" id="basic-tab1" role="tab" data-toggle="tab"	aria-controls="moneyList-2" arie-expanded="false">일별/거래쳐별 기초등록</a></li>
	</ul>

	<!-- 일별/거래쳐별 기초등록 Start -->
	<div class="abc" style="position: relative;">	
		<div id="moneyList-2" role="tablist" 1 class="tab-pane fade" aria-labelledby="basic-tab1" style="position: block; z-index: 2;">
			<form class="form-horizontal" id="b">
				<table class="table table-bordered table-hover new">
					<thead style="vertical-align: middle; text-align: center;">
						<tr>
							<th><input type="checkbox"></th>
							<th>거래처</th>
							<th>계좌번호</th>
							<th>장부잔액</th>
							<th>실잔액</th>
							<th>차액</th>
							<th>부서명</th>
							<th>프로젝트명</th>
							<th>비고</th>
							<th><input type="button" class="btn btn-default btn-sm saleListAdd" value="▼"></input></th>
						</tr>
					</thead>
					<tbody style="vertical-align: middle; text-align: center;">
						<tr>
							<td><input type="checkbox"></td>
							<td></td>
							<td><input id="company_number" type="text"
								disabled="disabled">
								<button id="company_number_search"
									class="btn btn-default btn-sm">
									<span class="fa fa-search"></span>
								</button></td>

							<td><input type="text" name="" id="account_number"
								disabled="disabled">
								<button id="account_number_search"
									class="btn btn-default btn-sm">
									<span class="fa fa-search"></span>
								</button></td>
							<td><input type="text" name="" id=""></td>
							<td><input type="text" name="" id=""></td>
							<td><input type="text" name="" id=""></td>
							<td><input type="text" name="" id=""></td>
							<td><input type="text" name="" id=""></td>
						</tr>

					</tbody>
				</table>
				<table class="table table-bordered table-hover new">
					<tr>
						<td>합계금액</td>
						<td><input type="text" name="" id=""></td>
					</tr>
				</table>
				<div class="buttongroup">
					<input type="button" id="save" class="btn btn-default" value="저장">
				</div>
			</form>
		</div>
		<!-- 일별/거래쳐별 기초등록 end -->

		<!-- 재무재표별기초 잔액입력 -->
		<div id="moneyList-1" role="tablist" class="tab-pane fade active in" aria-labelledbhy="basic-tab2" style="position: absolute; z-index: 4;">
			<form class="form-horizontal" action="SearchPurchase.pc" id="b">
				<table class="table table-bordered table-hover new">
					<tr>
						<th valign="middle" style="text-align: center;">구분</th>
						<td><label for="recipient-name" class="control-label"></label>
							<div class="radio-inline">
								<label> <input id="recipient-name" type="radio"
									checked="" value="yes" name="type">재무재표
								</label>
							</div>
							<div class="radio-inline">
								<label> <input id="recipient-name" type="radio"
									value="no" name="type">손익계산서
								</label>
							</div>
							<div class="radio-inline">
								<label> <input id="recipient-name" type="radio"
									value="no" name="type">원가명세서
								</label>
							</div>
						</td>
					</tr>
					<tr>
						<td>부서</td>
						<td><input type="text" name="customer_id" id="customer_id"
							size="13">
							<button type="button" id="customer_SearchKey"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#customerSearch_modal">
								<span class="fa fa-search"></span>
							</button></td>
					</tr>
					<tr>
						<td>프로젝트</td>
						<td><input type="text" name="product_id" id="product_id"
							size="13">
							<button type="button" id="product_SearchKey"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#productSearch_modal">
								<span class="fa fa-search"></span>
							</button></td>
					</tr>
					<tr>
						<td>기초잔액 입력 월</td>
						<td><input type="text" name="warehouse_id" id="warehouse_id"
							size="13">
							<button type="button" id="warehouse_SearchKey"
								class="btn btn-default btn-sm" data-toggle="modal"
								data-target="#warehouseSearch_modal">
								<span class="fa fa-search"></span>
							</button></td>
					</tr>
				</table>
				<div class="buttongroup">
					<input type="submit" id="searchBtn" class="btn btn-default"
						value="신규등록">
				</div>
			</form>
		</div><!-- 재무재표별기초 잔액입력 -->		
	</div>


</body>
</html>