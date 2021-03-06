<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="everyssafy.model.UserDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Every SSAFY</title>
<link rel="stylesheet" type="text/css" href="./css/common.css?after"/>
<link rel="stylesheet" type="text/css" href="./css/common.partial.css?after"/>
<link rel="stylesheet" type="text/css" href="./css/container.community.css?after"/>
<link rel="stylesheet" type="text/css" href="./css/container.article.css?after"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<jsp:include page="./module/nav.jsp"></jsp:include>
	<jsp:include page="./module/subnav.jsp"></jsp:include>
	<div id="container" class="community">
		<div class="context" id="changeable">
			<div class="leftside">
				<jsp:include page="./module/leftside.jsp"></jsp:include>
			</div>
			<div class="main">
				<jsp:include page="./page/main.jsp"></jsp:include>
			</div>
		</div>
		<div class="context">
			<div class="rightside">
				<jsp:include page="./module/rightside.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<jsp:include page="./module/footer.jsp"></jsp:include>
</body>
</html>