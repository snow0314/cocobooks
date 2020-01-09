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
</style>
</head>
<body>
 <div class="bottom">
  top
  </div>
  <div class="left">
  <div class="list-group">
  <a class="list-group-item list-group-item-action" onclick="userinfo()">회원보기</a><br>
  <a href="#" class="list-group-item list-group-item-action">블랙리스트 보기</a><br>
  <a href="#" class="list-group-item list-group-item-action">유료 작가 전환</a><br>
  <a href="#" class="list-group-item list-group-item-action">신고받은 글 보기 및 삭제</a><br>
  <a href="#" class="list-group-item list-group-item-action">작품 등급 제한 걸기</a><br>
  <a href="#" class="list-group-item list-group-item-action">장르 추가 기능</a><br>
  </div>
  </div>
  <div class="content" id="content">
  content
  </div>
  <div class="bottom">
  
  </div>

</body>
<script>
	
    


	function userinfo(){ //회원보기 
		$.ajax({
    		url: "userinfo",
    		type: "post",
    		dataType: 'json',
    		success: function(data) {
    			var json=data;
    			var str="";
    			console.log(json);
    			str+="<table class='table-striped'>";
    			str+="<tr>";
    			str+="<th>아이디</th>";
    			str+="<th>이름</th>";
    			str+="<th>나이</th>";
    			str+="<th>성별</th>";
    			str+="<th>코인</th>";
    			str+="<th>종류</th>";
    			str+="<th>이메일</th>";
    			str+="</tr>";
    			
    			for(var i=0;i<20;i++){
    				if(i<json.length){
    				str+="<tr>";
    				str+="<th>"+json[i].id+"</th>";
    				str+="<th>"+json[i].name+"</th>";
    				str+="<th>"+json[i].age+"</th>";
    				str+="<th>"+json[i].gender+"</th>";
    				str+="<th>"+json[i].coin+"</th>";
    				str+="<th>"+json[i].kind+"</th>";
    				str+="<th>"+json[i].email+"</th>";
    				str+="</tr>";
    			}else{
    				str+="<tr>";
    				str+="<th></th>";
    				str+="<th></th>";
    				str+="<th></th>";
    				str+="<th></th>";
    				str+="<th></th>";
    				str+="<th></th>";
    				str+="<th></th>";
    				str+="</tr>";
    			}
    				pageNum(json);
    			}
    			str+="</table>";
    			$("#content").html(str);
    			
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
	} //userinfo End
	
	function pageNum(json) {
		var str2="";
		str2="<ul class='pagination justify-content-center'>";
		
		<li class="page-item"><a class="page-link">Previous</a></li>
		<li class="page-item active"><a class="page-link">1</a></li>
		<li class="page-item"><a class="page-link">2</a></li>
		<li class="page-item"><a class="page-link">3</a></li>
		<li class="page-item"><a class="page-link">4</a></li>
		<li class="page-item"><a class="page-link">5</a></li>
		<li class="page-item"><a class="page-link">Next</a></li>
	</ul>
	
	}

</script>
</html>