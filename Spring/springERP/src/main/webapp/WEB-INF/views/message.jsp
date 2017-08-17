<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<link rel="stylesheet" href="/resources/hr/css/emp.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/dist/css/bootstrap.min.css">
<script src="/webjars/jquery/2.0.0/jquery.min.js"></script>

<!-- Custom Style -->
<link rel="stylesheet" href="/resources/common/css/common.css">
<link rel="stylesheet" href="/resources/hr/css/emp.css">
<style type="text/css">
.message_head th, .message_body td{
	text-align: center;
}
body{
	margin: 20px;
}
</style>
<script type="text/javascript">
	function fn_send_message(){
		location.href="/message/sendForm?emp_id="+$('#log_id').val()+"&receive_id=";
	}
</script>

<script type="text/javascript">
	$(function() {
		$('#messageSearch').on(
				'click',
				function(event) {
					self.location = "message" + '${pageMaker.makeQuery(1)}'
							+ "&searchType=null" + "&emp_id="+ $('#log_id').val() +"&keyword="
							+ $('#keyword_input').val();
				});
	});
	$(function() {
		$('#checkAll').click(function() {
			if (this.checked) {
				$('input[name=id_box]').each(function() {
					$(this).prop('checked', true);
				});
			} else {
				$('input[name=id_box]').each(function() {
					$(this).prop('checked', false);
				});
			}
		});

		$('#delete_msg_btn').on('click', function() {
			var array = [];
			$("input[name=id_box]:checked").each(function() {
				array.push($(this).val());
			});
			var url = "/message/message_delete${pageMaker.makeSearch(pageMaker.cri.page)}&array="
						+ array;
			if (array == "") {
				alert("삭제할 목록을 체크하시오.");
			} else {
				$(location).attr('href', url);
			}
		});
	});
</script>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<title>Insert title here</title>
</head>
<body>
	<h2 class="page_title">쪽지함</h2>
	<input type="hidden" value="${pageMaker.emp_id}" id="log_id">
	<div class="hr_body">
		<div class="pull-right">
			<div class="form-group">
				<label for="search_contents">찾을내용</label> <input type="text"
					class="input-sm" id="keyword_input" name="keyword">
				<button type="button" class="btn btn-default search_group" id="messageSearch"><span class="fa fa-search"></span></button>
			</div>
		</div>
		<div class="container-fluid">
			<table class="table table-condensed table table-bordered">
				<thead>
					<tr class="message_head">
						<th><input type="checkbox" id="checkAll"></th>
						<th>제목</th>
						<th>보낸사람</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="messageViewVO">
						<tr class="message_body">
							<td><input type="checkbox" class="upSelect check_id"
								name="id_box" value="${messageViewVO.message_id }"></td>
							<c:choose>
								<c:when test="${messageViewVO.receive_check eq 'Y' }">
									<td><b><a class="message_read" href="/message/readMessage${pageMaker.makeSearch(pageMaker.cri.page) }&message_id=${messageViewVO.message_id }">${messageViewVO.title }</a></b></td>
								</c:when>
								<c:otherwise>
									<td><a class="message_read" href="/message/readMessage${pageMaker.makeSearch(pageMaker.cri.page) }&message_id=${messageViewVO.message_id }">${messageViewVO.title }</a></td>
								</c:otherwise>
							</c:choose>									
							<td>${messageViewVO.e_name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<ul class="pagination">

					<c:if test="${pageMaker.prev}">
						<li><a
							href="message${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="message${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="message${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
					</c:if>

				</ul>
			</div>
		</div>
		<button type="button" class="btn btn-default" id="send_message_btn"
			onclick="fn_send_message()">쪽지보내기</button>
		<button type="button" class="btn btn-default" id="delete_msg_btn">삭제</button>
	</div>
</body>
</html>