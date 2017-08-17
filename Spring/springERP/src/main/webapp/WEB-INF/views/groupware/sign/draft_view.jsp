<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<script src="/resources/groupware/js/draft_view.js" type="text/javascript"></script>
<link rel="stylesheet" href="/resources/groupware/css/draft_view.css">
</head>
<body>

	<h2 class="page_title">기안서 작성 > ${draftView.draft_id }번 기안서</h2>

	<div class="page-header">
		<div class="panel panel-info">
			<div class="panel-heading">
				
				<h4 class="panel-title">${draftView.draft_title }</h4>
				<small> 글번호 : ${draftView.draft_id } / 작성자 : ${draftView.e_name}
				/ 작성일 : <fmt:formatDate value="${draftView.draft_date }" pattern="yyyy-MM-dd" /> 
				/ 결재자 :
				<c:forEach var="i" begin="0" end="${draftView.approval.size()-1}" step="1">
					${draftView.approval.get(i)}<c:if test="${ i != draftView.approval.size()-1}">, </c:if>
				</c:forEach>
			 	/ 참조자 :
				<c:forEach var="i" begin="0" end="${draftView.reference.size()-1}" step="1">
					${draftView.reference.get(i)}<c:if test="${ i != draftView.reference.size()-1}">, </c:if>
				</c:forEach>
				</small>
			</div>
		</div>
	</div>
	<div id="write_content">
		<p>${draftView.draft_content }</p>
		<hr>
	</div>
	<div class="row">
  			<a href="/groupware/sign/draft_edit${draftView.draft_id}" class="btn btn-warning">수정</a>
  			<a href="/groupware/sign/draft_delete${draftView.draft_id}" class="btn btn-danger">삭제</a>
  			<a href="/groupware/sign/all_draft_list" class="btn btn-primary">목록</a>
  			<button id="printBtn" class="btn btn-primary glyphicon glyphicon-print" value="${draftView.draft_id}">프린트</button>
	</div>
		
	<br/>
</body>
</html>
