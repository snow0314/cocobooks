var json;
var index;
var maxindex;

function genreInfo() { // DB에 저장된 장르 보기
	$
			.ajax({
				url : "genreshow",
				type : "post",
				dataType : 'json',
				success : function(data) {
					json = data;
					var str = "";
					str += "<table class='table-striped'>";
					str += "<tr>";
					str += "<th>번호</th>";
					str += "<th>장르이름</th>";
					str += "<th>삭제</th>";
					str += "</tr>";
					for (var i = 0; i < json.length; i++) {
						str += "<tr>";
						str += "<th>" + (i + 1) + "</th>";
						str += "<th>" + json[i] + "</th>";
						str += "<th><input type='button' value='삭제' onclick='genreDelete("
								+ "\"" + json[i] + "\"" + ")'>";
						str += "</tr>";
					}
					str += "</table>";
					$("#content").html(str);
					genreAddButton();
				},
				error : function(error) {
					alert(error);
					console.log(error);
				}
			}); // ajax End
}

function genreAddButton() { // 장르 추가하는 버튼 보여주는 메소드
	var str = "";
	str += "<div id='genretext'>"; 
	str += "<input type='text' class='form-control' id='genreAddText' name='genreName' maxlength='10' placeholder='장르명을 입력해주세요'>";
	str += "</div>"; 
	str += "<input type='button' class='myButton' id='genreAddButton' onclick='genreAdd()' value='장르 추가하기'>";
	$("#bottom").html(str);
}

