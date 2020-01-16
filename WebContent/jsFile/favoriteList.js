var json;
var index;
var maxindex;
var totalpage;
function prefList() {
	$.ajax({
		url: "preference",
		type: "post",
		//data: {"page":$("page").value},
		dataType: 'json',
		success: function(data) {
			console.log(data);
			json=data;
			pageShow4(json,1);
			pageNum4(json);
			
		},
		error: function(error) {
			alert("선호하신 작품이 없습니다.");
			location.href="myPage";
		}
	}); //ajax End
}

		
		function pageShow4(json,num) { //페이지 안의 내용 보여주는 함수
			index=num;
		
			var str="";
			str+="<table class='table-striped'>";
			str+="<tr>";
			str+="<th>작가</th>";
			str+="<th>작품 번호</th>";
			str+="<th>작품 제목</th>";
			str+="<th>이동</th>";
			str+="<th>삭제</th>";
			str+="</tr>";
			
			for(var i=(num - 1) *10;i<(num*10);i++){
				if(i<json.length){
				str+="<tr>";
				str+="<th>"+json[i].id+"</th>";
				str+="<th>"+json[i].novel_Num+"</th>";
				str+="<th>"+json[i].novel_title+"</th>";
				str+="<th><input type='button' value='이동' class='move_novel' id='move_novel' onclick='moveNovel("+json[i].novel_Num+")'>"
				str+="<th><input type='button' value='삭제' class='del_novel' id='del_novel' onclick='delLikeNovel("+json[i].novel_Num+")'>"
				str+="</tr>";
			}else{
				str+="<tr>";
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
		
		
	 	function pageNum4(json) { //페이지 넘버 보여주는 함수
			
			totalPages = json.length/10;
			if (json.length/10 > 0) {
			totalPages++;
			}
			maxindex=Math.floor(totalPages);
			var str2="";
			str2+="<ul class='pagination justify-content-center'>";
			str2+="<li class='page-item'><a class='page-link' onclick='newpage4("+0+")'>Previous</a></li>";
			
			for(var k=1; k<totalPages;k++){
				str2+="<li class='page-item'><a class='page-link' onclick='newpage4("+k+")'>"+k+"</a></li>";
				str2+="<input type='hidden' class='page' value='"+k+"'>";
			}
			str2+="<li class='page-item'><a class='page-link' onclick='newpage4("+-1+")'>Next</a></li></ul>";
			str2+="</ul>";
			
			$("#bottom").html(str2);
			
		} 
		
	 	function newpage4(num) { //페이지 이전, 다음 버튼 누를시 이동 제어하는 함수
	 		if(num===0){
	 			if(index==1){
	 				pageShow4(json,1);
	 			}else{
	 				pageShow4(json,index-1);
	 			}
	 		}else if(num===-1){
	 			console.log(maxindex);
	 			if(index==maxindex){
	 				pageShow4(json,maxindex);
	 			}else{
	 				pageShow4(json,index+1);
	 			}
	 		}else{
	 			pageShow4(json,num);
	 		}
		}