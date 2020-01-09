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
  <a class="list-group-item list-group-item-action">블랙리스트 보기</a><br>
  <a class="list-group-item list-group-item-action">유료 작가 전환</a><br>
  <a class="list-group-item list-group-item-action">신고받은 글 보기 및 삭제</a><br>
  <a class="list-group-item list-group-item-action">작품 등급 제한 걸기</a><br>
  <a class="list-group-item list-group-item-action" onclick="genreInfo()">장르 추가 기능</a><br>
  </div>
  </div>
  <div class="content" id="content">
  content
  </div>
  <div class="bottom" id="bottom">
 
  </div>

</body>
<script>
	
    var json; 
    var index;
    var maxindex;
    
    function genreInfo() { //DB에 저장된 장르 보기
    	$.ajax({
    		url: "genreadd",
    		type: "post",
    		dataType: 'json',
    		success: function(data) {
    			json=data;
    			var str="";
    			str+="<table class='table-striped'>";
    			str+="<tr>";
    			str+="<th>번호</th>";
    			str+="<th>장르이름</th>";
    			str+="<th>삭제</th>";
    			str+="</tr>";
    			for(var i=0;i<json.length;i++){
    				str+="<tr>";
    				str+="<th>"+(i+1)+"</th>";
    				str+="<th>"+json[i]+"</th>";
    				str+="<th><input type=''
    				str+="</tr>";
    			}
    			str+="</table>";
    			$("#content").html(str);
    			$("#bottom").html();
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
	}
    
	function userinfo(){ //회원보기 
		$.ajax({
    		url: "userinfo",
    		type: "post",
    		//data: {"page":$("page").value},
    		dataType: 'json',
    		success: function(data) {
    			json=data;
    			pageShow(json,1);
    			pageNum(json);
    			
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
	} //userinfo End
	
	function pageShow(json,num) { //페이지 안의 내용 보여주는 함수
		index=num;
	
		var str="";
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
		
		for(var i=(num - 1) *10;i<(num*10);i++){
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
			
		}
		str+="</table>";
		$("#content").html(str);
	}
	
	
 	function pageNum(json) { //페이지 넘버 보여주는 함수
		var totalpage;
		
		totalPages = json.length/10;
		if (json.length/10 > 0) {
		totalPages++;
		}
		maxindex=Math.floor(totalPages);
		var str2="";
		str2+="<ul class='pagination justify-content-center'>";
		str2+="<li class='page-item'><a class='page-link' onclick='newpage("+0+")'>Previous</a></li>";
		
		for(var k=1; k<totalPages;k++){
			str2+="<li class='page-item'><a class='page-link' onclick='newpage("+k+")'>"+k+"</a></li>";
			str2+="<input type='hidden' class='page' value='"+k+"'>";
		}
		str2+="<li class='page-item'><a class='page-link' onclick='newpage("+-1+")'>Next</a></li></ul>";
		str2+="</ul>";
		
		$("#bottom").append(str2);
		
	} 
	
 	function newpage(num) { //페이지 이전, 다음 버튼 누를시 이동 제어하는 함수
 		if(num===0){
 			if(index==1){
 				pageShow(json,1);
 			}else{
 				pageShow(json,index-1);
 			}
 		}else if(num===-1){
 			console.log(maxindex);
 			if(index==maxindex){
 				pageShow(json,maxindex);
 			}else{
 				pageShow(json,index+1);
 			}
 		}else{
 			pageShow(json,num);
 		}
	}

	
	
</script>
</html>