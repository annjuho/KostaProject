<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<!--jQuery UI CSS파일   -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!--jQuery 기본 js파일   -->
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--jQuery UI 라이브러리 js파일   -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!-- Script -->
<script type="text/javascript" src="/resources/accounting/js/income.js"></script>

</head>
<body>
<h2>손익계산서</h2>
<form:form action="/accountAllview/incomeSearch" class="form-horizontal" method="post">
	<table class="table table-bordered table-hover new">
		<tr>
			<td>기준일자</td>
			<td><input type="text" class="income_date" name="start_date" id="start_date"> ~ <input type="text" class="income_date" name="end_date" id="end_date"></td>
		</tr>
		<tr>
			<td>부서검색</td>
			<td>
				<input type="text" name="dept_id" class="dept_id" size="13">
				<button type="button" class="btn btn-default btn-sm dept_id_search" id="dept_id_search" data-toggle="modal" data-target="#departmentSearch_modal">
				<span class="fa fa-search"></span>
				</button><input type="text" class="dept_name" name="dept_name">
			</td>
		</tr>
		<tr>
			<td>프로젝트</td>			
			<td>				
				<input type="text" name="proj_id" class="proj_id" size="13">
				<button type="button" class="btn btn-default btn-sm proj_id_search" id="proj_id_search" data-toggle="modal" data-target="#projectsSearch_modal">
				<span class="fa fa-search"></span>
				</button><input type="text" class="proj_name" name="proj_name">
			</td>
		</tr>
		
	</table>
	<div class="buttongroup">
		<input type="submit" id="searchBtn" class="btn btn-default" value="검색">
	</div>
</form:form>

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


</body>
</html>