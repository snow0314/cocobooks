<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.maintxt{
			font-size: 50px;
			margin-left: 740px;
			margin-top: 60px;
			margin-bottom: 70px;
		}
		table{
			width: 100%;
			height: 100%;
			border: 1px solid #444444;
    		border-collapse: collapse;
			font-size: 20px;
		}
		td{
			border: 2px solid black;
		}
		.selectBox{
			width: 200px;
			height: 40px;
			font-size: 22px;
			margin-left: 1100px;
			margin-top: 20px;
		}
		.txtBox{
			width: 200px;
			height: 24px;
			font-size: 15px;
			padding-top: 9.7px;
		}
		.search{
			height: 40px;
			width: 50px;
			padding-top: 7px;
			font-size: 18px;
		}
		.createNovel{
			height: 40px;
			width: 90px;
			padding-top: 7px;
			font-size: 18px;
		}
	</style>
</head>
<body>
<form>
	<div class="maintxt">유료 웹소설</div>
	
	
	
	<table>
		<tr>
			<td>작품 번호</td>
			<td>작가</td>
			<td>작품 제목</td>
			<td>작품 소개</td>
			<td>장르</td>
			<td>추천</td>
		</tr>
		<tr>
			<td >123</td>
			<td>aa123</td>
			<td>아ㅏ아아아아 div 개짜증나는 모험</td>
			<td>ㅁ주이ㅟㅏㅁㅈ위ㅏㅟㅏㅁㅇ쥐ㅏ윚뮈asdlwanldnawlnasddlnlawndaw</td>
			<td>판타지</td>
			<td>21321321</td>
		</tr>
		<tr>
			<td >123</td>
			<td>aa123</td>
			<td>아ㅏ아아아아 div 개짜증나는 모험</td>
			<td>ㅁ주이ㅟㅏㅁㅈ위ㅏㅟㅏㅁㅇ쥐ㅏ윚뮈asdlwanldnawlnasddlnlawndaw</td>
			<td>판타지</td>
			<td>21321321</td>
		</tr>
		<tr>
			<td >123</td>
			<td>aa123</td>
			<td>아ㅏ아아아아 div 개짜증나는 모험</td>
			<td>ㅁ주이ㅟㅏㅁㅈ위ㅏㅟㅏㅁㅇ쥐ㅏ윚뮈asdlwanldnawlnasddlnlawndaw</td>
			<td>판타지</td>
			<td>21321321</td>
		</tr>
		<tr>
			<td >123</td>
			<td>aa123</td>
			<td>아ㅏ아아아아 div 개짜증나는 모험</td>
			<td>ㅁ주이ㅟㅏㅁㅈ위ㅏㅟㅏㅁㅇ쥐ㅏ윚뮈asdlwanldnawlnasddlnlawndaw</td>
			<td>판타지</td>
			<td>21321321</td>
		</tr>
		
	</table>
	
	<div>
	<select name="search" class="selectBox">
    <option value="num">작품번호</option>
    <option value="user">작가</option>
    <option value="name">제목</option>
    <option value="장르">장르</option>
	</select>
	<input type="text" class="txtBox">
	<input type="submit" value="검색" class="search">
	<input type="submit" value="작품등록" class="createNovel">
	</div>
	</form>
</body>
</html>