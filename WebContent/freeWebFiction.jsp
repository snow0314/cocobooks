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
		.maintxt{
			font-size: 30px;
			margin-top: 60px;
			margin-bottom: 70px;
			background-color: #2E9AFE;
			color: white;
			font-weight: bold;
			font-family: fantasy;
			width: 100%;
			border-radius: 10px;
			text-align: center;
		}
		table{
			width: 100%;
			height: 100%;
			border: 2px solid #2E9AFE;
    		border-collapse: collapse;
			font-size: 20px;
			text-align: center;
		}
		td{
			border: 2px solid gray;
			background-color: white;
		}
		.selectBox{
			width: 200px;
			height: 40px;
			font-size: 22px;
			margin-left: 1200px;
			margin-top: 20px;
			border-radius: 10px;
			font-weight: bold;
		}
		#txtBox{
			height: 40px;
			font-size: 23px;
			border-radius: 10px;
		}
		.search{
			height: 40px;
			width: 50px;
			padding-top: 7px;
			font-size: 18px;
			margin-top: 5px;
			border-radius: 10px;
			background-color: #2E9AFE;
			color: white;
		}
		.createNovel{
			height: 40px;
			width: 90px;
			padding-top: 7px;
			font-size: 18px;
			border-radius: 10px;
			background-color: #2E9AFE;
			color: white;
		}
		.insertnovel{
		border: 1.5px solid grey;
		text-decoration: none;
		height: 40px;
			width: 90px; 
		}
		option{
		font-weight: bold;}
		.indexa{
		background-color: #2E9AFE;
			color: white;
			border: 0;
		}
	</style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<form method="post">	
	<div class="maintxt">무료 웹소설</div>
	
	
	
	<table id="board">
		
	</table>
	<div id="bottom"></div>
	<div>
	<select name="search" class="selectBox" id="selectBox">
    <option value="번호">작품번호</option>
    <option value="작가">작가</option>
    <option value="제목">제목</option>
    <option value="장르">장르</option>
	</select>
	<input type="text" class="txtBox" id="txtBox">
	<input type="button" value="검색" class="search" id="freenovelsearch">
	<input type="submit" value="작품 등록" class="createNovel" formaction="writing">
	</div>
	</form>
	<script type="text/javascript">
		$("#board").append( "${list}");
	</script>
	<script type="text/javascript" src="jsFile/freeSearchList.js?ver2"></script>

</body>
</html>