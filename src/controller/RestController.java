package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Novel;
import service.AllNovelShow;
import service.Author;
import service.BlackList;
import service.Charge;
import service.Contents;
import service.Genre;
import service.MyInfo;
import service.NovelDetail;
import service.NovelGradeChange;
import service.PaidCheck;
import service.PaidNovelSearch;
import service.PreferenceAction;
import service.Purchase;
import service.Recommendation;
import service.Signup;
import service.SingoInfo;
import service.StoryDelete;
import service.UserInfo;
import service.Viewer;


@WebServlet({"/noveldetaillist","/list","/mynoble","/preference","/myinfo","/contents","/charge","/userinfo","/blacklistshow"
			,"/singoinfo","/novelgradechange","/checkid","/checkemail","/genredelete","/genreshow","/genreadd","/authorchangeshow"
			,"/blacklistdelete","/authorchangecomplete","/allnovelshow","/paidnovelsearch","/storydelete","/blacklistadd"
			,"/buynovel","/paidCheck","/preferenceadd","/viewer","/recommendation"})
public class RestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getServletPath();
		String json=null; //제이슨 받을 문자열 변수
		
		switch (cmd) {
		case "/list": //작품 목록
			
			
			
			break;

		case "/noveldetaillist": //작품화 목록
			NovelDetail novel=new NovelDetail(request, response);
			json=novel.NovelDetailList();
			
			break;	
		case "/mynoble": //내가 쓴 작품 목록
			
			
			
			break;	
		case "/preference": //선호작 목록
			
			
			
			break;	
		case "/myinfo": //회원가입시 입력한 정보 출력
			MyInfo myinfo=new MyInfo(request,response);
			json=myinfo.showMyInfo();
			
	
			break;	
		case "/contents": //그동안 구매한 작품 목록
			Contents ct=new Contents(request,response);
			json=ct.buyList();
			
			break;		
		case "/charge": //그동안 충전한 내역
			Charge charge=new Charge(request,response);
			json=charge.allChargeList();
			
			break;		
		case "/userinfo": //관리자기능, 회원보기
			UserInfo info=new UserInfo(request,response);
			json=info.allUserInfo();
			
			break;	
		case "/blacklistshow": //관리자기능, 블랙리스트 보기
			BlackList bList=new BlackList(request,response);
			json=bList.blacklistshow();
			
			break;	
		case "/authorchangecomplete": //관리자기능, 전환신청한 작가들 변경
			Author author=new Author(request,response);
			json=author.authorchange();
			
			break;
		case "/singoinfo": //관리자기능, 1회 이상 신고받은 모든 글 보기
			SingoInfo si=new SingoInfo(request,response);
			json=si.singoinfo();
	
			break;
			
		case "/novelgradechange": //관리자기능, 작품등급 변환하는 기능
			NovelGradeChange nChange=new NovelGradeChange(request,response);
			json=nChange.novelgradechange();
			
			break;
		case "/genreshow": //관리자기능, 장르 추가 기능
			Genre genre=new Genre();
			json=genre.genreShow();
			
			break;
			
		case "/checkid": //아이디 중복 검사
			Signup sign=new Signup(request, response);
			json=sign.checkid(request.getParameter("idcheck"));
			
			break;
			
		case "/checkemail": //이메일 중복 검사
			Signup sign2=new Signup(request, response);
			json=sign2.checkemail(request.getParameter("idcheck"));
			
			break;
			
		case "/genredelete": //장르 삭제하기
			Genre genre2=new Genre(request,response);
			json=genre2.genreDelete();
			
			break;
			
		case "/genreadd": //장르 추가하기
			Genre genre3=new Genre(request,response);
			json=genre3.genreAdd();
			
			break;	
			
		case "/authorchangeshow": //전환신청한 작가들 보기
			Author author2=new Author(request,response);
			json=author2.authorShow();
			
			break;
			
		case "/blacklistdelete": //블랙리스트 해제 기능
			BlackList bList2=new BlackList(request,response);
			json=bList2.blackListDelete();
			
			
			break;
		case "/allnovelshow": //모든 작품리스트 보기
			AllNovelShow novelShow=new AllNovelShow(request,response);
			json=novelShow.allnovelshow();
			break;
		case "/paidnovelsearch": //구입한 작품 보기
			PaidNovelSearch pNS=new PaidNovelSearch(request,response);
			json=pNS.search();
			
			break;
			
		case "/storydelete": //신고받은 글 삭제
			StoryDelete sDelete =new StoryDelete(request,response);
			json=sDelete.delete();
			
			break;
			
		case "/blacklistadd": //블랙리스트에 추가
			BlackList bAdd=new BlackList(request,response);
			json=bAdd.blackListAdd();
		
			break;
	
		case "/buynovel": //소설 화수 구매
			Purchase p=new Purchase(request,response);
			json=p.buynovel();
			
			break;
		case "/paidCheck": //구매했는지 체크
			PaidCheck check=new PaidCheck(request,response);
			json=check.paidCheck();
			
			break;
		case "/preferenceadd": //선호작에 추가하는 기능
			PreferenceAction pa=new PreferenceAction(request,response);
			json=pa.preferenceAdd();
			break;
			
		case "/viewer": //작품 보기
			Viewer view=new Viewer(request,response);
			json=view.view();
			
			break;	
		case "/recommendation":
			Recommendation rc=new Recommendation(request,response);
			json=rc.recAdd();
			
			break;
		default:
			break;
		}
		
		
		if(json!=null) { //제이슨 반환
			response.setContentType("test/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.write(json);
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
