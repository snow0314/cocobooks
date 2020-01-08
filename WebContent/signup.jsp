<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">


</style>


</head>
<body>
	<form class="form-horizontal" name="signcompleted" action="signcompleted" method="post" onsubmit="return validate();">
		<fieldset>

			<!-- Form Name -->
			<legend>Form Name</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="id">아이디</label>
				<div class="col-md-4" id="id_div">
					<input id="id" name="id" type="text" placeholder="아이디를 입력하세요"
						class="form-control input-md">
					<input type="button" class="myButton" value="중복확인"></>
					<input type="hidden" id="idcheck" value="false">
				</div>
			</div>
			
	
			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="pw">비밀번호</label>
				<div class="col-md-4">
					<input id="pw" name="pw" type="password" placeholder="비밀번호를 입력하세요"
						class="form-control input-md">

				</div>
			</div>
			
				<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="">비밀번호 확인</label>
				<div class="col-md-4">
					<input id="pw2" name="pw2" type="password" placeholder="비밀번호를 입력하세요"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">이름</label>
				<div class="col-md-4">
					<input id="name" name="name" type="text" placeholder="이름을 입력하세요"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="age">나이</label>
				<div class="col-md-4">
					<input id="age" name="age" type="number" placeholder="나이를 입력하세요"
						class="form-control input-md">

				</div>
			</div>

		

			<!-- Multiple Radios -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="gender">성별</label>
				<div class="col-md-4">
					<div class="radio">
						<label for="gender-0"> <input type="radio" name="gender"
							id="gender-0" value="남" checked="checked"> 남자
						</label>
					</div>
					<div class="radio">
						<label for="gender-1"> <input type="radio" name="gender"
							id="gender-1" value="여"> 여자
						</label>
					</div>
				</div>
			</div>

			<!-- Button Drop Down -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email">이메일</label>
				<div class="col-md-4">
					<div class="input-group">
						<input id="email" name="email" class="form-control"
							placeholder="이메일을 입력하세요" type="text">
						<input type="button" class="myButton2" value="중복확인"></>
						<input type="hidden" id="emailcheck" value="false">
					</div>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
			
				<div class="col-md-4">
					<input type="submit" id="singlebutton" name="singlebutton"
						class="btn btn-primary" value="회원가입">
					<input type="button" id="gomain"
						class="btn btn-primary" value="메인으로">
				</div>
			</div>

		</fieldset>
	</form>
	
<script type="text/javascript">

function validate() {
    var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
    var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    // 이메일이 적합한지 검사할 정규식

    var id = document.getElementById("id");
    var pw = document.getElementById("pw");
    var email = document.getElementById("email");
    
    
    if(!check(re,id,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
        return false;
    }

    if(!check(re,pw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
        return false;
    }

    if(signcompleted.pw.value != signcompleted.pw2.value) {
        alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
        signcompleted.pw2.value = "";
        signcompleted.pw2.focus();
        return false;
    }

    if(email.value=="") {
        alert("이메일을 입력해 주세요");
        email.focus();
        return false;
    }

    if(!check(re2, email, "적합하지 않은 이메일 형식입니다.")) {
        return false;
    }

    if(signcompleted.name.value=="") {
        alert("이름을 입력해 주세요");
        signcompleted.name.focus();
        return false;
    }
    
    if(signcompleted.age.value=="") {
        alert("나이를 입력해 주세요");
        signcompleted.age.focus();
        return false;
    }
    if(signcompleted.idcheck.value!="true"){
    	alert("아이디 중복 검사를 하세요");
    	return false;
    }
    if(signcompleted.emailcheck.value!="true"){
    	alert("이메일 중복 검사를 하세요");
    	return false;
    }
    
}

    function check(re, what, message) {
        if(re.test(what.value)) {
            return true;
        }
        alert(message);
        what.value = "";
        what.focus();
        //return false;
    }
    
    function inNumber(){
    	  if(event.keyCode<48 || event.keyCode>57){
    	     event.returnValue=false;
    	  }
    	}

    $(".myButton").click(function() { //아이디 중복 검사
    	$.ajax({
    		url: "checkid",
    		type: "post",
    		data: {"idcheck": signcompleted.id.value},
    		dataType: 'text',
    		success: function(data) {
    			alert(data);
    			if(data=="사용가능한 아이디 입니다"){
    				signcompleted.idcheck.value="true";
    			}
    			},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    			
    		}
    	}); //ajax End
    	
	});

    $(".myButton2").click(function() { //이메일 중복 검사
    	$.ajax({
    		url: "checkemail",
    		type: "post",
    		data: {"idcheck": signcompleted.email.value},
    		dataType: 'text',
    		success: function(data) {
    			if(data=="사용가능한 이메일 입니다"){
    				signcompleted.emailcheck.value="true";
    			}
    			alert(data);
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
    	
	});
    
    $("#gomain").click(function() {
		location.href="main.jsp";
	});

</script>

</body>
</html>

