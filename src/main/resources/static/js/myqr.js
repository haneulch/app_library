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
