<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="everyssafy.model.UserDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	
	UserDto user = (UserDto) session.getAttribute("user");
%>
<link href="/favicon.ico" rel="shortcut icon">
<!--[if lt IE 9]>
  <script src="/js/extensions.html5shiv.js"></script>
  <script src="/js/extensions.respond.min.js"></script>
  <script src="/js/extensions.excanvas.min.js"></script>
  <![endif]-->
<!--[if lt IE 8]>
  <script src="/js/extensions.json3.min.js"></script>
  <![endif]-->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
function writebtn() {
		var writeform = document.getElementsByClassName("write")[0]
		writeform.style.display = ""
		var writebutton =  document.getElementById("writeArticleButton")
		writebutton.style.display ="none"
		return;
}

function registArticle()
{
   const articletitle = $("#title").val();
   const content = $("#text").val();
   let boarId = $("#articleName").val();
   let userId = "${user.userId}";
   var writeform = document.getElementsByClassName("write")[0]
   var writebutton =  document.getElementById("writeArticleButton")
   console.log(articletitle);
   console.log(content);
   console.log(boarId);
   console.log(userId);
   
   
   let Data = {"articleTitle":articletitle,"articleContent":content,"boardId":boarId,"userId":userId};
   $.ajax({
      metod:"GET",
      tranditional:true,
      data : Data,
      contentType: "application/x-www-form-urlencoded; charset=UTF-8",
      url:"http://localhost:8080/tetetmp/registerArticle.do",
      success : function(res){
       		console.log(res)
			writeform.style.display = "none"
			writebutton.style.display =""
       		let newArticle =`
				<article>
				<a class="article" href="">
				<div class="attachthumbnail"
						style="background-image: url('./더미이미지.jfif');">
				</div>
				<h2 class="medium">제목 : ${'${articletitle}'} </h2>
				<p class="small">내용:  ${'${content}'} </p> <time class="small">temp</time>
				<h3 class="small">익명</h3>
				<ul class="status">
					<li class="attach">1</li>
					<li title="공감" class="vote"> 0 </li>
					<li title="댓글" class="comment"> 0 </li>
				</ul>
				<hr> 
				<div class="comments"></div>
			</article>`;
		$('.article-list').prepend(newArticle);
       		
       	
			
      }
   })
}

</script>

		<div class="wrap title">
			<h1>
				<a id="articleName" href="/389148"></a>
			</h1>
			<hr>
		</div>
		
		<div class="wrap articles">
			<form class="write" style="display: none;">
				<p>
					<input name="title" placeholder="글 제목" class="title" id="title">
				</p>
				<p>
					<textarea name="text" id ="text"
						placeholder="에브리타임은 누구나 기분 좋게 참여할 수 있는 커뮤니티를 만들기 위해 커뮤니티 이용규칙을 제정하여 운영하고 있습니다. 위반 시 게시물이 삭제되고 서비스 이용이 일정 기간 제한될 수 있습니다. 

 	에브리 싸피 게시글 작성 규칙 사항
 	"
						class="smallplaceholder large"></textarea>
				</p>
				<input class="file" type="file" name="file" multiple="multiple">
				<ol class="thumbnails">
					<li class="new"></li>
				</ol>
				<div class="clearBothOnly"></div>
				<ul class="option">
					<!--  <li title="해시태그" class="hashtag"></li>   -->
					<!--  <li title="첨부" class="attach" ></li>  -->
					<li title="완료" class="submit" onclick="javascript:registArticle()"></li>
					<li title="익명" class="anonym"></li>
				</ul>
				<div class="clearBothOnly"></div>
			</form>
			<a id="writeArticleButton" onclick="javascript:writebtn();" >새 글을 작성해주세요!</a>
			
			<div class="article-list">
				
				<!-- <article>
					<a class="article" href="/389148/v/181438459">
					<div class="attachthumbnail"
							style="background-image: url('./더미이미지.jfif');">
					</div>
					<h2 class="medium">글의 제목이 들어가는 부분</h2>
					<p class="small">글의 내용이 들어가는 부분</p> <time class="small">temp</time>
					<h3 class="small">익명</h3>
					<ul class="status">
						<li class="attach">1</li>
						<li title="공감" class="vote">공감 value</li>
						<li title="댓글" class="comment">댓글 cnt value</li>
					</ul>
					<hr> 
					<input type="hidden" name="181438459_comment_anonym" value="0"></a>
					<div class="comments"></div>
				</article> -->
			</div>
			
			
		</div> 
		<hr>
	</div>