<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		.loginbox{
		display: flex;
			padding-top: 50px;
		}
		.text{
			width: 280px;
			height: 60px;
			border-radius: 8px;
			margin-left: 20px;
			font-size: 25px;
		}
		.loginbtn{
			width: 70px;
			background-color: #2E9AFE;
			color: white;
			font-size: 16px;
			border-radius: 8px;
		}
		.loginfooter{
			display: flex;
			margin-top: 20px;
			margin-left: 20px;
		}
		.signup,.find{
			width: 110px;
			font-size: 15px;
			margin-top: 50px;
			margin-left: 3px;
			margin-right: 3px;
			height: 40px;
			border-radius: 8px;
			border :1px solid grey;
			font-family: fantasy;
			font-weight: 500;
		}
		.loginboxtotal{
			border: 2px solid #F2F2F2;
			width: 400px;
			margin-left: 20px;
			background-color: #F2F2F2;
			height: 300px
		}
		
	</style>
</head>
<body>
<body>
<form method="post">
	<div class="loginboxtotal">
	<div class="loginbox">
	<div class="logintext">
	<div><input type="text" placeholder="아이디" class="text" name="id"></div>
	<div><input type="password" placeholder="비밀번호" class="text" name="pw"></div>
	</div>
	<input type="submit" value="로그인" class="loginbtn" formaction="login">
	</div>
	<div class="loginfooter">
	<div><input type="submit" valuegit="간편 회원가입" class="signup" formaction="signup"></div>
	<div><input type="submit" value="아이디 찾기" class="find" formaction="idsearch"></div>
	<div><input type="submit" value="비밀번호 찾기" class="find" formaction="pwsearch"></div>
	</div>
	</div>
	</form>
</body>
</body>
</html>