<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 뷰포트 -->

<meta name="viewport" content="width=device-width" initial-scale="1">

<!-- 스타일시트 참조  -->

<link rel="stylesheet" href="css/bootstrap.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="userboard" method="post">
	제목 : <input type="text" name="title" /><br/>
	작성자 : <input type="text" name="writer" /><br/>
	내용 : <input type="text" name="contents" /><br/>
	<input type="submit" />
</form>
<!-- 애니매이션 담당 JQUERY -->

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

	<!-- 부트스트랩 JS  -->

	<script src="js/bootstrap.js"></script>

</body>
</html>