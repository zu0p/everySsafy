<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<% 
String root = request.getContextPath();
pageContext.setAttribute("root", root);
%>
			  <div class="card pconly">
		        <form class="logged">
		          <img src="https://cf-fpi.everytime.kr/0.png" class="picture">
		          <p class="nickname">${ user.userId }</p>
		          <p class="school">${ user.userName }</p>
		          <p class="school">${ user.userNickName }</p>
		          <ul class="buttons">
		            <li><a href="${root}/mypage.do">내 정보</a></li>
		            <li><a href="${root}/logout.do">로그아웃</a></li>
		          </ul>
		          <hr>
		        </form>
		      </div>
		      <div class="card">
		        <div class="menus">
		          <a href="/myarticle" class="myarticle">내가 쓴 글</a>
		          <a href="/mycommentarticle" class="mycommentarticle">댓글 단 글</a>
		          <a href="/myscrap" class="myscrap">내 스크랩</a>
		          <hr>
		        </div>
		      </div>