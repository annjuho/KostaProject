<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<link href="/resources/mypage/css/my_file.css" rel="stylesheet">
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<script type="text/javascript" src="/resources/mypage/js/my_file.js"></script>
<script type="text/javascript">

$(function(){
	$("#uploadBtn").click(function(){
		alert("upup");
		document.form1.action = "my_file/uploadForm?${_csrf.parameterName}=${_csrf.token }";
		document.form1.submit();
	})
	
	$("#downloadBtn").click(function(){
		alert("dada");
		document.form1.action = "my_file/download?${_csrf.parameterName}=${_csrf.token }";
		document.form1.submit();
	})
	
	$("#deleteBtn").click(function(){
		alert("del!!");
		document.form1.action = "my_file/deleteFile?${_csrf.parameterName}=${_csrf.token }";
		document.form1.submit();
	})
})
</script>
</head>
<body>

	<h2 class="page_title">개인파일함</h2>
	
	
	<form:form class="form-inline pull-left folderFileForm" name="form1" method="post" enctype="multipart/form-data">
		<input class="btn btn-sm btn-default form-control" type="file" id="fileUp" name="file" multiple title="파일 올리기">
		<button class="btn btn-sm btn-default form-control" type="button" id="uploadBtn">
			<span>올리기</span>
		</button>
		<button class="btn btn-sm btn-default form-control" type="button" id="downloadBtn">
			<span>내려받기</span>
		</button>
		<button class="btn btn-sm btn-default form-control" type="button" id="deleteBtn">
			<span>삭제</span>
		</button>
		<input id="search_txt" class="form-control"
			type="text" name="p_search" accesskey="s">
		<button class="btn btn-sm btn-warning form-control" href="#"><span>검색</span></button>
	
		<div class="fileDrop">
			<div class="uploadedList">
				<c:if test="${list.size()-1 >=0}">
				<c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
					<div class="item_box">
					  <label>
						  	<input id="input_check" name="fileCheck" type="checkbox" autocomplete="off" value="${list.get(i).getFile_id() }">
							<input type="hidden" id="filename${i }" value="${list.get(i).getUpload_file() }">
							
							<c:choose>
							<c:when test="${list.get(i).getFile_type().substring(0,5).equals('image')}">
								<div class="imagefile item"></div>
							</c:when>
							<c:otherwise>
								<div class="item">
									<c:choose>
										<c:when test="${list.get(i).getFile_type() =='application/zip' }">
											<img src="/resources/mypage/images/zipfile.jpg" alt="zip file image" />
											<span class="file_type_text">ZIP</span>
										</c:when>
										<c:when test="${list.get(i).getFile_type().substring(0,5).equals('audio') }">
											<img src="/resources/mypage/images/musicfile.jpg" alt="music file image" />
											<span class="file_type_text">Audio</span>
										</c:when>
										<c:when test="${list.get(i).getFile_type().substring(0,4).equals('text') }">
											<img src="/resources/mypage/images/textfile.jpg" alt="text file image" />
											<span class="file_type_text">Text</span>
										</c:when>
										<c:otherwise>
											<img src="/resources/mypage/images/otherfile.jpg" alt="other file image" />
											<span class="file_type_text">File</span>
										</c:otherwise>
									</c:choose>
								</div>
							</c:otherwise>
							</c:choose>
							
							<div class="item_text">
								<span class="item_title" value="${list.get(i).getFile_name() }">${list.get(i).getFile_name() }</span>
								<span class="item_size">${list.get(i).getFile_size() }</span>
								<span class="item_writer">${e_name }</span>
							</div>
					  </label>
					</div>
				</c:forEach>
				</c:if>
			</div>
		</div>
	</form:form>
	
	<ul class="pager">
		<li class="previous"><a href="#">Previous</a></li>
		<li><a>1</a></li>
		<li class="next"><a href="#">Next</a></li>
	</ul>
		
</body>
</html>