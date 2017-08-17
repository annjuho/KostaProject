<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="erp-local-nav-title">회계관리</div>
	<div class="erp-local-nav">
		<ul class="local">
			<li><a href="/accountAllview/print">회계 핵심 출력물</a></li>
			<li><a data-toggle="collapse" href="./accounting/view/basic/moneyCheck.jsp #one">회계기초등록</a>
				<ul id="one" class="collapse">
					<li><a href="/accounting/account/test/list">기초잔액등록</a></li>
					<li><a href="/accounting/card/list">신용카드등록</a></li>
					<li><a href="/accounting/account/list">통장계좌등록</a></li>
					<li><a href="/accounting/project/list">프로젝트등록</a></li>
					<li><a href="/accounting/diagnosis2/DiagnosisList">계정관리</a></li>
				</ul></li>
			<li><a data-toggle="collapse"
				href="./accounting/view/MoneyManagement/inoutMoney.jsp #two">현금거래관리</a>
				<ul id="two" class="collapse">
					<li><a href="/accounting/moneymanagement/inoutMoney">입출금보고서</a></li>
					<li><a href="/accounting/moneymanagement/inoutCompanyMoney">거래처로부터</a></li>
				</ul></li>
			<li><a data-toggle="collapse" href="#three">어음원장관리</a>
				<ul id="three" class="collapse">
					<li><a href="/accounting/promissory/list">어음원장</a></li>
					<li><a href="/accounting/promissory/promissory_note">어음등록</a></li>
					<!-- <li><a href="/accounting/promissory/promissory_give">어음지급</a></li> -->
					<li><a href="/accounting/promissory/promissory_notePayment">어음결제</a></li>
					<li><a href="/accounting/promissory/promissory_noteBill">어음 할인/만기</a></li>
				</ul></li>
			<li><a data-toggle="collapse" href="#four">채무채권관리</a>
				<ul id="four" class="collapse">
					<li><a href="#">채권관리</a></li>
					<li><a href="#">채무관리</a></li>
					<li><a href="#">채권채무현황</a></li>
				</ul></li>
			<li><a data-toggle="collapse"
				href="./accounting/view/MoneyPlan/MoneyPlan_Add.jsp #five">자금계획관리</a>
				<ul id="five" class="collapse">
					<li><a href="/accounting/moneyPlan/MoneyPlan_Add">자금계획등록</a></li>
					<li><a href="/accounting/moneyPlan/list">자금계획현금조회</a></li>
					<li><a href="/accounting/moneyPlan/promissorylist">자금계획전표조회</a></li>
					<li><a href="/accounting/moneyPlan/MoneyPlan_calendar">자금증감계획일정표</a></li>
				</ul></li>
			<li><a data-toggle="collapse"
				href="./accounting/view/Statement_List.jsp #six">전표관리</a>
				<ul id="six" class="collapse">
					<li><a href="/StateMent/StatementAllViewList">전표이력조회</a>
					<li><a href="/StateMent/StatementAllSalesList">매출청구서조회</a>
					<li><a href="/StateMent/StatementAllPurchaseList">매입청구서조회</a>
				</ul></li>
		</ul>
	</div>
</body>
</html>
