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
		.myNovel,.favorites,.profile,.buyList,.chargeList,.chargeCoin,.changeKind{
			width: 200px;
			height: 130px;
			background-color: white;
			font-size: 30px;
			font-family: fantasy;
			font-weight: 700;
			border-radius: 17px;
		}
		.myPageMainText{
			font-size: 25px;
			font-weight: 700;
			color: white;
			background-color:  #2E9AFE;
			text-align: center;
			margin-top: 25px;
		}
		.contents{
			border: 2px solid #2E9AFE;
			width: 1500px;
			height: 880px;
			margin-top: 20px;
			margin-left: 30px;
			border-radius: 10px;
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
			margin-left: 120px;
			color: #2E9AFE;
			font-weight: bold;
		}
		.idtxt2,.nametxt2,.agetxt2,.emailtxt2,.cointxt2,.kindtxt2,.applytxt2{
			font-size: 30px;
			padding: 30px;
			font-weight: bold;
			color: graytext;
		}
		a{
	cursor:pointer;
}		
	.idbox{
	margin-top: 75px;
 }
 .gitt{
 width: 100%;
 height: 100%;}
 .chargeBox1,#chargeBox2{
 
 width: 100%;
 margin-left: 0;}
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="mainBox">
	<div class="myPageMainText">${id}님의 마이 페이지</div>
	</div>
<form method="post">
	<div class="totalBox">
	<div class="BtnBox">
	<div><input type="button" value="내 작품" class="myNovel" onclick="myNovel()"></div>
	<div><input type="button" value="선호작" class="favorites" id="favorites" onclick="prefList()" ></div>
	<div><input type="button" value="프로필" class="profile" id="profile"></div>
	<div><input type="button" value="구매목록" class="buyList" id="buyList"></div>
	<div><input type="button" value="충전내역" class="chargeList" id="chargeList"></div>
	<div><input type="button" value="결제하기" class="chargeCoin"  id="chargeCoin"></div>
	<div><input type="button" value="전환신청" class="changeKind" id="changeKind" formaction="authorchange"></div>
	</div>
	<div class="contentsbox">
	<div class="contents" id="content">
	<img alt="img" src="image/gith.jpg" class="gitt">
	</div>
	<div id="bottom"></div>
	</div>
	</div>
	</form>
	<script type="text/javascript" src="jsFile/chargeList.js?ver2">
	</script>
	<script type="text/javascript" src="jsFile/profile.js?ver3">
	</script>
	<script type="text/javascript">
	var msg="${msg}";
	if(msg=="신청이 완료 되었습니다."){
		alert("${msg}");
	}else if(msg=="이미 신청된 회원입니다."){
		alert("${msg}");
	}
	</script>
	<script type="text/javascript" src="jsFile/buyList.js"></script>
	<script type="text/javascript" src="jsFile/favoriteList.js?ver1"></script>
	<script type="text/javascript">
	function moveNovel(num) {
		location.href="noveldetail?novelNum="+num;
	}
	</script>
	<script type="text/javascript">
	
	function delLikeNovel(num) {
		var q=confirm("정말 삭제하시겠습니까?");
		if(q){
		$.ajax({
    		url: "deleteFavoritesNovel?novelNum="+num,
    		type: "get",
    		dataType: 'text',
    		success: function(data) {
    			alert(data);
    			prefList();
    		},
    		error: function(error) {
    			console.log(error);
    		}
    	}); //ajax End
		}
	}
	</script>
	<script type="text/javascript" src="jsFile/myNovelList.js?ver1">
	</script>
	<script type="text/javascript">
	$("#chargeCoin").click(function () {
		$.ajax({
			url: "payment",
			type: "get",
			dataType: 'html',
			success: function(data) {
				$("#content").html(data);
				$("#bottom").html("");
			},
			error: function(error) {
				console.log(error);
			}
		}); //ajax End
	});
	
	</script>
	<script type="text/javascript">
	$("#changeKind").click(function () {
		$.ajax({
			url: "authorchange",
			type: "get",
			dataType: 'html',
			success: function(data) {
				$("#content").html(data);
				$("#bottom").html("");
			},
			error: function(error) {
				console.log(error);
			}
		}); //ajax End
	});
	</script>
</body>
</html>