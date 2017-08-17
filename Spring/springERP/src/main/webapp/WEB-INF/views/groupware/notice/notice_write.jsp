<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="ko">
<head>
<title>POWER ERP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/common/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="/resources/common/css/common.css">

</head>
<body>

	<h2 class="page_title">공지사항</h2>
	
	<form:form id="writeForm" role="form" method="post">
	
		<div class="write_header content-group">
			<label class="control-label col-sm-1" for="noticeWriteTitle">제목</label>
			<div class="col-sm-11">
				<input id="noticeWriteTitle" type="text" class="form-control" name="notice_title"
					placeholder="제목 입력">
			</div>
		</div>

		<div id="write_content content-group">
			<label class="control-label col-sm-1" for="noticeWriteContent">내용</label>
			<div class="col-sm-11">
				<textarea id="noticeWriteContent" class="ckeditor" cols="133" name="notice_content" rows="15"></textarea>
			</div>
		</div>
			
		<div class="col-sm-2 col-sm-push-10 content-group">
			<button type="submit" class="btn btn-default">등록</button>
			<button type="button" class="btn btn-default">목록</button>
		</div>
	</form:form>
</body>
</html>