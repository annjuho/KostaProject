<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
$(function(){
	$.ajax({
	    url : "http://localhost:8000/",
	    //cache : false,
	    type : "post",
	    dataType : 'xml',
	    data : {
	    	step : 1,
	    	step2 : 0
	    },
	    success : function(data) {
	    	console.log(data);
	        $(data).find('order_data').each(function () {
	          var name = $(this).find('ordno').text(); 
	          $('#a').append(name);
	       });     
	    }, 
	    error : function(){
	    	alert("실패");
	    }
	 
	 });  
})
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="a"></div>
</body>
</html>