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

#listBtn {
	margin-left: 750px;
}

#viewercontents {
	width: 450px;
	height: 800px;
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
</style>

</head>
<body>
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

	<!--Modal: 소설보는 모달-->
	<div class="modal fade" id="readModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-fullsize" role="document">
			<!--Content-->
			<div class="modal-content modal-fullsize">
				<!--Body-->
				<div class="modal-body">
					<i class="fas fa-bell fa-4x animated rotateIn mb-4"></i>
					<div id='viewercontents'>내용</div>
					
						<input type="hidden" name="story_num" id='likebtn' value=""> <input
							type="button" onclick="recommendation()" value="추천"> <input type='text' class='like'
							value='' disabled>
				
				</div>
				<!--Footer-->
				<div class="modal-footer flex-center">
					<a type="button" class="btn btn-outline-info waves-effect"
						data-dismiss="modal">끄기</a>
				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>
	<!--Modal: modalPush-->
</body>
<script type="text/javascript" src="jsFile/novelDetail.js">
	var message = "${message}"; //구매하라는 메세지
	if (message != "") {
		alert(message);
	}
</script>


</html>