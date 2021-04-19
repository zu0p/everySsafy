<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>에브리싸피</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${root}/css/article.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/fa7b781275.js" crossorigin="anonymous"></script>
</head>
<body>
	<header class="title">
		<h1>김해사는포르쉐오너</h1>
	</header>
	<article>
		<div class="main">
			<div class="article_info">
				<div class="article_member">
					<i class="fas fa-portrait fa-4x"></i>
					<div class="profile">
						<h3>익명</h3>
						<time>방금</time>
					</div>
				</div>
				<div class="article_send">
					<a href="#">신고</a>
					<a href="#">쪽지</a>
				</div>
			</div>
			<div class="article_content">
				<p>샌즈 멈춰!!!</p>
			</div>
			<div class="article_cnt">
				
			</div>
		</div>
	</article>
</body>
</html>