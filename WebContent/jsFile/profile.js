$("#profile").click(function () {
		$.ajax({
    		url: "myinfo",
    		type: "post",
    		//data: {"page":$("page").value},
    		dataType: 'json',
    		success: function(data) {
    			console.log(data);
    			json=data;
    			pageShow1(json);
    		},
    		error: function(error) {
    			alert(error);
    			console.log(error);
    		}
    	}); //ajax End
});
	
	function pageShow1(json) { //페이지 안의 내용 보여주는 함수
		var str="";
		str+="<div class='idbox'>";
		str+="<div class='idtxt1'>아이디 -</div><div class='idtxt2'>"+json.id+"</div>";
		str+="</div>";
		str+="<div class='nameBox'>";
		str+="<div class='nametxt1'>이름 -</div><div class='nametxt2'>"+json.name+"</div>";
		str+="</div>";
		str+="<div class='ageBox'>";
		str+="<div class='agetxt1'>나이 -</div><div class='agetxt2'>"+json.age+"</div>";
		str+="</div>";
		str+="<div class='emailBox'>";
		str+="<div class='emailtxt1'>이메일 -</div><div class='emailtxt2'>"+json.email+"</div>";
		str+="</div>";
		str+="<div class='coinBox'>";
		str+="<div class='cointxt1'>코인 -</div><div class='cointxt2'>"+json.coin+"</div>";
		str+="</div>";
		str+="<div class='kindBox'>";
		str+="<div class='kindtxt1'>회원종류 -</div><div class='kindtxt2'>"+json.kind+"</div>";
		str+="</div>";
		str+="<div class='applyBox'>";
		str+="<div class='applytxt1'>유료작가 신청여부 -</div><div class='applytxt2'>"+json.apply+"</div>";
		str+="</div>";
		$("#content").html(str);
		$("#bottom").html("");
	}