<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/stock/css/stock.css" rel="stylesheet">
<script src="/resources/stock/js/stock_search.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">
$(function(){
	$('#newBtn').click(function(){
		$('.add').css("display","block");
	})
	$('#updateBtn').click(function(){
		$('.update').css("display","block");
	})
	$('.closeBtn').click(function(){
		$('.xclose').css("display","none");
	})
})
$(function(){
	$('input').keyup(function(){
		if($(this).val() != null){
			$(this).next().addClass("glyphicon");
			$(this).next().addClass("glyphicon-ok");
			$(this).next().addClass("form-control-feedback");
		}if($(this).val() == ""){
			$(this).next().removeClass("glyphicon");
			$(this).next().removeClass("glyphicon-ok");
			$(this).next().removeClass("form-control-feedback");
		}
	})
})
$(function(){
	$(".productChecked").click(function() {
		$('#searchTable').empty();
		$("input[name=productRow]:checked").each(function() {
			var checks = $(this).val();
			$(".product_id2").attr("value",checks);
		});
	});
	$("#deleteBtn").on('click',function(){
 		$("input[name=productRow]:checked").each(function() {
			var checks = $(this).val();
			$(location).attr("href","deleteProduct.ba?checks="+checks);
		});
	});
	
});
$(function(){
	$('#search_product').keyup(function() {
		var searchKey = $('#search_product').val();
  		$.ajax({
			url : "productCodeJson.ba?searchKey="+searchKey,
			type : "post",
			dataType : "json",
			success : function(data) {
				var html = "<tr><th>품목코드</th><th>품목명</th></tr>";
				$('#searchTable').empty();
				$.each(data, function(index, list) {
					html += "<tr><td>" + list.product_id + "</td><td>" + list.product_name + "</td></tr>";
			});
				if(html == "<tr><th>품목코드</th><th>품목명</th></tr>"){
					html += "<tr><td colspan='2'> 해당코드는 사용가능합니다.</td></tr>";
					$('#useBtn').on('click',function(){
						var searchKey = $('#search_product').val();
						$('#product_id').val(searchKey);
						$('#search_product').val('');
						$('#myModal').modal('hide');
					});
				}; 
				$('#searchTable').append(html);
				},
			error : function(){
				alert("실패!");
			}
		});
	});
 	
});
</script>
</head>
<body>

	<h2 class="page_title">재고수불부</h2>

	<div class="item_div">
		<div class="title">
			<span class=""><strong>품목코드검색</strong></span>
			<button type="button" class="close i_closeBtn"><span>&times;</span></button>
		</div>
		<form class="form-horizontal" action="">
			<div class="form1">
				<div class="form-group has-feedback">				
					<label for="product_id" class="col-sm-2 control-label"><strong>품목코드</strong></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="product_id"><br>
						<button class="btn btn-default btn-sm" type="submit"><span class="fa fa-search"></span></button>
						<span></span>					
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="warehouse_div">
		<div class="title">
			<span class=""><strong>창고검색</strong></span>
			<button type="button" class="close w_closeBtn"><span>&times;</span></button>
		</div>
		<div class="form1">
				<div class="form-group has-feedback">				
					<label for="warehouse_id" class="col-sm-2 control-label"><strong>창고검색</strong></label>
					<div class="col-sm-10">
						<table class="table table-bordered table-hover">
							<tr class="tablecenter">
								<th><input type="checkbox" id="" name=""></th>
								<th>구분</th>
								<th>창고코드</th>
								<th>창고명</th>
							</tr>
							<tr>
								<td><input type="checkbox" id="" name=""></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
						<button class="btn btn-default btn-sm" type="submit"><span class="fa fa-search"></span></button>
						<span></span>					
					</div>
				</div>
		</div>
	</div>
<div class="search">
<form:form action="stockRP_searchList" method="post">
			<div class="searchform">
			<table class="table table-bordered table-hover new">
				<tr>
					<td>기준일자</td>
					<td><input type="text" class="stockRP_date" name="start_date">  -  <input type="text" class="stockRP_date" name="end_date"></td>
				</tr> 
				<!-- <tr>
					<td>거래처</td>
					<td><input type="text" id="warehouse_id" disabled="disabled">&nbsp;&nbsp;<button id="warehouse_search" class="btn btn-default btn-sm"><span class="fa fa-search"></span></button></td>
				</tr>
				<tr>
					<td>품목코드</td>
					<td><input type="text" id="product_id" disabled="disabled">&nbsp;&nbsp;<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"><span class="fa fa-search"></span></button></td>
				</tr> -->
			</table>
			<div class="localcenter">
				<button type="submit" class="btn-default btn-sm localcenter"><span class="fa fa-search"></span></button>
			</div>
			</div>
</form:form>
</div>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
      
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">중복확인(품목코드)</h4>
      </div>
      <div class="modal-body">
			<div class="col-sm-10">
				<input type="text" class="form-control" name="product_id" id="search_product">
			</div>
			<div class="col-sm-2">
				<button type="button" class="btn btn-default btn-sm" id="search_id"><span class="fa fa-search"></span></button>
			</div>
			<br><br><br>
  				<table id="searchTable" class="table table-bordered">
				</table>
				<div id="useBtnArea">
					<input type="button" id="useBtn" class="btn btn-default center" value="사용">
				</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>