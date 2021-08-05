/**
 * 
 */
 
 let visited = [
					{
						'date' : '2021-03-05',
						'time' : '12:39',
						'place' : 'GG56 Korea'
					},
					{
						'date' : '2021-03-05',
						'time' : '15:40',
						'place' : '스타벅스'
					},
					{
						'date' : '2021-03-06',
						'time' : '10:20',
						'place' : '김밥천국'
					},
					{
						'date' : '2021-03-08',
						'time' : '19:20',
						'place' : 'PP필라테스'
					},
			   ]//visited



$( document ).ready(function() {
	
		visitedContent()
		
}); //




/* 데이터 넣어주기 */
function visitedContent(){
	
	for(i=0; i < visited.length; i++){
			
			// 데이터 가져오기
			let date = visited[i].date;
			let time = visited[i].time;
			let place = visited[i].place;
			
			$('#jsonTest').append('<li id="jsonTestli' + i + '"></li>');
	    	$('#jsonTestli' + i ).append('<span id="datetest">' + visited[i].date + '</span>');
	    	$('#jsonTestli' + i ).append('<span id="timetest">' + visited[i].time + '</span>');
	    	$('#jsonTestli' + i ).append('<span id="placetest">' + visited[i].place + '</span>');
	    						  
	    	/*제이쿼리 한줄로쓰기			  
	    	$('#jsonTest').append('<li>'+'<span id="datetest">' + visited[i].date + '</span>'+
	    						  '<span id="timetest">' + visited[i].time + '</span>'+
	    						  '<span id="placetest">' + visited[i].place + '</span>'+'</li>'
	    						  ); */
			
			
			// HTML태그 생성하고 추가하기
			/* 자바스크립트로 구현하기 */
			/*
			var newli = document.createElement("li");
	    	var jsonTest = document.getElementById("jsonTest");
	    	jsonTest.appendChild(newli);
			
			var newDate = document.createElement("span");
			newDate.innerHTML = visited[i].date;
			newDate.setAttribute("id","datetest");
			
			var newTime = document.createElement("span");
			newTime.innerHTML = visited[i].time;
			newTime.setAttribute("id","timetest");
			
			var newPlace = document.createElement("span");
			newPlace.innerHTML = visited[i].place;
			newPlace.setAttribute("id","placetest");
			
	    	newli.appendChild(newDate);
	    	newli.appendChild(newTime);
	    	newli.appendChild(newPlace);
	    	*/
	    	
		} //for


	
} //visitedContent







