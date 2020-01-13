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
		.maintxt{
			font-size: 30px;
			margin-left: 740px;
			margin-top: 60px;
			margin-bottom: 70px;
			background-color: #2E9AFE;
			color: white;
			font-weight: bold;
			font-family: fantasy;
			width: 100%;
			border-radius: 10px;
		}
		table{
			width: 100%;
			height: 100%;
			border: 2px solid #444444;
    		border-collapse: collapse;
			font-size: 20px;
			text-align: center;
		}
		td{
			border: 2px solid black;
		}
		.selectBox{
			width: 200px;
			height: 40px;
			font-size: 22px;
			margin-left: 1100px;
			margin-top: 20px;
		}
		#txtBox{
			height: 40px;
			margin-bottom: 10px;
		}
		.search{
			height: 40px;
			width: 50px;
			padding-top: 7px;
			font-size: 18px;
			margin-top: 5px;
		}
		.createNovel{
			height: 40px;
			width: 90px;
			padding-top: 7px;
			font-size: 18px;
		}
	</style>
</head>
<body>
<form>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="maintxt">유료 웹소설</div>
	
	
	
	<table id="board">
		<tr>
			<td>작품 번호</td>
			<td>작가</td>
			<td>작품 제목</td>
			<td>작품 소개</td>
			<td>등급</td>
			<td>장르</td>
			<td>총 추천수</td>
		</tr>
	</table>
	<div id="bottom"></div>
	<div>
	<select name="search" class="selectBox" id="selectBox">
    <option value="번호">작품번호</option>
    <option value="작가">작가</option>
    <option value="제목">제목</option>
    <option value="장르">장르</option>
	</select>
	<input type="text" class="txtBox" id="txtBox">
	<input type="button" value="검색" class="search" id="paidnovelsearch">
	<input type="submit" value="작품등록" class="createNovel">
	</div>
	</form>
	<script type="text/javascript">
		$("#board").append("${list}");
	</script>
	
	<script type="text/javascript">
	
	
	$("#paidnovelsearch").click(function () {
		var lists=[];
		var selectBoxVal=$("#selectBox option:selected").val();
		var txtBoxVal=$("#txtBox").val();
		console.log(selectBoxVal);
		console.log(txtBoxVal);
		lists.push(selectBoxVal);
		lists.push(txtBoxVal);
		console.log(lists);
		 jQuery.ajaxSettings.traditional = true;
		$.ajax({
    		url: "paidnovelsearch",
    		type: "post",
    		data: {"data1":lists},
    		dataType: 'json',
    		success: function(data) {
    			console.log(data);
    			json=data;
    			pageShow(json,1);
    			pageNum(json);
    			
    		},
    		error: function(error) {
    			var str1="";
    			str1+="<tr>";
    			str1+="<td>검색결과가 없습니다</td>";
    			str1+="</tr>";
    			$("#board").html(str1);
    		}
    	}); //ajax End
});
	
	 function pageShow(json,num) { //페이지 안의 내용 보여주는 함수
		index=num;
	
		var str="";
		
		for(var i=(num - 1) *10;i<(num*10);i++){
			if(i<json.length){
			str+="<tr>";
			str+="<td>"+json[i].novel_num+"</td>";
			str+="<td>"+json[i].user_id+"</td>";
			str+="<td><a href='noveldetail?"+json[i].novel_num+"'>"+json[i].title+"</a></td>";
			str+="<td>"+json[i].intro+"</td>";
			str+="<td>"+json[i].grade+"</td>";
			str+="<td>"+json[i].genre+"</td>";
			str+="<td>"+json[i].like+"</td>";
			str+="</tr>";
			}
	
			
		}
		$("#board").html(str);
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