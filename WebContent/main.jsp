<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
body {
	background-color: white;
}

.free_best {
	border: 2.5px solid #2E9AFE;
	width: 920px;
	height: 1000px;
}

.pay_best {
	margin-left: 8px;
	border: 2.5px solid #2E9AFE;
	width: 920px;
	height: 1000px;
}

.novel_category {
	display: flex;
}

.login {
	width: 500px;
	height: 400px;
	margin-left: 40px;
	margin-top: 40px;
}

.cash {
	width: 500px;
	height: 200px;
	margin-left: 30px;
	margin-top: 20px;
}



.logintxt {
	margin-left: 35px;
	font-size: 35px;
	font-weight: 700;
	padding-top: 20px;
	color: graytext;
}

.tot {
	border: 5px solid #2E9AFE;
	width: 450px;
	margin-left: 30px;
	border-radius: 8px;
}

.msg {
	color: red;
}
</style>
</head>
<body>
	<script type="text/javascript">
		function callList() {
			$.ajax({
				url : "bestfreewebnovel",
				type : "get",
				async : false,
				//data: {"page":$("page").value},
				dataType : 'html',
				success : function(data) {
					console.log(data);
					$("#free_best").html(data);

				},
				error : function(error) {
					alert("실패");
				}
			}); //ajax End
			$.ajax({
				url : "bestpaywebnovel",
				type : "get",
				async : false,
				//data: {"page":$("page").value},
				dataType : 'html',
				success : function(data) {
					console.log(data);
					$("#pay_best").html(data);

				},
				error : function(error) {
					alert("실패");
				}
			}); //ajax End
		}
		window.onload = callList;
	</script>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="novel_category">
		<div class="free_best" id="free_best"></div>
		<div class="pay_best" id="pay_best"></div>
		<div class="right">
			<div class="tot">
				<div class="logintxt">회원 로그인</div>
				<div class="login">
					<div class="logintext" id="logintext">
						<jsp:include page="loginFrm.jsp"></jsp:include>
					</div>
					<div class="msg">${msg}</div>
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
		var info = "${id}";
		if (info != "") {
			$("#logintext").load("loginSuccessFrm.jsp");
		} else {
			$("#logintext").load("loginFrm.jsp");
		}
	</script>
	<script type="text/javascript">
		function doNotReload() {
			if ((event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82))
					|| (event.keyCode == 116)) {
				event.keyCode = 0;
				event.cancelBubble = true;
				event.returnValue = false;
			}
		}
		document.onkeydown = doNotReload;
		
		var loginNovel="${loginNovel}";
			console.log("${loginNovel}");
			if(loginNovel=="로그인 후 이용해주세요"){
				alert("${loginNovel}");
			}
		
		
	</script>
</body>
</html>