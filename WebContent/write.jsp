<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 글쓰기</title>
    
     
    <style type="text/css">
        #title{
            height : 16;
            font-family :'돋움';
            font-size : 12;
            text-align :center;
			font-weight: bold;
        }
       table{
			width: 100%;
			height: 100%;
			border: 2px solid #444444;
    		border-collapse: collapse;
			font-size: 20px;
		}
		td{
			border: 2px solid black;
		}
		.mainTxt{
			margin-left: 80px;
			font-size: 46px;
		}
		.btn{
			width: 270px;
			height: 60px;
			background-color: #2E9AFE;
			font-size: 25px;
			font-weight: bold;
			color: white;
			border-radius: 15px;
		}
		.txtar{
			font-size: 20px;
			overflow: auto;
			 font-family :'돋움';
			font-weight: bold;
		}
    </style>
    
</head>
<body>
  <br>
    <b class="mainTxt"><font color="gray">글쓰기</font></b>
    <br>
    
    <form method="post">
    <input type="hidden" name="board_id" value="${id}">
    <table id="write">
        <tr>
            <td id="title">작성자</td>
            <td>${id}</td>
        </tr>
            <tr>
            <td id="title">
                제 목
            </td>
            <td>
                <input name="board_subject" type="text" size="130" maxlength="100" value="" class="txtar">
            </td>        
        </tr>
        <tr>
            <td id="title">
                내 용
            </td>
            <td>
                <textarea name="board_content" cols="150" rows="30" class="txtar" id="txtar"></textarea>            
            </td>        
        </tr>
        <tr align="center" valign="middle">
            <td colspan="5">
                <input type="submit" value="등록" class="btn" formaction="write">
                <input type="button" value="작성취소" class="btn" onclick="reset1()">
                <input type="button" value="목록" class="btn" onclick="list1()">            
            </td>
        </tr>
    </table>    
    </form>
    <script>
		function reset1(){
			var confim=confirm(" 작성된 내용이 사라집니다. 취소하시겠습니까? ");
			if(confim==true){
				location.href="noveldetail";	
			}
		}
		
		
		function list1(){
			var confim=confirm(" 작성된 내용이 사라집니다. 돌아가시겠습니까? ");
			if(confim==true){
				location.href="noveldetail";	
			}
		}
	</script>
</body>
</html>