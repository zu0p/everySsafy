<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			$('#changeable').addClass("articles");
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

			<div class="card">
				<div class="board">
					<h3><a id="101" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">자유게시판</a></h3>
					<a class="list" href="/389148/v/181814276">
						<time>방금</time><p>취향</p><hr>
					</a>
					<a class="list" href="/389148/v/181811769">
						<time>방금</time><p>오늘</p><hr>
					</a>
					<a class="list" href="/389148/v/181809613">
						<time>방금</time><p>코로나 2단계 각인가</p><hr>
					</a>
					<a class="list" href="/389148/v/181808170">
						<time>방금</time><p>오늘 학교 앞</p><hr>
					</a>
				</div>
			</div>
			<div class="card">
				<div class="board">
					<h3><a id="102" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">비밀게시판</a></h3>
					<div class="needauth">
						<p>로그인을 한 학생들만<br>이용할 수 있어요!</p>
						<a class="button" href="/login">로그인</a>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="board">
					<h3><a id="103" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">졸업생게시판</a></h3>
					<a class="article" href="/389425/v/181799554">
						<p>저는 4학년 전자통신쪽 인데요<br>졸업진로를 반도체나 태양광 혹은 통신 생각하고 있습니다.<br>전기기사나 공사기사는 공기업빼고는 사기업에선<br>필요가 없더</p>
						<time>방금</time>
						<ul class="status">
							<li class="vote active">1</li>
							<li class="comment active">1</li>
						</ul>
						<hr>
					</a>
					<a class="article" href="/389425/v/181607909">
						<p>공대 대학원으로 가볼만한 마지노선이 <br>어디까지라 생각하시나요??<br>서카포연고까지 인가요?<br>한양중앙라인은 메리트가 없을려나요..</p>
						<time>04/08 03:13</time>
						<ul class="status">
							<li class="vote active">0</li>
							<li class="comment active">10</li>
						</ul>
						<hr>
					</a>
				</div>
			</div>
			<div class="card">
				<div class="board">
					<h3><a id="104" href="javasrcipt:void(0)" onclick="goArticleList(this); return false;">새내기게시판</a></h3>
					<a class="article" href="/389237/v/181814899">
						<p>내일 불금 선착 2명 술사줌 쪽지 ㄱ</p>
						<time>방금</time>
						<ul class="status">
							<li class="vote active">0</li>
							<li class="comment active">0</li>
						</ul>
						<hr>
					</a>
					<a class="article" href="/389237/v/181779638">
						<p>기초학력평가 비대면 신청은 그냥 자기가 원하는 날짜 쓰면 되는거야?</p>
						<time>방금</time>
						<ul class="status">
							<li class="vote active">0</li>
							<li class="comment active">2</li>
						</ul>
						<hr>
					</a>
				</div>
			</div>