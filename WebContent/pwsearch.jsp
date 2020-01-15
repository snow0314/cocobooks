<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
    integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
    crossorigin="anonymous">
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
    integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
    crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>비밀번호 조회</title>
</head>

<style type="text/css">
    .login-box{
        width : 800px;
    	height : 300px;
        background-color: skyblue;
        border:solid 1px #bbbbbb;
    	border-radius:15px;
    	margin:150px 0 0 200px;
    	padding:10px 0 0 15px;
    }
    #idinput{
    	width : 200px;
    
    }
    #email{
    	width : 400px;
    }
</style>
<body>
<form class = "formsearch" method="post" action="pwsearch">
<div class="container">
 <div class="row">
  <div class="col-md-3">
   <div class="login-box">
    <legend>비밀번호 찾기</legend>
     <div class="form-group">
      <label>아이디</label><input type="text" name="id" class="form-control" id="idinput"
      placeholder="아이디를 입력하세요"/>
<div class="form-group">
 <label>Email</label> <input type="text" name="email" class="form-control" id="email"
 placeholder="이메일을 입력하세요"/>
  <button type="submit" class="btn btn-primary">조회</button>
</div>
 </div>
  </div>
   </div>
    </div>
     </div>
</form>
</body>
</html>