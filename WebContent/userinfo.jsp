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

<title>내 정보 - 에브리싸피</title>
<link type="text/css" rel="stylesheet" href="./css/userinfo.css">
<link type="text/css" rel="stylesheet" href="./css/userinfo_2.css">

</head>
<body>
	<div>
		<div class="container">
			<section>
				<div class="title">
					<h1>내 정보</h1>
					<a href="/user/logout.do" class="logout">로그아웃</a>
				</div>
				<div class="profile">
					<img src="https://cf-fpi.everytime.kr/0.png">
					<h3>${user.userId}</h3>
					<p>
						<span>${user.userName}</span>
					</p>
					<p>
						<span>${user.userNickName}</span>
					</p>
				</div>
			</section>
			<section>
				<h2>계정</h2>
				<a href="/auth" class="item">지역 인증</a>
				<a href="./user/password.jsp" class="item">비밀번호 변경</a>
				<a href="./user/email.jsp" class="item">이메일 변경</a>
			</section>
			<section>
				<h2>커뮤니티</h2>
				<a href="./user/nick.jsp" class="item">닉네임 설정</a>
				<a href="/my/banlist" class="item">이용 제한 내역</a>
				<a href="/my/boardlist" class="item">게시판 관리</a>
				<a href="/page/rules" class="item">커뮤니티 이용규칙</a>
			</section>
			<section>
				<h2>이용 안내</h2>
				<a href="/page/faq" class="item">문의하기</a>
				<a href="/notice" class="item">공지사항</a>
				<a href="/page/serviceagreement" class="item">서비스이용약관</a>
				<a href="/page/privacy" class="item">개인정보 처리방침</a>
			</section>
			<section>
				<h2>기타</h2>
				<a href="/my/adagreement" class="item">정보 동의 설정</a>
				<a href="./user/deleteUser.jsp" class="item">회원탈퇴</a>
			</section>
		</div>
		<%@ include file="/module/footer.jsp"%>
	</div>
</body>
</html>