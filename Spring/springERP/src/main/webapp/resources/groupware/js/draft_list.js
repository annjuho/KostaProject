window.onload = function(){
	$("#myApReList").hide();
	
	$('#myDraftTab a').click(function (e) {
		e.preventDefault()
		$(this).tab('show');
		if($(this).hasClass("myWriteList")){
			$("#myWriteList").show();
			$("#myApReList").hide();
		} else if($(this).hasClass("myApReList")){
			$("#myWriteList").hide();
			$("#myApReList").show();
		}
	})
}
