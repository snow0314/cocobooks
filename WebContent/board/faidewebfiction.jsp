<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
/* faidwebfiction 에서 사용되는 글 등록 버튼 테이블 크기 */
#faidwebfiction_add_button_table { width: 100%; margin: 0 auto 15px; /*position: relative; background: #bddcff; font-weight: bold;*/ }

/* 화면에 보여지는 글 등록 버튼 */
#faidwebfiction_add_button_table .add_button { cursor: pointer; border: 1px solid #bebebe; position: relative; left: 85%; width: 200px; height: 20px; padding: 6px 0 7px; text-align: center; font-weight: bold; }
/* #freewebfiction_add_button_table .add_button a { color: #ffffff; } */

/* 글 등록 버튼과 글 목록이 겹치지 않게 만들어준 아무것도 아닌것 */
#faidwebfiction_add_button_table .freewebfiction_add_button ul { width: 100%; overflow: hidden; height: 10px;}

/* freewebfiction 에서 사용하는 글 목록 테이블 크기*/
.faidwebfiction_table { width: 100%; }

/* 화면에 보여지는 글 목록 테이블 */
.list_table { width: 100%; }

/* 화면에 보여지는 caption */
.list_table caption { display: none; }

/* list_table 에서 사용되는 thead */
.list_table thead th { text-align: center; border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; padding: 8px 0; background: #faf9fa; }

/* list_table 에서 사용되는 tbody */
.list_table tbody td { text-align: center;  border-bottom: 1px solid #e5e5e5; padding: 5px 0; }

</style>

<body>
<!-- 등록버튼 시작 -->
<div id="faidwebfiction_add_button_table">
	<div class="faidwebfiction_add_button">
		<p class="add_button">작품 만들기</p>
		<ul></ul>
	</div>
</div>
<!-- 등록버튼 종료 -->

<!-- 테이블 시작 -->
<div class="faidwebfiction_table">
	<table class="list_table">
		<caption>유료 웹소설 게시판</caption>
		<colgroup>
			<col width="15%" />
			<col width="45%" />
			<col width="20%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>등록일자</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>열혈강호</td>
				<td>양정훈</td>
				<td>2020-01-10</td>
			</tr>
			<tr>
				<td>2</td>
				<td>용비불패</td>
				<td>이설형</td>
				<td>2020-01-10</td>
			</tr>
			<tr>
				<td>3</td>
				<td>천랑열전</td>
				<td>마재환</td>
				<td>2020-01-10</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- 테이블 종료 -->


</body>
</html>