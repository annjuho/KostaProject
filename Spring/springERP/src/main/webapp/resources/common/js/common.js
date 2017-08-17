$(function(){
   $('.collapse li a').click(function(e) {
      e.preventDefault();
      
      $('#contents').empty();
      $('#contents').load($(this).attr('href'));
   });
})