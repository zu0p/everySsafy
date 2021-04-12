<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<title>에브리 싸피 로그인</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${root}/css/registerUser.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/fa7b781275.js" crossorigin="anonymous"></script>
</head>
<body>
	<div id="container">
		<form class="registerForm">
			<input type="hidden" name="action" id="action" value="register">
			<div class="form-group">
				<label for="userId"> 아이디 :</label>
				<input type="text" class="form-control" id="userId" name="userId" placeholder="아이디">
				<input class="btn btn-danger btn-block" onclick="javascript:checkId()">중복확인</button>
			</div>
			<div class="form-group">
				<label for="userPwd"> 비밀번호 :</label>
				<input type="password" class="form-control" id="userpwd" name="userPwd" placeholder="비밀번호">
			</div>
			<div class="form-group">
				<label for="userName"> 이름 :</label>
				<input type="text" class="form-control" id="userName" name="userName" placeholder="이름">
			</div>
			<div class="form-group">
				<label for="userNickName"> 닉네임 :</label>
				<input type="text" class="form-control" id="userNickName" name="userNickName" placeholder="닉네임">
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-danger btn-block" onclick="javascript:void()">회원가입</button>
			</div>	
		</form>
	</div>

</body>
</html>