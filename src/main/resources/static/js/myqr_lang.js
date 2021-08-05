/**
 * 
 *//**
 * 
 */
 
 // 언어값 설정값으로 유지하기 (페이지 넘어가도 유지하기)
	 let getLang = localStorage.getItem('lang');
	 
	 /*
	 if( getLang ==='en'){
	 	localStorage.setItem('lang', 'en');
	 }
	 else if( getLang ==='ko'){
	 	localStorage.setItem('lang', 'ko');
	 }
	 else{
		 localStorage.setItem('lang', 'en');
	 }*/
	 

 
 
 //다국어 처리기능
	
	let multiLanguage = {
		
	  "ko" : {
 		
		 //myqr
			myqrPlaceTitle : "장소명 : ",
			myqrPlace : " 지지56코리아",
			myqrAdTitle : "주소 : ",
			myqrAd : "강남구 테헤란로 437 삼영빌딩 302호",
			myqrTestTitle : "검사 후, 출입 허용 시간 : ",
			myqrTest : "48시간",
	  },
	
	  "en" : {
	  
	    //myqr
			myqrPlaceTitle : "Place : ",
			myqrPlace : " GG56Korea",
			myqrAdTitle : "Address : ",
			myqrAd : "Samyoung Building 302, 437 Teheran-ro, Gangnam-gu",
			myqrTestTitle : "Access allowed time : ",
			myqrTest : "48 hours",
	  }
	};
	
	
	
	
	
	
	$(document).ready(function() {
    
		
		  let setLanguage = (lang) => {
			  let changeNodeList = Array.prototype.slice.call(document.querySelectorAll('[data-detect]'));
			    
			  // 각 dataset중 detect인 요소들을 찾아 변경하는 곳. 
			  changeNodeList.map( v => {
			      v.textContent = multiLanguage[lang][v.dataset.detect]
			  })
		    
	      }; //setLanguage
		
		  //alert(getLang)
		
		  if( getLang ==='en' ){
		  	  setLanguage('en');
		  }
		  else if( getLang ==='ko' ){
			  setLanguage('ko');
		  }
		
		 
		   // qr코드 이미지 생성
		   myqrMaker()
		 

	}); //
	
	
	




//QR코드 생성 기능 (for myqr.html)
	  function myqrMaker(){
				  // QR 입력정보
			      var myqrPlace =  $('#myqrPlace').text();
			      var myqrAd =  $('#myqrAd').text();
			      var myqrTest =  $('#myqrTest').text();
		
			      // encodeURIComponent.
			      myqrPlace = encodeURIComponent(myqrPlace);
			      myqrAd = encodeURIComponent(myqrAd);
			      myqrTest = encodeURIComponent(myqrTest);
			      
			      //  변수에 주소를 저장
			      googleQRUrl = "https://chart.googleapis.com/chart?chs=300x300&cht=qr&chl=";
	
		      	  // QR이미지 - 영문
		      	  if( getLang ==='en' ){
				      $('#qrcode').attr('src', googleQRUrl + "Place name:" + myqrPlace +
				        		 		                     " / Address:" + myqrAd +
				        		 		                     " / Access allowed time:" + myqrTest +
				        		 		                     '&choe=UTF-8');
                  } 
                  // QR이미지 - 국문
                  else if( getLang ==='ko' ){
				      $('#qrcode').attr('src', googleQRUrl + "장소명 :" + myqrPlace +
				        		 		                     " / 주소:" + myqrAd +
				        		 		                     " / 검사 후, 출입 허용 시간:" + myqrTest +
				        		 		                     '&choe=UTF-8');
                  } 
		        		 		                     
				        		 		                     
	  } //myqrMaker
					 
	
	
	
	
	
	
	
	
	
	
	
	
	
