$(function(){
	  /**********탭에서 풀캘린더 안먹을때**************/
	   $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	        $('#allProCalendar').fullCalendar('render');
	        $('#deptCalendar').fullCalendar('render');
	    });
	   
	    $('#myTab a:first').tab('show');
	   
	   /************************/
	
	$('.noticeTitle').on('click', function(e) {
		e.preventDefault();
		$('#maincontents').empty();
		$('#contents').empty();
		$('#contents').load('/groupware/notice/' + $(this).attr('href'));
		$('#Left_Menu').empty();
		$('#Left_Menu').load('/groupware');
	});

	$('.deptTitle').on('click', function(e) {
		e.preventDefault();
		$('#maincontents').empty();
		$('#contents').empty();
		$('#contents').load('/groupware/dept_board/' + $(this).attr('href'));
		$('#Left_Menu').empty();
		$('#Left_Menu').load('/groupware');
	});
	
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
	   
	 
/*	전체 프로젝트 달력 */
	
	var allProLists = [];
	
	function allProListAjax() {
		
		$.ajax({
			url : "/groupware/project_board/getAllPro",
			type : "post",
			dataType : "JSON",
			async : false,
			success : function(data) {
				allProLists = [];
				$.each(data, function(index, list) {
					var json = {};
					
					json.id = list.proj_id;
					json.title = list.proj_name;
					json.content = list.proj_content;
					json.period = list.proj_period;
					json.start = list.proj_start_date;
					json.end = list.proj_end_date;
				
					allProLists.push(json);
				});
			}
		});

	}
	
	allProListAjax();
	$('#allProCalendar').fullCalendar({
			height : 450,
			header : {
			left : 'today',
			center : 'prev title next',
			right : ''
		},
		events : allProLists,
		droppable : false,
		editable: false,
		eventLimit : true,
		
		eventClick : function(calEvent, jsEvent, view) {
			$(".modal-title").text(calEvent.title);
			$.each(allProLists, function(index, s) {
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
					
					$('#proj_content').text(str);
					$('#proj_period').text(s.period);
					$('#proj_start_date').text(s.start);
					$('#proj_end_date').text(s.end);
				}
			});
			$('#allProModal').modal('show');
		}
		
	});
	
		/*부서 일정 달력 */
	
	var deptCalLists = [];
	
	function deptCalListAjax() {
		
		$.ajax({
			url : "/groupware/dept_board/getCalendar",
			type : "post",
			dataType : "JSON",
			async : false,
			success : function(data) {
				deptCalLists = [];
				$.each(data, function(index, list) {
					var json = {};
					
					json.id = list.dept_schedule_id;
					json.title = list.schedule_name;
					json.content = list.schedule_content;
					json.start = list.start_schedule_date;
					json.end = list.end_schedule_date;
					
					deptCalLists.push(json);
				});
			}
		});
		
	}
	
	deptCalListAjax();
	$('#deptCalendar').fullCalendar({
		height : 450,
		header : {
			left : 'today',
			center : 'prev title next',
			right : ''
		},
		events : deptCalLists,
		droppable : false,
		editable: false,
		eventLimit : true,
		
		eventClick : function(calEvent, jsEvent, view) {
			$(".modal-title").text(calEvent.title);
			$.each(deptCalLists, function(index, s) {
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
					
					$('#dept_cal_content').text(str);
					$('#dept_cal_start_date').text(s.start);
					$('#dept_cal_end_date').text(s.end);
				}
			});
			$('#deptCalModal').modal('show');
		}
		
	});
});