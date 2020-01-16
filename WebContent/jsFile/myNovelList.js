function myNovel() {
		$.ajax({
    		url: "mynovel",
    		type: "post",
    		dataType: "json",
    		success: function(data) {
    			json=data;
    			pageShow5(json,1);
    			pageNum5(json);

    		},
    		error: function(error) {
    			console.log(error);
    		}
    	}); //ajax End
		
	}

function pageShow5(json,num) { //페이지 안의 내용 보여주는 함수
	index=num;

	var str="";
	str+="<table class='table-striped'>";
	str+="<tr>";
	str+="<th>작품 번호</th>";
	str+="<th>작품 제목</th>";
	str+="<th>장르</th>";
	str+="<th>바로가기</th>";
	str+="</tr>";
	
	for(var i=(num - 1) *10;i<(num*10);i++){
		if(i<json.length){
		str+="<tr>";
		str+="<th>"+json[i].novel_num+"</th>";
		str+="<th>"+json[i].title+"</th>";
		str+="<th>"+json[i].genre+"</th>";
		str+="<th><input type='button' value='바로가기' class='move_novel' id='move_novel' onclick='moveNovel("+json[i].novel_num+")'>"
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


	function pageNum5(json) { //페이지 넘버 보여주는 함수
	
	totalPages = json.length/10;
	if (json.length/10 > 0) {
	totalPages++;
	}
	maxindex=Math.floor(totalPages);
	var str2="";
	str2+="<ul class='pagination justify-content-center'>";
	str2+="<li class='page-item'><a class='page-link' onclick='newpage5("+0+")'>Previous</a></li>";
	
	for(var k=1; k<totalPages;k++){
		str2+="<li class='page-item'><a class='page-link' onclick='newpage5("+k+")'>"+k+"</a></li>";
		str2+="<input type='hidden' class='page' value='"+k+"'>";
	}
	str2+="<li class='page-item'><a class='page-link' onclick='newpage5("+-1+")'>Next</a></li></ul>";
	str2+="</ul>";
	
	$("#bottom").html(str2);
	
} 

	function newpage5(num) { //페이지 이전, 다음 버튼 누를시 이동 제어하는 함수
		if(num===0){
			if(index==1){
				pageShow5(json,1);
			}else{
				pageShow5(json,index-1);
			}
		}else if(num===-1){
			console.log(maxindex);
			if(index==maxindex){
				pageShow5(json,maxindex);
			}else{
				pageShow5(json,index+1);
			}
		}else{
			pageShow5(json,num);
		}
}