<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	
<div class="mainTxt">Best 무료 웹 소설 </div>

	<div class="listTable" id="listTable">
	
	</div>
	<script type="text/javascript">
		$("#listTable").append("${list}");
	</script>
</body>
</html>