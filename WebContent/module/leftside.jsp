<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<%
	UserDto userDto = (UserDto) session.getAttribute("user");
%>
			  <div class="card pconly">
		        <form class="logged">
		          <img src="https://cf-fpi.everytime.kr/0.png" class="picture">
		          <p class="nickname">${user.userNickName}</p>
		          <p class="school">${user.userName}</p>
		          <p class="school">zu0p</p>
		          <ul class="buttons">
		            <li><a href="/my">내 정보</a></li>
		            <li><a href="/user?act=logout">로그아웃</a></li>
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