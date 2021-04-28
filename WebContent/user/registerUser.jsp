<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>에브리 싸피 회원가입</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${root}/css/registerUser.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/fa7b781275.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
		function register(){
			let checkId=RegExp( /^[a-zA-Z]+[A-Za-z0-9_]{5,15}$/gi);
			if($('#userId').val()==''){
				alert('아이디 비우는 행위 멈춰!!');
				$('#userId').focus();
				return;
			}
			if(!checkId.test($('#userId').val())){
				alert('아이디는 영문자로 시작하며 대소문자를 구분하지 않으며 숫자와 특수문자_를 포함가능합니다.');
				$('#userId').val('');
				$('#userId').focus();
				return;
			}
			if($('#userPwd').val()==''){
				alert('비밀번호 비우는 행위 멈춰!!');
				$('#userPwd').focus();
				return;
			}
			if($('#chkPwd').val()==''){
				alert('비밀번호 확인 비우는 행위 멈춰!!');
				$('#chkPwd').focus();
				return;
			}
			if($('#chkPwd').val()!=$('#userPwd').val()){
				alert('비밀번호가 다릅니다!!');
				$('#chkPwd').focus();
				return;
			}
			if($('#userName').val()==''){
				alert('이름 비우는 행위 멈춰!!');
				$('#userName').focus();
				return;
			}
			if($('#userNickName').val()==''){
				alert('닉네임 비우는 행위 멈춰!!');
				$('#userNickName').focus();
				return;
			}
			if(!chkIdFlag) return;
			$("#registerForm").attr("action", "${root}/register.do").submit();
		}
		function checkUserId(){
			$.ajax({
				url:'${root}/chkId.do',
				method:'post',
				data:{
					"userId":$('#userId').val()
				},
				dataType:'json',
				success:function(data){
					alert('1');
					if(data==0){
						alert('이미 존재하는 아이디 입니다.');
						$('#userId').focus();
					}else{
						chkIdFlag=true;
						alert('사용 가능한 아이디 입니다.');
						$('#userId').attr('readonly',true);
					}
				}
			});	
		}
		 
	</script>
</head>
<body>
	<div id="container">
		<h1>건강하세요</h1>
		<form id="registerForm"  method="post" >
			<input type="hidden" name="act" id="act" value="register">
			<div class="idGroup form-group">
				<label for="userId"> 아이디</label>
				<input type="text" class="form-control" id="userId" name="userId" placeholder="아이디">
				<button class="btn btn-danger " onclick="javascript:checkId()">중복확인</button>
			</div>
			<div class="form-group">
				<label for="userPwd"> 비밀번호</label>
				<input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="비밀번호">
			</div>
			<div class="form-group">
				<label for="userPwd"> 비밀번호확인</label>
				<input type="password" class="form-control" id="chkPwd" name="chkPwd" placeholder="비밀번호확인">
			</div>
			<div class="form-group">
				<label for="userName"> 이름</label>
				<input type="text" class="form-control" id="userName" name="userName" placeholder="이름">
			</div>
			<div class="form-group">
				<label for="userNickName"> 닉네임</label>
				<input type="text" class="form-control" id="userNickName" name="userNickName" placeholder="닉네임">
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-danger btn-block" onclick="javascript:register()">회원가입</button>
			</div>	
		</form>
	</div>

</body>
</html>