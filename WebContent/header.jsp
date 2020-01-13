<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
	<style>
body{
background-color: #F2F2F2;}
		.header_logo{
			padding-left: 650px;
			position: absolute;
		}
		.header_image
		{	
			width: 400px;
			height: 200px;
		}
		.header_menu{
			position: relative;
			display: flex;
			font-size: 15px;
			padding-left: 1200px;
			font-family: fantasy;
			
		}
		.header_item{
			padding-left: 9px;
			border: 0;
			font-size: 15px;
		}
		.header_search
		{
			padding-left: 1180px;
			position: relative;
			padding-top: 140px;
		}
		.main_menu
		{	
		display: flex;
		margin-top: 17px;
		background-color: #2E9AFE;
		color: #EFF5FB;
		border: 1px solid #2E9AFE;
		border-radius: 8px;
		
		}
		.menu{
			padding-left: 320px;
			font-size: 20px;
			font-family:sans-serif;
			font-weight: 600;
		}
		.search_text{
			padding: 7px;
			border-radius: 7px;
		}
		.search_button{
			padding: 5px;
			background-color:#2E9AFE;
			font-weight: 550;
			color: #EFF5FB;
			border: 0.5px solid #2E9AFE;
		}
		.freeWeb{
			font-size: 20px;
			font-family:sans-serif;
			font-weight: 600;
			border: 0px;
			background-color:#2E9AFE;
			color: #EFF5FB;
		}
	</style>
</head>
<body>
	<form method="post">
	<div class="header_menu">
		<div class="header_item"><input type="submit" value="&#124; 메인으로" formaction="main" class="header_item"></div>
	<div class="header_item">&#124; 로그인</div>
	<div class="header_item">&#124; 회원가입</div>
	<div class="header_item">&#124; 결제하기 </div>
	<div class="header_item">&#124; 관리자 기능</div>
	</div>
	<div class="header_logo">
	<img src="image/logo.png" class="header_image" alt="logo">
	</div>
	<div class="header_search">
		<input type="text" placeholder="작품명,작가명" class="search_text">
		<input type="submit" value="통합검색" class="search_button" formaction="#">
	</div>
   
	<div class="main_menu">
		<div class="menu"><input type="submit" value="무료 웹소설" class="freeWeb" formaction="freewebfiction"></div>
		<div class="menu"><input type="submit" value="유료 웹소설" class="freeWeb" formaction="faidewebfiction"></div>
		<div class="menu">독자 게시판</div>
	</div>
	</form>
	<script type="text/javascript">
	var login="${login}"
	console.log("${login}");
	if(login=="로그인후 이용해주세요"){
		alert("${login}");
	}
	</script>
	
	<script type="text/javascript">
	function img_main(){
		location.href="main";
	}
	</script>
</body>
</html>