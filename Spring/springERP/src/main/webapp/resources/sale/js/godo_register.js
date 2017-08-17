$(function(){
	 //<![CDATA[
    alert("<c:out value='${sell_id}'/>");    
    //]]>
	if("<c:out value='${sell_id}'"!=null){
		$.ajax({
			url : "http://localhost:8000/godo_register",
			type : "post",
			data : {
				sell_id : "<c:out value='${sell_id}'/>"
			},
			success : function(){
				alert("성공");
			},
			error : function(){
				alert("실패");
			}
			
		})
	}
});