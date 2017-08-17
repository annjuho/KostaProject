$(function(){
	
	 $('.schBoard').on('click', function(e) {
	      e.preventDefault();
	      $('#contents').empty();	
	      $('#contents').load('/groupware/dept_board/'+$(this).attr('href'));
	   });

	 $('.projBoard').on('click', function(e) {
		 e.preventDefault();
		 $('#contents').empty();	
		 $('#contents').load('/groupware/project_board/'+$(this).attr('href'));
	 });

	   $('#write').click(function(e) {
	      e.preventDefault();
	      
	      $('#contents').empty();
	      $('#contents').load('/groupware/dept_board/'+$(this).attr('href'));
	   });
	   
	var lists = [];
	function listAjax() {
		$.ajax({
			url : "/groupware/dept_board/getCalendar",
			type : "post",
			dataType : "JSON",
			async : false,
			success : function(data) {
				lists = [];
				$.each(data, function(index, list) {
					var json = {};
					
					json.id = list.dept_schedule_id;
					json.title = list.schedule_name;
					json.content = list.schedule_content;
					json.start = list.start_schedule_date;
					json.end = list.end_schedule_date;
				
					lists.push(json);
				});
			}
		});

	}
	listAjax();
	$('#calendar').fullCalendar({
			height : 520,
			header : {
			left : 'today',
			center : 'prev title next',
			right : ''
		},
		events : lists,
		droppable : false,
		editable: false,
		eventLimit : true,
		eventClick : function(calEvent, jsEvent, view) {
			
			$(".modal-title").text(calEvent.title);
			$.each(lists, function(index, s) {
				if (calEvent.id == s.id) {
					
					var str="";

					var keyword   = s.content;
					var arrayList = keyword.split("<p>");
					
					for(var i=1 ; i < arrayList.length ; i++){
						str +=arrayList[i];
					}

					arrayList = str.split("</p>");
					str="";

					for(var i=0 ; i < arrayList.length ; i++){
						str+=arrayList[i];
					}
					
					$('#sch_content').text(str);
					$('#sch_start_date').text(s.start);
					$('#sch_end_date').text(s.end);
				}
			});
			$('#showModal').modal('show');
		}
	});

});