var express = require('express')
	,http = require('http')
	,request = require("request")
	,app = express()
	,server = http.createServer(app)
	,url = require('url');

var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
})); 




app.use(function(req, res, next) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, x-csrf-token, Accept");
	next();
});


var key = "SSUyMSUyNiVDMyUyNyVFNzclODclMkMlRkMlQ0ElM0QlQ0YlMDclMTZJNHolOUUlODYlRjQlQURKJUEyJTJCJTFCNCUwOVQlRTclMDclRUQlQjclOUUlRDg2";
var partner_key = "aCUwMmslRjAlODclOUJWdA==";
	app.get('/', function(req, res, next) {
	  // Handle the get for this route
	});
	app.post('/', function(req, res, next) {
		 // Handle the post for this route
	});

	app.post('/godo_register', function(req, res, next){
		var sell_id = req.param('sell_id');
		//var data_url = "http://67.194.225.187:8080/apixml/register?sell_id="+sell_id;
		var data_url = "http://67.194.225.187:8080/API/register?sell_id="+sell_id;
		//var data_url = "http://kostaseo.iptime.org:8000/register/xml?sell_id="+sell_id;
		//var data_url = url.parse("http://kostaseo.iptime.org:8000/sale/xmltest?sell_id="+sell_id);
		//var data_url = url.parse("http://67.194.225.187:8080/apixml/register?sell_id="+sell_id);
		//var data_url = url.format("kostaseo.iptime.org:8081/sale/xmltest?sell_id="+sell_id);
		//var data_url = url.format("http://67.194.225.187:8080/apixml/register?sell_id="+sell_id);
		
		request({
		    url: 'https://openhub.godo.co.kr/enamoo/goods/Goods_Insert.php?key='+key+"&partner_key="+partner_key+"&data_url="+data_url, //URL to hit
		}, function(error, response, body){
		    if(error) {
		        console.log(error);
		    } else {
		        console.log(body);
//		        res.set('Content-Type', 'text/xml');
//		    	res.send(xml(body));
//		        res.setHeader('Content-Type', 'text/xml');
		        res.send(body);
		        //res.end();
		    	
		}
		});
		
	});
	app.get('/orderTest',function(req, res, next){
		request({
			url : "https://openhub.godo.co.kr/enamoo/order/Order_Status_Check.php?key="+key+"&partner_key="+partner_key+"&ordno=1466119527147"
		}, function(error, response, body){
			if(error) {
		        console.log(error);
		    } else {
		        //console.log(body);
//		    	res.set('Content-Type', 'text/xml');
//		    	res.send(xml(body));
		    	console.log(body);
		}
		});
	})
	app.post('/orderCollect', function(req, res, next) {
			var step = req.param('step');
			var step2 = req.param('step2')
			
			var resBody= null;
			
			request({
			    url: 'https://openhub.godo.co.kr/enamoo/order/Order_Search.php?key='+key+"&partner_key="
			    					+partner_key+"&step="+step+"&step2="+step2, 
			}, function(error, response, body){
			    if(error) {
			        console.log(error);
			    } else {
			    	//console.log(body);
			    	res.send(body);
			        console.log("주문 수집 성공");
			}
			});
		});
		app.post("/orderStatus", function(req, res, body){
			var ordno = req.param("ordno");
			var step = req.param("step");
			var step2 = req.param("step2");
			var dvcode = req.param("dvcode");
			var status;
			if(dvcode != null){
				step == 3;
				step2 == 0;
				status = "&step="+step+"&step2="+step2+"&dvcode="+dvcode;
			}
			if(step == '0' && step2 == '0'){
				step = 1;
				step2 = 0;
				status = "&step="+step+"&step2="+step2;
			}else if(step == '1' && step2 == '0'){
				step = 2;
				step2 = 0;
				status = "&step="+step+"&step2="+step2;
			}
			console.log("주문번호 : "+ordno+"변경 상태 "+step+" and "+step2);
			//res.send("상태변경 node 들어오기 성공");
			request({
				
				//url : "https://openhub.godo.co.kr/enamoo/order/Order_Status.php?key="+key+"&partner_key="+partner_key+"&ordno="+ordno+"&step="+step+"&step2="+step2,
				url : "https://openhub.godo.co.kr/enamoo/order/Order_Status.php?key="+key+"&partner_key="+partner_key+"&ordno="+ordno+status,
				
			}, function(error, response, body){
			    if(error) {
			        console.log(error);
			    } else {
			        //console.log(body);
//			    	res.set('Content-Type', 'text/xml');
//			    	res.send(xml(body));
			    	res.send(body);
			    	console.log(body);
			        console.log("상태 변경 성공");
			    }
			});
/*			request({
				url : "https://localhost:8081/odm/"
			})*/
		});

server.listen(8000, function(){
	console.log('listening'+server.address().port);
});

//function scrappingResult(){
//	this.scrappedObject = [];
//}
//function scrappedObject(path, name, content){
//	this.path = path;
//	this.name = name;
//	this.content = content;
//	//this.subObject = [];
//}