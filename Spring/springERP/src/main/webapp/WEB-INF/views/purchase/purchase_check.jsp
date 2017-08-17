<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	out.clear();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

 <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<!-- Custom CSS -->
    <link rel="stylesheet" href="/resources/purchase/css/purchase.css">
    <script type="text/javascript" src="/resources/purchase/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/purchase/js/purchase2.js"></script>
</head>
<body>
<h2>구매 조회</h2>
	<table class="table table-bordered table-hover new">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkAll"></th>
				<th>구매번호</th>
				<th>거래처명</th>
				<th>품목명</th>
				<th>구매금액</th>
				<th>수량</th>
				<th>구매일자</th>
				<th>입고창고</th>
				<th>지급방법</th>
			</tr>			
		</thead>
		<c:forEach var="list" items="${list }">
			<tr>
				<td><input type="checkbox" class="upSelect check_id" name="id_box" value="${list.buy_id }"></td>
				<td>${list.buy_id}</td>
				<td>${list.customer_name }</td>
				<td>${list.product_name }</td>
				<td>${list.buy_price }</td>
				<td>${list.buy_amount }</td>
				<td>${list.buy_date }</td>
				<td>${list.warehouse_name }</td>
				<td>${list.pay_type }</td>		
			</tr>
		</c:forEach>
	</table>
	<div class="buttongroup">
		<input type="button" id="newBtn" class="btn btn-default" value="등록">
		<button type="button" id="updateBtn" class="btn btn-default" data-toggle="modal" data-target="#update_modal">수정</button>
		<input type="button" id="deleteBtn" class="btn btn-default" value="삭제">
		<input type="button" id="excelBtn" class="btn btn-default" value="Excel다운">
	</div>
		<form:form action="/purchase/excelUp?${_csrf.parameterName}=${_csrf.token }" method="post" enctype="multipart/form-data" id="excelForm">
			<input type="file" id="excelFile" name="excelFile" class="btn btn-default">
			<input type="submit" value="Excel업로드" class="btn btn-default">
		</form:form>
	
	<!-- 페이징 -->
	<div class="box-footer">

		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a
						href="purchase_check${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="purchase_check${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="purchase_check${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
<!-- 수정 -->
<div id="update_modal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">구매 내역 수정</h4>
      </div>
      <div class="modal-body">
     	<form:form class="form-horizontal" method="post" action="/purchase/purchase_update">
			<div class="col-sm-12">
				수량   <input type="text" class="form-control" name="buy_amount">
			</div>
			<div class="col-sm-12">
				가격   <input type="text" class="form-control" name="buy_price">
			</div>
			<div class="col-sm-12">
				지급방법   <select  name="pay_type" class="form-control">
							<option value="cash">현금</option>
							<option value="bill">어음</option>
						</select>
			</div>
			<div class="col-sm-12">
				<input type="hidden" id="buy_id_update" name="buy_id">
			</div>
			<br><br><br>
			<div id="useBtnArea">
				<input type="submit" class="btn btn-default center" value="수정">
			</div>
		</form:form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>