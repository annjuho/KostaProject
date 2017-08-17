<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>POWER ERP</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Custom CSS -->
<!-- <script src="./resources/common/js/common.js"></script>
 -->
 <script src="/resources/common/js/csrf.js"></script>
 </head>
<body>
		<div class="erp-local-nav-title">그룹웨어</div>
		<div class="erp-local-nav">
			<ul class="local">
				<li><a href="/groupware/notice/notice_list">공지사항</a></li>
				
				<li><a data-toggle="collapse" href="/groupware/dept_board/dept_board_list #dept_board">부서게시판</a>
					<ul id="dept_board" class="collapse">
						<li><a href="/groupware/dept_board/dept_board_list">부서 게시판</a></li>
						<li><a href="/groupware/dept_board/share_folder">공유 폴더</a></li>
						<li><a id="gw_cal" href="/groupware/dept_board/dept_calendar">부서 일정</a></li> 
					</ul>
				</li>
				
				<li><a data-toggle="collapse" href="/groupware/sign/all_draft_list #dept_sign">전자결재</a>
					<ul id="dept_sign" class="collapse">
						<li><a href="/groupware/sign/format_select_list">기안서 작성</a></li>
						<li><a href="/groupware/sign/my_draft_list">내 결재 관리</a></li>
						<li><a href="/groupware/sign/all_draft_list">기안서 통합 관리</a></li>
						<li><a href="/groupware/sign/draft_format_list">공통 양식 관리</a></li>
					</ul>
				</li>
				
				<li><a data-toggle="collapse" href="/groupware/project_board/pb_myproject_list #dept_project">프로젝트게시판</a>
	               <ul id="dept_project" class="collapse">
	                  <li><a href="/groupware/project_board/all_project_list">전체 프로젝트</a></li>
	                  <li><a href="/groupware/project_board/pb_myproject_list">내 프로젝트</a></li>
	               </ul>
          		</li>
			</ul>
		</div>
</body>
</html>