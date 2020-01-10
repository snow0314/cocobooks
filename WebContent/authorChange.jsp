<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		body{
			background-color: #F2F2F2;
		}
	.txt{
		background-color: #2E9AFE;
		font-size: 80px;
		margin-left: 630px;
		margin-top: 170px;
		
	}
		.maintxt{
			font-size: 40px;
			margin-left: 500px;
			margin-top: 200px;
		}
		.btnBox{
			margin-left: 750px;
			margin-top: 200px;
		}
		.btn1{
			width: 200px;
			height: 100px;
			margin-right: 10px;
			font-size: 30px;
			border-radius: 200px;
			font-weight: bold;
			border: 0.5px solid black;
		}
		.btn2{
			width: 200px;
			height: 100px;
			margin-left: 10px;
			font-size: 30px;
			border-radius: 200px;
			font-weight: bold;
			border: 0.5px solid black;
		}
		
	</style>
</head>
<body>
	<form method="post">
	<div class="maintxt">신청하시면 관리자 검열 후 유료 작가로 전환 됩니다.</div>
	<div class="txt">신청하시겠습니까?</div>
	<div class="btnBox"><input type="submit" value="예" class="btn1" formaction="authorchangeinsert"> 
	<input type="submit" value="아니오" class="btn2" formaction="main"></div>
	</form>
</body>
</html>