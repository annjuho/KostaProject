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
</head>
<body>

	<h2 class="page_title">기안서 작성 > ${draft.draft_id }번 기안서</h2>

	<div class="page-header">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h4 class="panel-title">${draft.draft_title }</h4>
				<small> 글번호 : ${draft.draft_id } / 작성자 : ${e_name}
				/ 작성일 : <fmt:formatDate value="${draft.draft_date }" pattern="yyyy-MM-dd" /> 
				</small>
			</div>
		</div>
	</div>
	<div id="write_content">
		<p>${draft.draft_content }</p>
		<hr>

		<form role="form" method="post">
			<input type='hidden' name='draft_id' value="${draft.draft_id}">
		</form>

		<div class="row">
			<button type="submit" class="btn btn-warning" id="modifyBtn">수정</button>
   			<button type="submit" class="btn btn-danger" id="removeBtn">삭제</button>
   			<button type="button" class="btn btn-primary" id="goListBtn">목록</button>
		</div>
		
	</div>
	<br/>
	
	<script>
		$(document).ready(function(){
		
			var formObj = $("form[role='form']");
			
			console.log(formObj);
		       
			$("#modifyBtn").on("click", function(){
				formObj.attr("method", "get");
				formObj.attr("action", "/groupware/sign/draft_edit");
				formObj.submit();
			});
			
		 	$("#removeBtn").on("click", function(){
		 		formObj.attr("method", "get");
				formObj.attr("action", "/groupware/sign/draft_delete");
				formObj.submit();
			});
		
			/* $("#removeBtn").on("click", function(){
				
				var replyCnt =  $("#replycntSmall").html();
				
				if(replyCnt > 0 ){
					alert("댓글이 달린 게시물을 삭제할 수 없습니다.");
					return;
				}	
				
				var arr = [];
				$(".uploadedList li").each(function(index){
					 arr.push($(this).attr("data-src"));
				});
				
				if(arr.length > 0){
					$.post("/deleteAllFiles",{files:arr}, function(){
						
					});
				}
				
				formObj.attr("action", "/sboard/removePage");
				formObj.submit();
			});	 */
			
			$("#goListBtn").click(function(){
				/* formObj.attr("method", "get");
				formObj.attr("action", "/groupware/sign/draft_list");
				formObj.submit(); */
				location.href="/groupware/sign/all_draft_list";
			});
		
		});
	</script>

</body>
</html>
