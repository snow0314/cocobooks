<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<style>
		.maintxt{
			font-size: 50px;
			margin-left: 740px;
			margin-top: 60px;
			margin-bottom: 70px;
		}
		table{
			width: 100%;
			height: 100%;
			border: 1px solid #444444;
    		border-collapse: collapse;
			font-size: 20px;
		}
		td{
			border: 1px solid black;
		}
		.selectBox{
			width: 200px;
			height: 40px;
			font-size: 22px;
			margin-left: 1100px;
			margin-top: 20px;
		}
		.txtBox{
			width: 200px;
			height: 24px;
			font-size: 15px;
			padding-top: 9.7px;
		}
		.search{
			height: 40px;
			width: 50px;
			padding-top: 7px;
			font-size: 18px;
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
	
	<div>
	<select name="search" class="selectBox">
    <option value="num">작품번호</option>
    <option value="user">작가</option>
    <option value="name">제목</option>
    <option value="장르">장르</option>
	</select>
	<input type="text" class="txtBox">
	<input type="submit" value="검색" class="search">
	<input type="submit" value="작품등록" class="createNovel">
	</div>
	</form>
	<script type="text/javascript">
		$("#board").append("${list}");
	</script>
</body>
</html>