<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/odm/js/odm.js"></script>
<link href="/resources/odm/css/odm.css" rel="stylesheet">
</head>
<body>

	<h2 class="page_title">주문수집</h2>
<div id="container">
	<div class="success xclose">
		<div class="title">
			<button type="button" class="close closeBtn">
				<span>&times;</span>
			</button>
		</div>
		<br> <br>
		<div class="localcenter">
			<strong>수집이 완료되었습니다.</strong>
			<button type="button" id="successBtn">확인</button>
		</div>
	</div>
	<div class="failed xclose">
		<div class="title">
			<button type="button" class="close closeBtn">
				<span>&times;</span>
			</button>
		</div>
		<div class="localcenter">
			<strong>에러!</strong>
		</div>
	</div>
	<div class="search">
		<div class="searchform">
			<table class="table table-bordered table-hover new">
				<tr>
					<th><input type="checkbox"></th>
					<th>쇼핑몰이름</th>
				</tr>
				<tr class="localcenter">
					<td><input type="checkbox" value="godo" name="shopList"></td>
					<td>godo</td>
				</tr>
			</table>
			<div class="localcenter">
				<!-- <button type="button" class="btn btn-default" data-toggle="modal" data-target="#registerModal" id="registerBtn">등록</button> -->
				<button type="button" class="btn btn-default" data-toggle="modal" data-target="#collectModal" id="collectBtn">수집</button>
			</div>
		</div>
	</div>
</div>
<!-- 	<!-- collectModal
	<div id="collectModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">옥션(id:mj92)</h4>
				</div>
				<div class="modal-body">
					<div class="progress">
						<div
							class="progress-bar progress-bar-success progress-bar-striped"
							role="progressbar" aria-valuenow="80" aria-valuemin="0"
							aria-valuemax="100" style="width: 80%">신규주문</div>
					</div>
					<div class="progress">
						<div
							class="progress-bar progress-bar-danger progress-bar-striped"
							role="progressbar" aria-valuenow="73" aria-valuemin="0"
							aria-valuemax="100" style="width: 73%">취소/반품 요청</div>
					</div>
					<div class="progress">
						<div
							class="progress-bar progress-bar-warning progress-bar-striped"
							role="progressbar" aria-valuenow="33" aria-valuemin="0"
							aria-valuemax="100" style="width: 33%">구매확정</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->


	<!-- registerModal 
	<div id="registerModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">쇼핑몰 로그인 정보</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-4">쇼핑몰</div>
						<div class="col-sm-8">
							<select>
								<option>옥션</option>
								<option>g마켓</option>
							</select>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-4">로그인 ID</div>
						<div class="col-sm-8">
							<input type="text">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-4">로그인 비밀번호</div>
						<div class="col-sm-8">
							<input type="password">
						</div>
					</div>
					<br> <br>
					<div class="row localcenter">
						<button type="button" class="btn btn-default">등록</button>
						<button type="button" class="btn btn-default">목록</button>
					</div>
				</div>
			</div>

		</div>
	</div>-->
</body>
</html>