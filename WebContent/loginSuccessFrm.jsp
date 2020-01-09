<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: #F2F2F2;}
	.logOutBtn{
		
		border-radius: 7px;
		margin-left: 20px;
		width: 200px;
		height: 30px;
		background-color:  #2E9AFE;
		font-size: 15px;
		font-weight: 700;
	}
	.admin{
		
		border-radius: 7px;
		margin-left: 20px;
		width: 200px;
		height: 30px;
		background-color:  #2E9AFE;
		font-size: 15px;
		font-weight: 700;
	}
	.myPage{
		border-radius: 7px;
		margin-left: 20px;
		width: 200px;
		height: 30px;
		background-color:  #2E9AFE;
		font-size: 15px;
		font-weight: 700;
		margin-top: 40px;
	}
	.userId{
		margin-left: 50px;
		margin-top: 20px;
		font-weight: bold;
	}
	.myCoin{
		margin-left: 50px;
		margin-top: 50px;
		font-weight: 700;
		
	}
</style>
</head>
<body>
	<form>
	<div class="userId">*${id}님 환영합니다.*</div>
	<div class="myCoin">내 코인 : ${coin} 개</div>
	<div><input type="submit" formaction="myPage" value="마이 페이지" class="myPage"></div>
	<div><input id="admin" type="submit" formaction="admin" value="관리자 모드" class="admin" ></div>
	<div><input type="submit" formaction="logout" value="로그아웃" class="logOutBtn"></div>
	</form>
	<script type="text/javascript">
	var kind="${kind}"
	console.log(kind);
	if(kind=="관리"){
		document.getElementById("admin").style.display= "";
	}else if(kind=="일반"){
		document.getElementById("admin").style.display= "none";
	}
	</script>
</body>
</html>