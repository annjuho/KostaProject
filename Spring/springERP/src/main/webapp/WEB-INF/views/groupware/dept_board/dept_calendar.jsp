<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">

<head>
<title>POWER ERP</title>
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


<!-- custom js,css경로 -->
<link href='/resources/groupware/css/gw_dept_calendar.css' rel='stylesheet'>
<script src='/resources/groupware/js/dept_calendar.js'></script>
</head>
<body>

	<h2 class="page_title">부서 일정</h2>

	<div id='calendar'></div>


	<table class="table table-hover" class="boardList">
		<thead>
			<tr class="row">
				<th class="col-sm-1">글번호</th>
				<th class="col-sm-3">제목</th>
				<th class="col-sm-2">작성자</th>
				<th class="col-sm-2">시작일</th>
				<th class="col-sm-2">종료일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${list.size()-1 >=0}">
				<c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
					<tr class="row">
						<td class="col-sm-1">${list.get(i).getDept_schedule_id()}</td>
						<td class="col-sm-3">
							<c:choose>
								<c:when test="${list.get(i).getProj_id() == '' }">
									<a class="schBoard" href="dept_sch_view?sch_id=${list.get(i).getDept_schedule_id()}">${list.get(i).getSchedule_name() }</a>
								</c:when>
								<c:otherwise>
									<a class="projBoard" href="all_project_view?proj_id=${list.get(i).getProj_id()}">${list.get(i).getSchedule_name() }</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td class="col-sm-2">${e_name_list.get(i) }</td>
						<td class="col-sm-2"><fmt:formatDate
								value="${list.get(i).getStart_schedule_date() }"
								pattern="yyyy-MM-dd" /></td>
						<td class="col-sm-2"><fmt:formatDate
								value="${list.get(i).getEnd_schedule_date() }"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

	<div class="box-footer">

		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a
						href="dept_calendar${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="dept_calendar${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="dept_calendar${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>

			</ul>
		</div>

	</div>
	
	<div class="row">
		<a id="write" href="dept_sch_write" class="btn btn-default col-sm-1 col-sm-push-11">글쓰기</a>
	</div>
	
	<form action="noticeSearchAction.gw" method="post">
		<div class="col-xs-2">
			<select name="type" class="form-control">
				<option value="writer">글쓴이</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
		</div>

		<div class="col-xs-2">
			<input class="form-control" id="ex1" type="text" name="word">
		</div>
		<button type="submit" class="btn btn-default">검색</button>
	</form>
	
	
<div id="showModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
      
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
<form class="form-horizontal">
  <div class="form-group">
    <label for="sch_content_t" class="col-sm-5 control-label">Content : </label>
    <div class="col-sm-7">
		<p id="sch_content"></p>
    </div>
  </div>
  <div class="form-group">
    <label for="sch_start_date_t" class="col-sm-5 control-label">Start Date : </label>
    <div class="col-sm-7">
		<p id="sch_start_date"></p>
    </div>
  </div>
  <div class="form-group">
    <label for="sch_end_date_t" class="col-sm-5 control-label">End Date : </label>
    <div class="col-sm-7">
		<p id="sch_end_date"></p>
    </div>
  </div>
</form>
      </div>
    </div>

  </div>
</div>
</body>
</html>