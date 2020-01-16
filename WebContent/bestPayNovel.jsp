<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
body {
	background-color: #F2F2F2;
}

table {
	border: 1px solid #444444;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	font-size: 18px;
	width: 170px;
	height: 11px;
	text-align: center;
	font-weight: bold;
}

.mainTxt {
	font-size: 20px;
	font-weight: bolder;
	margin-bottom: 40px;
	margin-top: 70px;
	width: 100%;
	text-align: center;
	color: white;
		background-color: #2E9AFE;
}

.listTable {
	background-color: white;
}
.listTable2{
background-color: white;
}

a:link {
	color: #2E9AFE;
	text-decoration: none;
}

a:visited {
	color: #2E9AFE;
	text-decoration: none;
}

a:hover {
	color: #2E9AFE;
}
		img{
			width: 90px;
			height: 70px;
		}
		.oneViewBox{
			display: flex;
			margin-left: 84px;
			margin-top: 10px;
		}
		.oneImg{
			margin-left: 119px;
		}
		.one{
			margin-left: 90px;
			margin-top: 10px;
			font-weight: 700;
			width: 140px;
		}
		.oneViewNum{
			padding-left: 5px;
			background-color: gold;
			font-weight: 700;
			color: red;
		}
		.oneViewTxt{
			border-bottom: 1px solid gold;
			background-color: gold;
			font-weight: 700;
		}
		.twoViewBox{
			display: flex;
		}
		.twoImg{
			margin-left: 30px;
			margin-top: 7px;
		}
		.two{
			margin-left: 42px;
			margin-top: 5px;
			font-weight: bold;
			width: 140px;
		}
		.twoViewTxt{
			display: flex;
			font-weight: bolder;
			background-color: silver;
		}
		.twoViewNum{
			background-color: silver;
			font-weight: bold;
			color: red;
		}
		.twoAndthree{
			display: flex;
		}
		.threeImg{
			margin-top: 4px;
			margin-left: 73px;
		}
		.three{
			display: flex;
			font-weight: bolder;
			margin-left: 82px;
			margin-top: 8px;
			width: 140px;
		}
		.threeViewTxt{
			margin-left: 38px;
			font-weight: bold;
			background-color: saddlebrown;
			color: currentColor;
		}
		.threeBox{
			display: flex;
		}
		.threeViewNum{
			font-weight: bold;
			background-color: saddlebrown;
			color: red;
		}
</style>
</head>
<body>
	<div class="mainTxt">Best 유료 웹 소설</div>
	<table class="listTable2" id="listTable2">

	</table>
	<script type="text/javascript">
		$("#listTable2").append("${list}");
	</script>
</body>
</html>