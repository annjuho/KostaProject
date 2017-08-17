<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<!-- full Calendar js,css경로 -->
<link href='/resources/common/css/fullcalendar.css' rel='stylesheet' />
<link href='/resources/common/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<!-- <script src='/resources/common/js/jquery.min.js'></script>
 --><script src="/resources/common/js/moment.min.js"></script>
<script src='/resources/common/js/jquery-ui.custom.min.js'></script>
<script src="/resources/common/js/fullcalendar.js"></script>
<script src="/resources/common/js/totalData.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<!-- custom js,css경로 -->
<script src='/resources/main/js/mainCon.js'></script>

</head>
<body>
	<div class="row" style="width: 1280px">
	<!-- 프로젝트 , 부서일정 START-->
		<div class="col-sm-6">
			<div role="tabpanel">
				  <!-- Nav tabs -->
				  <ul class="nav nav-tabs" role="tablist" id="myTab">
				    <li role="presentation" class="active"><a id="allProCalA" href="#allPro" aria-controls="allPro" role="tab" data-toggle="tab">전체 프로젝트</a></li>
				    <li role="presentation"><a id="deptCalA" href="#deptCal" aria-controls="deptCal" role="tab" data-toggle="tab">부서 일정</a></li>
				  </ul>
				
				  <!-- Tab panes -->
				  <div class="tab-content">
				    <div role="tabpanel" class="tab-pane fade in active" id="allPro">
						<div id='allProCalendar'></div>
				    </div>
				    <div role="tabpanel" class="tab-pane fade " id="deptCal">
						<div id='deptCalendar'></div>
				    </div>
				  </div>
			</div>
		</div><!-- 프로젝트 , 부서일정 END-->
		
		<div class="col-sm-3 pull-right">
			<h2 class="page_title">공지사항</h2>

			<table class="table table-hover" class="boardList">
				<tbody>
					<c:if test="${noticeList.size()-1 >=0}">
						<c:forEach var="i" begin="0" end="2" step="1">
							<tr>
								<td><a class="noticeTitle"
									href="notice_view?notice_id=${noticeList.get(i).getNotice_id()}">${noticeList.get(i).getNotice_title() }</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		<hr>
		</div>
		<div class="col-sm-3 pull-right">
			<h2 class="page_title"></h2>
			<div id="container" style="width: 300px; height: 210px; margin: 0 auto"></div>
			
		<hr>
		</div>
		
	<div class="row">
		
		
		<div class="col-sm-3 pull-right">
			<h2 class="page_title">부서 게시판</h2>

			<table class="table table-hover" class="boardList">
				<tbody>
					<c:if test="${deptBoardList.size()-1 >=0}">
						<c:forEach var="i" begin="0" end="2" step="1">
							<tr>
								<td><a class="deptTitle" href="dept_board_view?dept_board_id=${deptBoardList.get(i).getDept_board_id()}">${deptBoardList.get(i).getDept_board_title() }</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="col-sm-3 pull-right">
			<h2 class="page_title"></h2>
			<div id="container2" style="width: 300px; height: 230px; margin: 0 auto"></div>
		<hr>
		</div>		
	</div>
		
	</div>
	
	<div class="row" style="width: 1280px">

		<div class="col-sm-6">
			<h2 class="page_title">재고 현황</h2>
			<table class="table">
				<thead>
					<tr class="row">
						<th class="col-sm-2">상품명</th>
						<th class="col-sm-2">재고량</th>
						<th class="col-sm-2">입고/출고</th>
						<th class="col-sm-3">입고량/출고량</th>
						<th class="col-sm-3">입고일/출고일</th>
					</tr>
				</thead>
		
				<tbody>
					<c:if test="${stockList.size()-1 >=0}">
						<c:forEach var="i" begin="0" end="0" step="1">
							<tr class="row">
								<td class="col-sm-2">${stockList.get(i).getProduct_name()}</td>
								<td class="col-sm-2">${stockList.get(i).getStock_amount()}</td>
								<td class="col-sm-2">${stockList.get(i).getInout_type()}</td>
								<td class="col-sm-3">${stockList.get(i).getInout_amount()}</td>
								<td class="col-sm-3">
									<fmt:formatDate value="${stockList.get(i).getInout_date() }" pattern="yyyy-MM-dd" />
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>

		<div class="col-sm-6">
			<h2 class="page_title">매출 현황</h2>
			<table class="table">
				<thead>
					<tr class="row">
						<th class="col-sm-2">목록</th>
						<th class="col-sm-2">재고량</th>
						<th class="col-sm-2">입고/출고</th>
						<th class="col-sm-3">입고량/출고량</th>
						<th class="col-sm-3">입고일/출고일</th>
					</tr>
				</thead>
		
				<tbody>
					<c:if test="${list.size()-1 >=0}">
						<c:forEach var="i" begin="0" end="2" step="1">
							<tr class="row">
								<td class="col-sm-2">${list.get(i).getDept_board_id()}</td>
								<td class="col-sm-2">${list.get(i).getDept_board_id()}</td>
								<td class="col-sm-2">${list.get(i).getDept_board_id()}</td>
								<td class="col-sm-3">${list.get(i).getDept_board_id()}</td>
								<td class="col-sm-3">
									<fmt:formatDate value="${list.get(i).getDept_board_date() }" pattern="yyyy-MM-dd" />
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	
	<div id="allProModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
	     	   <button type="button" class="close" data-dismiss="modal">&times;</button>
	     	   <h4 class="modal-title"></h4>
	      	</div>
	      	<div class="modal-body">
				<form class="form-horizontal">
					  <div class="form-group">
	 				   <label for="proj_content_t" class="col-sm-5 control-label">Content : </label>
	   				 <div class="col-sm-7">
						<p id="proj_content"></p>
	  				  </div>
	  			      </div>
				  	<div class="form-group">
				    <label for="proj_start_date_t" class="col-sm-5 control-label">Period : </label>
				    <div class="col-sm-7">
						<p id="proj_period"></p>
				    </div>
				  </div>
				  	<div class="form-group">
				    <label for="proj_start_date_t" class="col-sm-5 control-label">Start Date : </label>
				    <div class="col-sm-7">
						<p id="proj_start_date"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="proj_end_date_t" class="col-sm-5 control-label">End Date : </label>
				    <div class="col-sm-7">
						<p id="proj_end_date"></p>
				    </div>
				  </div>
			</form>
	      </div>
	    </div>
	  </div>
	</div>

	<div id="deptCalModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
	     	   <button type="button" class="close" data-dismiss="modal">&times;</button>
	     	   <h4 class="modal-title"></h4>
	      	</div>
	      	<div class="modal-body">
				<form class="form-horizontal">
					  <div class="form-group">
	 				   <label for="dept_cal_content_t" class="col-sm-5 control-label">Content : </label>
	   				 <div class="col-sm-7">
						<p id="dept_cal_content"></p>
	  				  </div>
	  			      </div>
				  	<div class="form-group">
				    <label for="dept_cal_start_date_t" class="col-sm-5 control-label">Start Date : </label>
				    <div class="col-sm-7">
						<p id="dept_cal_start_date"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="dept_cal_end_date_t" class="col-sm-5 control-label">End Date : </label>
				    <div class="col-sm-7">
						<p id="dept_cal_end_date"></p>
				    </div>
				  </div>
			</form>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>