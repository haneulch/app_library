/**
 * 
 */
 
 
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
		    document.querySelector('.file-upload').style.width = "50%"
		    
		    localStorage.setItem('setphoto', reader.result);
	    };
	};
	
	
	
	