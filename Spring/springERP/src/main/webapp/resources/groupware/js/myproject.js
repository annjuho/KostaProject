$(function(){
	 $('.eggFri').on('click', function(e) {
	      e.preventDefault();
	      $('#contents').empty();	
	      $('#contents').load('/groupware/project_board/'+$(this).attr('href'));
	   });

	   $('#write').click(function(e) {
	      e.preventDefault();
	      
	      $('#contents').empty();
	      $('#contents').load('/groupware/project_board/'+$(this).attr('href'));
	   });
});