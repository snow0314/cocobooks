<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #F2F2F2;
}

.logOutBtn {
	border-radius: 7px;
	margin-left: 39px;
	width: 220px;
		height: 34px;
	background-color: #2E9AFE;
	font-size: 15px;
	font-weight: 700;
	color: cornsilk;
	margin-top: 10px;
}

.admin {
	border-radius: 7px;
	margin-left: 39px;
	width: 220px;
		height: 34px;
	background-color: #2E9AFE;
	font-size: 15px;
	font-weight: 700;
	color: cornsilk;
	margin-top: 10px;
}

.myPage {
	border-radius: 7px;
	margin-left: 39px;
	width: 220px;
		height: 34px;
	background-color: #2E9AFE;
	font-size: 15px;
	font-weight: 700;
	margin-top: 75px;
	color: cornsilk;
}

.userId {
	margin-left: 64px;
	margin-top: 20px;
	font-weight: bold;
	font-size: 22px;
	color: graytext;
}

.myCoin {
	margin-left: 67px;
	margin-top: 50px;
	font-weight: 700;
	color: graytext;
	display: flex;
	font-size: 20px;
}
.sucsessBox{
		margin-top: 70px;
		margin-left: 35px;
	}
	.coinTxt{
	color:gold;
	padding-left: 5px;
	padding-right: 5px;
	}
</style>
</head>
<body>
	<form>
		<div class="sucsessBox">
		<div class="userId">${id}님 환영합니다.</div>
		<div>
		<div class="myCoin">내 코인:<div class="coinTxt">${coin}</div>개</div>
		</div>
		<div>
			<input type="submit" formaction="myPage" value="마이 페이지"
				class="myPage">
		</div>
		<div>
			<input id="admin" type="submit" formaction="admin" value="관리자 모드"
				class="admin">
		</div>
		<div>
			<input type="submit" formaction="logout" value="로그아웃"
				class="logOutBtn">
		</div>
		</div>
	</form>
	<script type="text/javascript">
		var kind = "${kind}"
		console.log(kind);
		if (kind == "관리") {
			document.getElementById("admin").style.display = "";
		} else if (kind == "일반") {
			document.getElementById("admin").style.display = "none";
		}
	</script>
</body>
</html>