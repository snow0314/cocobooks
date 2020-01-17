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
.root {
	border: solid 1px #2E9AFE;
}
.rootBtn{
	border:hidden;
}
.rootGrade{
	border: solid 1px #2E9AFE;
	width: 200px;
	height: 30px;
	margin-left: 50px;
	margin-top: -30px;
	
}
p {
	margin-left: 50px;
	font: bold;
}
a {
	cursor: pointer;
}

#container {
	width: 1000px;
	height: 1000px;
	margin-left: 350px;
	background-color: #F2F2F2;
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

#listBtn {
	margin-left: 750px;
}

#viewercontents {
	width: 450px;
	height: 800px;
	border-bottom: 1px solid gray;
}

.modal {
	text-align: center;
}

@media screen and (min-width: 768px) {
	.modal:before {
		display: inline-block;
		vertical-align: middle;
		content: " ";
		height: 100%;
	}
}

.modal-dialog {
	display: inline-block;
	text-align: left;
	vertical-align: middle;
}

.modal-dialog.modal-fullsize {
	width: 80%;
	height: 100%;
	margin: 0;
	padding: 0;
}

.modal-content.modal-fullsize {
	height: auto;
	min-height: 100%;
	border-radius: 0;
}

.like {
	width: 30px;
	background-color: white;
	border: 1px solid grey;
}

.singo {
	width: 200px;
	height: 100px;
	border-radius: 5px;
}

#show, .btn btn-primary {
	width: 200px;
	margin-left: 700px;
}

#rec_btn {
	margin-left: 200px;
}

textarea {
	width: 400px;
	height: 100px;
	resize: none; /* 크기고정 */
}
</style>


</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	${novelDetail}
	<input type="hidden" id="novelNum" value="">

	<!--Modal: 구매하는 모달-->
	<div class="modal fade" id="Modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modaltitle">구입확인창</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">X</span>
					</button>
				</div>
				<div class="modal-body" id="modalcontents">내용 입력 !!</div>
				<div class="modal-footer">
					<a class="btn" onclick='selectPurchase()'>예</a>
					<button class="btn" type="button" data-dismiss="modal">아니요</button>
				</div>
			</div>
		</div>
	</div>


	<!-- Modal 스크롤바 -->
	<div class="modal fade" id="readModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="story_title">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id='viewercontents'>내용</div>
					<div id='rec_btn'>
						<input type="hidden" name="story_num" id='likebtn' value="">
						<input type="button" class='btn btn-primary'
							onclick="recommendation()" value="추천"> <input type='text'
							class='like' value='' disabled>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				
			</div>
		</div>
	</div>

	<!--Modal: 신고하는 모달-->
	<div class="modal fade" id="Modal_report" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modaltitle">신고하시겠습니까?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">X</span>
					</button>
				</div>
				<div class="modal-body" id="modalcontents_report">
					<input type="radio" name="radioChk" value="abuse" checked="checked">욕설<br> <input
						type="radio"  name="radioChk" value="hateSpeech">혐오표현<br>
					<input type="radio"  name="radioChk" value="inapposite">부적절한
					콘텐츠<br> <input type="radio"  name="radioChk" value="mistake">외설적인 콘텐츠<br> <br>
					<h5>자세한 내용을 입력해주세요(200자 이내)</h5>
					<textarea id="report_contents" rows="" cols=""></textarea>
				</div>
				<div class="modal-footer">
					<a class="btn" onclick='report()'>예</a>
					<div id="report_num"></div>
					<button class="btn" type="button" data-dismiss="modal">아니요</button>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript" src="jsFile/novelDetail.js?ver9">
	var message = "${message}"; //구매하라는 메세지
	if (message != "") {
		alert(message);
	}
</script>


</html>