<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	UserDto userDto = (UserDto) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Every SSAFY-내 정보</title>
<link type="text/css" rel="stylesheet" href="./css/userinfo.css"/>
<link type="text/css" rel="stylesheet" href="./css/userinfo_2.css"/>
<link rel="stylesheet" type="text/css" href="./css/common.css"/>
<link rel="stylesheet" type="text/css" href="./css/common.partial.css"/>
<link rel="stylesheet" type="text/css" href="./css/container.community.css"/>
<link rel="stylesheet" type="text/css" href="./css/container.article.css"/>
</head>
<body>
	<jsp:include page="/module/nav.jsp"></jsp:include>
	<div class="mt-2">
		<div data-v-cd48e290="" class="container">
			<section data-v-cd48e290="">
				<div data-v-cd48e290="" class="title">
					<h1 data-v-cd48e290="">내 정보</h1>
					<a data-v-cd48e290="" href="/user/logout.do" class="logout">로그아웃</a>
				</div>
				<div data-v-cd48e290="" class="profile">
					<img data-v-cd48e290="" src="https://cf-fpi.everytime.kr/0.png">
					<h3 data-v-cd48e290="">${user.userId}</h3>
					<p data-v-cd48e290="">
						<span>${user.userName}</span>
					</p>
					<p data-v-cd48e290="">
						<span>${user.userNickName}</span>
					</p>
				</div>
			</section>
			<section data-v-cd48e290="">
				<h2 data-v-cd48e290="">계정</h2>
				<a data-v-cd48e290="" href="/auth" class="item">학교 인증</a>
				<a data-v-cd48e290="" href="/my/password" class="item">비밀번호 변경</a>
				<a data-v-cd48e290="" href="/my/email" class="item">이메일 변경</a>
			</section>
			<section data-v-cd48e290="" >
				<h2 data-v-cd48e290="" >커뮤니티</h2>
				<a data-v-cd48e290="" href="/nick.jsp" class="item">닉네임 설정</a>
				<a data-v-cd48e290="" href="/my/banlist" class="item">이용 제한 내역</a>
				<a data-v-cd48e290="" href="/my/boardlist" class="item">게시판 관리</a>
				<a data-v-cd48e290="" href="/page/rules" class="item">커뮤니티 이용규칙</a>
			</section>
			<section data-v-cd48e290="" >
				<h2 data-v-cd48e290="" >이용 안내</h2>
				<a data-v-cd48e290="" href="/page/faq" class="item">문의하기</a>
				<a data-v-cd48e290="" href="/notice" class="item">공지사항</a>
				<a data-v-cd48e290="" href="/page/serviceagreement" class="item">서비스이용약관</a>
				<a data-v-cd48e290="" href="/page/privacy" class="item">개인정보 처리방침</a>
			</section>
			<section data-v-cd48e290="">
				<h2 data-v-cd48e290="" >기타</h2>
				<a data-v-cd48e290="" href="/my/adagreement" class="item">정보 동의 설정</a>
				<a data-v-cd48e290="" href="/my/withdrawal" class="item">회원탈퇴</a>
			</section>
		</div>
	</div>
	<jsp:include page="./module/footer.jsp"></jsp:include>
</body>
</html>