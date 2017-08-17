<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--jQuery UI CSS파일   -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!--jQuery 기본 js파일   -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--jQuery UI 라이브러리 js파일   -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!-- JS파일 -->
<script src="/resources/accounting/js/promissory.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/purchase/js/purchase.js"></script>
<!-- CSS파일 -->
<link href="/resources/accounting/css/account.css" rel="stylesheet">
<script type="text/javascript">
$(function(){
	$('#standard_date').val($.datepicker.formatDate($.datepicker.ATOM, new Date()));
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" /></head>
<body>

	<h2 class="page_title">어음원장</h2>
<form:form action="/Search/promissory/noteAllSearch" method="post">
	<!-- 상단 메뉴이름 -->
	<div class="mainContents">
	
		<div class="contents contents-fixed" style="top: 29px; bottom: 34px">
			<!-- 신규등록 Table Start -->
			
			<table
				class="table table-bordered table-hover table-left table-striped">
				<colgroup>
					<col style="width: 149px;">
					<col style="width: 600px;">
				</colgroup>
				<tbody>
					<tr id="row-CardTYPE">
						<th>조회일자</th>
						<td><input type="text" class="purchase_date" name="start_date" id="start_date"> ~ <input type="text" class="purchase_date" name="end_date" id="end_date"></td>
					</tr>

					<tr id="row-sysdate">
						<th>기준일</th>
						<td><input type="text" name="standard_date" id="standard_date" readonly="readonly"></td>
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
					<tr>
						<th>구분</th>
						<td><select class="form-control" name="typelist">
								<option value="받는어음">받을어음발행내역</option>
								<option value="지급어음">지급어음발행내역</option>
								<option value="">보유어음현황</option>
						</select></td>
					</tr>
					<tr id="row-noteNum">
						<th>어음번호</th>
						<td><input id="card_number" type="text" name="card_number">
							<button id="card_number_search" class="btn btn-default btn-sm">
								<span class="fa fa-search"></span>
							</button> <input type="text" name="" value="">
					</tr>
					<tr >
						<th>간편검색조건</th>
						<td >
							<ul class="list-inline">
								<li>금일</li>
								<li>전일</li>
								<li>금주</li>
								<li>전주</li>
								<li>금월</li>
								<li>전월</li>
							</ul>
						</td>
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
						type="Submit">조회</button>
					<button id="btn-footer-Reset" class="btn btn-xs btn-default"
						type="button" value="reset">리셋</button>

				</div>
			</div>
		</div>		
		<!-- 메뉴 footar END -->
	</div>
	<!-- 신규등록 END -->
</form:form>

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
</body>
</html>