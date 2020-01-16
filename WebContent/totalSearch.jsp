<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
		table{
			border: 1px solid #444444;
    		border-collapse: collapse;
			margin-left: 200px;
		}
		td{
			border :1px solid black;
			font-size: 20px;
			width: 280px;
			height: 30px;
			text-align: center;
			font-weight: bold;
		}
		.mainTable{
			margin-top: 80px;
		}
		.borderList{
			background-color: white;
			border: 0;
			font-weight: bold;
			font-size: 20px;
			color: #2E9AFE;
			cursor: pointer;
		}
		.listTable{
		background-color: white;
		}
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="noveldetail">
<table class="mainTable">
		<tr>
			<td>작품번호</td>
			<td>작품명</td>
			<td>작가</td>
			<td>총 추천수</td>
			<td>구분</td>
		</tr>
	</table>
	<table class="listTable">

	</table>
	</form>
	
	<script type="text/javascript">
	$(".listTable").append("${data}");
	</script>
	<script type="text/javascript">
	function submitt(num) {
		location.href="noveldetail?novelNum="+num;
	}
	</script>
	<script type="text/javascript">
	function delLikeNovel(num) {
		
	}
	</script>
</body>
</html>