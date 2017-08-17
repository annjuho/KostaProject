<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<script src="/resources/common/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="/resources/common/css/common.css">

</head>
<body>

	<h2 class="page_title">공통 양식 관리</h2>
	
	<form:form id="writeForm" action="draft_format_write" role="form" method="post">
	
		<div class="write_header content-group">
			<label class="control-label col-sm-1" for="title">제목</label>
			<div class="col-sm-11">
				<input type="text" class="form-control" name="draft_format_title"
					placeholder="제목 입력"  value="${draftFormat.draft_format_title }">
			</div>
		</div>
		
		<div class="content-group col-sm-12">
			<label class="control-label col-sm-1" for="draft_format_type">종류</label>
			<div class="col-sm-3">
				<select class="form-control" name="draft_format_type">
					<option value="공통" selected>공통</option>
					<option value="인사">인사</option>
					<option value="회계">회계</option>
				</select>
			</div>
		</div>
		
		<div id="write_content content-group">
			<label class="control-label col-sm-1" for="content">내용</label>
			<div class="col-sm-11">
				<textarea class="ckeditor" cols="133" name="draft_format_content" rows="15">${draftFormat.draft_format_content }</textarea>
			</div>
		</div>
			
		<div class="col-sm-2 col-sm-push-10 content-group">
			<button type="submit" class="btn btn-default">등록</button>
			<button type="button" class="btn btn-default">목록</button>
		</div>
	</form:form>
</body>
</html>