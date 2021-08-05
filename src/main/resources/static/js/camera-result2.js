/**
 * 
 */
 
 
 // 테스트결과&백신내역 등록 페이지
 // 사진 등록 후 뒷 페이지에서도 등록한 사진 노출하기
  $( document ).ready(function() {
			 var setPhoto = localStorage.getItem('setphoto');
			
			document.querySelector('#choose-confirm-photo').style.backgroundImage = "url('" + setPhoto + "')" ;
			document.querySelector('#choose-confirm-photo').style.backgroundSize = "300px";
				
			 
});
		
		

		