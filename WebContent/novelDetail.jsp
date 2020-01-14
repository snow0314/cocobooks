<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
div {
	border: solid 1px black;
}

#container {
	width: 1000px;
	height: 1000px;
}

table {
	height: 100%;
	width: 100%;
	text-align: center;
}

#top {
	display: flex;
	width: 900px;
	height: 70px;
	margin: 50px;
	text-align: center;
	font-size: 30px;
}

#author {
	width: 150px;
}

#title {
	width: 600px;
}

#novel_num {
	width: 150px;
}

#sub_title {
	width: 700px;
	height: 70px;
	margin: 50px;
	margin-left: 150px;
	margin-bottom: 20px;
}

#author_button {
	width: 200px;
	margin-left: 750px;
}

#contents {
	margin: 50px;
}

#contents_container {
	width: 900px;
	height: 500px;
	margin: 50px;
}

#contents {
	margin: 0px;
	height: 500px;
}

#bottom {
	width: 200px;
	margin-left: 750px;
}
</style>

</head>
<body>
	${novelDetail}
	<input type="hidden" id="novelNum" value="">
</body>
<script type="text/javascript">

	var json;
	var index;
	
	 window.onload=function(){
		$.ajax({
			url : "noveldetaillist",
			type : "post",
			data : {
				"novelNum" : $("#novelNum").val()
			},
			dataType : 'json',
			success : function(data) {
				json=data;
				novelDetailListShow(json,1);
				pageNum(json);
				
			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End
	} 
	
	 function novelDetailListShow(json, num) { // 작품 화수 보여주는 메소드
			index = num;

			var str = "";
			str += "<table class='table-striped'>";
			str += "<tr>";
			str += "<th>화수</th>";
			str += "<th>제목</th>";
			str += "<th>날짜</th>";
			str += "<th>조회수</th>";
			str += "<th>추천수</th>";
			str += "</tr>";
			var j=9;
			for (var i = (num - 1) * 10; i < (num * 10); i++) {
				if (i < json.length) {
					str += "<tr>";
					str += "<th>" + (i+1) + "</th>";
					str += "<th><a href='viewer?story_num="+json[i].SR_NUM+"'>" + json[i].SR_TITLE + "</a></th>";
					str += "<th>" + json[i].SR_DATE + "</th>";
					str += "<th>" + json[i].SR_VIEW_NUM + "</th>";
					str += "<th>" + json[i].rec + "</th>";
					str += "</tr>";
				} else {
					str += "<tr>";
					str += "<th></th>";
					str += "<th></th>";
					str += "<th></th>";
					str += "<th></th>";
					str += "<th></th>";
					str += "</tr>";
				}

			}
			str += "</table>";
			$("#contents").html(str);
		} 
	 
	 function pageNum(json) { // 페이지 넘버 보여주는 함수
			var totalpage;
			
			totalPages = json.length / 10;
			if (json.length / 10 > 0) {
				totalPages++;
			}
			maxindex = Math.floor(totalPages);
			var str2 = "";
			str2 += "<ul class='pagination justify-content-center'>";
			str2 += "<li class='page-item'><a class='page-link' onclick='newpage(" + 0
					 + ")'>Previous</a></li>";

			for (var k = 1; k < totalPages; k++) {
				str2 += "<li class='page-item'><a class='page-link' onclick='newpage("
						+ k +")'>" + k + "</a></li>";
				str2 += "<input type='hidden' class='page' value='" + k + "'>";
			}
			str2 += "<li class='page-item'><a class='page-link' onclick='newpage(" + -1
					+ ")'>Next</a></li></ul>";
			str2 += "</ul>";

			$("#paging").html(str2);

		}
	 
	 function newpage(num) { // 페이지 이전, 다음 버튼 누를시 이동 제어하는 함수

				if (num === 0) {
					if (index == 1) {
						novelDetailListShow(json, 1);
					} else {
						novelDetailListShow(json, index - 1);
					}
				} else if (num === -1) {
					console.log(maxindex);
					if (index == maxindex) {
						novelDetailListShow(json, maxindex);
					} else {
						novelDetailListShow(json, index + 1);
					}
				} else {
					novelDetailListShow(json, num);
				}
	 }
</script>

</html>