<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!--jQuery UI CSS파일   -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!--jQuery 기본 js파일   -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--jQuery UI 라이브러리 js파일   -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/accounting/js/MoneyPlan.js" type="text/javascript"></script>
</head>
<body>

	<h2 class="page_title">자금계획등록</h2>

	<div class="mainContents">
		<form:form action="/accounting/moneyPlan/MoneyPlan_Add" method="post" name="moneyplan">
			<div class="contents contents-fixed" style="top: 29px; bottom: 34px">
				<!-- 신규등록 Table Start -->
				<table
					class="table table-bordered table-hover table-left table-striped">
					<colgroup>
						<col style="width: 149px;">
						<col style="width: 600px;">
					</colgroup>
					<tbody>
						<tr>
							<th>계획번호</th>
							<td><input type="text" name="funds_id"></td>
						</tr>
						<tr id="row-TYPES">
							<th>현금 어음구분 <span class="card-Info" data-html="true" data-toggle="popover" data-trigger="focus hover"
								data-placement="right" data-original-title="" title=""></span>
							</th>
							<td>
								<div class="radio-inline">
									<label> <input id="optionsRadios1" type="radio"
										checked="" name="moneytype" value="Cash">Cash
									</label>
								</div>
								<div class="radio-inline">
									<label> <input id="optionsRadios2" type="radio"
										name="moneytype" value="Promissory" >Promissory
									</label>
								</div>
							</td>
						</tr>						
						<tr id="row-TYPES">
							<th>입출금 구분 <span class="card-Info" data-html="true" data-toggle="popover" data-trigger="focus hover"
								data-placement="right" data-original-title="" title=""></span>
							</th>
							<td>
								<div class="radio-inline">
									<label> <input id="optionsRadios1" type="radio"
										checked="" name="typelist" value="출금">출금
									</label>
								</div>
								<div class="radio-inline">
									<label> <input id="optionsRadios2" type="radio"
										name="typelist" value="입금">입금
									</label>
								</div>
							</td>
						</tr>
						<tr id="row-CardTYPE">
							<th>발생단위</th>
							<td><select class="form-control" name="repeat_unit">
									<option>1개월마다</option>
									<option>2개월마다</option>
									<option>3개월마다</option>
									<option>4개월마다</option>
									<option>5개월마다</option>
									<option>6개월마다</option>
									<option>7개월마다</option>
									<option>8개월마다</option>
									<option>9개월마다</option>
									<option>10개월마다</option>
									<option>11개월마다</option>
									<option>12개월마다</option>
							</select></td>
						</tr>
						<tr>
							<th>최초 발생날짜</th>
							<td>
								<div class="col-sm-6 input-group">
									<input type="text" id="datepicker2" class="form-control" name="start_date">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-th"></span>
									</div>
								</div>
							</td>
						</tr>

						<tr>
							<th>발생기간</th>
							<td><div class="col-sm-6 input-group date">
									<input type="text" id="datepicker" class="form-control" name="periods">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-th"></span>
									</div>
								</div></td>
						</tr>
						<tr id="row-deptNum">
							<th>부서코드</th>
							<td><input type="text" name="dept_id" class="dept_id">
								<button type="button" class="btn btn-default btn-sm dept_id_search" id="dept_id_search" data-toggle="modal" data-target="#departmentSearch_modal">
									<span class="fa fa-search"></span>
								</button><input type="text" class="dept_name" name="dept_name">
							</td>
						</tr>
						<tr id="row-project">
							<th>프로젝트번호</th>
							<td><input type="text" name="proj_id" class="proj_id">
								<button type="button" class="btn btn-default btn-sm proj_id_search" id="proj_id_search" data-toggle="modal" data-target="#projectsSearch_modal">
									<span class="fa fa-search"></span>
								</button><input type="text" class="proj_name" name="proj_name">
							</td>
						</tr>		
						<tr id="row-accountNum">
							<th>계좌번호</th>
							<td><div class="form-group">
							<input class="accountHiddenids" type="text" name ="account_id">
							<button type="button" class="btn btn-default btn-sm account_numbers_search" id="account_numbers_search" data-toggle="modal" data-target="#account_numbers_modal">
								<span class="fa fa-search"></span>
							</button>
							<input class=" account_number" type="text" placeholder="계좌번호" name="account_number" id="account_number">
							</div>	
						</tr>
						<tr id="row-customer">
							<th>계정</th>
							<td>
								<input class="diagnosis_number" type="text"  name="diagnosis_number" id="diagnosis_number">
								<button data-toggle="modal" data-target="#diagnosisSearch_modal" type="button" class="btn btn-default btn-sm diagnosis_number_search" id="diagnosis_number_search">
								<span class="fa fa-search"></span></button>
								<input class="diagnosis_name" type="text"  name="diagnosis_name" id="diagnosis_name">
						</tr>
						<tr id="row-customer">
							<th>거래처</th>
							<td><input type="text" name="customer_id" class="customer_id">
								<button type="button" id="customer_id_search" class="btn btn-default btn-sm customer_id_search" data-toggle="modal" data-target="#customerSearch_modal">
									<span class="fa fa-search"></span>
								</button><input type="text" name="customer_name" class="customer_name">
						</tr>
						<tr id="row-money">
							<th>금액</th>
							<td><input class="form-control" type="text" value=""
								placeholder="금액" name="sums">
								
								</td>
						</tr>
						<tr id="row-Employee">
							<th>비고</th>
							<td><input class="form-control" type="text" value=""
								name="remarks"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 메뉴 footar END -->
			<div class="footer footer-fixed" id="footer-Group"
				style="display: block;">
				<div class="wrapper-toolbar">
					<div class="pull-reft"></div>
					<div class="pull-right" id="button-Group">
						<input id="btn-footer-Save" class="btn btn-xs btn-default"
							type="submit" value="저장">
						<input id="btn-footer-Reset" class="btn btn-xs btn-default"
							type="reset" value="다시작성">						
					</div>
				</div>
			</div>
			<!-- 메뉴 footar END -->
		</form:form>
	</div>
	<!-- 신규등록 END -->
	
	<!--########## 검색 모달 부분  ##########-->

