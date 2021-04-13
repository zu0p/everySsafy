<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>에브리 싸피 로그인</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${root}/css/login.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/fa7b781275.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function login(){
			if($('#loginForm'))
		}
		
	</script>
</head>
<body>
	<h1>에러 멈춰!!</h1>
	<!-- 인덱스 페이지  -->
	<!-- 로그인,회원가입,아이디/비밀번호 찾기 이용 -->
	<!-- 로그인해야 사이트 이용가능 -->
	<div id="container">
		<div class="logoPart">
			<i class="fas fa-user-secret fa-10x">
				<span>지금 에브리싸피를 시작해보세요!!</span>
			</i>
		</div>		
		<form id="loginForm" method="post">
			<input type="hidden" name="act" id="act" value="login">
			<div class="form-group">
				<input type="text" class="form-control" id="userId" name="userId" placeholder="아이디">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="비밀번호">
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-danger btn-block" onclick="javascript:login()">로그인</button>
			</div>			
			<div class="form-check">
				<label class="form-check-label">
					<input type="checkbox" class="form-check-input" value="idSafe">로그인 유지
				</label>
				<a href="findUser.jsp">아이디/비밀번호 찾기</a>
			</div>
		</form>
		<div class="registerLabel">
			<span>에브리싸피가 처음 이신가요?</span>
			<a href="registerUser.jsp">회원가입</a>				
		</div>
	</div>

</body>
</html>