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

	<h2 class="page_title">부서 일정 게시판</h2>
	
	<form:form id="writeForm" role="form" method="post">
	
		<div class="write_header content-group">
			<label class="control-label col-sm-1" for="deptSchWriteTitle">제목</label>
			<div class="col-sm-11">
				<input id="deptSchWriteTitle" type="text" class="form-control" name="schedule_name"
					placeholder="제목 입력">
			</div>
		</div>

		<div id="write_content content-group">
			<label class="control-label col-sm-1" for="deptSchWriteContent">내용</label>
			<div class="col-sm-11">
				<textarea id="deptSchWriteContent" class="ckeditor" cols="133" name="schedule_content" rows="15"></textarea>
			</div>
		</div>

		<div class="col-sm-12 content-group">
			<label class="control-label col-sm-6" for="content">시작일</label><input class="col-sm-6" type="date" name="start_schedule_date">
			<label class="control-label col-sm-6" for="content">종료일</label><input class="col-sm-6" type="date" name="end_schedule_date">
		</div>
			
		<div class="col-sm-2 col-sm-push-10 content-group">
			<button type="submit" class="btn btn-default">등록</button>
			<button type="button" class="btn btn-default">목록</button>
		</div>
	</form:form>
</body>
</html>