<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>

<!-- full Calendar js,css경로 -->
<link href='/resources/common/css/fullcalendar.css' rel='stylesheet' />
<link href='/resources/common/css/fullcalendar.print.css' rel='stylesheet' media='print' /> 
<!-- <script src='/resources/common/js/jquery.min.js'></script>  -->
<script src="/resources/common/js/moment.min.js"></script>
<script src='/resources/common/js/jquery-ui.custom.min.js'></script> 
<script src="/resources/common/js/fullcalendar.js"></script>


<!-- custom js,css경로 -->
<link href='/resources/stock/css/stock_search.css' rel='stylesheet'>
<script src='/resources/stock/js/stock_search_calendar.js'></script>
<style type="text/css">
.fc-unthemed .fc-today {
	background: #F5F5F5 none repeat scroll 0 0;
}
</style>
</head>
<body>

<!-- 			<p>
				<input type='checkbox' id='drop-remove' />
				<label for='drop-remove'>remove after drop</label>
			</p> -->

		<div id='calendar'></div>
		
<div id="addModal" class="modal fade" role="dialog">
  <div class="modal-dialog">  
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
  		<div class="form-group">
    		<label for="product_id" class="col-sm-2 control-label">product</label>
				<div class="col-sm-10">
					<select class="form-control" id="product_id" name="product_id">
						<c:forEach var="p" items="${list}">
							<option value="${p.product_id }">${p.product_name}</option>
						</c:forEach>
					</select>
				</div>
  		</div>
 		<div class="form-group">
   			<label for="inout_amount" class="col-sm-2 control-label">amount</label>
   			<div class="col-sm-10">
    			<input type="number" class="form-control" id="inout_amount">
    		</div>
  		</div>
  		<div class="form-group">
  			<label for="type" class="col-sm-2 control-label">type</label>
  				<div class="col-sm-10">
  				<select class="form-control" id="type" name="type">
  					<option value="in">in</option>
  					<option value="out">out</option>
  				</select>
  				</div>
  		</div>
  		<div class="form-group">
    		<label for="customer_id" class="col-sm-2 control-label">customer</label>
					<div class="col-sm-10">
						<select class="form-control" id="customer_id" name="customer_id">
						<c:forEach var="c" items="${clist}">
							<option value="${c.customer_id }">${c.customer_name}</option>
						</c:forEach>
						</select>
					</div>
  		</div>
  		<hr>
  		<div class="center">
  			<button type="button" class="btn btn-default" id="addBtn">ADD</button>
		</div>
      </div>
    </div>

  </div>
</div>

<div id="showModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
      
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
<form class="form-horizontal">
  <div class="form-group">
    <label for="product_name" class="col-sm-5 control-label">Product Name : </label>
    <div class="col-sm-7">
		<p id="product_name"></p>
    </div>
  </div>
  <div class="form-group">
    <label for="warehouse_name" class="col-sm-5 control-label">Warehouse Name : </label>
    <div class="col-sm-7">
		<p id="warehouse_name"></p>
    </div>
  </div>
  <div class="form-group">
    <label for="stock_amount" class="col-sm-5 control-label">Stock Amount : </label>
    <div class="col-sm-7">
		<p id="stock_amount"></p>
    </div>
  </div>
     <div class="form-group">
    <label for="amount" class="col-sm-5 control-label">In/Out Amount : </label>
    <div class="col-sm-7">
		<p id="amount"></p>
    </div>
    </div>
  <div class="form-group">
    <label for="e_name" class="col-sm-5 control-label">Employee Name : </label>
    <div class="col-sm-7">
		<p id="e_name"></p>
    </div>
  </div>
</form>
      </div>
    </div>

  </div>
</div>

</body>
</html>
