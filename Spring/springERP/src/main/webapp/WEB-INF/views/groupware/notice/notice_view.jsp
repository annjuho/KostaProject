<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>POWER ERP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
<script src="/webjars/jquery/2.0.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/dist/js/bootstrap.min.js"></script>

<script src='/resources/groupware/js/gw_notice.js'></script>
<script type="text/javascript">
$(function(){
var formObj = $("form[role='form']");
   
$("#modifyBtn").on("click", function(){
	formObj.attr("method", "get");
	formObj.attr("action", "/groupware/notice/notice_edit");
	formObj.submit();
});

	$("#removeBtn").on("click", function(){
		formObj.attr("method", "get");
	formObj.attr("action", "/groupware/notice/notice_delete");
	formObj.submit();
});

$("#goListBtn").click(function(){
	formObj.attr("method", "get");
	formObj.attr("action", "/groupware/notice/notice_list");
	formObj.submit();
});

$(".reUpdate").on('click', function(e){
	e.preventDefault();
	var re_id=this.getAttribute('href');
	alert(re_id);
	$('hinput').val(re_id);
	$('#showModal').modal('show');
});
});


</script>

</head>
<body>

	<h2 class="page_title">공지사항  > ${notice.notice_id }번 글</h2>

	<div class="page-header">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h4 class="panel-title">${notice.notice_title }</h4>
				<small> 글번호 : ${notice.notice_id } / 작성자 : ${e_name}
				/ 작성일 : <fmt:formatDate value="${notice.notice_date }" pattern="yyyy-MM-dd" /> 
				/ 조회수 : ${notice.notice_hit } 
				</small>
			</div>
		</div>
	</div>
	<div id="write_content">
		<p>${notice.notice_content }</p>
		<hr>

		<form:form role="form" method="post">
			<input type='hidden' name='notice_id' value="${notice.notice_id}">
		</form:form>

		<div class="row">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<button type="submit" class="btn btn-warning" id="modifyBtn">수정</button>
	   			<button type="submit" class="btn btn-danger" id="removeBtn">삭제</button>
	   		</sec:authorize>
   			<button type="submit" class="btn btn-primary" id="goListBtn">목록</button>
		</div>
		
	</div>
	<br/>
		
		<div id="view_comment">
			<ul class="list-unstyled">
				<c:if test="${list.size()-1 >=0}">
					<c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
						<li>
								<div class="panel panel-warning">
									<div class="panel-heading">
										<span class="text-muted">${re_name.get(i) }</span>
										<span class="redate"> ${list.get(i).getNreply_date() }</span>
										<a type="button" href="notice_reply_delete?re_id=${list.get(i).getNreply_id() }&notice_id=${notice.notice_id}"	class="btn btn-sm pull-right">삭제</a>
										<a type="button" href="${list.get(i).getNreply_id() }" class="reUpdate btn btn-sm pull-right">수정</a>
									</div>
									<div class="panel-body">${list.get(i).getNreply_content() }</div>
								</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<form:form action="notice_reply_insert" method="post">
					<input type='hidden' name='notice_id' value="${notice.notice_id}">
					<textarea id="co_content" class="form-control" rows="2" name="nreply_content"></textarea>
					<button type="submit" class="btn btn-default">댓글달기</button>	
			</form:form>
		</div>
		
		
<div id="showModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
      
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
		<form:form class="form-horizontal" action="notice_reply_update" method="post">
		  <div class="form-group">
		    <label class="col-sm-12 control-label">댓글 수정</label>
		  </div>
		    <div class="col-sm-12">
				<input type='hidden' name='nreply_id' id='hinput'>
		    	<textarea id="re_content" class="form-control" rows="2" name="nreply_content"></textarea>
		    </div>
			<button type="submit" class="btn btn-default">확인</button>	
		</form:form>
      </div>
    </div>

  </div>
</div>

</body>
</html>
