<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewer</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<style>
		.header{
			display: flex;
			margin-left: 230px;
		}
		.heading{
			margin-top: 10px;
		}
		.novel{
			color: aliceblue;
		}
		.main_button
		{display: flex;
			margin-top:200px;
		}
		.like{
			width: 30px;
			background-color: white;
			border: 1px solid grey;
		}
		.singo{
			width: 200px;
			height: 100px;
			border-radius: 5px;
		}
		#show,.btn btn-primary{
			width: 200px;
			margin-left: 700px;
		}
	</style>
</head>
<body>
	<!-- Button trigger modal-->
	<div class="main_button">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalPush" id="show"
> <a class="novel">소설 보기</a></button>
	<div>
		<input type="button" value="신고하기" class="singo">
	</div>
</div>

<!--Modal: modalPush-->
<div class="modal fade" id="modalPush" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
  aria-hidden="true">
  <div class="modal-dialog modal-notify modal-info" role="document">
    <!--Content-->
    <div class="modal-content text-center">
      <!--Body-->
      <div class="modal-body">

        <i class="fas fa-bell fa-4x animated rotateIn mb-4"></i>

        <p> ${contents}</p>
		<input type="submit" value="추천">
     	<input type='text' class='like' value='${rec}' disabled> 
      </div>

      <!--Footer-->
      <div class="modal-footer flex-center">
        <a type="button" class="btn btn-outline-info waves-effect" data-dismiss="modal">끄기</a>
      </div>
    </div>
    <!--/.Content-->
  </div>
</div>
<!--Modal: modalPush-->
</body>
</html>