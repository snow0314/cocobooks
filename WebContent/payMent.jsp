<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: #F2F2F2;
}

.coin1 {
	display: flex;
	margin-left: 30px;
	margin-top: 80px;
}

.img1000c, .img2000c, .img3000c, .img5000c, .img10000c, .img30000c,
	.img50000c, .img100000c {
	width: 170px;
	height: 100px;
}

.radioc {
	margin-top: 45px;
	margin-right: 20px;
	margin-left: 20px;
}

.chargeMainText {
	font-size: 60px;
	margin-left: 750px;
	margin-top: 130px;
}

.chargeBox1 {
	margin-left: 400px;
	margin-top: 70px;
	border: 1px solid black;
	width: 1000px;
	height: 500px;
	border-radius: 40px;
}

.chargeBoxText {
	font-size: 30px;
	margin-left: 440px;
	font-family: fantasy;
	margin-top: 28px;
}

.radiod {
	margin: 13px;
}

.coin2 {
	margin-top: 70px;
	margin-left: 50px;
}

.footerBox {
	margin-left: 700px;
	margin-top: 40px;
}

.chargeBtn {
	width: 200px;
	height: 100px;
	font-size: 40px;
	border-radius: 8px;
	border: 2px solid black;
}

.cancelBtn {
	width: 200px;
	height: 100px;
	font-size: 40px;
	border-radius: 8px;
	border: 2px solid black;
}
</style>
</head>
<body>
	<form method="post">
		<div class="chargeMainText">결제 페이지</div>
		<div class="chargeBox1">
			<div class="chargeBoxText">결제 금액</div>
			<div class="coin1">
				<input type="radio" name="radio" value="1000" class="radioc">
				<img src="image/1000.png" class="img1000c"> <input
					type="radio" name="radio" value="2000" class="radioc"> <img
					src="image/2000.png" class="img2000c"> <input type="radio"
					name="radio" value="3000" class="radioc"> <img
					src="image/3000.png" class="img3000c"> <input type="radio"
					name="radio" value="5000" class="radioc"> <img
					src="image/5000.png" class="img5000c">
			</div>
			<div class="coin2">
				<input type="radio" name="radio" value="10000" class="radiod">
				<img src="image/10000.png" class="img10000c"> <input
					type="radio" name="radio" value="30000" class="radiod"> <img
					src="image/30000.png" class="img30000c"> <input type="radio"
					name="radio" value="50000" class="radiod"> <img
					src="image/50000.png" class="img50000c"> <input type="radio"
					name="radio" value="100000" class="radiod"> <img
					src="image/100000.png" class="img100000c">
			</div>
		</div>
		<div class="footerBox">
			<input type="submit" value="결제" class="chargeBtn"
				formaction="chargecoin"> <input type="submit" value="취소"
				class="cancelBtn" formaction="main">
		</div>
	</form>
	<script type="text/javascript">
		function doNotReload() {
			if ((event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82))
					|| (event.keyCode == 116)) {
				event.keyCode = 0;
				event.cancelBubble = true;
				event.returnValue = false;
			}
		}
		document.onkeydown = doNotReload;
	</script>
</body>
</html>