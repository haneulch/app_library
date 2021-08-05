/**
 * 
 */
 
 /* Test 데이터*/
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
			
			$('#visited-content').append('<li id="vistlist' + i + '"></li>');
	    	$('#vistlist' + i ).append('<span id="visited-date">' + visited[i].date + '</span>');
	    	$('#vistlist' + i ).append('<span id="visited-time">' + visited[i].time + '</span>');
	    	$('#vistlist' + i ).append('<span id="visited-place">' + visited[i].place + '</span>');
	    	
		} //for

} //visitedContent







