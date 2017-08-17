<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>POWER ERP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/webjars/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>

	<h2 class="page_title">전체 프로젝트  > ${project.proj_id }번 글</h2>

	<div class="page-header">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h4 class="panel-title">${project.proj_name }</h4>
				<small> 글번호 : ${project.proj_id } / 작성자 : ${e_name}
				/ 전체 기간 : ${project.proj_period } 
				/ 시작일 : <fmt:formatDate value="${project.proj_start_date }" pattern="yyyy-MM-dd" /> 
				/ 종료일 : <fmt:formatDate value="${project.proj_end_date }" pattern="yyyy-MM-dd" /> 
				</small>
			</div>
		</div>
	</div>
	<div id="write_content">
		<p>${project.proj_content }</p>
		<hr>

		<form role="form" method="post">
			<input type='hidden' name='proj_id' value="${project.proj_id}">
		</form>

		<div class="row">
   			<button type="submit" class="btn btn-primary" id="goListBtn">목록</button>
		</div>
		
	</div>
	<br/>
		
	<form action="noticeReplyInsertAction.gw?notice_id=${project.proj_id }" method="post">
		<div id="view_comment">
			<ul class="list-unstyled">
				<c:if test="${list.size()-1 >=0}">
					<c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
						<li>
								<div class="panel panel-warning">
									<div class="panel-heading">
										<span class="text-muted">${re_name.get(i) }</span>
										<span class="redate"> ${list.get(i).getNreply_date() }</span>
										<a type="button" href="replyDeleteAction.gw?re_id=${list.get(i).getNreply_id() }"	class="btn btn-sm pull-right">삭제</a>
										<a type="button" href="replyDeleteAction.gw?re_id=${list.get(i).getNreply_id() }"	class="btn btn-sm pull-right">수정</a>
									</div>
									<div class="panel-body">${list.get(i).getNreply_content() }</div>
								</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<textarea id="co_content" class="form-control" rows="2" name="no_reply"></textarea>
			<button type="submit" class="btn btn-default">댓글달기</button>	
		</div>	
	</form>
	
	<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#goListBtn").click(function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/groupware/project_board/all_project_list");
		formObj.submit();
	});
	
});
</script>

</body>
</html>
