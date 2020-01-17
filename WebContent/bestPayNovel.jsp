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
body{
			background-color: #F2F2F2;
		}

table {
background-color: #F2F2F2;
	/*  border: 1px solid #444444; */
	border-collapse: collapse;
	border-radius: 10px;
}

td {
	/* border: 1px solid black; */
	font-size: 18px;
	width: 170px;
	height: 11px;
	text-align: center;
	font-weight: bold;
	padding: 5px;
	border-bottom: 1px solid gray;
	border-radius: 10px;
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
			margin-top: 10px;
			margin-left: 270px;
		}
		.oneImg{
			text-align: center;
		}
		.one{
			font-weight: 700;
			margin-top: 12px;
			font-weight: 700;
			text-align: center;
			 
		}
		.oneViewNum{
			padding-left: 5px;
			background-color: gold;
			font-weight: 700;
			color: red;
			text-align: center;
		}
		.oneViewTxt{
			border-bottom: 1px solid gold;
			background-color: gold;
			font-weight: 700;
			text-align: center;
		}
		.twoViewBox{
			display: flex;
		}
		
		.two{
			font-weight: bold;
			margin-top: 5px;
			
		}
		.twoViewBox{
			
			margin-top: 10px;
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
			padding-left: 5px;
		}
		.twoAndthree{
			display: flex;
		}
		.threeImg{
			text-align: center;
		}
		.three{
			display: flex;
			font-weight: bolder;
			margin-left: 30px;
			margin-top: 8px;
			width: 50px;
			overflow:auto; 
		}
		.threeViewTxt{
			
			font-weight: bold;
			background-color: saddlebrown;
			color: currentColor;
		}
		.threeBox{
			display: flex;
			margin-top: 7px;
		}
		.threeViewNum{
			font-weight: bold;
			background-color: saddlebrown;
			color: red;
			padding-left: 5px;
		}
		.twotot{
			text-align: center;
			margin-left: 100px;
		}
		.threetot{
		text-align:center;
		margin-left: 230px;
		}
		.viewTdG{
		background-color: gold;
		color: red;}
		.viewTdS{
		background-color: silver;
		color: red;}
		.viewTdB{
		background-color:#B45F04;
		color: red;}
</style>
</head>
<body>
	<div class="mainTxt">Best 유료 웹 소설</div>
	<div class="listTable2" id="listTable2">

	</div>
	<script type="text/javascript">
		$("#listTable2").append( "${bestPList}");
	</script>
</body>
</html>