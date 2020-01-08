<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  .free_best{
  border: 2px solid grey;
  width: 650px;
  height: 1000px;
}
.pay_best{
border: 2px solid grey;
  width: 650px;
  height: 1000px;
}
.novel_category{
display: flex;}
.login{
width: 500px;
height: 400px;
margin-left: 60px;
margin-top: 40px;
background-color: #F2F2F2;
}
.cash{
border: 2px solid grey;
width: 500px;
height: 200px;
margin-left: 60px;
margin-top: 20px;
}
.logintext{
font-size: 20px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="novel_category">
	<div class="free_best">
	베스트 무료 웹 소설 목록
	</div>
	<div class="pay_best">
	베스트 유료 웹 소설 목록
	</div>
	<div class="right">
	<div class="login">
	<div class="logintext">회원 로그인</div>
	<jsp:include page="loginFrm.jsp"></jsp:include>
	</div>
	<div class="cash">
	결제 하기
	</div>
	</div>
	</div>
	<footer>
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>