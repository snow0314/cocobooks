	var json;
	var index;
	var paid;
	$('#modalopen').click(function(e) { //구매창 클릭시 뜨는 모달 메소드
		var lists = [];
		$("input[name='purchase']:checked").each(function(i) { // jQuery로 for문 돌면서
			// check 된값 배열에 담는다
			lists.push($(this).val());
		});
		var cnt = lists.length;
		var str = "";
		str += "총 " + (cnt * 100) + "원 구입하시겠습니까?"
		$("#modalcontents").html(str);
		
		$('#Modal').modal("show");
	});

	window.onload = noveldetaillist();
		
		function noveldetaillist() { //처음 시작시 DB에 갔다와 게시물 보여주는 메소드
		$.ajax({
			url : "noveldetaillist",
			type : "post",
			data : {
				"novelNum" : $("#novelNum").val()
			},
			dataType : 'json',
			success : function(data) {
				json = data;
				paidCheck();
				novelDetailListShow(json, 1, paid);
				pageNum(json);

			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End
	}

	function paidCheck() { //아이디,작품번호를 이용하여 구매목록을 가져오는 메소드
		$.ajax({
			url : "paidCheck",
			type : "post",
			async : false,
			data : {
				"novelNum" : $("#novelNum").val()
			},
			dataType : 'json',
			success : function(check) {
				paid = check;
				console.log(paid);

			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End

	}

	function novelDetailListShow(json, num, paid) { // 작품 화수 보여주는 메소드
		index = num;
		var str = "";
		var flg;
		str += "<table class='table-striped'>";
		str += "<tr>";
		str += "<th><input type='checkbox' id='allCheck'></th>";
		str += "<th>화수</th>";
		str += "<th>제목</th>";
		str += "<th>날짜</th>";
		str += "<th>조회수</th>";
		str += "<th>추천수</th>";
		str += "</tr>";
	
		for (var i = (num - 1) * 10; i < (num * 10); i++) {
			if (i < json.length) {
				str += "<tr>";

				for (var j = 0; j < paid.length; j++) { //구매리스트와 비교해서 구매한 화수면 flg를 true로 변경
					if (json[i].SR_NUM == paid[j].SR_NUM) {
						flg = true;
					}
				}
				if (flg) { //구매한 화수, 체크박스 비활성화
					str += "<th><input type='checkbox' name='purchase' disabled='disabled' value='"
								+ json[i].SR_NUM + "'></th>";
					flg = false;
				} else { //구매하지 않은 화수, 체크박스 활성화
					str += "<th><input type='checkbox' name='purchase' value='"
								+ json[i].SR_NUM + "'></th>";
					flg = false;
				}

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
				novelDetailListShow(json, 1, paid);
			} else {
				novelDetailListShow(json, index - 1, paid);
			}
		} else if (num === -1) {
			console.log(maxindex);
			if (index == maxindex) {
				novelDetailListShow(json, maxindex, paid);
			} else {
				novelDetailListShow(json, index + 1, paid);
			}
		} else {
			novelDetailListShow(json, num, paid);
		}
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
				noveldetaillist();
				alert(msg);
				
			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End
		$('#Modal').modal("hide"); //모달 닫기
	}
	
	function preferenceAdd(Novel_num) {
		$.ajax({
			url : "preferenceadd",
			type : "post",
			data : {
				"Novel_num" : Novel_num
			},
			dataType : 'text',
			success : function(data) {
				var msg = data;
				noveldetaillist();
				alert(msg);
				
			},
			error : function(error) {
				alert(error);
				console.log(error);
			}
		}); // ajax End
	}
	
	
	
	