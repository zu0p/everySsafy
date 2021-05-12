<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<% 
String root = request.getContextPath();
pageContext.setAttribute("root", root);
%>
<script type="text/javascript">
function goArticleList(event){
	let boardId = event.id;
	let Data = {"boardId" : boardId};
	console.log(boardId);
	let title = "";
	$.ajax({
		method: "GET",
		data: Data,
		url: "${root}/getBoardTitle.do",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		datatype: boardId,
		success: function(res){
			console.log(res);
			title = res;
		}
	})
	$.ajax({
		method: "GET",
		data: Data,
		url: "${root}/getlistArticle.do",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		datatype: 'JSON',
		success: function(res){
			//console.log(res)
			$('#changeable').empty()	
			
			let info = JSON.parse(res);
			//console.log(info);
			//console.log(info.user);
			//let curClass = $('#changeable').attr('class');
			//console.log("before: "+curClass);
			//console.log("after: "+$('#changeable').attr('class'));
			$('#changeable').load("http://localhost:8080/tetetmp"+info.path, function(){
				//$('#info-id').text(info.user.userId);
				//$('#info-name').text(info.user.userName);
				$('#articleName').text(title);
				$('#articleName').val(boardId);
				//console.log($('#articleName').val())
				$.each(info.list, function(index, item){
					let newArticle = `

						<article>
							<a class="article" href="/389148/v/181438459">
							<div class="attachthumbnail"
									style="background-image: url('./더미이미지.jfif');">
							</div>
							<h2 class="medium">제목 : ${'${item.articleTitle}'} </h2>
							<p class="small">내용: ${'${item.articleContent}'} </p> <time class="small">${'${item.articleDate}'}</time>
							<h3 class="small">${'${item.userId}'}</h3>
							<ul class="status">
								<li title="공감" class="vote">${'${item.articleLike}'} </li>
								<li title="댓글" class="comment"> ${'${item.Comcnt}'} </li>
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
function loadComment(target){
	let id=$(target).children('h2').attr("id");
	let content=$(target).children('p').text();
	let userId=$(target).children('h3').text();
	let boardName=$('#articleName').text();
	let like=$(target).children('ul').children('.vote').val();
	let commentCnt=$(target).children('ul').children('.comment').val();

	$.ajax({
		url:'${root}/getlistcommnet.do',
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		data:{"articleId":id},
		datatype: 'JSON',
		method:'get',
		success:function(data){
			let info = JSON.parse(data);
			console.log(info);
			$('#changeable').empty();
			$('#changeable').addClass("articles");//뭐해야함?
			$('#changeable').load("http://localhost:8080/tetetmp"+info.path, function(){
				let titleStr=`
					<h1 id="boardTitle">${'${boardName}'}</h1>
					`;
				$('.title').append(titleStr);
				let articleStr=`
					<div class="article_info" id=${'${id}'}>
					<div class="article_member">
						<i class="fas fa-portrait fa-3x"></i>
						<div class="profile">
							<h3 id="articleUserName">${'${userId}'}</h3>
							<time>방금</time>
						</div>
					</div>
					<div class="article_send">
						<a href="#">쪽지</a>
						<a href="#">신고</a>
					</div>	
				</div>
				<div class="article_content">
					<p id="articleContent">${'${content}'}</p>
				</div>
				<div class="article_cnt">
				    <i class="far fa-star fa-1x"></i>
					<i class="far fa-comment fa-1x">${'${commentCnt}'}</i>
					<i class="far fa-thumbs-up fa-1x">${'${like}'}</i>
				</div>
			`;
			$('.main').append(articleStr);
				$.each(info.list,function(index,comment){
					let str=`
						<li>
						<div class="main">
							<div class="comment_info">
								<div class="comment_member">
									<i class="fas fa-portrait fa-2x"></i>
									<div class="profile">
										<h3>${'${comment.userId }'}</h3>
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
								<p>${'${comment.commentContent }'}</p>
							</div>
							<time>${'${comment.commentDate}'}</time>
						</div>
					</li>
					`;
					$('#list').append(str);
				})
			});
		}
	});
}

	$(document).ready(function(){
		var ele = document.getElementsByClassName('board');
		console.log(ele);
		$.each(ele, function(index, myele){
			console.log(myele.length);
			var curId = $(myele).attr("data-id");
			console.log(curId);
				  $.ajax({
						method: "GET",
						data: {"boardId" : curId},
						url: "${root}/getBoardList.do",
						contentType: "application/x-www-form-urlencoded; charset=UTF-8",
						datatype: 'JSON',
						async:false,
						success: function(res){
							//console.log(res);
							let info = JSON.parse(res);					
								$.each(info.list, function(index, item){
									console.log(item);
									let getBoard = `
										<a class="list" href="/389148/v/181814276">
											<time>${'${item.articleDate}'}</time><p>${'${item.articleTitle}'}</p><hr>
										</a>`;
									$(`#${'${curId}'}-board`).append(getBoard);
								})
							}
						})
			  // 컬렉션 내의 모든 노드를 보여줍니다.
			})
		// Handler for .ready() called.
		
	});

</script>
<div class="card">
		<div class="board" id="101-board" data-id="101">
			<h3><a id="101" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">자유게시판</a></h3>

		</div>
</div>
<div class="card">
	<div class="board" id="102-board" data-id="102">
		<h3><a id="102" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">비밀게시판</a></h3>
		</div>
	</div>
<div class="card">
  <div class="board" id="103-board" data-id="103">
	  <h3><a id="103" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">졸업생게시판</a></h3>		
  </div>
</div>
<div class="card">
	<div class="board" id="104-board" data-id="104">
		<h3><a id="104" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">새내기게시판</a></h3>
	</div>
</div>