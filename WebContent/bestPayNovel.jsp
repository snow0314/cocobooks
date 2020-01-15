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