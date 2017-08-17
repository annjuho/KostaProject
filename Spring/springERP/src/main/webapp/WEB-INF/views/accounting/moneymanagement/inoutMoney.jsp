<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/resources/purchase/js/jquery.js"></script>
<script type="text/javascript" src="/resources/accounting/js/inoutMoney.js"></script>
<!-- <script src="/resources/accounting/js/moneymanagement.js" type="text/javascript"></script> -->
<!-- <script src="/resources/common/js/csrf.js" type="text/javascript"></script> -->
<!-- CS -->
<link href="/resources/accounting/css/moneymanagement.css" rel="stylesheet">

</head>
<body>

	<h2 class="page_title">입출금 보고서</h2>


	<!-- 자금계획 조회 모달기능 -->
	<div>
		<div class="selectdate">
			<input type="date" id="datefiker">
			<button type="button" id="moneyplanselect" data-toggle="modal" data-target="#Modal">자금계획</button>
		</div>
	</div>

	<!-- 자금계획 모달 내용부분 -->
	<div class="modal fade" id="Modal" aria-hidden="true" aria-labelledby="Modal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" id="MoneyPlanListView"></button>
					<h4 class="modal-title">
						<strong>자금계획</strong>
					</h4>
				</div>
				<div class="modal-body">
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
					<%-- <c:forEach var="cash" items="${allList}">
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
					</c:forEach> --%>
					</tbody>
				</table>
					<div id="ustBtnArea">
						<input type="button" id="use" class="btn btn-default center useBtn"	value="사용" data-dismiss="modal">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
<div id="Bottom2-contents-warpper">
	<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
		<ul id="myTab" class="nav nav-tabs " role="tablist">
			<li class="active" role="presentation">
				<a id="first-tab" aria-expanded="in" aria-controls="#first-tabs" data-toggle="tab" role="tab" href="#first-tabs">입금보고서</a>
			</li>
			<li class="" role="presentation">
				<a id="second-tab" aria-controls="#second-tabs" data-toggle="tab" role="tab" href="#second-tabs" aria-expanded="">출금보고서</a>
			</li>						
		</ul>
		
	<!-- 입금보고서 Start -->
	
<form class="form-horizontal">
	<div id="deposit-contents" class="tab-content">
		<div id="first-tabs" class="tab-pane fade active in CssDisplay" aria-labelledby="first-tab" role="tabpanel">
			<table class="table table-bordered table-hover new" id="saleList">
				<thead class="tbody">
					<tr id="abc">
						<th class="abcd">
							<input type="checkbox">
						</th>
						<th class="button">
							<input type="button" class="btn btn-default btn-sm saleListAdd" value="▼">
						</th>
						<th>계정코드</th>
						<th>입금된계좌번호</th>
						<th>거래처</th>
						<th>금액</th>
						<th>수수료</th>
						<th>부서</th>
						<th>프로젝트</th>
						<th>비고</th>
						</tr>
					</thead>
					
				<tbody class="tbody" id="tbodyTable">
				<c:forEach var="list" items="${list }">				
					<tr class="inoutMoneylist">
						<td><input type="checkbox"></td>
						<td class="button">						
							<input type="button"class="btn btn-default btn-sm saleListAdd" value="▼"/>
						</td>						
						<td><input type="text" value="${list.funds_id }"></td>							
						<td><input type="text" value="${list.account_number }"></td>	
						<td><input type="text" value="${list.customer_id }"></td>		
						<td><input type="text" name="" value="${list.sums }" class="sums"></td>
						<td><input type="text" name="" value="0"></td>
						<td><input type="text" name="" value="${list.dept_id }"></td>
						<td><input type="text" name="" value="${list.proj_id }"></td>
						<td><input type="text" name="" value="${list.remarks }"></td>
					</tr>
				</c:forEach>					
					</tbody>
					<tr style="text-align: center; font-size: 14px; font-weight: bold;">
						<td colspan="3">금액합계</td>
						<td colspan="2"><input type="text" name="" id="totalSums" width="100%"
							size="30" disabled="disabled"></td>
						<td colspan="2">수수료합계</td>
						<td colspan="3"><input type="text" name="" id=""
							disabled="disabled" size="30" width="20"></td>
					</tr>
				</table>
				</div>
			</div>
		</form> <!-- 입금보고서 END -->	
		


<!-- 출금보고서 Start -->
	<form class="form-horizontal">
		<div id="deposit-contents" class="tab-content">
			<div id="second-tabs" class="tab-pane fade CssDisplay" aria-labelledby="second-tab" role="tabpanel" style="display: none;">
			<table class="table table-bordered table-hover new" id="saleList">
				<thead>
					<tr>
						<th class="abcd">
							<input type="checkbox">
						</th>
						<th>
							<input type="button" class="btn btn-default btn-sm saleListAdd" value="▼">
						</th>
						<th>계정코드</th>
						<th>출금된계좌번호</th>
						<th>거래처</th>
						<th>금액</th>
						<th>수수료</th>
						<th>부서</th>
						<th>프로젝트</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<tr class="inoutMoneylist">
						<td><input type="checkbox"></td>
						<td>						
							<input type="button"class="btn btn-default btn-sm saleListAdd" value="▼"/>
						</td>						
						<td>
						<div class="input-append">
							<input type="text">							
						</div>
						</td>
						
						<td>
						<input type="text">
						</td>
						
						<td>
						<input type="text">													
						</td>						
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
					</tr>
					<tr class="inoutMoneylist">
						<td><input type="checkbox"></td>
						<td>						
							<input type="button"class="btn btn-default btn-sm saleListAdd" value="▼"/>
						</td>						
						<td>
						<input type="text">													
						</td>	
						
						<td>
						<input type="text">													
						</td>	
						
						<td>
						<input type="text">													
						</td>				
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
					</tr>
					<tr class="inoutMoneylist">
						<td><input type="checkbox"></td>
						<td>						
							<input type="button"class="btn btn-default btn-sm saleListAdd" value="▼"/>
						</td>						
						<td>
						<input type="text">													
						</td>	
						
						<td>
						<input type="text">													
						</td>	
						
						<td>
						<input type="text">													
						</td>
								
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
						<td><input type="text" name="" id=""></td>
					</tr>
					<tr style="text-align: center; font-size: 14px; font-weight: bold;">
						<td colspan="3">금액합계</td>
						<td colspan="2"><input type="text" name="" id="" width="100%"
							size="30" disabled="disabled"></td>
						<td colspan="2">수수료합계</td>
						<td colspan="3"><input type="text" name="" id=""
							disabled="disabled" size="30" width="20"></td>
					</tr>									
				</tbody>
			</table>
			</div>
			</div>
		</form><!-- 출금보고서 End --> 		
	</div>
	<div id="footer-Group" class="footer footer-fixed pull-right" >
		<div class="wrapper-toolbar">
			<div class="buttongroup">
				<button id="btn-footer-Save" class="btn btn-xs btn-default"	 type="Submit">저장</button>
				<button id="btn-footer-Reset" class="btn btn-xs btn-default" tepe="reset">선택삭제</button>
				<button id="btn-footer-Close" class="btn btn-xs btn-default" type="button">닫기</button>
			</div>
		</div>
	</div>
</div>


			
	
	
	
	
</body>
</html>