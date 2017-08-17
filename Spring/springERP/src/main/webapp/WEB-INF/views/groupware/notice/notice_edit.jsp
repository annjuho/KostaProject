<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>POWER ERP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/common/ckeditor/ckeditor.js"></script>

</head>
<body>

	<h2 class="page_title">공지사항</h2>

	<form:form action="notice_edit" method="post">
		<input type="hidden" name="notice_id" value="${notice.notice_id }">

		<div class="write_header">
			<label class="control-label col-sm-1" for="noticeEditTitle">제목</label>
			<div class="col-sm-11">
				<input id="noticeEditTitle" type="text" class="form-control" name="notice_title"
					placeholder="제목 입력" value="${notice.notice_title }">
			</div>
		</div>

		<div id="write_content">
			<label class="control-label col-sm-1" for="noticeEditContent">내용</label>
			<div class="col-sm-11">
				<textarea id="noticeEditContent" class="ckeditor" cols="1" name="notice_content" rows="15">
					${notice.notice_content }
				</textarea>
			</div>
		</div>

		<div class="col-sm-2 col-sm-push-10">
			<button type="submit" class="btn btn-default">수정</button>
			<button type="button" class="btn btn-default">목록</button>
		</div>
	</form:form>
	
</body>
</html>