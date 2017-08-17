$(function(){
	var lists = [];
	function listAjax() {
		$.ajax({
			url : "/stock/rp/calendar",
			type : "post",
			dataType : "JSON",
			async : false,
			success : function(data) {
				lists = [];
				$.each(data, function(index, p) {
					var json = {};
					
					if (p.inout_type == "in") {
						json.id = p.inout_id;
						json.title = p.product_name + " 입고";
						json.start = p.inout_date;
						json.end = p.inout_date;
						json.product_name = p.product_name;
						json.inout_amount = p.inout_amount;
						json.warehouse_name = p.warehouse_name;
						json.stock_amount = p.stock_amount;
						json.e_name = p.e_name;

						lists.push(json);
					} else if (p.inout_type == "out") {
						json.id = p.inout_id;
						json.title = p.product_name + " 출고";
						json.start = p.inout_date;
						json.end = p.inout_date;
						json.product_name = p.product_name;
						json.inout_amount = p.inout_amount;
						json.warehouse_name = p.warehouse_name;
						json.stock_amount = p.stock_amount;
						json.e_name = p.e_name;

						lists.push(json);
					}
				});
			}
		});

	}
	listAjax();
	$('#calendar').fullCalendar({
			header : {
			left : 'today',
			center : 'prev title next',
			right : ''
		//right: 'month,agendaWeek,agendaDay'
		},
		events : lists,
		droppable : true, // this allows things to be dropped onto the calendar
		drop : function(start) {

		},
		editable: true,
		eventDrop : function(event, delta, revertFunc) {

			var date = event.start.format('YYYY-MM-DD');
			if (confirm("선택한 날짜로 변경하시겠습니까?")) {
				$.ajax({
					url : '/stock/rp/update',
					type : 'post',
					async : false,
					data : {
						inout_id : event.id,
						inout_date : date
					},
					success : function(data) {
						if (data == 0) {
							alert('실패');
						}

						listAjax();

						$('#calendar').fullCalendar('removeEvents');
						$('#calendar').fullCalendar('addEventSource', lists);
						$('#calendar').fullCalendar('rerenderEvents');
					}
				});
			}
		},
		dayClick : function(date) {
			$('#addModal').modal('show');
			
			$("#addBtn").on('click', function() {
				
				var product_id = $('#product_id').val();
				var inout_amount = $('#inout_amount').val();
				var customer_id = $('#customer_id').val();
				var type = $('#type').val();
				var day = date.format("YYYY-MM-DD");
				
				$.ajax({
					url : '/stock/rp/insert',
					type : 'post',
					async : false,
					data : {
						product_id : product_id,
						inout_amount : inout_amount,
						inout_type : type,
						inout_date : day,
						customer_id : customer_id
					},
					success : function(data) {

						if (data == 0) {
							alert('실패');
						}
						$('#addModal').modal('hide');

						listAjax();

						$('#calendar').fullCalendar('removeEvents');
						$('#calendar').fullCalendar('addEventSource', lists);
						$('#calendar').fullCalendar('rerenderEvents');
					}
				});
				$('#addBtn').unbind('click');
			});
		},
		eventLimit : true, // allow "more" link when too many events
		eventClick : function(calEvent, jsEvent, view) {
			
			$(".modal-title").text(calEvent.title);
			$.each(lists, function(index, s) {
				if (calEvent.id == s.id) {

					$('#product_name').text(s.product_name);
					$('#amount').text(s.inout_amount);
					$('#warehouse_name').text(s.warehouse_name);
					$('#stock_amount').text(s.stock_amount);
					$('#e_name').text(s.e_name);
				}
			});
			$('#showModal').modal('show');
		}
	});

});