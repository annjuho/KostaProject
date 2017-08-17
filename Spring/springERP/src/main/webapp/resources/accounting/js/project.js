//프로젝트 예산설정
$(function() {
   $('#updateBtn').click(function() {
      var val = '';
      $("input[name=number_box]:checked").each(function() {
         val = $(this).val();
      });
      if (val == "") {
         alert("설정할 내용을 체크해주세요.");
         return false;
      } else {
         $('#updateProj_id').val(val);
         alert(val);
      }
   });
});

// 체크박스 선택,해제
$(function() {
   $('#checkAll').click(function() {
      if (this.checked) {
         $('input[name=number_box]').each(function() {
            $(this).prop('checked', true);
         });
      } else {
         $('input[name=number_box').each(function() {
            $(this).prop('checked', false);
         });
      }
   });

})   
 // ************계좌번호검색 ************
$(function() {
         $('.account_numbers_search').click(function() {
            $('.a_searchTable').empty();
            $('.search_account_number').val('');
            var url = "/Search/account/list";
            $.ajax({
               url : url,
               dataType : 'json',
               success : handler
            })
         })

         // 검색된 계좌번호 사용하기
         $('.useBtn').on('click', function() {
            var accountName = $('.search_account_number').val();
            var accountId = $('.accountHiddenid').val()
            $('.account_number').val(accountName);
            $('.accountHiddenids').val(accountId);
         })

         // 계정 테이블 내용 클릭시
         $('.a_searchTable').on('click', '.getValue', function() {
            var accountName = $(this).find('.getaccountName').text();
            var accountId = $(this).find('.getaccountId').text();
            $('.search_account_number').val(accountName);
            $('.accountHiddenid').val(accountId);
         })

         // 계좌번호 검색하기
         $('.account_numbers').click(function() {
            var diagnosis_number = $('#search_account_number').val();
            var url = "/Search/account/Idlist?account_id=" + account_id;
            $('.a_searchTable').empty();
            $.ajax({
               url : url,
               dateType : 'json',
               success : handler
            });
         });

         // 계좌번호 검색 ajax 이벤트 처리
         function handler(data) {
            var html = '<tr><th>계좌번호 아이디</th><th>계좌번호</th><th>계좌이름</th><th>계정번호</th><th>계좌내용</th><th>사용여부</th><th>비고</th></tr>';
            $.each(data, function(index, list) {
               html += '<tr class="getValue"><td class = "getaccountId">' + list.account_id + '</td>';
               html += '<td class="getaccountName">' + list.account_number
                     + '</td>';
               html += '<td>' + list.account_name + '</td>';
               html += '<td>' + list.diagnosis_number + '</td>';
               html += '<td>' + list.account_detail + '</td>';
               html += '<td>' + list.use + '</td>';
               html += '<td>' + list.remarks + '</td>';
               html += '</tr>';
            });
            $('.a_searchTable').append(html);
         }
      })
//************계좌번호 검색 END************