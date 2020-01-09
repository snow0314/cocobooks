<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 페이지</title>
<style>
.memberdrop{ 
 width:600px;
 margin:auto;
}
.twobutton{ 
 margin-top:20px;
 }
</style>
<script type="text/javascript">
        // 비밀번호 미입력시 경고창
        function checkValue(){
            if(!document.deleteform.password.value){
                alert("비밀번호를 입력하지 않았습니다.");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="memberdrop"></div>
<h1>회원탈퇴</h1>
<br>
<div id="header" style="height:8px; background-color:skyblue;">
	</div>
<div class="dtail">
<ul>
<li>탈퇴 후에는 동일한 아이디로 재가입 및 복구가 불가능하니 신중하게 선택해 주시기 바랍니다.</li>
<li>탈퇴 후 캐쉬 및 코인은 모두 소멸되어 환불이 불가능합니다. 또한 재가입하더라도 복구되지 않습니다.</li>
<li>탈퇴 후 결제내역 및 구매내역 또한 이용이 불가능합니다.</li>
<li>탈퇴 시 삭제 정보.
<ul>
<li>게시글, 댓글</li>
<li>내가 등록한 선호작 정보.</li>
<li>코코북스에서 직접 제공하는 모든 유료형 서비스의 구입/구매 내용</li>
<li>삭제된 데이터는 복구가 불가능합니다.</li>
</ul>
</li>
<li>위 항목에 해당하지 않는 사항은 이용약관, 유료이용약관, 개인정보처리방침에 따릅니다.</li>
<li>마지막 수정일 : 2020년 01월 08일</li>
</ul>
</div>
<form name="deleteFrm" method="post" onsubmit="return checkValue()">
<div class="agree">
<h4>탈퇴동의</h4>
<label for="memberLeaveAgree">
<input type="checkbox" id="memberLeaveAgree" value="Y" required="required" />
<span>상단의 주의사항을 확인했고, 탈퇴하겠습니다.</span>
</label>
</div>
<div class="mbpass">
<h4>현재 비밀번호</h4>
<input type="password" class="text" placeholder="비밀번호를 입력하세요." required="required"/>
</div>
<div class="twobutton">
<input type="submit" value="확인" class="a button" formaction="dropmember"/>
<input type="submit" value="취소" class="tow button" formaction="main"/>
</div>
</form>
</body>
</html>