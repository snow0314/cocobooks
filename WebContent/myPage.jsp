<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
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
		table{
		width:100%;
		height: 100%;
		text-align: center;
			}
		.idbox,.nameBox,.ageBox,.emailBox,.coinBox,.kindBox,.applyBox
		{
			display: flex;
		}
		.idtxt1,.nametxt1,.agetxt1,.emailtxt1,.cointxt1,.kindtxt1,.applytxt1{
			font-size: 40px;
			padding: 20px;
			margin-left: 100px;
			color: #2E9AFE;
		}
		.idtxt2,.nametxt2,.agetxt2,.emailtxt2,.cointxt2,.kindtxt2,.applytxt2{
			font-size: 30px;
			padding: 30px;
		}
		a{ cursor: pointer;}
		
	</style>
</head>
<body>
<div class="myPageMainText">${id}님의 마이 페이지</div>
<form method="post">
	<div class="totalBox">
	<div class="BtnBox">
	<div><input type="submit" value="내 작품" class="myNovel"></div>
	<div><input type="submit" value="선호작" class="Favorites"></div>
	<div><input type="button" value="프로필" class="profile" id="profile"></div>
	<div><input type="submit" value="구매목록" class="buyList"></div>
	<div><input type="button" value="충전내역" class="chargeList" id="chargeList"></div>
	<div><input type="submit" value="결제하기" class="chargeCoin" formaction="payment"></div>
	<div><input type="submit" value="전환신청" class="changeKind" id="changeKind" formaction="authorchange"></div>
	</div>
	<div class="contentsbox">
	<div class="contents" id="content"></div>
	<div id="bottom"></div>
	</div>
	</div>
	</form>
	<script type="text/javascript" src="jsFile/chargeList.js">
	</script>
	<script type="text/javascript" src="jsFile/profile.js">
	</script>
	<script type="text/javascript">
	var msg="${msg}";
	if(msg=="신청이 완료 되었습니다."){
		alert("${msg}");
	}
	</script>
</body>
</html>