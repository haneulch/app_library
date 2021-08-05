/**
 * 
 */
 							
//myprofile -> 토글버튼
	$(document).on('click', '.toggleBG', function () {
	    var toggleBG = $(this);
	    var toggleFG = $(this).find('.toggleFG');
	    var left = toggleFG.css('left');
	    if(left === '40px') {
	        toggleBG.css('background', '#9B7AFD');
	        toggleBG.css('border', '1px solid #9B7AFD');
	        toggleActionStart(toggleFG, 'TO_LEFT');
	        $('.visitor-select').show();
	        $('.site-select').hide();
	        $('.visitor-btn').css('background', '#9B7AFD');
	        $('.visitor-btn').css('border', '1px solid #9B7AFD');
	        $('.visitor-btn').prop('href', '/change_info.html')
	        
	    }else if(left === '0px') {
	        toggleBG.css('background', '#FD7A7A');
	        toggleBG.css('border', '1px solid #FD7A7A');
	        toggleActionStart(toggleFG, 'TO_RIGHT');
	        $('.visitor-select').hide();
	        $('.site-select').show();
	        $('.visitor-btn').css('background', '#FD7A7A');
	        $('.visitor-btn').css('border', '1px solid #FD7A7A');
	        $('.visitor-btn').prop('href', '/change_ownerinfo.html')
	    }
	});
	

	
// 토글 버튼 이동 모션 함수
function toggleActionStart(toggleBtn, LR) {
    // 0.01초 단위로 실행
    var intervalID = setInterval(
        function() {
            // 버튼 이동
            var left = parseInt(toggleBtn.css('left'));
            left += (LR == 'TO_RIGHT') ? 5 : -5;
            if(left >= 0 && left <= 40) {
                left += 'px';
                toggleBtn.css('left', left);
            }
        }, 10);
    setTimeout(function(){
        clearInterval(intervalID);
    }, 201);
}


// My PCR - MY Vaccines 정보이동
$( document ).ready(function() {
       $('.title-vaccine').click(function(){
	        $('.mypcr').hide();
	        $('.myvaccine').show();
	        $(this).addClass('test-select-title');
	        $('.title-pcr').removeClass('test-select-title');
   		 }); 
   		 
   		 $('.title-pcr').click(function(){
	        $('.myvaccine').hide();
	        $('.mypcr').show();
	        $(this).addClass('test-select-title');
	        $('.title-vaccine').removeClass('test-select-title');
   		 }); 
    
}); 






/* 하단부 데이터 넣어주기 -- My PCR tests / My Vaccines /  */




/* Test 데이터*/
 let myPCR = [
					{
						'date' : '2021-03-05',
						'time' : '12:39',
						'place' : '강남구보건소'
					},
					{
						'date' : '2021-03-05',
						'time' : '15:40',
						'place' : '서초구보건소'
					},
					{
						'date' : '2021-03-06',
						'time' : '10:20',
						'place' : '관악구보건소'
					},
					{
						'date' : '2021-03-08',
						'time' : '19:20',
						'place' : '금천구보건소'
					},
			   ]//visitorPCR
			   
			   
let myVaccine = [
					{
						'date' : '2021-03-05',
						'time' : '12:39',
						'vaccine' : 'Modena'
					},
					{
						'date' : '2021-03-07',
						'time' : '15:50',
						'vaccine' : 'Modena'
					},
					
			   ]//visitorPCR
	
			   
let myVisitor = [
					{
						'date' : '2021-03-05',
						'time' : '12:39',
						'visitor' : 'Jhon smith'
					},
					{
						'date' : '2021-03-07',
						'time' : '15:50',
						'visitor' : 'daniel smith'
					},
					{
						'date' : '2021-03-07',
						'time' : '15:50',
						'visitor' : 'william smith'
					},
					
			   ]//visitorPCR



$( document ).ready(function() {
	
		myPcrContent()
		myVaccinesContent()
		myVisitorContent()
		
}); //




/* My PCR tests 데이터 넣어주기 */
function myPcrContent(){
	
	for(i=0; i < myPCR.length; i++){
			
			// 데이터 가져오기
			let date = myPCR[i].date;
			let time = myPCR[i].time;
			let place = myPCR[i].place;

			$('#mypcr-list').append('<li id="pcrlist' + i + '"></li>');
	    	$('#pcrlist' + i ).append('<span id="profile-date">' + myPCR[i].date + '</span>');
	    	$('#pcrlist' + i ).append('<span id="profile-time">' + myPCR[i].time + '</span>');
	    	$('#pcrlist' + i ).append('<span id="profile-place">' + myPCR[i].place + '</span>');
	    	$('#pcrlist' + i ).append('<img id="profile-result" src="/img/visitor-check.png" alt="유효한 검사">');
	    	
		} //for

} //myPcrContent





/* My vaccines 데이터 넣어주기 */
function myVaccinesContent(){
	
	for(i=0; i < myVaccine.length; i++){
			
			// 데이터 가져오기
			let date = myVaccine[i].date;
			let time = myVaccine[i].time;
			let vaccine = myVaccine[i].vaccine;
			
			$('#myvaccine-list').append('<li id="vaccinelist' + i + '"></li>');
	    	$('#vaccinelist' + i ).append('<span id="profile-date">' + myVaccine[i].date + '</span>');
	    	$('#vaccinelist' + i ).append('<span id="profile-time">' + myVaccine[i].time + '</span>');
	    	$('#vaccinelist' + i ).append('<span id="profile-place">' + myVaccine[i].vaccine + '</span>');
	    	$('#vaccinelist' + i ).append('<img id="profile-result" src="/img/visitor-check.png" alt="유효한 백신">');
	    	
		} //for

} //myVaccinesContent





function myVisitorContent(){
	
	for(i=0; i < myVisitor.length; i++){
			
			// 데이터 가져오기
			let date = myVisitor[i].date;
			let time = myVisitor[i].time;
			let visitor = myVisitor[i].visitor;

			$('#myvisitor-list').append('<li id="visitorlist' + i + '"></li>');
	    	$('#visitorlist' + i ).append('<span id="profile-date">' + myVisitor[i].date + '</span>');
	    	$('#visitorlist' + i ).append('<span id="profile-time">' + myVisitor[i].time + '</span>');
	    	$('#visitorlist' + i ).append('<span id="profile-place">' + myVisitor[i].visitor + '</span>');
	    	
		} //for

} //myVisitorContent







