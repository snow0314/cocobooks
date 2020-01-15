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
		table{
			border: 1px solid #444444;
    		border-collapse: collapse;
		}
		td{
			border :1px solid black;
			font-size: 18px;
			width: 170px;
			height: 11px;
			text-align: center;
			font-weight: bold;
		}
		.mainTxt{
			margin-left: 240px;
			font-size: 20px;
			font-weight: bolder;
			margin-bottom: 40px;
		}
		.listTable{
		background-color: white;
		}
	</style>
</head>
<body>
<div class="mainTxt">Best 유료 웹 소설 </div>
	<table>
		<tr>
			<td>작품 번호</td>
			<td>작품 제목</td>
			<td>작가 </td>
			<td>총 조회수</td>
		</tr>
	</table>
	<table class="listTable">
		<tr>
			<td>작품 번호</td>
			<td>작품 제목</td>
			<td>작가 </td>
			<td>총 조회수</td>
		</tr>
	</table>
</body>
</html>