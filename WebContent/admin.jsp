<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  
<title>Insert title here</title>
<style type="text/css">
    .left {
  position:absolute;
  width:200px;
  height: 500px;
  border: 1px solid black;
  text-align: center;
}
.content {
  position:relative;
  width:70%;
  left:200px;
  height:500px;
  border: 1px solid black;
}
.bottom {
  position:relative;
  width:70%;
  left:200px;
  height: 100px;
  border: 1px solid black;
}
a{
	cursor:pointer;
}
table{
	width:100%;
	height: 100%;
	text-align: center;
}
.myButton {
	box-shadow:inset 0px 1px 0px 0px #97c4fe;
	background:linear-gradient(to bottom, #3d94f6 5%, #1e62d0 100%);
	background-color:#3d94f6;
	border-radius:6px;
	border:3px solid #337fed;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Verdana;
	font-size:15px;
	font-weight:bold;
	padding:12px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #1570cd;
	position:   relative;
	left:       400px;
	
}
.myButton:hover {
	background:linear-gradient(to bottom, #1e62d0 5%, #3d94f6 100%);
	background-color:#1e62d0;
}
.myButton:active {
	position:relative;
	top:1px;
}
#blackbutton{
  position:relative;
  top:-30px;
  left:750px;
  background-color: #2E9AFE;

}


</style>
</head>
<body>
 <div class="bottom">
  top
  </div>
  <div class="left">
  <div class="list-group">
  <a class="list-group-item list-group-item-action" onclick="userinfo()">회원보기</a><br>
  <a class="list-group-item list-group-item-action" onclick="blacklistshow()">블랙리스트 보기</a><br>
  <a class="list-group-item list-group-item-action" onclick="authorChangeShow()">유료 작가 전환</a><br>
  <a class="list-group-item list-group-item-action">신고받은 글 보기 및 삭제</a><br>
  <a class="list-group-item list-group-item-action" onclick="allNovelShow()">작품 등급 제한 걸기</a><br>
  <a class="list-group-item list-group-item-action" onclick="genreInfo()">장르 추가 기능</a><br>
  </div>
  </div>
  <div class="content" id="content">
  content
  </div>
  <div class="bottom" id="bottom">
  </div>

</body>
<script src="jsFile/admin.js">


</script>
</html>