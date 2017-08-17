<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--jQuery UI CSS파일   -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!--jQuery 기본 js파일   -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--jQuery UI 라이브러리 js파일   -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!-- JS파일 -->
<script src="/resources/accounting/js/promissory.js" type="text/javascript"></script>

<!-- CSS파일 -->
<link href="/resources/accounting/css/account.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
</head>
<body>

	<h2 class="page_title">어음할인/만기</h2>

	<!-- 상단 메뉴이름 -->
	<div class="mainContents">
		<form:form action="/accounting/promissory/promissory_noteBill"	method="post">
			<div class="contents contents-fixed" style="top: 29px; bottom: 34px">
				<!-- 신규등록 Table Start -->
				<table
					class="table table-bordered table-hover table-left table-striped">
					<colgroup>
						<col style="width: 149px;">
						<col style="width: 600px;">
					</colgroup>
					<tbody>
						<tr id="row-date">
							<th>전표일자</th>
							<td><div class="col-sm-6 input-group">
									<input type="text" name="red_date" id="datepicker"	class="form-control">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-th" id="icon"></span>
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
						<tr id="row-customer">
						<th>입금되는 계좌번호</th>
						<td><div class="form-group">
							<input class="accountHiddenids" type="text" name ="account_id">
							<button type="button" class="btn btn-default btn-sm account_numbers_search" id="account_numbers_search" data-toggle="modal" data-target="#account_numbers_modal">
								<span class="fa fa-search"></span>
							</button>
							<input class=" account_number" type="text" placeholder="계좌번호" name="account_number" id="account_number">
							</div>			
						</tr>
						<tr id="row-noteNum">
						<th>어음번호</th>
						<td><input id="note_id" type="text" class="note_id" name="note_id">
						<button type="button" class="btn btn-default btn-sm note_id_search" id="note_id_search" data-toggle="modal" data-target="#note_ledgerSearch_modal">
							<span class="fa fa-search"></span>
						</button>
						</td>
						</tr>
						<tr id="row-money">
						<th>어음금액(입금액+수수료)</th>
						<td><input class="sums" type="text" name="total">
						</td>
						</tr>				
						<tr id="row-money">
							<th>입금액</th>
							<td><input class="realsums" type="text" name="sums"></td>
						</tr>
						<tr id="row-money">
							<th>수수료</th>
							<td><input class="charge" type="text" name="charge">							
							</td>
						</tr>
						
						<tr id="row-Employee">
							<th>비고</th>
							<td><input class="form-control" type="text" name="remarks"></td>
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
						<button id="btn-footer-Save" class="btn btn-xs btn-default"
							type="Submit">등록</button>
						<button id="btn-footer-Reset" class="btn btn-xs btn-default"
							type="button" value="reset">다시작성</button>
						<button id="btn-footer-Close" class="btn btn-xs btn-default"
							type="button">닫기</button>
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
<!-- 어음 검색 Start-->
<div class="modal fade" id="note_ledgerSearch_modal" role="dialog">
 <div class="modal-dialog modal-lg">      
    <div class="modal-content">
		<div class="modal-header">
			   <button type="button" class="close" data-dismiss="modal">&times;</button>
			   <h4 class="modal-title"><strong>어음 검색</strong></h4>	
		</div>
			<div class="modal-body">				
				<div class="col-sm-8">
					<input type="text" class="form-control search_note_id" name="search_note_id" id="search_note_id">
					<input type="hidden" class="search_customer_name">
					<input type="hidden" class="search_sums">

				</div>		
						
				<div class="col-sm-2">
						<button type="button" class="btn btn-dault btn-sm noteIds" id="noteIds"><span class="fa fa-search"></span></button>
				</div>
				<br><br><br>
				<table id="n_searchTable" class="table table-bordered table-hover n_searchTable">
				
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
<!-- 어음 검색 End-->

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
</body>
</html>