<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<script src="/resources/common/ckeditor/ckeditor.js"></script>
<script src="/resources/groupware/js/draft_write.js"></script>
<link rel="stylesheet" href="/resources/common/css/common.css">
</head>
<body>

	<!-- 결재자 검색 -->
	<div id="approvalSearch_modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
	       		<button type="button" class="close" data-dismiss="modal">&times;</button>
	       		<h4 class="modal-title">결재자 검색</h4>
	      	</div>
		      
	      	<div class="modal-body">
				
				<div class="input-group">
				  <input type="text" class="form-control" name="e_name" id="ap_name_input" placeholder="직원 이름을 입력하세요" aria-describedby="apSearchBtn">
				  <span class="btn btn-info input-group-addon" id="apSearchBtn"><span class="fa fa-search"></span></span>
				</div>
				
				<br>
	  			<table id="apSearchTable" class="table table-bordered table-hover text-center"></table>
				<div id="useBtnArea">
					<input type="button" class="btn btn-default center apUseBtn" value="사용" data-dismiss="modal">
				</div>
	      	</div>
      	
		    <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		    </div>
	    </div>
	</div>
	</div>
	
	<!-- 참조자 검색 -->
	<div id="referenceSearch_modal" class="modal fade" role="dialog">
	<div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
	       		<button type="button" class="close" data-dismiss="modal">&times;</button>
	       		<h4 class="modal-title">참조자 검색</h4>
	      	</div>
		      
	      	<div class="modal-body">
				<div class="input-group">
				  <input type="text" class="form-control" name="e_name" id="re_name_input" placeholder="직원 이름을 입력하세요" aria-describedby="reSearchBtn">
				  <span class="btn btn-info input-group-addon" id="reSearchBtn"><span class="fa fa-search"></span></span>
				</div>
				
				<br>
	  			<table id="reSearchTable" class="table table-bordered table-hover text-center"></table>
				<div id="useBtnArea">
					<input type="button" class="btn btn-default center reUseBtn" value="사용" data-dismiss="modal">
				</div>
	      	</div>
      	
		    <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		    </div>
	    </div>
	</div>
	</div>
	

	<h2 class="page_title">기안서 작성</h2>
	<form:form name="writeForm" role="form" method="post">
		<input type="hidden" name="draft_id" value="${draftView.draft_id }">
		<input type="hidden" name="draft_format_id" value="${draftFormat.draft_format_id }">
		<input type="hidden" name="approval_emp" id="approval_emp" value="${draftView.approval }">
		<input type="hidden" name="reference_emp" id="reference_emp" value="${draftView.reference }">
		<input type="hidden" name="emp_id" value="${emp_id }">
		<c:if test="${draftView != null}">
			<input type="hidden" name="draft_date" value="${draftView.draft_date }">
		</c:if>
		<input type="hidden" name="draft_state" value="진행중">
		
		<div class="write_header content-group col-sm-12">
			<label class="control-label col-sm-1" for="draft_title">제목</label>
			<div class="col-sm-11">
				<c:if test="${draftFormat.draft_format_id == null}">
				<input type="text" class="form-control" name="draft_title"
					placeholder="제목 입력" value="${draftView.draft_title }">
				</c:if>
				<c:if test="${draftFormat.draft_format_id != null}">
				<input type="text" class="form-control" name="draft_title"
					placeholder="제목 입력" value="${draftFormat.draft_format_title }">
				</c:if>
			</div>
		</div>
		
		<div class="content-group col-sm-12">
		
			<div class="col-sm-4">
				<label class="control-label col-sm-4" for="draft_type">종류</label>
				<div class="col-sm-8">
					<select class="form-control" name="draft_type">
						<option value="공통" selected>공통</option>
						<option value="인사">인사</option>
						<option value="회계">회계</option>
					</select>
				</div>
			</div>
			
			<div class="col-sm-4">
				<label class="control-label col-sm-4">결재자</label>
				<div class="input-group col-sm-8">
				  <input type="text" class="form-control" name="approval" id="approvalName" placeholder="결재자를 선택하세요" aria-describedby="approval_SearchKey">
				  <span class="btn btn-info input-group-addon" id="approval_SearchKey" data-toggle="modal" data-target="#approvalSearch_modal"><span class="fa fa-search"></span></span>
				</div>
			</div>
			
			<div class="col-sm-4">
				<label class="control-label col-sm-4">참조자</label>
				<div class="input-group col-sm-8">
				  <input type="text" class="form-control" name="reference" id="referenceName" placeholder="결재자를 선택하세요" aria-describedby="reference_SearchKey">
				  <span class="btn btn-info input-group-addon" id="reference_SearchKey" data-toggle="modal" data-target="#referenceSearch_modal"><span class="fa fa-search"></span></span>
				</div>
			</div>
		</div>
		
		<div id="write_content content-group col-sm-12">
			<label class="control-label col-sm-1" for="draft_content">내용</label>
			<div class="col-sm-11">
				<c:if test="${draftFormat.draft_format_id == null}">
					<textarea class="ckeditor" name="draft_content">${draftView.draft_content }</textarea>
				</c:if>
				<c:if test="${draftFormat.draft_format_id != null}">
					<textarea class="ckeditor" name="draft_content">${draftFormat.draft_format_content }</textarea>
				</c:if>
			</div>
		</div>
		
		<div class="content-group col-sm-12 text-center">
			<c:choose>
				<c:when test="${draftView.draft_id == null }">
					<button id="createBtn" class="btn btn-default">등록</button>
				</c:when>
				<c:otherwise>
					<button id="editBtn" class="btn btn-default">수정</button>
				</c:otherwise>
			</c:choose>
			<button type="button" class="btn btn-default">목록</button>
		</div>
	</form:form>
</body>
</html>