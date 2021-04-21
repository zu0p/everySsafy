function clickMypage(){
	//location.href="${root}/mypage.do"
	$.ajax({
		method: "GET",
		url: "${root}/mypage.do",
		success: function(res){
			console.log(res)
			$('.community').empty()	
			
			//var newContents = $('<')
			//$('.community').load("http://localhost:8080/tetetmp/userinfo.jsp");
			
			$('.community').load("http://localhost:8080/tetetmp/"+res);
		}
	})
}