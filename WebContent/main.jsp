<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
body{
background-color: #F2F2F2;
}
  .free_best{
  border: 2.5px solid #2E9AFE;
  width: 650px;
  height: 1000px;
}
.pay_best{
margin-left :4px;
border: 2.5px solid #2E9AFE;
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
width: 500px;
height: 200px;
margin-left: 60px;
margin-top: 20px;
}
.logintext{
font-size: 20px;
}
.logintxt{
margin-left: 80px;
font-size: 35px;
font-weight: 700;
padding-top: 50px;
}
.tot{
 border: 5px solid #2E9AFE;
 width: 490px;
 margin-left: 40px;
 border-radius: 8px; 
}
.msg{
 color: red;
}
</style>
</head>
<body>
<script type="text/javascript">
	function callList() {
		$.ajax({
    		url: "bestfreewebnovel",
    		type: "get",
    		async: false,
    		//data: {"page":$("page").value},
    		dataType: 'html',
    		success: function(data) {
    			console.log(data);
    			$("#free_best").html(data);
    			
    			
    		},
    		error: function(error) {
    			alert("실패");
    		}
    	}); //ajax End
    	$.ajax({
    		url: "bestpaywebnovel",
    		type: "get",
    		async: false,
    		//data: {"page":$("page").value},
    		dataType: 'html',
    		success: function(data) {
    			console.log(data);
    			$("#pay_best").html(data);
    			
    			
    		},
    		error: function(error) {
    			alert("실패");
    		}
    	}); //ajax End
	}
	window.onload=callList;
</script>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="novel_category">
	<div class="free_best" id="free_best">
	
	</div>
	<div class="pay_best" id="pay_best">
	
	</div>
	<div class="right">
	<div class="tot">
	<div class="logintxt">회원 로그인</div>
	<div class="login">
	<div class="logintext" id="logintext" >
	<jsp:include page="loginFrm.jsp"></jsp:include>
	</div>
	<div class="msg">
	${msg}
	</div>
	</div>
	</div>
	<div class="cash">
	<jsp:include page="chargeCoin.jsp"></jsp:include>
	</div>
	</div>
	</div>
	<footer>
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<script type="text/javascript">
		var info="${id}";
		if(info!=""){
			$("#logintext").load("loginSuccessFrm.jsp");
		}else {
			$("#logintext").load("loginFrm.jsp");
		}
	</script>
	
</body>
</html>