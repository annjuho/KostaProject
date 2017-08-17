<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
 <script type="text/javascript" src="/resources/purchase/js/jquery.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script type="text/javascript">
$(function () {
	var list;
	$.ajax({
		url : '/purchase/totalDataChart',
		dataType : 'json',
		async : false,
		success : success
	})
	function success(data){
		list = data;
		console.log(data);
	}
	console.log(list);
    $('#container').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: '총매출 월별 현황'
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: '총매출액'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: list
    });
});
</script>
<title>Insert title here</title>
</head>
<body>
<div id="container" style="width: 300px; height: 300px; margin: 0 auto"></div></body>
</html>