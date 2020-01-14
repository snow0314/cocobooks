<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
div {
	border: solid 1px black;
}

#container {
	width: 1000px;
	height: 1000px;
}

table {
	border: solid 1px black;
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
</body>
<script type="text/javascript">

	window.onload=function(){
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
	
</script>

</html>