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
	margin-left: 450px;
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
	
	<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modaltitle">구입확인창</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">X</span>
					</button>
				</div>
				<div class="modal-body" id="modalcontents">내용 입력 !!</div>
				<div class="modal-footer">
					<a class="btn" onclick='selectPurchase()' >예</a>
					<button class="btn" type="button" data-dismiss="modal">아니요</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var json;
	var index;
	var paid;
	$('#modalopen').click(function(e){ //구매창 클릭시 뜨는 모달 메소드
		var lists = [];
		$("input[name='purchase']:checked").each(function(i) { // jQuery로 for문 돌면서
			// check 된값 배열에 담는다
			lists.push($(this).val());
		});
		var cnt=lists.length;
		var str="";
		str+="총 "+(cnt*100)+"원 구입하시겠습니까?"
		$("#modalcontents").html(str);
		
		$('#Modal').modal("show");
	});
	
	window.onload = function noveldetaillist() { //처음 시작시 DB에 갔다와 게시물 보여주는 메소드
		$.ajax({
			url : "noveldetaillist",
			type : "post",
			data : {
				"novelNum" : $("#novelNum").val()
			},
			dataType : 'json',
			success : function(data) {
				json = data;
				paid=paidCheck();
				console.log(paid);
				novelDetailListShow(json, 1, paid);
				pageNum(json);

			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End
	}

	function paidCheck() {
		$.ajax({
			url : "paidCheck",
			type : "post",
			data : {
				"novelNum" : $("#novelNum").val()
			},
			dataType : 'json',
			success : function(data) {
				paid=data;
				console.log(paid);
				return paid;
			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End
	}
	
	function novelDetailListShow(json, num, paid) { // 작품 화수 보여주는 메소드
		index = num;
		console.log(paid);
		var str = "";
		str += "<table class='table-striped'>";
		str += "<tr>";
		str += "<th><input type='checkbox' id='allCheck'></th>";
		str += "<th>화수</th>";
		str += "<th>제목</th>";
		str += "<th>날짜</th>";
		str += "<th>조회수</th>";
		str += "<th>추천수</th>";
		str += "</tr>";
		var j = 9;
		for (var i = (num - 1) * 10; i < (num * 10); i++) {
			if (i < json.length) {
				str += "<tr>";
				str += "<th><input type='checkbox' name='purchase' value='"
						+ json[i].SR_NUM + "'></th>";
				str += "<th>" + (i + 1) + "</th>";
				str += "<th><a href='viewer?story_num=" + json[i].SR_NUM + "'>"
						+ json[i].SR_TITLE + "</a></th>";
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
		str2 += "<li class='page-item'><a class='page-link' onclick='newpage("
				+ 0 + ")'>Previous</a></li>";

		for (var k = 1; k < totalPages; k++) {
			str2 += "<li class='page-item'><a class='page-link' onclick='newpage("
					+ k + ")'>" + k + "</a></li>";
			str2 += "<input type='hidden' class='page' value='" + k + "'>";
		}
		str2 += "<li class='page-item'><a class='page-link' onclick='newpage("
				+ -1 + ")'>Next</a></li></ul>";
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

	var message = "${message}"; //구매하라는 메세지
	if (message != "") {
		alert(message);
	}

	function selectPurchase() { //체크된 화수를 구매하는 메소드
		var lists = [];
		$.ajaxSettings.traditional = true;
		$("input[name='purchase']:checked").each(function(i) { // jQuery로 for문 돌면서
			// check 된값 배열에 담는다
			lists.push($(this).val());
		});
		
		console.log(lists);
		$.ajax({
			url : "buynovel",
			type : "post",
			data : {
				"purchase" : lists
			},
			dataType : 'text',
			success : function(data) {
				var msg = data;
				console.log(msg);
				alert(msg);
				noveldetaillist();
			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End
	}
</script>

</html>