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
</style>
</head>
<body>
 <div class="bottom">
  top
  </div>
  <div class="left">
  <div class="list-group">
  <a href="#" class="list-group-item list-group-item-action">회원보기</a><br>
  <a href="#" class="list-group-item list-group-item-action">블랙리스트 보기</a><br>
  <a href="#" class="list-group-item list-group-item-action">유료 작가 전환</a><br>
  <a href="#" class="list-group-item list-group-item-action">신고받은 글 보기 및 삭제</a><br>
  <a href="#" class="list-group-item list-group-item-action">작품 등급 제한 걸기</a><br>
  <a href="#" class="list-group-item list-group-item-action">장르 추가 기능</a><br>
  </div>
  </div>
  <div class="content">
  content
  </div>
  <div class="bottom">
  bottom
  </div>


</body>
</html>