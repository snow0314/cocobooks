<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
    integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
    crossorigin="anonymous">
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
    integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
    crossorigin="anonymous"></script>
<title>비밀번호 찾기 결과창</title>
<meta charset="UTF-8">
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
    .form-group{
    	text-align : center;
    	font-size : 4em;
    }
</style>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="login-box">
                    <form role="form">
                        <legend>비밀번호 검색 결과</legend>
                        <label>회원님의 비밀번호는</label>
                        <div class="form-group">
                            <label>${pwsearch}</label>
                        </div>
                        <div class="form-group">
                             <a href="main.jsp" class="btn btn-primary">메인으로</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>