function genreAdd() { // 장르 추가하는 메소드
	$.ajax({
		url : "genreadd",
		type : "post",
		data : {
			"genreName" : $("#genreAddText").val()
		},
		dataType : 'text',
		success : function(data) {
			alert(data);
			genreInfo();
		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function genreDelete(genreName) { // 장르 삭제 메소드
	$.ajax({
		url : "genredelete",
		type : "post",
		data : {
			"genreName" : genreName
		},
		dataType : 'text',
		success : function(data) {
			alert(data);
			genreInfo();
		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function userinfo() { // 회원보기
	$.ajax({
		url : "userinfo",
		type : "post",
		dataType : 'json',
		success : function(data) {
			json = data;
			pageShow(json, 1);
			pageNum(json, "userInfo");

		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
} // userinfo End

function pageShow(json, num) { // 페이지 안의 내용 보여주는 함수(회원정보)
	index = num;

	var str = "";
	str += "<table class='table-striped'>";
	str += "<tr>";
	str += "<th>아이디</th>";
	str += "<th>이름</th>";
	str += "<th>나이</th>";
	str += "<th>성별</th>";
	str += "<th>코인</th>";
	str += "<th>종류</th>";
	str += "<th>이메일</th>";
	str += "</tr>";

	for (var i = (num - 1) * 10; i < (num * 10); i++) {
		if (i < json.length) {
			str += "<tr>";
			str += "<th>" + json[i].id + "</th>";
			str += "<th>" + json[i].name + "</th>";
			str += "<th>" + json[i].age + "</th>";
			str += "<th>" + json[i].gender + "</th>";
			str += "<th>" + json[i].coin + "</th>";
			str += "<th>" + json[i].kind + "</th>";
			str += "<th>" + json[i].email + "</th>";
			str += "</tr>";
		} else {
			str += "<tr>";
			str += "<th></th>";
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
	$("#content").html(str);
}

function pageNum(json, kind) { // 페이지 넘버 보여주는 함수
	var totalpage;
	console.log(kind);
	totalPages = json.length / 10;
	if (json.length / 10 > 0) {
		totalPages++;
	}
	maxindex = Math.floor(totalPages);
	var str2 = "";
	str2 += "<ul class='pagination justify-content-center'>";
	str2 += "<li class='page-item'><a class='page-link' onclick='newpage(" + 0
			+ ",\"" + kind + "\"" + ")'>Previous</a></li>";

	for (var k = 1; k < totalPages; k++) {
		str2 += "<li class='page-item'><a class='page-link' onclick='newpage("
				+ k + ",\"" + kind + "\"" + ")'>" + k + "</a></li>";
		str2 += "<input type='hidden' class='page' value='" + k + "'>";
	}
	str2 += "<li class='page-item'><a class='page-link' onclick='newpage(" + -1
			+ ",\"" + kind + "\"" + ")'>Next</a></li></ul>";
	str2 += "</ul>";

	if (kind == "black") { // 블랙리스트 해제 버튼 출력
		str2 += "<input id='blackbutton' class='myButton' type='button' onclick='blackDelete()' value='블랙리스트 해제'>";

	}

	$("#bottom").html(str2);

}

function newpage(num, kind) { // 페이지 이전, 다음 버튼 누를시 이동 제어하는 함수
	// 페이지 넘버, 종류
	console.log(kind);
	switch (kind) {
	case "userInfo": //
		if (num === 0) {
			if (index == 1) {
				pageShow(json, 1);
			} else {
				pageShow(json, index - 1);
			}
		} else if (num === -1) {
			console.log(maxindex);
			if (index == maxindex) {
				pageShow(json, maxindex);
			} else {
				pageShow(json, index + 1);
			}
		} else {
			pageShow(json, num);
		}
		break;

	case "black":
		if (num === 0) {
			if (index == 1) {
				blackListPageShow(json, 1);
			} else {
				blackListPageShow(json, index - 1);
			}
		} else if (num === -1) {
			console.log(maxindex);
			if (index == maxindex) {
				blackListPageShow(json, maxindex);
			} else {
				blackListPageShow(json, index + 1);
			}
		} else {
			blackListPageShow(json, num);
		}
		break;

	case "author":
		if (num === 0) {
			if (index == 1) {
				authorChangeShowPage(json, 1);
			} else {
				authorChangeShowPage(json, index - 1);
			}
		} else if (num === -1) {
			console.log(maxindex);
			if (index == maxindex) {
				authorChangeShowPage(json, maxindex);
			} else {
				authorChangeShowPage(json, index + 1);
			}
		} else {
			authorChangeShowPage(json, num);
		}
		break;
	case "novel":
		if (num === 0) {
			if (index == 1) {
				allNovelShowPage(json, 1);
			} else {
				allNovelShowPage(json, index - 1);
			}
		} else if (num === -1) {
			console.log(maxindex);
			if (index == maxindex) {
				allNovelShowPage(json, maxindex);
			} else {
				allNovelShowPage(json, index + 1);
			}
		} else {
			allNovelShowPage(json, num);
		}
		break;
	case "singo":
		if (num === 0) {
			if (index == 1) {
				singoInfoShowPage(json, 1);
			} else {
				singoInfoShowPage(json, index - 1);
			}
		} else if (num === -1) {
			console.log(maxindex);
			if (index == maxindex) {
				singoInfoShowPage(json, maxindex);
			} else {
				singoInfoShowPage(json, index + 1);
			}
		} else {
			singoInfoShowPage(json, num);
		}
		
		break;
	default:
		break;
	}

}

function blacklistshow() { // 블랙리스트 보기
	$.ajax({
		url : "blacklistshow",
		type : "post",
		dataType : "json",
		success : function(data) {
			json = data;
			blackListPageShow(json, 1);
			pageNum(json, "black");

		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function blackListPageShow(json, num) { // 페이지 안의 내용 보여주는 함수
	index = num;

	var str = "";
	str += "<table class='table-striped'>";
	str += "<tr>";
	str += "<th><input type='checkbox' id='allCheck'></th>";
	str += "<th>아이디</th>";
	str += "<th>이름</th>";
	str += "<th>나이</th>";
	str += "<th>성별</th>";
	str += "<th>코인</th>";
	str += "<th>종류</th>";
	str += "<th>이메일</th>";
	str += "</tr>";

	for (var i = (num - 1) * 10; i < (num * 10); i++) {
		if (i < json.length) {
			str += "<tr>";
			str += "<th><input type='checkbox' name='black' value='"
					+ json[i].id + "'></th>";
			str += "<th>" + json[i].id + "</th>";
			str += "<th>" + json[i].name + "</th>";
			str += "<th>" + json[i].age + "</th>";
			str += "<th>" + json[i].gender + "</th>";
			str += "<th>" + json[i].coin + "</th>";
			str += "<th>" + json[i].kind + "</th>";
			str += "<th>" + json[i].email + "</th>";
			str += "</tr>";
		} else {
			str += "<tr>";
			str += "<th></th>";
			str += "<th></th>";
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

	$("#content").html(str);
}

function blackDelete() { // 선택한 아이디의 블랙리스트 해제하는 기능
	var lists = [];
	$.ajaxSettings.traditional = true;
	$("input[name='black']:checked").each(function(i) { // jQuery로 for문 돌면서
														// check 된값 배열에 담는다
		lists.push($(this).val());
	});

	console.log(lists);
	$.ajax({
		url : "blacklistdelete",
		type : "post",
		data : {
			"black" : lists
		},
		dataType : 'text',
		success : function(data) {
			var msg = data;
			console.log(msg);
			alert(msg);
			blacklistshow();
		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End

}

function authorChangeShow() { // 전환신청한 작가들 보여주는 메소드
	$.ajax({
		url : "authorchangeshow",
		type : "post",
		dataType : 'json',
		success : function(data) {
			json = data;
			authorChangeShowPage(json, 1);
			pageNum(json, "author");

		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function authorChangeShowPage(json, num) { // 유료 작가 전환 페이지
	index = num;

	var str = "";
	str += "<table class='table-striped'>";
	str += "<tr>";
	str += "<th>아이디</th>";
	str += "<th>이름</th>";
	str += "<th>나이</th>";
	str += "<th>성별</th>";
	str += "<th>이메일</th>";
	str += "<th>총 조회수</th>";
	str += "<th>전환버튼</th>";
	str += "</tr>";

	for (var i = (num - 1) * 10; i < (num * 10); i++) {
		if (i < json.length) {
			str += "<tr>";
			str += "<th>" + json[i].id + "</th>";
			str += "<th>" + json[i].name + "</th>";
			str += "<th>" + json[i].age + "</th>";
			str += "<th>" + json[i].gender + "</th>";
			str += "<th>" + json[i].email + "</th>";
			str += "<th>" + json[i].totalView + "</th>";
			str += "<th><button class='transform' onclick='authorchangecomplete(\""
					+ json[i].id + "\")'>전환</button></th>";
			// "<input type='hidden' class='transformValue'
			// value='"+json[i].id+"'></th>";
			str += "</tr>";
		} else {
			str += "<tr>";
			str += "<th></th>";
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

	$("#content").html(str);
}

function authorchangecomplete(id) { // 전환버튼, 누르면 유료작가로 전환
	$.ajax({
		url : "authorchangecomplete",
		type : "post",
		data : {
			"authorId" : id
		},
		dataType : 'text',
		success : function(data) {
			var msg = data;
			alert(msg);
			authorChangeShow();

		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function allNovelShow() { // 모든 작품 리스트 불러오기
	$.ajax({
		url : "allnovelshow",
		type : "post",
		dataType : 'json',
		success : function(data) {
			json = data;
			allNovelShowPage(json, 1);
			pageNum(json, "novel");
		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End

}

function allNovelShowPage(json, num) { // 모든 작품 리스트 HTML
	index = num;

	var str = "";
	str += "<table class='table-striped'>";
	str += "<tr>";
	str += "<th>아이디</th>";
	str += "<th>작품 제목</th>";
	str += "<th>현재 등급</th>";
	str += "<th>전환버튼</th>";
	str += "</tr>";

	for (var i = (num - 1) * 10; i < (num * 10); i++) {
		if (i < json.length) {
			str += "<tr>";
			str += "<th>" + json[i].id + "</th>";
			str += "<th>" + json[i].title + "</th>";
			str += "<th>" + json[i].grade + "</th>";
			str += "<th><button onclick='novelGradeChange(\""
					+ json[i].novel_num + "\")'>전환</button></th>";
			str += "</tr>";
		} else {
			str += "<tr>";
			str += "<th></th>";
			str += "<th></th>";
			str += "<th></th>";
			str += "<th></th>";
			str += "</tr>";
		}

	}
	str += "</table>";

	$("#content").html(str);
}

function novelGradeChange(num) { //작품등급 변환하는 메소드
	$.ajax({
		url : "novelgradechange",
		type : "post",
		data : {
			"novelNum" : num
		},
		dataType : 'text',
		success : function(data) {
			var msg = data;
			alert(msg);
			allNovelShow();

		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function singoInfoShow() {
	$.ajax({
		url : "singoinfo",
		type : "post",
		dataType : 'json',
		success : function(data) {
			json = data;
			singoInfoShowPage(json, 1);
			pageNum(json, "singo");
			
		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function singoInfoShowPage(json, num) { // 신고받은 글 모두 보기
	index = num;

	var str = "";
	str += "<table class='table-striped'>";
	str += "<tr>";
	str += "<th>글번호</th>";
	str += "<th>신고한 아이디</th>";
	str += "<th>신고받은 아이디</th>";
	str += "<th>카테고리</th>";
	str += "<th>내용</th>";
	str += "<th>블랙리스트 추가</th>";
	str += "</tr>";

	for (var i = (num - 1) * 10; i < (num * 10); i++) {
		if (i < json.length) {
			str += "<tr>";
			str += "<th>" + json[i].story_num + "</th>";
			str += "<th>" + json[i].name + "</th>";
			str += "<th>" + json[i].id + "</th>";
			str += "<th>" + json[i].cartegory + "</th>";
			str += "<th>" + json[i].diteil + "</th>";
			str += "<th><button onclick='blackListAdd(\""
				+ json[i].id + "\")'>블랙리스트</button></th>";
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

	$("#content").html(str);
}

function storyDelete(num) { //신고받은 글 삭제  블랙리스트 추가
	$.ajax({
		url : "storydelete",
		type : "post",
		data: {"storyNum":num},
		dataType : 'text',
		success : function(data) {
			msg = data;
			alert(msg);
			singoInfoShow();
		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}

function blackListAdd(id) { // 블랙리스트 추가
	$.ajax({
		url : "blacklistadd",
		type : "post",
		data: {"blackId":id},
		dataType : 'text',
		success : function(data) {
			msg = data;
			alert(msg);
			singoInfoShow();
		},
		error : function(error) {
			alert(error);
			console.log(error);
		}
	}); // ajax End
}
