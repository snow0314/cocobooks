<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<style>
		body{
			background-color: #F2F2F2;
		}
		.myNovel,.Favorites,.profile,.buyList,.chargeList,.chargeCoin,.changeKind{
			width: 200px;
			height: 130px;
			background-color: white;
			font-size: 30px;
			font-family: fantasy;
			font-weight: 700;
			border-radius: 17px;
		}
		.myPageMainText{
			font-size: 50px;
			margin-left: 680px;
			font-family: fantasy;
			font-weight: 700;
		}
		.contents{
			border: 2px solid black;
			width: 1500px;
			height: 880px;
			margin-top: 20px;
			margin-left: 30px;
		}
		.totalBox{
			display: flex;
		}
		table{
	width:100%;
	height: 100%;
	text-align: center;
}
	</style>
</head>
<body>
<div class="myPageMainText">${id}님의 마이 페이지</div>
<form method="post">
	<div class="totalBox">
	<div class="BtnBox">
	<div><input type="submit" value="내 작품" class="myNovel"></div>
	<div><input type="submit" value="선호작" class="Favorites"></div>
	<div><input type="button" value="프로필" class="profile" id="profile"></div>
	<div><input type="submit" value="구매목록" class="buyList"></div>
	<div><input type="button" value="충전내역" class="chargeList" id="chargeList"></div>
	<div><input type="submit" value="결제하기" class="chargeCoin" formaction="payment"></div>
	<div><input type="submit" value="전환신청" class="changeKind"></div>
	</div>
	<div class="contentsbox">
	<div class="contents" id="content"></div>
	<div id="bottom"></div>
	</div>
	</div>
	</form>
	<script type="text/javascript" src="jsFile/chargeList.js">
	</script>
	<script type="text/javascript">
	$("#profile").click(function () {
		$.ajax({
    		url: "myinfo",
    		type: "post",
    		//data: {"page":$("page").value},
    		dataType: 'json',
    		success: function(data) {
    			console.log(data);
    			json=data;
    			pageShow(json,1);
    			pageNum(json);
    			
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
});
	
	function pageShow(json,num) { //페이지 안의 내용 보여주는 함수
		index=num;
	
		var str="";
		str+="<table class='table-striped'>";
		str+="<tr>";
		str+="<th>충전번호</th>";
		str+="<th>아이디</th>";
		str+="<th>충전금액</th>";
		str+="<th>충전날짜</th>";
		str+="</tr>";
		
		for(var i=(num - 1) *10;i<(num*10);i++){
			if(i<json.length){
			str+="<tr>";
			str+="<th>"+json[i].chargeNum+"</th>";
			str+="<th>"+json[i].chargeId+"</th>";
			str+="<th>"+json[i].chargePrice+"</th>";
			str+="<th>"+json[i].ChargeDate+"</th>";
			str+="</tr>";
		}else{
			str+="<tr>";
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
		
		$("#bottom").html(str2);
		
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
</body>
</html>