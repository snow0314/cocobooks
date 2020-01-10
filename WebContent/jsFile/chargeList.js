$("#chargeList").click(function () {
			$.ajax({
	    		url: "charge",
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

	