<!-- 부서 검색 Start-->
<div class="modal fade" id="departmentSearch_modal" role="dialog">
 <div class="modal-dialog modal-lg">      
    <div class="modal-content">
		<div class="modal-header">
			   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   <h4 class="modal-title"><strong>부서검색</strong></h4>	
		</div>
			<div class="modal-body">				
				<div class="col-sm-8">
					<input type="text" class="form-control search_dept_id" name="search_proj_id" id="search_proj_id">
					<input type="hidden" class="search_dept_name">
				</div>					
		
				<br><br><br>
				<table id="d_searchTable" class="table table-bordered table-hover d_searchTable">
				
				</table>
				<div id="ustBtnArea">
					<input type="button" class="btn btn-default center useBtn" value="사용" data-dismiss="modal">
				</div>
				<div class="modal-footer">
      				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     			 </div>
			</div>
		</div>
	</div>
</div>
<!-- 부서검색 End-->


<!-- 프로젝트 검색 Start-->
<div class="modal fade" id="projectsSearch_modal" role="dialog">
 <div class="modal-dialog modal-lg">      
    <div class="modal-content">
		<div class="modal-header">
			   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   <h4 class="modal-title"><strong>프로젝트 검색</strong></h4>	
		</div>
			<div class="modal-body">				
				<div class="col-sm-8">
					<input type="text" class="form-control search_proj_id" name="search_proj_id" id="search_proj_id">
					<input type="hidden" class="search_proj_name">
				</div>		
						
				<div class="col-sm-2">
						<button type="button" class="btn btn-dault btn-sm projIds" id="projIds"><span class="fa fa-search"></span></button>
				</div>
				<br><br><br>
				<table id="p_searchTable" class="table table-bordered table-hover p_searchTable">
				
				</table>
				<div id="ustBtnArea">
					<input type="button" class="btn btn-default center useBtn" value="사용" data-dismiss="modal">
				</div>
				<div class="modal-footer">
      				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     			 </div>
			</div>
		</div>
	</div>
