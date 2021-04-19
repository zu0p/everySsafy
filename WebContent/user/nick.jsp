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
<link rel="stylesheet" type="text/css" href="../css/nickName.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo_2.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.partial.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.community.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.article.css"/>
<script type="text/javascript">
		function changeNick(){
			if($('#changeNick').val()==''){
				alert('2~10자까지 가증합니다.');
				$('#userId').focus();
				return;
			}
			$('#changeNickForm').attr("action", "${root}/changeNick.do").submit();
		}
</script>
</head>
<body>
	<jsp:include page="/module/nav.jsp"></jsp:include>
	<form id="chnageNickForm" method="post" action="${root}/userinfo.do"class="container">
		<section>
			<h1>닉네임 설정</h1>
			<div class="input">
				<div class="label">
					<label>닉네임</label>
				</div>
				<input type="hidden" id="userId" name="userId" placeholder="${user.userId}" autocomplete="off" class="">
				<input type="text" id="changeNick" name="changeNick" maxlength="10" placeholder="닉네임" autocomplete="off" class="">${user.userNickName}
			</div> 
			<div class="rules">
				<p>※ 닉네임을 설정하면 <span class="caution">30일간 변경할 수 없습니다.</span></p>
			</div>
			<input type="submit" value="닉네임 설정" onclick="javascript:changeNick()">
		</section>
	</form>
</body>
</html>