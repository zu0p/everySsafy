<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<% 
String root = request.getContextPath();
pageContext.setAttribute("root", root);
UserDto user = (UserDto) session.getAttribute("user");
%>
<script type="text/javascript">
function clickMypage(){
	//location.href="${root}/mypage.do"
	$.ajax({
		method: "GET",
		url: "${root}/mypage.do",
		success: function(res){
			//console.log(res)
			$('.community').empty()	
			
			let info = JSON.parse(res);
			//console.log(info);
			//console.log(info.user);
			$('.community').load("http://localhost:8080/tetetmp/"+info.path, function(){
				$('#info-id').text(info.user.userId);
				$('#info-name').text(info.user.userName);
			});
		}
	})
}
function clickMyArticle() {
	
	let userId = "${user.userId}";
	let Data={"userId" : userId };
	$.ajax({
		method: "GET",
		data: Data,
		url: "${root}/getMyArticle.do",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		datatype: 'JSON',
		success: function(res){
			
			$('#changeable').empty()	
			
			let info = JSON.parse(res);
			
			$('#changeable').addClass("articles");
			
			$('#changeable').load("http://localhost:8080/tetetmp"+info.path, function(){
				 document.getElementById("writeArticleButton").style.display= "none";
			
				
				$('#articleName').text("내가 쓴글");
				console.log(info);
				$.each(info.list, function(index, item){
					let newArticle =`
						<article>
							<a class="article" href="/389148/v/181438459">
							<div class="attachthumbnail"
									style="background-image: url('./더미이미지.jfif');">
							</div>
							<h2 class="medium">제목 : ${'${item.articleTitle}'} </h2>
							<p class="small">내용: ${'${item.articleContent}'} </p> <time class="small">temp</time>
							<h3 class="small">익명</h3>
							<ul class="status">
								<li class="attach">1</li>
								<li title="공감" class="vote">${'${item.articleLike}'} </li>
								<li title="댓글" class="comment"> 댓글cnt </li>
							</ul>
							<hr> 
							<div class="comments"></div>
						</article>`;
					$('.article-list').append(newArticle);
				})
			
			});
		}
	})
}

</script>
			  <div class="card pconly">
		        <form class="logged">
		          <img src="https://cf-fpi.everytime.kr/0.png" class="picture">
		          <p class="nickname">${ user.userId }</p>
		          <p class="school">${ user.userName }</p>
		          <p class="school">${ user.userNickName }</p>
		          <ul class="buttons">
		            <li><a href="javascript:void(0);" onclick="javascript:clickMypage(); return false;" id="mypage">내 정보</a></li>
		            <li><a href="${root}/logout.do">로그아웃</a></li>
		          </ul>
		          <hr>
		        </form>
		      </div>
		      <div class="card">
		        <div class="menus">
		          <a href="javascript:void(0);" onclick="javascript:clickMyArticle(); return false;" id="mypage">내가 쓴 글</a>
		          <a href="/mycommentarticle" class="mycommentarticle" >댓글 단 글</a>
		          <a href="/myscrap" class="myscrap">내 스크랩</a>
		          <hr>
		        </div>
		      </div>