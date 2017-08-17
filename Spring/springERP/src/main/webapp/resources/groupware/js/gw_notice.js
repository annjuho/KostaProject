$(function(){
	 $('.eggFri').on('click', function(e) {
	      e.preventDefault();
	      $('#contents').empty();	
	      $('#contents').load('/groupware/notice/'+$(this).attr('href'));
	   });

	   $('#write').click(function(e) {
	      e.preventDefault();
	      
	      $('#contents').empty();
	      $('#contents').load('/groupware/notice/'+$(this).attr('href'));
	   });
});