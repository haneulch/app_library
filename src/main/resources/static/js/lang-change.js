/**
 * 
 */
 
 // 언어값 설정값으로 유지하기 (페이지 넘어가도 유지하기)
	 let getLang = localStorage.getItem('lang');
	 
	 
	 if( getLang ==='en'){
	 	localStorage.setItem('lang', 'en');
	 }
	 else if( getLang ==='ko'){
	 	localStorage.setItem('lang', 'ko');
	 }
	 else{
		 localStorage.setItem('lang', 'en');
	 }
	 
	 // 첫 언어 영어로 설정해주기 위해 (처음 접속 --> else 로 'en'이 세팅됨)
	 let firstLang = localStorage.getItem('lang');


 
 
 //다국어 처리기능
	
	let multiLanguage = {
	  "ko" : {
 		//setting	  
		    about : "회사소개",
		    faq: "자주하는 질문",
		    contact: "고객센터",
		    logOut : "로그아웃", 
	     //mypass
		    nameTitle : "이름: ",
		    name : "이보영",
		    idTitle : "아이디",
		    id : "980732-5230999",
		    lastTitle: "마지막 검사",
		    last : "검사내역 없음",
		 //profile
		    changeInfo : "내 정보 변경하기",
		 //result
		 	importTestTitle : "PCR검사 결과 등록하기",
		    importTest : "PCR검사 결과가 있다면 앱에 업로드하세요",
		    importVeccineTitle : "백신 접종내역 등록하기",
		    importVeccine : "백신 인증서가 있다면 앱에 업로드하세요",
		 
	  },
	
	
	  "en" : {
	    //setting
		    about : "About",
		    faq: "FAQ",
		    contact: "Contact us",
		    logOut : "Log Out", 
	    //mypass
		    nameTitle: "name: ",
		    name: "Lee Boyoung",
		    idTitle : "ID",
		    id : "980732-5230999",
		    lastTitle: "Last test",
		    last: "Not tested yet",
		//profile
		    changeInfo : "Change my information",
	    //result
		 	importTestTitle : "Import test result",
		    importTest : "If you have result of completing a PCR test, you can upload int in the App",
		    importVeccineTitle : "Import vaccine record",
		    importVeccine : "Upload your vaccine certificate and use it to confirm your status",
	    
	  }
	}; //multiLanguage
	
	
	
	
	
	
	$(document).ready(function() {
    
    
 		  let koBtn = document.getElementById("koBtn");
		  let enBtn = document.getElementById("enBtn");

		
		  let setLanguage = (lang) => {
		    let changeNodeList = Array.prototype.slice.call(document.querySelectorAll('[data-detect]'));
		    
		  // 각 dataset중 detect인 요소들을 찾아 변경하는 곳. 
		    changeNodeList.map( v => {
		      v.textContent = multiLanguage[lang][v.dataset.detect]
		    })
		    
		  };
		
		
		  koBtn.addEventListener("click" , () => {
		    setLanguage(koBtn.dataset.lang);
		    localStorage.setItem('lang', 'ko');
		  });
		+
		  enBtn.addEventListener("click" , () => {
		    setLanguage(enBtn.dataset.lang);
		    localStorage.setItem('lang', 'en');
		  });
		  
		  setLanguage(firstLang);
		 
		 
		 //mypass에 qr코드 이미지 생성
		 qrMaker()
		 

	});
	
	
	
//언어선택 버튼 배경처리
	$( document ).ready(function() {
	       $('#koBtn').click(function(){
		       	$(this).css('background', '#9B7AFD');
		       	$(this).css('border', '1px solid #9B7AFD');
		       	$('#enBtn').css('background', '#22B8DD');
		       	$('#enBtn').css('border', '1px solid #22B8DD');
	   	   });
	   	   $('#enBtn').click(function(){
		       	$(this).css('background', '#9B7AFD');
		       	$(this).css('border', '1px solid #9B7AFD');
		       	$('#koBtn').css('background', '#22B8DD');
		       	$('#koBtn').css('border', '1px solid #22B8DD');
	   	   });
	   	   
	   	
	   	  //버튼 상태 고정하기 (페이지 넘어가도 유지하기)
			 if(getLang === 'en'){
		       	 	$('#enBtn').trigger('click');
		     }
		     else if( getLang ==='ko'){
		        	$('#koBtn').trigger('click');
		     }
		     else {
		        $('#enBtn').trigger('click');
		     }
	 
	});
	
	
	
/* 개인이 설정해둔 기본 값은 유지하는게 좋을 것 같아 주석처리
//로그아웃 시 로컬스토리지 비우기	
	$( document ).ready(function() {
	       $('.setting-logout').click(function(){
		       	localStorage.removeItem('lang');
	   	   });	 
	});
*/







//QR코드 생성 기능
	  function qrMaker(){
				  // Mypass의 사용자 정보
			      //var name = $('#name').text();
			      var id =  $('#id').text();
			      var last = $('#last').text();
				      // qr코드 생성 시 이름 정보가 들어가면 국문/영문 구분해서 qr을 다시 만들어 주어야하므로 id정보만 담기(문자열 제외한 정보만)
				      // last test는 추후에 검사내역 없음 / not tested yet 묶어서 false같은 처리로 넘기구
				      // 있을 때는 검사내역 넘겨서 검사 날짜로 언어 상관없이 인식 되도록 하면 좋을듯
		
			      // encodeURIComponent.
			      //name = encodeURIComponent(name);
			      id = encodeURIComponent(id);
			      last = encodeURIComponent(last);
			      
			      //  변수에 주소를 저장
			      googleQRUrl = "https://chart.googleapis.com/chart?chs=300x300&cht=qr&chl=";
	
		      	  // 이미지가 나타날 영역에 원하는 내용을 넣은 QR code의 이미지를 출력합니다.
			      $('#qrcode').attr('src', googleQRUrl + "ID:" + id +
			        		 		                     " / 검사일:" + last +
			        		 		                     '&choe=UTF-8');
	  } 
					 
	
	
	
	
	
	
	
	
	
	
	
	
	
