<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%UserDto userDto = (UserDto) session.getAttribute("user");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 - 에브리싸피</title>
<link rel="stylesheet" type="text/css" href="../css/nickName.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo_2.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.partial.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.community.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.article.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script type="text/javascript">
	function delUser(){
		if($('#userPwd').val()==''){
			alert("계정 비밀번호를 입력해주세요.");
			$('#userPwd').focus();
			return;
		}
		if($('#userPwd').val()!="${user.userPwd}"){
			alert("탈퇴 전 안내사항을 반드시 확인 후 진행해주세요. 탈퇴하시겠습니까?");
			alert("계정 비밀번호가 올바르지 않습니다.");
			$('#userPwd').focus();
			return;
		}
		alert("탈퇴하셨씁니다. 앞으로 저희 서비스 이용하지 마세요 ㅋㅋ");
		$('#deleteUserForm').submit();
	}
</script>
</head>
<body>
<jsp:include page="/module/nav.jsp"></jsp:include>
	<form class="container" id="deleteUserForm" method="post" action="${root}/deleteUser.do">
		<section>
			<h1>회원 탈퇴</h1>
			<div class="input">
				<div class="label">
					<label>계정 비밀번호</label>
				</div>
				<input type="password" maxlength="20" placeholder="계정 비밀번호" id="userPwd" name="userPwd">
			</div>
			<div class="rules">
				<!---->
				<p>
					※ 탈퇴 및 가입을 반복할 경우, 서비스 악용 방지를 위해 재가입이 제한됩니다. 최초 탈퇴 시에는 가입 시점을 기준으로
					1일간 제한되며, 2회 이상 탈퇴를 반복할 경우 30일간 제한됩니다.<br>
					<!---->
				</p>
				<p>
					※ 탈퇴 후 개인 정보, 시간표 등의 데이터가 삭제되며, 복구할 수 없습니다.<br>
					※ 다시 가입하여도, 게시판 등 이용 제한 기록은 초기화되지 않습니다.<br>
					※ 작성한 게시물은 삭제되지 않으며, (알수없음)으로 닉네임이 표시됩니다.<br>
					※ 자세한 내용은 개인정보처리방침을 확인해주세요.
				</p>
			</div>
			<input type="button" value="회원 탈퇴" onclick="javascript:delUser()">
		</section>
	</form>
</body>
</html>