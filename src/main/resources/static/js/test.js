

// 화면 캡쳐 기능 (myqr 이미지 저장하기부분)
	function bodyShot() {
		//전체 스크린 샷하기
		html2canvas(document.body)
		//document에서 body 부분을 스크린샷을 함.
		.then( function (canvas) {
			//canvas 결과값을 drawImg 함수를 통해서
			//결과를 canvas 넘어줌.
			//png의 결과 값
			drawImg(canvas.toDataURL('image/png'));
			//appendchild 부분을 주석을 풀게 되면 body
			//document.body.appendChild(canvas);
			//특별부록 파일 저장하기 위한 부분.
			saveAs(canvas.toDataURL(), 'myQRpass.png');
			}).catch(function (err) {
				console.log(err);
				});
	}
	
	/*  
	function partShot() {
			//특정부분 스크린샷
			html2canvas(document.getElementById("container"))
			//id container 부분만 스크린샷
			.then(function (canvas) {
			//jpg 결과값
			drawImg(canvas.toDataURL('image/jpeg'));
			//이미지 저장
			saveAs(canvas.toDataURL(), 'file-name.jpg');
			}).catch(function (err) {
			console.log(err); });
	} */
	
	//아마 이미지를 만들어주는 함수인거같은데...
	function drawImg(imgData) {
			console.log(imgData);
			//imgData의 결과값을 console 로그롤 보실 수 있습니다.
			return new Promise(function reslove() {
			//내가 결과 값을 그릴 canvas 부분 설정
			var canvas = document.getElementById('canvas');
			var ctx = canvas.getContext('2d');
			//canvas의 뿌려진 부분 초기화
			ctx.clearRect(0, 0, canvas.width, canvas.height);
			
			var imageObj = new Image();
			imageObj.onload = function () {
				ctx.drawImage(imageObj, 10, 10);
				//canvas img를 그리겠다.
				};
				imageObj.src = imgData;
				//그릴 image데이터를 넣어준다.
				}, function reject() { });
	}
	
	//save as
	function saveAs(uri, filename) {
			var link = document.createElement('a');
			if (typeof link.download === 'string') { 
				link.href = uri;
				link.download = filename;
				document.body.appendChild(link);
				link.click();
				document.body.removeChild(link);
			} else { window.open(uri);
			}
	}
	
	
	
	
	
//다국어 처리기능
	// 다국어 언어 예시.
	let multiLanguage = {
	  "ko" : {
	    msg : "안녕하세요.",
	    title: "한국어",
	  },
	
	  "en" : {
	    msg : "Hello World.",
	    title: "English",
	  }
	};
	
	window.onload = () => {
	
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
	  });
	+
	  enBtn.addEventListener("click" , () => {
	    setLanguage(enBtn.dataset.lang);
	  });
	};
	
	
	
	
	 
	 
	 
	 
// 다국어처리 2
	// 언어팩 선언.
	$.lang = {};
	 
	$.lang.ko = {
	    0: '자바스크립트 다국어 처리.',
	    1: '안녕하세요',
	    2: '오늘은 금요일 입니다.',
	    3: '불금을 즐겨 보아요.'
	};
	 
	$.lang.en = {
	    0: 'Javascript Language Localization.',
	    1: 'Hello.',
	    2: 'Today is Friday',
	    3: 'Fire~!!'
	};
	    
	$.lang.ja = {
	    0: 'JavaScriptの言語',
	    1: 'こんにちは',
	    2: '今日は金曜日です。',
	    3: 'ガンバレ~!!'
	};
	 
	/**
	* setLanguage 
	* use $.lang[currentLanguage][languageNumber]
	*/
	
	function setLanguage(currentLanguage) {
	  console.log('setLanguage', arguments);
	  
	  $('[data-langNum]').each(function() {
	    var $this = $(this); 
	    $this.html($.lang[currentLanguage][$this.data('langnum')]); 
	  });    
	}  
	 
	// 언어 변경
	$('button').click(function() {
	  var lang = $(this).data('lang');
	  setLanguage(lang); 
	});
	
	
	
//input camera 촬영 이미지 반환하기
	
	var file = document.querySelector('#getfile');
	
	file.onchange = function () {
	    var fileList = file.files ;
	
	    // 읽기
	    var reader = new FileReader();
	    reader.readAsDataURL(fileList [0]);
	
	    //로드 한 후
	    reader.onload = function  () {
	    document.querySelector('#preview').src = reader.result ;
	    document.querySelector('#preview').style.width = "80%"
	    };
	};
	
	
	
	
//QR코드 생성하기
	    $(document).ready(function(){
		    $('#createBtn').click(function(){
	
				 // input에 입력하는 값
			       var pass_name = $('#pass_name').val();
			       var pass_id =  $('#pass_id').val();
			       var pass_test = $('#pass_test').val();
		
			      // encodeURIComponent.
			      pass_name = encodeURIComponent(pass_name);
			      pass_id = encodeURIComponent(pass_id);
			      pass_test = encodeURIComponent(pass_test);
		
			      //  변수에 주소를 저장
			      googleQRUrl = "https://chart.googleapis.com/chart?chs=195x195&cht=qr&chl=";
		
		
		      	  // 이미지가 나타날 영역에 원하는 내용을 넣은 QR code의 이미지를 출력합니다.
			      $('#qrcode').attr('src', googleQRUrl + "이름:" + pass_name +
			      										 "/ ID:" + pass_id +
			        		 		                     "/ 검사일:" + pass_test +
			        		 		                     '&choe=UTF-8');
			  });
		 });

	
		 
	
	
