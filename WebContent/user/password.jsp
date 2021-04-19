<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<%
	UserDto userDto = (UserDto) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 - 에브리타임</title>
<link rel="stylesheet" type="text/css" href="../css/nickName.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo_2.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.partial.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.community.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.article.css"/>
<script type="text/javascript">
		function changePassword(){
			if($('#newpassword').val()==''){
				alert('비밀번호는 4~20자까지 가능합니다.');
				$('#newpassword').focus();
				return;
			}
			if($('#newpasswordchk').val()==''||$('#newpassword'.val()!=$('newpasswordchk').val())){
				alert('입력하신 두 비밀번호가 일치하지 않습니다.');
				$('#newpasswordchk').focus();
				return;
			}
			if($('#password').val()==''){
				alert('현재 비밀번호를 입력해주세요.');
				$('#password').focus();
				return;
			}
			if($('password').val()!="${user.userPwd}"){
				alert('현재 비밀번호가 올바르지 않습니다.');
				$('#password').focus();
			}
			$('#changeNickForm').attr("action", "${root}/changePass.do").submit();
		}
</script>
</head>
<body>
<jsp:include page="/module/nav.jsp"></jsp:include>
	<form class="container" id="changePassForm" method="post" action="${root}/changePass.do">
		<section>
			<h1>비밀번호 변경</h1>
			<div class="input">
				<div class="label">
					<label>새 비밀번호</label>
					<p>4~20자</p>
				</div>
				<input type="password" id="newpassword" name="newuserPwd" maxlength="20"
					placeholder="새 비밀번호" class="">
				<!---->
				<input type="password" id="newpasswordchk" name="newuserPwdchk" maxlength="20"
					placeholder="새 비밀번호 확인" class="">
				<!---->
			</div>
			<div class="input">
				<div class="label">
					<label>현재 비밀번호</label>
				</div>
				<input type="password" id="password" name="userPwd" maxlength="20" placeholder="현재 비밀번호" class="">
			</div>
			<div class="rules">
				<p>
					<strong>※ 혹시 타인에게 계정을 양도하려고 하시나요?</strong><br> 에브리타임 이용약관에서는 타인에게 계정 판매, 양도 및 대여 등을 엄격하게
					금지하고 있습니다.<br> 모니터링 시스템에 의해 계정 양도가 적발될 경우
					해당 계정은 영구 정지, 탈퇴 등의 조치가 가해지며, 계정 양도로 인해 사기, 불법 행위가 발생할 경우 관련법에 따라 <span class="caution">법적 책임을 지게 될 수 있습니다.</span>
				</p>
				<p>
					<strong>※ 타인에 의한 계정 사용이 의심되시나요?</strong><br> 개인정보 보호를 위해 비밀번호를 변경하여 주시기 바랍니다. 비밀번호를
					변경하면 <span class="caution">모든 디바이스(앱,
						브라우저 등)에서 즉시 로그아웃 처리됩니다.</span>
				</p>
			</div>
			<input type="submit" value="비밀번호 변경">
		</section>
	</form>
</body>
</html>