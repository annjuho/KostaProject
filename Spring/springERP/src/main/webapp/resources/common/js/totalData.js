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
	}
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
                text: ''
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: false
                },
                enableMouseTracking: false
            }
        },
        series: list
    });
});
$(function () {
	var tlists = [];
	var plists = [];
	var customer_id;
	function productAjax(customer_name){
		$.ajax({
			url : "/sale/product_chart?customer_name="+customer_name,
			type : "post",
			dataType : "JSON",
			async : false,
			success : function(data) {
				plists = [];

				var total  = 0;
				$.each(data, function(index,p){
					total += p.total_price;
				});

				$.each(data, function(index, p){
					var json = [];
					var y = parseFloat((p.total_price / total * 100).toFixed(2));
					
					json.name = p.product_name;
					json.y = y;
					json.push(p.product_name);
					json.push(y);
					plists.push(json);
				});
			}
		});
	}
		
	$.ajax({
		url : "/sale/customer_chart",
		type : "post",
		dataType : "JSON",
		async : false,
		success : function(data) {
			console.log(data);
			lists = [];
			tlists = [];
			var total = 0;
			$.each(data, function(index, c) {
				total += c.total;
			});

			$.each(data, function(index, c) {
				var json = {};
				var pjson = {};
				var y = parseFloat((c.total / total * 100).toFixed(2));

				pjson.name = c.customer_name;
				pjson.id = c.customer_name;
				
				productAjax(c.customer_name);
				pjson.data = plists;
				
				json.name = c.customer_name;
				json.y = y;
				json.drilldown = c.customer_name;

				lists.push(json);
				tlists.push(pjson);
			});
		}
	});
    $('#container2').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: '거래처별<br>현황',
            align: 'center',
            verticalAlign: 'middle',
            y: 40
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                dataLabels: {
                    enabled: false,
                    distance: -50,
                    style: {
                        fontWeight: 'bold',
                        color: 'white',
                        textShadow: '0px 1px 2px black'
                    }
                },
                startAngle: -90,
                endAngle: 90,
                center: ['50%', '75%']
            }
        },
        series: [{
            type: 'pie',
            name: '통계',
            innerSize: '50%',
            data: lists
        }]
    });
});