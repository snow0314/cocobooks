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
			margin-left: 740px;
			margin-top: 60px;
			margin-bottom: 70px;
			background-color: #2E9AFE;
			color: white;
			font-weight: bold;
			font-family: fantasy;
			width: 100%;
			border-radius: 10px;
		}
		table{
			width: 100%;
			height: 100%;
			border: 2px solid #444444;
    		border-collapse: collapse;
			font-size: 20px;
			text-align: center;
		}
		td{
			border: 2px solid black;
		}
		.selectBox{
			width: 200px;
			height: 40px;
			font-size: 22px;
			margin-left: 1100px;
			margin-top: 20px;
		}
		#txtBox{
			height: 40px;
			margin-bottom: 10px;
		}
		.search{
			height: 40px;
			width: 50px;
			padding-top: 7px;
			font-size: 18px;
			margin-top: 5px;
		}
		.createNovel{
			height: 40px;
			width: 90px;
			padding-top: 7px;
			font-size: 18px;
		}
	</style>
</head>
<body>
<form>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="maintxt">유료 웹소설</div>
	
	
	
	<table id="board">
		<tr>
			<td>작품 번호</td>
			<td>작가</td>
			<td>작품 제목</td>
			<td>작품 소개</td>
			<td>등급</td>
			<td>장르</td>
			<td>총 추천수</td>
		</tr>
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
	<input type="button" value="검색" class="search" id="paidnovelsearch">
	<input type="submit" value="작품등록" class="createNovel">
	</div>
	</form>
	<script type="text/javascript">
		$("#board").append("${list}");
	</script>
	

<script type="text/javascript" src="jsFile/searchList.js">
</script>
</body>
</html>