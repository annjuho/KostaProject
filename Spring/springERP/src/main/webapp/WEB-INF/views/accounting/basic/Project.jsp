<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />

<!-- CSS -->
<link href="/resources/accounting/css/account.css" rel="stylesheet">
<!-- JS -->
<script src="/resources/accounting/js/project.js" type="text/javascript"></script>
<script src="/resources/common/js/csrf.js" type="text/javascript"></script>
</head>
<body>

   <h2 class="page_title">프로젝트등록</h2>

   <!-- 프로젝트리스트 -->
   <div class="container-fluid">
      <div class="table-responsive">
         <table class="table table-bordered table-hover table-striped"
            id="Card">
            <thead id="cardList">
               <tr class="mainTable">
                  <th><input type="checkbox" id="checkAll"></th>
                  <th>프로젝트번호</th>
                  <th>프로젝트명</th>
                  <th>금액</th>
                  <th>계좌번호</th>
                  <th>비고</th>
               </tr>
            </thead>
            <tbody id="cardInfos">
               <c:forEach var="projects" items="${listModel}">
                  <tr class="mainTable">
                     <td><input type="checkbox" class="upSelect check_id" name="number_box" value="${projects.proj_id}"></td>
                     <td>${projects.proj_id}</td>
                     <td>${projects.proj_name}</td>
                     <td>${projects.sums}</td>
                     <td>${projects.account_number}</td>
                     <td>${projects.remarks}</td>
                  </tr>
               </c:forEach>
            </tbody>

         </table>
      </div>
      <div class="buttongroup" align="right">
         <input type="button" id="updateBtn" class="btn btn-default"   value="예산설정"  data-toggle="modal" data-target="#exampleModal3">
      </div>
   </div>

   <!-- 프로젝트 예산설정 -->
   <div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal"
                     aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                  </button>
                  <h4 class="modal-title" id="exampleModalLabel">
                     <strong>프로젝트 예산설정</strong>
                  </h4>
               </div>

               <form:form action="/accounting/project/update" method="post" >
                  <div class="modal-body">
                     <div class="form-group">
                        <div class="form-group">
                           <label for="updateProj_id" class="control-label">프로젝트 번호</label>
                           <input type="hidden" id="updateProj_id" name="proj_id">
                           <input class="form-control" type="text" id="updateProj_id" name="proj_id">
                        </div>
                        
                        <div class="form-group">
                           <label for="message-text" class="control-label">프로젝트 명</label>
                           <input class="form-control" type="text" id="updateprojects_name" name="proj_name">
                        </div>   
                                             
                        <div class="form-group">
                           <label for="message-text" class="control-label">금액</label>
                           <input class="form-control" type="text" placeholder="금액" name="sums" >
                        </div>
                        
                        <div class="form-group">
                           <label for="message-text" class="control-label">계좌번호</label>
                              <input class="accountHiddenids" type="hidden" name ="account_id">
                              <button type="button" class="btn btn-default btn-sm account_numbers_search" id="account_numbers_search" data-toggle="modal" data-target="#account_numbers_modal">
                                 <span class="fa fa-search"></span></button>
                           <input class="form-control account_number" type="text" placeholder="계좌번호" name="account_number" id="account_number">
                        </div>
                        
                                                
                        <div class="form-group">
                           <label for="message-text" class="control-label">비고</label>
                           <input class="form-control" type="text" placeholder="비고"name="remarks">
                        </div>
                        
                        <div class="modal-footer">
                           <input type="submit" class="btn btn-default" value="저장">
                           <input type="reset" class="btn btn-default" value="다시작성">
                           <input type="button" class="btn btn-default" data-dismiss="modal" value="취소">
                        </div>
                     </div>
                  </div>
               </form:form>
            </div>
         </div>
      </div><!-- 신규 통장계좌 수정 END-->
      
      
<!-- 검색 -->
<!-- 계좌번호 검색 Start-->
<div class="modal fade" id="account_numbers_modal" role="dialog">
 <div class="modal-dialog modal-lg">      
    <div class="modal-content">
      <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title"><strong>계좌번호 검색</strong></h4>   
      </div>
         <div class="modal-body">            
            <div class="col-sm-8">
               <input type="text" class="form-control search_account_number" name="account_number" id="search_account_number">
               <input type="hidden" class="accountHiddenid">
            </div>
                  
            <div class="col-sm-2">
                  <button type="button" class="btn btn-dault btn-sm account_numbers" id="account_numbers"><span class="fa fa-search"></span></button>
            </div>
            <br><br><br>
            <table id="a_searchTable" class="table table-bordered table-hover a_searchTable">
            
            </table>
            <div id="ustBtnArea">
               <input type="button" class="btn btn-default center useBtn" value="사용" data-dismiss="modal">
            </div>
            <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               </div>
         </div>
      </div>
   </div>
</div>
<!-- 계좌번호 검색 End-->      
</body>
</html>