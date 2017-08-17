<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/webjars/jquery/2.0.0/jquery.min.js"></script>

</head>
<body>

	<!-- 부서 게시판 내 글 start -->
	
	<h2 class="page_title">부서 게시판</h2>
	
	<table class="table table-hover" class="boardList">
		<thead>
			<tr class="row">
				<th class="col-sm-1">글번호</th>
				<th class="col-sm-6">제목</th>
				<th class="col-sm-2">작성자</th>
				<th class="col-sm-2">작성일</th>
				<th class="col-sm-1">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${deptBoardList.size()-1 >=0}">
				<c:forEach var="i" begin="0" end="${deptBoardList.size()-1}" step="1">
					<tr class="row">
						<td class="col-sm-1">${deptBoardList.get(i).getDept_board_id()}</td>
					 	<td class="col-sm-6"><a class="deptBoardTitle" href="dept_board_view?dept_board_id=${deptBoardList.get(i).getDept_board_id()}">${deptBoardList.get(i).getDept_board_title() }</a></td>
						<td class="col-sm-2">${dept_ename_list.get(i) }</td>
								<td class="col-sm-2"><fmt:formatDate value="${deptBoardList.get(i).getDept_board_date() }"
								pattern="yyyy-MM-dd" /></td>
						<td class="col-sm-1">${deptBoardList.get(i).getDept_board_hit() }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	<div class="box-footer">
		<div class="text-center">
			<ul class="pagination">
				<c:if test="${deptBoardPageMaker.prev}">
					<li><a href="my_text${deptBoardPageMaker.makeQuery(deptBoardPageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${deptBoardPageMaker.startPage }" end="${deptBoardPageMaker.endPage }" var="idx">
					<li	<c:out value="${deptBoardPageMaker.deptCri.deptPage == idx?'class =active':''}"/>>
						<a href="my_text${deptBoardPageMaker.makeQuery(idx)}">${idx}</a>
					</li>
				</c:forEach>
				<c:if test="${deptBoardPageMaker.next && deptBoardPageMaker.endPage > 0}">
					<li><a href="my_text${deptBoardPageMaker.makeQuery(deptBoardPageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	
	<hr>
	
	<!-- 프로젝트 내 글 start -->
	
	<h2 class="page_title">내 프로젝트</h2>
	
	<table class="table table-hover" class="boardList">
		<thead>
			<tr class="row">
				<th class="col-sm-1">글번호</th>
				<th class="col-sm-3">제목</th>
				<th class="col-sm-2">작성자</th>
				<th class="col-sm-2">총기간</th>
				<th class="col-sm-2">시작일</th>
				<th class="col-sm-2">종료일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${myProjList.size()-1 >=0}">
				<c:forEach var="i" begin="0" end="${myProjList.size()-1}" step="1">
					<tr class="row">
						<td class="col-sm-1">${myProjList.get(i).getProj_id()}</td>
					 	<td class="col-sm-3"><a class="myProjTitle" href="pb_myproject_view?proj_id=${myProjList.get(i).getProj_id()}">${myProjList.get(i).getProj_name() }</a></td>
						<td class="col-sm-2">${myProj_Ename_list.get(i) }</td>
						<td class="col-sm-2">${myProjList.get(i).getProj_period() }</td>
								<td class="col-sm-2"><fmt:formatDate value="${myProjList.get(i).getProj_start_date() }"
								pattern="yyyy-MM-dd" /></td>
								<td class="col-sm-2"><fmt:formatDate value="${myProjList.get(i).getProj_end_date() }"
								pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	<div class="box-footer">
		<div class="text-center">
			<ul class="pagination">
				<c:if test="${myProjPageMaker.prev}">
					<li><a href="my_text${myProjPageMaker.makeQuery(myProjPageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${myProjPageMaker.startPage }" end="${myProjPageMaker.endPage }" var="idx">
					<li	<c:out value="${myProjPageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="my_text${myProjPageMaker.makeQuery(idx)}">${idx}</a>
					</li>
				</c:forEach>
				<c:if test="${myProjPageMaker.next && deptBoardPageMaker.endPage > 0}">
					<li><a href="my_text${myProjPageMaker.makeQuery(myProjPageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>

	<script type="text/javascript">
	
	$(function(){
		/* 부서 게시판 상세 내용 */
		   $('.deptBoardTitle').on('click', function(e) {
		      e.preventDefault();
		      $('#contents').empty();	
		      $('#contents').load('/groupware/dept_board/'+$(this).attr('href'));
		   });
		/* 내 프로젝트 상세 내용 */
		   $('.myProjTitle').on('click', function(e) {
			      e.preventDefault();
			      $('#contents').empty();	
			      $('#contents').load('/groupware/project_board/'+$(this).attr('href'));
			   });

		   
		})
	</script>
	
</body>
</html>