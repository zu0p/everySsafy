<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/userinfo.css">
<link type="text/css" rel="stylesheet" href="./css/userinfo_3.css">

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
					<h3>alswn8972</h3>
					<p>
						<span>강민주</span> / <span>ㅎㅎ</span>
					</p>
					<p>
						<span>금오공대</span> <span data-v-cd48e290="">15</span>학번
					</p>
				</div>
			</section>
			<section>
				<h2>계정</h2>
				<a href="/auth" class="item">학교 인증</a> <a href="/my/password"
					class="item">비밀번호 변경</a> <a href="/my/email" class="item">이메일
					변경</a>
			</section>
			<section data-v-cd48e290="" >
				<h2 data-v-cd48e290="" >커뮤니티</h2>
				<a data-v-cd48e290="" href="/my/nickname" class="item">닉네임 설정</a>
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
			<section data-v-cd48e290="" >
				<h2 data-v-cd48e290="" >기타</h2>
				<a data-v-cd48e290="" href="/my/adagreement" class="item">정보 동의 설정</a>
				<a data-v-cd48e290="" href="/my/withdrawal" class="item">회원탈퇴</a>
			</section>
		</div>
		<%@ include file="/module/footer.jsp"%>
	</div>
</body>
</html>