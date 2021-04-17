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
</head>
<body>
	<jsp:include page="/module/nav.jsp"></jsp:include>
	<form data-v-34dbaf39="" class="container">
		<section data-v-34dbaf39="">
			<h1 data-v-34dbaf39="">닉네임 설정</h1>
			<div data-v-34dbaf39="" class="input">
				<div data-v-34dbaf39="" class="label">
					<label data-v-34dbaf39="">${ user.nickName}</label>
				</div>
				<input data-v-34dbaf39="" type="text" maxlength="10" placeholder="닉네임" autocomplete="off" class="">
			</div> 
			<div data-v-34dbaf39="" class="rules">
				<p data-v-34dbaf39="">※ 닉네임을 설정하면 <span data-v-34dbaf39="" class="caution">30일간 변경할 수 없습니다.</span></p>
			</div>
			<input data-v-34dbaf39="" type="submit" value="닉네임 설정">
		</section>
	</form>
</body>
</html>