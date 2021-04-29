<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>에브리싸피</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${root}/css/article.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/fa7b781275.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function addComment(){
			let content=$('#content').val();
			let user=${user};
			let article=${article};
			$ajax({
				url:'${root}RegisterComment.do',
				type:'post',
				data:{"content":content,"user":user,"article":article},
				dataType:'json',
				success:function(data){
					$('#commentContent').val("");
				}
			});
		}
		/* function goArticleList(event){
		    let boardId = event.id;
		    console.log(boardId);
		    $.ajax({
		        method: "GET",
		        data:{
		            boardId : "${boardId}"
		        },
		        url: "${root}/getlistArticle.do",
		        success: function(res){
		            console.log(res)
		            $('.changable').empty()    
		            
		            //let info = JSON.parse(res);
		            //console.log(info);
		            //console.log(info.user);
		            //$('.community').load("http://localhost:8080/tetetmp/"+info.path, function(){
		            //    $('#info-id').text(info.user.userId);
		            //    $('#info-name').text(info.user.userName);
		            //});
		        }
		    })
		} */
	</script>
</head>
<body>
	<header class="title">
		<h1>김해사는포르쉐오너</h1>
	</header>
	<article>
		<div class="main">
			<div class="article_info">
				<div class="article_member">
					<i class="fas fa-portrait fa-3x"></i>
					<div class="profile">
						<h3>${user.userName}</h3>
						<time>방금</time>
					</div>
				</div>
				<div class="article_send">
					<a href="#">쪽지</a>
					<a href="#">신고</a>
				</div>
			</div>
			<div class="article_content">
				<p>${article.articleContent }</p>
			</div>
			<div class="article_cnt">
			    <i class="far fa-star fa-1x">0</i>
				<i class="far fa-comment fa-1x">0</i>
				<i class="far fa-thumbs-up fa-1x">0</i>
			</div>
		</div>
		<c:forEach items="${commentList}" var="comment">
			<div class="main">
				<div class="comment_info">
					<div class="comment_member">
						<i class="fas fa-portrait fa-2x"></i>
						<div class="profile">
							<h3>${comment.userId }</h3>
						</div>
					</div>
					<div class="article_send">
						<a href="#">대댓글</a>
						<a href="#">공감</a>
						<a href="#">쪽지</a>
						<a href="#">신고</a>
					</div>
				</div>
				<div class="article_content">
					<p>${comment.commentContent }</p>
				</div>
				<time>방금</time>
			</div>
		</c:forEach>
		<form class="commentForm" id="commentForm" method="post" onsubmit="return false;">
			<div class="wraper input-group mb-4">
			  <input type="text" class="form-control bg-color" name="content" id="content" placeholder="댓글을 입력하세요">
	          <div class="form-check">
			    <label class="form-check-label">
			      <input type="checkbox" class="form-check-input" value="">익명
			    </label>
			  </div>
			  <div class="input-group-append">
			    <button class="btn btn-danger" type="button" onclick="javascript:addComment()"><i class="fas fa-pen 5x"></i></button>
			  </div>
			</div>
		</form>
	</article>
</body>
</html>