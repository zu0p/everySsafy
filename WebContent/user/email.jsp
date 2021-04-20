<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<%
	UserDto userDto = (UserDto) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 변경 - 에브리싸피</title>
<link rel="stylesheet" type="text/css" href="../css/email.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo_2.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.partial.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.community.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.article.css"/>
</head>
<body>
<jsp:include page="/module/nav.jsp"></jsp:include>
	<form class="container">
		<section>
			<h1>이메일 변경</h1>
			<div class="input">
				<div class="label">
					<label>이메일</label>
				</div>
				<input type="email" maxlength="255"
					placeholder="이메일이 없다..${user.nickName}" autocomplete="off" class="">
				<!---->
			</div>
			<div class="input">
				<div class="label">
					<label>계정 비밀번호</label>
				</div>
				<input type="password" maxlength="20"
					placeholder="계정 비밀번호" class="">
			</div>
			<div class="rules">
				<p>
					※ 반드시 본인의 이메일을 입력해주세요.<br> ※ 계정 분실 시
					아이디/비밀번호 찾기, 개인정보 관련 주요 고지사항 안내 등에 사용됩니다.
				</p>
			</div>
			<input type="submit" value="이메일 변경">
		</section>
	</form>
</body>
</html>