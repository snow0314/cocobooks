var json; 
    var index;
    var maxindex;
    
    function genreInfo() { //DB에 저장된 장르 보기
    	$.ajax({
    		url: "genreshow",
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

    				str+="<th><input type='button' value='삭제' onclick='genreDelete("+"\""+json[i]+"\""+")'>";
    				str+="</tr>";
    			}
    			str+="</table>";
    			$("#content").html(str);
    			genreAddButton();
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
	}
    
    function genreAddButton() { //장르 추가하는 버튼 보여주는 메소드
		var str="";
    	str+="<input type='text' class='form-control' id='genreAddText' name='genreName' maxlength='10'>";
		str+="<input type='button' class='myButton' id='genreAddButton' onclick='genreAdd()' value='장르 추가하기'>";
    	$("#bottom").html(str);
    }
    
	function genreAdd() { //장르 추가하는 메소드
		$.ajax({
    		url: "genreadd",
    		type: "post",
    		data: {"genreName":$("#genreAddText").val()},
    		dataType: 'text',
    		success: function(data) {
    			alert(data);
    			genreInfo();
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
	}
    
    function genreDelete(genreName) { //장르 삭제 메소드
    	$.ajax({
    		url: "genredelete",
    		type: "post",
    		data: {"genreName":genreName},
    		dataType: 'text',
    		success: function(data) {
    			alert(data);
    			genreInfo();
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
	
	
 	function pageNum(json,kind) { //페이지 넘버 보여주는 함수
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
		
		if(kind=="black"){ //블랙리스트 해제 버튼 출력
			str2+="<input id='blackbutton' class='myButton' type='button' onclick='blackDelete()' value='블랙리스트 해제'>";
			
		}
		
		
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
 	
 	function blacklistshow() { //블랙리스트 보기
		$.ajax({
    		url: "blacklistshow",
    		type: "post",
    		dataType: 'json',
    		success: function(data) {
    			json=data;
    			blackListPageShow(json,1);
    			pageNum(json, "black");
    			
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
	}
 	
 	function blackListPageShow(json,num) { //페이지 안의 내용 보여주는 함수
		index=num;
	
		var str="";
		str+="<table class='table-striped'>";
		str+="<tr>";
		str+="<th><input type='checkbox' id='allCheck'>아이디</th>";
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
			str+="<th><input type='checkbox' name='black' value='"+json[i].id+"'>"+json[i].id+"</th>";
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
 	
	function authorChangeShow() {
		$.ajax({
    		url: "authorchangeshow",
    		type: "post",
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
	}
	
	function blackDelete() {
		var lists = [];
		$("input[name='black']:checked").each(function(i){   //jQuery로 for문 돌면서 check 된값 배열에 담는다
			   lists.push($(this).val());
			  });
		
		console.log(lists);
		$.ajax({
    		url: "blacklistdelete",
    		type: "post",
    		data:{'black':lists},
    		dataType: 'json',
    		success: function(data) {
    			alert(data);
    			blacklistshow();
    			
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End	
		
	}
 	
 	