$(function(){
	
	// 브라우저에 파읠 드래그&드래그오버시 새창에서 열리는 기본이벤트 제거 - 보람
	$(".fileDrop").on("dragenter dragover", function(e){
		e.preventDefault();
	});
	
	// 체크박스 이벤트
	$(".item_box").mouseover(function(){
		$(this).find(".item").addClass("mouseover");
	}).mouseout(function(){
		$(this).find(".item").removeClass("mouseover");
	}).on("click",function(e){
		e.preventDefault();

	    var $thischeck = $(this).find("#input_check");
	    var $thisimg = $(this).find("label .item");
	    
	    if($thischeck.is(":checked")){
	    	$thischeck.prop("checked", false);
	    	$thisimg.removeClass("oncheck");
	    } else {
	    	$thischeck.prop("checked", true);
	    	$thisimg.addClass("oncheck");
	    }
	});
	
	// 썸네일 백그라운드로 깔기
	var itemboxes = document.getElementsByClassName("item_box");
	for(var i=0; i<itemboxes.length;i++){
		var filetitle = $(itemboxes[i]).find(".item_title").attr("value").split(".")[0];
		
//		$(itemboxes[i]).find(".imagefile").css("background", "url('/resources/mypage/upload" + $("#filename"+i).val() + "') no-repeat center center");
		$(itemboxes[i]).find(".imagefile").css("background", "url('\\\\resources\\\\mypage\\\\upload" + $("#filename"+i).val() + "') no-repeat center center");
	}
	
	
	$(".fileDrop").on("drop", function(e){
		e.preventDefault();
		//alert("aaa");
		
		var files = e.originalEvent.dataTransfer.files;
		
		for(var i=0; i<files.length; i++){
			var file = files[i];
			var formData = new FormData();
			formData.append("file", file);
			
			$.ajax({
				url:'/mypage/my_file/uploadAjax',
				data:formData,
				dataType:'text',
				processData:false,
				contentType:false,
				type:'POST',
				success:function(data){
				//	alert("성공쿠!!");
					location.href="/mypage/my_file";
				}
			});
		}
	});
})


// 이미지 파일인지 체크
function checkImageType(fileName){
	var pattern = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}

// 원본파일 이름
function getOriginalName(fileName){
	if(checkImageType(fileName)){
		return;
	}
	
	var idx = fileName.indexOf("_") + 1;
	return fileName.substr(idx);
}


// 이미지파일 원본 찾기
function getImageLink(fileName){
	if(!checkImageType(fileName)){
		return;
	}
	var front = fileName.substr(0, 12);
	var end = fileName.substr(14);
	
	return front + end;
}