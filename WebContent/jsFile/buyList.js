$("#buyList").click(function () {
			$.ajax({
	    		url: "contents",
	    		type: "post",
	    		//data: {"page":$("page").value},
	    		dataType: 'json',
	    		success: function(data) {
	    			console.log(data);
	    			json=data;
	    			pageShow3(json,1);
	    			pageNum3(json);
	    			
	    		},
	    		error: function(error) {
	    			alert("구매한 작품이 없습니다");
	    		}
	    	}); //ajax End
	});
		
		function pageShow3(json,num) { //페이지 안의 내용 보여주는 함수
			index=num;
		
			var str="";
			str+="<table class='table-striped'>";
			str+="<tr>";
			str+="<th>구매자아이디</th>";
			str+="<th>구매소설번호</th>";
			str+="<th>구매소설제목</th>";
			str+="<th>구매작품</th>";
			str+="<th>구매날짜</th>";
			str+="<th>구매가격</th>";
			str+="</tr>";
			
			for(var i=(num - 1) *10;i<(num*10);i++){
				if(i<json.length){
				str+="<tr>";
				str+="<th>"+json[i].buyId+"</th>";
				str+="<th>"+json[i].storyNum+"</th>";
				str+="<th>"+json[i].storyTitle+"</th>";
				str+="<th>"+json[i].novelTitle+"</th>";
				str+="<th>"+json[i].buyDate+"</th>";
				str+="<th>"+json[i].price+"</th>";
				str+="</tr>";
			}else{
				str+="<tr>";
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
		
		
	 	function pageNum3(json) { //페이지 넘버 보여주는 함수
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
	 				pageShow3(json,1);
	 			}else{
	 				pageShow3(json,index-1);
	 			}
	 		}else if(num===-1){
	 			console.log(maxindex);
	 			if(index==maxindex){
	 				pageShow3(json,maxindex);
	 			}else{
	 				pageShow3(json,index+1);
	 			}
	 		}else{
	 			pageShow3(json,num);
	 		}
		}

	