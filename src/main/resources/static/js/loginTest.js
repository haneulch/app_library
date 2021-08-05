/**
 * 
 */
 




const admin = [
	           	{ "id":"admin", "pw":"admin" },
	           	{ "id":"user1", "pw":"user1" },
	           	{ "id":"user2", "pw":"user2" },
			   ]  
		


let id; 
let pw;
let userinputText;
let adminText;


$( document ).ready(function() {
	
	   //window.location.href='/mypass.html';
       $('.login-btn').click(function(){
	
		    // 로그인 화면 id pw 입력값
			id = document.getElementById("id").value;
		    pw = document.getElementById("pw").value;
		    let userinput = { "id": id, "pw": pw };
		    
			userinputText = JSON.stringify(userinput); 
			//adminText = JSON.stringify(admin);
			
			login()
			
    	}); //click
    	
});





/* login 기능 */
function login(){
	// id 입력 안했을 때
	if(id === ""){ 
		alert("아이디를 입력해 주세요");	
	} 
	// pw 입력 안했을 때
	else if ( pw === "" ){ 
		alert("비밀번호를 입력해 주세요");
	} 
	// 로그인 정보 비교
	else{
		//id pw 일치
		if( loginTest() == true){ 
			alert('로그인 성공')
			//window.location.href ='/mypass.html';		
		} 
		//id pw 불일치
		else{ 
			alert('[로그인 실패] \n아이디 비밀번호를 확인해주세요 \n Test계정 \nID : admin | PW : admin \nID : user1 | PW : user1 \nID : user2 | PW : user2')
		} 
	} 
	
} //login






/* login 정보비교 */
function loginTest(){
	
	for( i = 0; i < admin.length; i++ ){
		
		adminText = JSON.stringify(admin[i]);
		
		if(adminText === userinputText){
			return true;
		}	
		
	} //for
	
}//loginTest






