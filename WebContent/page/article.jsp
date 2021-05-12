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
		function addComment(){ //댓글 추가하는거 테스트 해봐야함
			let userId=$()
			let addContent=$('#content').val();
			let addArticleId=$('.article_info').attr('id');
			$.ajax({
				url:'${root}/registerComment.do',
				method:'get',
				data:{"content":addContent,"user":"${user}","article":addArticleId},
				dataType:'json',
				success:function(data){
					if(data!="1") return;
					$('#commentContent').val("");
					$('#list').append(`
							<li>
								<div class="main">
									<div class="comment_info">
										<div class="comment_member">
											<i class="fas fa-portrait fa-2x"></i>
											<div class="profile">
												<h3>${user.userId}</h3>
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
										<p>${'${addContent}'}</p>
									</div>
									<time>방금</time>
								</div>
							</li>
					`);
					$('#content').val('');
				}
			});
		}
	</script>
</head>
<body>
	<header class="title">
		
	</header>
	<article>
		<div class="main">
		</div>
		<ul id="list">
		</ul>

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