</div>
<!-- 프로젝트 검색 End-->

<!-- 거래처 검색 Start-->
<div class="modal fade" id="customerSearch_modal" role="dialog">
 <div class="modal-dialog modal-lg">      
    <div class="modal-content">
		<div class="modal-header">
			   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   <h4 class="modal-title"><strong>거래처 검색</strong></h4>	
		</div>
			<div class="modal-body">				
				<div class="col-sm-8">
					<input type="text" class="form-control search_customer_id" name="search_customer_id" id="search_customer_id">
					<input type="hidden" class="search_customer_name">
				</div>		
						
				<div class="col-sm-2">
						<button type="button" class="btn btn-dault btn-sm customerIds" id="customerIds"><span class="fa fa-search"></span></button>
				</div>
				<br><br><br>
				<table id="c_searchTable" class="table table-bordered table-hover c_searchTable">
				
				</table>
				<div id="ustBtnArea">
					<input type="button" class="btn btn-default center useBtn" value="사용" data-dismiss="modal">
				</div>
				<div class="modal-footer">
      				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     			 </div>
			</div>
		</div>
	</div>
</div>
<!-- 거래처 검색 End-->

<!-- 계좌번호 검색 Start-->
<div class="modal fade" id="account_numbers_modal" role="dialog">
 <div class="modal-dialog modal-lg">      
    <div class="modal-content">
		<div class="modal-header">
			   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   <h4 class="modal-title"><strong>사원검색</strong></h4>	
		</div>
			<div class="modal-body">				
				<div class="col-sm-8">
					<input type="text" class="form-control search_account_number" name="account_number" id="search_account_number">
					<input type="hidden" class="accountHiddenid">
				</div>
						
				<div class="col-sm-2">
						<button type="button" class="btn btn-dault btn-sm account_numbers" id="account_numbers"><span class="fa fa-search"></span></button>
				</div>
				<br><br><br>
				<table id="a_searchTable" class="table table-bordered table-hover a_searchTable">
				
				</table>
				<div id="ustBtnArea">
					<input type="button" class="btn btn-default center useBtn" value="사용" data-dismiss="modal">
				</div>
				<div class="modal-footer">
      				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     			 </div>
			</div>
		</div>
	</div>
</div>
<!-- 계좌번호 검색 End-->
<!-- 계정 검색 -->
<div class="modal fade" id="diagnosisSearch_modal" role="dialog">
 <div class="modal-dialog modal-lg">      
    <div class="modal-content">
		<div class="modal-header">
			   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   <h4 class="modal-title"><strong>계정검색</strong></h4>	
		</div>
			<div class="modal-body">				
				<div class="col-sm-8">
					<input type="text" class="form-control search_diagnosis_number" name="diagnosis_number" id="search_diagnosis_number">
					<input type="hidden" class="diagnosisHiddenid">
				</div>		
				<div class="col-sm-2">
						<button type="button" class="btn btn-dault btn-sm diagnosis_numbers" id="diagnosis_numbers"><span class="fa fa-search"></span></button>
				</div>
				<br><br><br>
				<table id="m_searchTable" class="table table-bordered table-hover m_searchTable">
				
				</table>
				<div id="ustBtnArea">
					<input type="button" class="btn btn-default center useBtn" value="사용" data-dismiss="modal">
				</div>
				<div class="modal-footer">
      				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
     			 </div>
			</div>
		</div>
	</div>
</div>

</body>
</html>