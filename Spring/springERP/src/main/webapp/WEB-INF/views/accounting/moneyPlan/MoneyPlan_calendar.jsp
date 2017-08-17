<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<link href='/resources/common/css/fullcalendar.css' rel='stylesheet' />
<link href='/resources/common/css/fullcalendar.print.css' rel='stylesheet' media='print' /> 
<script src="/resources/common/js/moment.min.js"></script>
<script src='/resources/common/js/jquery-ui.custom.min.js'></script> 
<script src="/resources/common/js/fullcalendar.js"></script>
<script src='/resources/accounting/js/MoneyPlan_Calendar.js'></script>
</head>
<body>

	<h2 class="page_title">자금계획일정표</h2>
	<div id='calendar'></div>

</body>
</html>