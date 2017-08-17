window.onload = function(){
	
	var draft_id = document.location.href.split("printPop")[1];
	
	$.ajax({
		url : "/groupware/sign/print"+draft_id,
		dataType : "json", 
		success : function(data){
			$("body").append("<div id='write_content'>"+data.draft_content+"</div>");
		}
	});
	
}

$(function(){
	$("#printGo").on("click", function(){
		window.print();
	})
})
