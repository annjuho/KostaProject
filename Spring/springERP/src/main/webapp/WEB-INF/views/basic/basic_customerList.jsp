<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
<!-- Custom CSS -->
<link href="/resources/basic/css/basic_customerList.css" rel="stylesheet">
<script src="/resources/basic/js/customerBasic.js" type="text/javascript"></script>
</head>
<body>
<h2 class="page_title">거래처관리</h2>

<!-- 거래처 등록 폼 -->
<div class="add xclose">
	<div class="title">
		<span class=""><strong>거래처등록</strong></span>
		<button type="button" class="close closeBtn">
			<span>&times;</span>
		</button>
	</div>
	<form:form class="form-horizontal" action="/basic/customer/insert" method="post">
		<div class="addform">
			<div class="form-group has-feedback">
				<label for="product_id" class="col-sm-2 control-label"><strong>거래처코드</strong></label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="ptext" name="customer_id">
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal" id="idCheck"><span class="fa fa-search"></span></button>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="product_name" class="col-sm-3 control-label"><strong>거래처명</strong></label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_name" name="customer_name"><span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="pgroup_name" class="col-sm-3 control-label">대표자명</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="repre_name" name="repre_name"><span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="in_customer" class="col-sm-3 control-label">전화번호</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="phone_number" name="phone_number">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="standard" class="col-sm-3 control-label">주소</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_address" name="customer_address">
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="in_customer" class="col-sm-3 control-label">통장사본</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="copy_bankbook" name="copy_bankbook">
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="in_price" class="col-sm-3 control-label">통장등록여부</label>
				<div class="col-sm-9">
					<label class="radio-inline"> 
						<input type="radio" name="bankbook_check" id="yes" value="yes">예
					</label> 
					<label class="radio-inline"> 
						<input type="radio" name="bankbook_check" id="no" value="no">아니요
					</label>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="out_price" class="col-sm-3 control-label">EMAIL</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_email" name="customer_email"> <span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="out_price" class="col-sm-3 control-label">FAX</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_fax" name="customer_fax"> <span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="out_price" class="col-sm-3 control-label">담당자</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="checkman" name="checkman"> <span></span>
				</div>
			</div>
			<button type="submit" class="btnn btn btn-default" id="saveBtn">등록</button>
		</div>
	</form:form>
</div><!-- 거래처 등록 폼 끝-->

<!-- 거래처 수정 폼 -->
<div class="update xclose">
	<div class="title">
		<span class=""><strong>거래처수정</strong></span>
		<button type="button" class="close closeBtn">
			<span>&times;</span>
		</button>
	</div>
			<form:form class="form-horizontal" action="/basic/customer/update" method="post">
		<div class="updateform">
			<div class="form-group has-feedback">
				<label for="product_id" class="col-sm-3 control-label"><strong>거래처코드</strong>
				</label>
				<div class="col-sm-9">
					<input type="text" class="form-control customer_id2" disabled="disabled" id="product_search">
					<input type="hidden" name="customer_id" class="customer_id2" id="customer_id2">
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="product_name" class="col-sm-3 control-label"><strong>거래처명</strong></label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_name2" name="customer_name"><span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="pgroup_name" class="col-sm-3 control-label">대표자명</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="repre_name2" name="repre_name"><span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="in_customer" class="col-sm-3 control-label">전화번호</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="phone_number2" name="phone_number">
					<span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="standard" class="col-sm-3 control-label">주소</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_address2" name="customer_address">
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="in_customer" class="col-sm-3 control-label">통장사본</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="copy_bankbook2" name="copy_bankbook">
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="in_price" class="col-sm-3 control-label">통장등록여부</label>
				<div class="col-sm-9">
					<label class="radio-inline"> 
						<input type="radio" name="bankbook_check" id="yes" value="yes">예
					</label> 
					<label class="radio-inline"> 
						<input type="radio" name="bankbook_check" id="no" value="no">아니요
					</label>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="out_price" class="col-sm-3 control-label">EMAIL</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_email2" name="customer_email"> <span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="out_price" class="col-sm-3 control-label">FAX</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="customer_fax2" name="customer_fax"> <span></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label for="out_price" class="col-sm-3 control-label">담당자</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="checkman2" name="checkman"> <span></span>
				</div>
			</div>
			<button type="submit" class="btnn btn btn-default" id="saveBtn">수정</button>
		</div>
	</form:form>
</div><!-- 거래처 수정 폼 끝-->

<table class="table table-bordered table-hover">
	<thead>
		<tr>
			<th><input type="checkbox" id="checkAll"></th>
			<th>거래처코드</th>
			<th>거래처명</th>
			<th>대표자명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>통장사본</th>
			<th>통장등록여부</th>
			<th>EMAIL</th>
			<th>FAX</th>
			<th>담당자</th>
		</tr>
	</thead>
	<c:forEach var="list" items="${list }">
		<tr>
			<td><input type="checkbox" class="upSelect check_id getCheckBox" name="id_box" value="${list.customer_id }"></td>
			<td>${list.customer_id}</td>
			<td>${list.customer_name }</td>
			<td>${list.repre_name }</td>
			<td>${list.phone_number }</td>
			<td>${list.customer_address }</td>
			<td>${list.copy_bankbook }</td>
			<td>${list.bankbook_check }</td>
			<td>${list.customer_email }</td>
			<td>${list.customer_fax }</td>
			<td>${list.checkman }</td>
		</tr>
	</c:forEach>
</table>
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
						<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</body>
<div class="buttongroup">
	<input type="button" id="newBtn" class="btn btn-default" value="등록">
	<input type="button" id="updateBtn" class="btn btn-default" value="수정">
	<input type="button" id="deleteBtn" class="btn btn-default" value="선택삭제">
</div>

<!-- location=no -->

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">중복확인(거래처코드)</h4>
      </div>
      <div class="modal-body">
			<div class="col-sm-10">
				<input type="text" class="form-control" name="product_id" id="search_product">
			</div>
			<div class="col-sm-2">
				<button type="button" class="btn btn-info btn-sm" id="search_id"><span class="fa fa-search"></span></button>
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
	
</html>