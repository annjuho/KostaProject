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

	<h2 class="page_title">부서 게시판</h2>

	<form:form action="dept_board_edit" method="post">
		<input type="hidden" name="dept_board_id" value="${dept.dept_board_id }">

		<div class="write_header">
			<label class="control-label col-sm-1" for="deptEditTitle">제목</label>
			<div class="col-sm-11">
				<input id="deptEditTitle"type="text" class="form-control" name="dept_board_title"
					placeholder="제목 입력" value="${dept.dept_board_title }">
			</div>
		</div>

		<div id="write_content">
			<label class="control-label col-sm-1" for="deptEditContent">내용</label>
			<div class="col-sm-11">
				<textarea id="deptEditContent" class="ckeditor" cols="1" name="dept_board_content" rows="15">
					${dept.dept_board_content }
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