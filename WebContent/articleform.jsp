<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>에브리싸피</title>
<meta charset="utf-8">
<link type="text/css" href="./css/common.css" rel="stylesheet">
<link type="text/css" href="./css/common.partial.css" rel="stylesheet">
<link type="text/css" href="./css/container.article.css"
	rel="stylesheet">
<link type="text/css" href="./css/container.community.css"
	rel="stylesheet">
<link href="/favicon.ico" rel="shortcut icon">
<!--[if lt IE 9]>
  <script src="/js/extensions.html5shiv.js"></script>
  <script src="/js/extensions.respond.min.js"></script>
  <script src="/js/extensions.excanvas.min.js"></script>
  <![endif]-->
<!--[if lt IE 8]>
  <script src="/js/extensions.json3.min.js"></script>
  <![endif]-->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/fa7b781275.js" crossorigin="anonymous"></script>
	
<script type="text/javascript">
function writebtn() {
		var writeform = document.getElementsByClassName("write")[0]
		writeform.style.display = ""
		var writebutton =  document.getElementById("writeArticleButton")
		writebutton.style.display ="none"
		return;
}

//localStorage.getItem("item");  로컬 스토리지에서  값얻오기
</script>
</head>
<body style="">
    <!--  request로 저장 -->
	
		<input type="hidden" id="isUser" value="1"> <input
			type="hidden" id="boardId" value="389148">
		<aside class="none">
			<div class="title">
				<a class="hamburger"></a>
				<h1>
					<a href="/389148">{asd.title}</a>
				</h1>
			</div>
		</aside>
		<div class="wrap title">
			<h1>
				<a href="/389148">자유게시판</a>
			</h1>
			<hr>
		</div>
		<div class="wrap articles">
			<form class="write" style="display: none;">
				<p>
					<input name="title" placeholder="글 제목" class="title">
				</p>
				<p>
					<textarea name="text"
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
					<li title="완료" class="submit" ></li>
					<li title="익명" class="anonym"></li>
				</ul>
				<div class="clearBothOnly"></div>
			</form>
			<a id="writeArticleButton" onclick="javascript:writebtn();" >새 글을 작성해주세요!</a>
			
			<article>
				<a class="article" href="/389148/v/181438459"><div
						class="attachthumbnail"
						style="background-image: url('./더미이미지.jfif');"></div>
					<h2 class="medium">글의 제목이 들어가는 부분</h2>
					<p class="small">글의 내용이 들어가는 부분</p> <time class="small">temp</time>
					<h3 class="small">익명</h3>
					<ul class="status">
						<li class="attach">1</li>
						<li title="공감" class="vote">공감 value</li>
						<li title="댓글" class="comment">댓글 cnt value</li>
					</ul>
					<hr> <input type="hidden" name="181438459_comment_anonym"
					value="0"></a>
				<div class="comments"></div>
			</article>

			
			<div class="clearBothOnly"></div>
			<div class="pagination">
				<form id="searchArticleForm" class="search">
					<select name="search_type"><option value="4">전체</option>
						<option value="3">해시태그</option>
						<option value="2">글 제목</option>
						<option value="1">글 내용</option></select><input name="keyword"
						placeholder="검색어를 입력하세요." class="text">
				</form>
				<a href="/389148/p/2" class="next">다음</a>
			</div>
		</div> 
		<hr>

</body>

</html>