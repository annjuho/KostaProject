$(function(){
	var lists = [];
		$.ajax({
			url : "/accounting/moneyCal/getAll",
			type : "post",
			dataType : "JSON",
			async : false,
			success : function(data) {
				lists = [];
				$.each(data, function(index, p) {
					var json = {};
					json.start= p.start_date;
					json.end = p.repeat_unit;					
					json.title = p.calPrint;

					lists.push(json);
				});
			}
		});
	
	$('#calendar').fullCalendar({
			header : {
			left : 'today',
			center : 'prev title next',
			right : ''
		},
		events : lists,
//		droppable : true // this allows things to be dropped onto the calendar
	});
});