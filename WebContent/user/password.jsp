<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>비밀번호 변경 - 에브리싸피</title>
<link rel="stylesheet" type="text/css" href="../css/password.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo.css"/>
<link type="text/css" rel="stylesheet" href="../css/userinfo_2.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.partial.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.community.css"/>
<link rel="stylesheet" type="text/css" href="../css/container.article.css"/>
</head>
<body>
	<jsp:include page="/module/nav.jsp"></jsp:include>
	<form data-v-e7756488="" class="container">
		<section data-v-e7756488="">
			<h1 data-v-e7756488="">비밀번호 변경</h1>
			<div data-v-e7756488="" class="input">
				<div data-v-e7756488="" class="label">
					<label data-v-e7756488="">새 비밀번호</label>
					<p data-v-e7756488="">4~20자</p>
				</div>
				<input data-v-e7756488="" type="password" maxlength="20"
					placeholder="새 비밀번호" class=""> <input data-v-e7756488=""
					type="password" maxlength="20" placeholder="새 비밀번호 확인" class="">
			</div>
			<div data-v-e7756488="" class="input">
				<div data-v-e7756488="" class="label">
					<label data-v-e7756488="">현재 비밀번호</label>
				</div>
				<input data-v-e7756488="" type="password" maxlength="20"
					placeholder="현재 비밀번호" class="">
			</div>
			<div data-v-e7756488="" class="rules">
				<p data-v-e7756488="">
					<strong data-v-e7756488="">※ 혹시 타인에게 계정을 양도하려고 하시나요?</strong> <br
						data-v-e7756488=""> 에브리타임 이용약관에서는 타인에게 계정 판매, 양도 및 대여 등을 엄격하게
					금지하고 있습니다. <br data-v-e7756488=""> 모니터링 시스템에 의해 계정 양도가 적발될 경우
					해당 계정은 영구 정지, 탈퇴 등의 조치가 가해지며, 계정 양도로 인해 사기, 불법 행위가 발생할 경우 관련법에 따라 <span
						data-v-e7756488="" class="caution">법적 책임을 지게 될 수 있습니다.</span>
				</p>
				<p data-v-e7756488="">
					<strong data-v-e7756488="">※ 타인에 의한 계정 사용이 의심되시나요?</strong> <br
						data-v-e7756488=""> 개인정보 보호를 위해 비밀번호를 변경하여 주시기 바랍니다. 비밀번호를
					변경하면 <span data-v-e7756488="" class="caution">모든 디바이스(앱,
						브라우저 등)에서 즉시 로그아웃 처리됩니다.</span>
				</p>
			</div>
			<input data-v-e7756488="" type="submit" value="비밀번호 변경">
		</section>
	</form>
</body>
</html>