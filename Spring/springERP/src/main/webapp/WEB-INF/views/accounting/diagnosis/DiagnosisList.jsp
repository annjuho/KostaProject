<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />


<script src="/resources/accounting/js/jquery.treetable.js" type="text/javascript"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="/resources/accounting/js/jquery-3.0.0.js" type="text/javascript"></script>
<script src="/resources/accounting/js/di.js" type="text/javascript"></script>
<link rel="stylesheet" href="/resources/accounting/css/jquery.treetable.css">

</head>
<body>

	<h2 class="page_title">계정등록</h2>
	<div class="mainContents">	
		<div class="container-fluid">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped tree"
					id="Card">
					<thead id="diagnosisHeader">
						<tr class="mainTable">
							<th class="center" style="width: 20px">
							<input type="checkbox"></th>
							<th style="width: 100px;">계정명</th>
							<th style="width: 55px;">대차구분</th>
							<th style="width: 53px;">계정종류</th>
							<th style="width: 53px;">사용구분</th>
							<th style="width: 45px;">비고</th>
						</tr>
					</thead>
					<tbody id="diagnosisContents">
				<c:forEach var="listModel" items="${listModel }">
				<tr><td><input type="checkbox"></td>
					<td>${listModel.diagnosis_name }</td>				
					<td>${listModel.sort }</td>
					<td>${listModel.diagnosis_type }</td>
					<td>${listModel.use }</td>
					<td>${listModel.remarks }</td>					
				</tr>
				</c:forEach>
						

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="buttongroup">
		<button type="button" class="btn btn-default">신규등록</button>
		<button id="updateBtn" type="button" class="btn btn-default">수정</button>
		<input type="button" id="deleteBtn" class="btn btn-default" value="삭제">
	</div>

</body>
</html>