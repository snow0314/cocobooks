	
	
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
		str+="<tr>";
		str+="<td class='indexa'>작품 번호</td>";
		str+="<td class='indexa'>작가</td>";
		str+="<td class='indexa'>작품 제목</td>";
		str+="<td class='indexa'>작품 소개</td>";
		str+="<td class='indexa'>등급</td>";
		str+="<td class='indexa'>장르</td>";
		str+="<td class='indexa'>총 추천수</td>";
		str+="</tr>";
		for(var i=(num - 1) *10;i<(num*10);i++){
			if(i<json.length){
			str+="<tr>";
			str+="<td>"+json[i].novel_num+"</td>";
			str+="<td>"+json[i].user_id+"</td>";
			str+="<td><a href='noveldetail?novelNum="+json[i].novel_num+"'>"+json[i].title+"</a></td>";
			str+="<td>"+json[i].intro+"</td>";
			str+="<td>"+json[i].grade+"</td>";
			str+="<td>"+json[i].genre+"</td>";
			str+="<td>"+json[i].like+"</td>";
			str+="</tr>";
			}
	
		console.log(str);
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

