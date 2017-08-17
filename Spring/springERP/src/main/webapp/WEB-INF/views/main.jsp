<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- spring security -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="erp.hr.domain.EmployeeVO"%>

<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String left = request.getParameter("left");
	Object principal = auth.getPrincipal();
	String name = "";
	String emp_id = "";
	int margin = 0;
	if (principal != null && principal instanceof EmployeeVO) {
		name = ((EmployeeVO) principal).getE_name();
		emp_id = ((EmployeeVO) principal).getEmp_id();
	}
	if(left != ""){
		margin = 220;
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>POWER ERP</title>

<!-- Script -->
<script src="/webjars/jquery/2.0.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/dist/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript">
$(function() {
	$('#contents').css('margin-left',margin)
});
</script> -->
<!-- Custom Script -->
<!-- <script src="/resources/common/js/csrf.js"></script> -->
<!-- <script src="/resources/common/js/common.js" type="text/javascript"></script> -->

<!-- Style -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/webjars/bootstrap/3.3.6/dist/css/bootstrap.min.css">

<!-- Custom Style -->
<link rel="stylesheet" href="/resources/common/css/common.css">
</head>
<body id="body_html" class="font-dotum">
	<!-- top -->

	<!-- logo start -->
	<div class="erp-global-nav-qm">
		<div class="qm-company-logo col-sm-2">
			<a href="/main" ><img src="/resources/common/images/SMERP.png" alt=""></a>
		</div>
		<div class="hello pull-right">
			<span class="delicious-spam"> <a id="a-in-spam"	href="./main.jsp?left=./mypage/view/mypage.jsp"><%=name%></a>님
				환영합니다. <form:form name="form" id="messageForm">
					<input type="hidden" name="emp_id" value="<%=emp_id%>">
					<c:set var="cnt" value="${mcnt }"></c:set>
					<c:choose>
						<c:when test="${cnt > 0 }">
							<span class="glyphicon glyphicon-exclamation-sign"></span>
							<button type="button" name="messagBtn"
								class="btn btn-default btn-sm"
								onclick="javascript:popup(this.form);">
								<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
							</button>
						</c:when>
						<c:otherwise>
							<button type="button" name="messagBtn"
								class="btn btn-default btn-sm"
								onclick="javascript:popup(this.form);">
								<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
							</button>
						</c:otherwise>
					</c:choose>

				</form:form> <form:form id="logoutForm" role="form">
					<input name="leaveRe" type="checkbox" value="leave"> 퇴근
					<button id="logoutBtn" class="btn btn-default">로그아웃</button>
				</form:form>
			</span>
		</div>
	</div>

	<!--logo end-->

	<!-- topMenuBar start-->

	<div id="Top-Menu" class="erp-global-nav">
		<ul>
			<li class=""><a href="/basic">기초관리</a>
			<li class=""><a href="/purchase">구매관리</a></li>
			<li class=""><a href="/sale">판매관리</a></li>
			<li class=""><a href="/odm">주문/배송관리</a></li>
			<li class=""><a href="/stock">재고관리</a></li>
			<li class=""><a href="/accounting">회계관리</a></li>
			<li class=""><a href="/hr">인사관리</a></li>
			<li class=""><a href="/groupware">그룹웨어</a></li>
			<li class=""><a href="/mypage">마이페이지</a></li>
		</ul>
	</div>

	<!-- topMenuBar end -->
	<div id="Left_Menu" class="erp-local-nav">
		<jsp:include page="${left }"></jsp:include>
	</div>

	<div id="contents" class="container">
		<jsp:include page="${contents }"></jsp:include>
	</div>
	
	<div id="maincontents" class="container">
		<jsp:include page="${maincontents }"></jsp:include>
	</div>

	<script>
		$(function() {
			var formObj = $("form[role='form']");

			$("#logoutBtn").on(
					"click",
					function() {
						formObj.attr("method", "POST");
						formObj.attr("action",
								"${pageContext.request.contextPath}/logout");
						formObj.submit();
					});
		})
		function popup(frm) {
			var url = "/message";
			var title = "Message";
			var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=520, height=450, top=0,left=20";
			window.open("", title, status); 
			frm.target = title; 
			frm.action = url; 
			frm.method = "get";
			frm.submit();
		}
	</script>
</body>
</html>