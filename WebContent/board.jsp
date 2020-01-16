<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="js/jquery-3.1.1.js"></script>
	<script src="js/bootstrap.js"></script>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
    integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
    crossorigin="anonymous">
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
    integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
    crossorigin="anonymous"></script>
<script type="text/javascript">
	function move(url){
		location.href=url;
	}
</script>
<title>독자 게시판</title>
</head>
<body>
<h1>독자 게시판</h1>
<div class="container"></div>
	<table class="table table-hover">
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>1</td>
		<td>이게 나라냐</td>
		<td>양정훈</td>
		<td>2020.01.15</td>
		<td>1</td>
	</tr>
	<tr>
		<td>2</td>
		<td>이게 나라냐</td>
		<td>이설형</td>
		<td>2020.01.15</td>
		<td>2</td>
	</tr>
	<tr>
		<td>3</td>
		<td>이게 나라냐</td>
		<td>마재환</td>
		<td>2020.01.15</td>
		<td>2</td>
	</tr>
	</tbody>
	</table>
<input type="button" value="글쓰기" onclick="move('userwrite.jsp');" />
</body>
</html>