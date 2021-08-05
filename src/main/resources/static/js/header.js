


 //설정창 열고닫기
	 $( document ).ready(function() {
	       $('.setting-btn').click(function(){
	        $('.setting-wrap').show();
	    });
	    $('.setting-close').click(function(e){
	        e.preventDefault();
	        $('.setting-wrap').hide();
	    });
	});



//알림 아이콘
	 $( document ).ready(function() {
	       $('.notice-btn').click(function(){
		       	if($('.notice-num').css('display') === 'none'){
		       	 	$('.notice-num').show();
		        }
		        else{
		        	$('.notice-num').hide();
		        }
	    });
	});



	





