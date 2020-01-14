<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
		body {
			background-color: #F2F2F2;
		}
		
		.mainTxt {
			font-size: 34px;
			margin-left: 760px;
			font-weight: bold;
			margin-top: 80px;
		}
		
		.titleBox {
			margin-top: 50px;
			border-bottom: 2px solid black;
			border-left: 3px solid black;
			font-weight: bold;
			font-size: 20px;
		}
		
		.title {
			margin-left: 20px;
			width: 1020px;
			height: 30px;
			border: 0px;
			border-radius: 10px;
		}
		
		.area {
			width: 1040px;
			margin-top: 40px;
			height: 300px;
			margin-left: 40px;
			margin-bottom: 10px;
		}
		
		.introBox {
			border-bottom: 2px solid black;
			border-left: 3px solid black;
			font-weight: bold;
			font-size: 20px;
		}
		
		.contentsTxt {
			margin-top: 20px;
		}
		.gradeTxt{
			width: 200px;
			height: 55px;
			font-size: 20px;
			font-weight: bold;
			border-radius: 12px;
			margin-left: 10px;
			
		}
		.oldPerson{
			color: red;
		}
		.submitBtn{
			width: 200px;
			height: 55px;
			font-size: 20px;
			font-weight: bold;
			border-radius: 12px;
			background-color: #2E9AFE;
			color: white;
			margin-left: 50px;
			
		}
		.footerBox{
			display: flex;
			margin-top: 40px;
		}
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form method="post">
<div class="mainTxt">${info} 작품 등록 페이지</div>
	<div class="titleBox">제목:
		<input type="text" value="" class="title" name="title">
	</div>
	<div class="introBox">
		<div class="contentsTxt">작품 소개 250자 이내</div>
		<textarea class="area" name="contents"></textarea>
	</div>
	<div class="footerBox">
	<div class="gradeBox">
		<select name="grade" class="gradeTxt">
			<option value="">등급</option>
			<option value="일반">일반</option>
			<option value="성인" class="oldPerson">성인</option>
		</select>
	</div>
	<div class="genreBox">
		
	</div>
	<div class="payNfreeBox"><input type="submit" value="${info}등록" class="submitBtn" formaction="novelinsert"></div>
	<input type="hidden" value="${info}" name="kind">
	</div>
	<script type="text/javascript">
	$(".genreBox").append("${category}");
	</script>
	</form>
</body>


</html>