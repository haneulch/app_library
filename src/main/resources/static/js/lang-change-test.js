/**
 * 
 */
 
  localStorage.setItem('lang', 'ko');
 let getLang = localStorage.getItem('lang');
 
 
 //다국어 처리기능
	// 다국어 언어 예시.
	let multiLanguage = {
	  "ko" : {
	    about : "회사소개",
	    faq: "자주하는 질문",
	    contact: "고객센터",
	    
	  },
	
	  "en" : {
	    about : "About",
	    faq: "FAQ",
	    contact: "Contact us",
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
		  
		  setLanguage(getLang);
		 //setLanguage(enBtn.dataset.lang);
		 //$('#enBtn').trigger('click');
		 
	}; //window.onload