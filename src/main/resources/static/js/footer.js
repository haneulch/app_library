/**
 * 
 */
 
 
 $( document ).ready(function() {
       $('.qrscan-icon').click(function(){
	        $(this).hide();
	        $('.qrscan-icon-work').show();
   		 });
   		 $('.scan-close').click(function(){
	        $('.qrscan-icon-work').hide();
	        $('.qrscan-icon').show();
   		 }); 
   		 
   		 
    
}); 