<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<style>
		body{
			background-color: #F2F2F2;
		}
		.myNovel,.Favorites,.profile,.buyList,.chargeList,.chargeCoin,.changeKind{
			width: 200px;
			height: 130px;
			background-color: white;
			font-size: 30px;
			font-family: fantasy;
			font-weight: 700;
			border-radius: 17px;
		}
		.myPageMainText{
			font-size: 50px;
			margin-left: 680px;
			font-family: fantasy;
			font-weight: 700;
		}
		.contents{
			border: 2px solid black;
			width: 1500px;
			height: 880px;
			margin-top: 20px;
			margin-left: 30px;
		}
		.totalBox{
			display: flex;
		}
	</style>
</head>
<body>
<div class="myPageMainText">${id}님의 마이 페이지</div>
<form method="post">
	<div class="totalBox">
	<div class="BtnBox">
	<div><input type="submit" value="내 작품" class="myNovel"></div>
	<div><input type="submit" value="선호작" class="Favorites"></div>
	<div><input type="submit" value="프로필" class="profile"></div>
	<div><input type="submit" value="구매목록" class="buyList"></div>
	<div><input type="submit" value="충전내역" class="chargeList" formaction="charge"></div>
	<div><input type="submit" value="결제하기" class="chargeCoin" formaction="payment"></div>
	<div><input type="submit" value="전환신청" class="changeKind"></div>
	</div>
	<div class="contents"></div>
	</div>
	</form>
</body>
</html>