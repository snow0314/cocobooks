package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import service.Admin;
import service.AuthorChangeInsert;
import service.Authorchange;
import service.ChargeCoin;
import service.Delete;
import service.FaideWebFiction;
import service.Idsearch;
import service.LogOut;
import service.Login;
import service.Main;
import service.MyPage;
import service.NovelDetail;
import service.NovelInsert;
import service.PayMent;
import service.Pwsearch;
import service.Searchboard;
import service.Signup;
import service.Viewer;
import service.Write;
import service.Writing;


@WebServlet({"/signup","/main","/login","/idsearch","/pwsearch","/dropmember","/searchboard","/freewebfiction","/faidewebfiction",
				"/noveldetail","/report","/write","/bestwebnovel","/myPage","/payment","/authorchange","/signcompleted"
				,"/logout","/chargecoin","/admin","/authorchangeinsert","/writing","/novelinsert"})

public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getServletPath(); 
		Forward fw=null;
		System.out.println(cmd);
		
		switch (cmd) {
		case "/main": //메인화면
			
			Main main=new Main(request, response);
			fw=main.check();
			break;
		
		case "/signup": //회원가입
			
			fw=new Forward();
			fw.setPath("signup.jsp");
			break;
		
		case "/login": //로그인
			Login login=new Login(request, response);
			fw=login.check();
			break;
			
			
			
			
			
		case "/idsearch": //아이디 찾기
			Idsearch idsearch = new Idsearch(request, response);
			fw=idsearch.idsearch();
			break;
			
			
			
			
		
		case "/pwsearch": //비밀번호 찾기
			Pwsearch pwsearch = new Pwsearch(request, response);
			fw=pwsearch.pwsearch();
			break;
			
			
			
			
		case "/dropmember": //회원탈퇴
			Delete delete = new Delete(request, response);
			fw=delete.dropmember();
			break;
			
			
		case "/searchboard": //통합검색
			Searchboard searchB= new Searchboard(request, response);
			fw=searchB.totalSearch();
			break;
			
			
			
		case "/freewebfiction": //무료 웹 소설
			break;
			
			
			
			
		case "/faidewebfiction": //유료 웹 소설
			FaideWebFiction fadeWebFiction= new FaideWebFiction(request,response);
			fw=fadeWebFiction.move();
			break;
			
			
			
		case "/noveldetail": //작품 상세 페이지
			NovelDetail nDetail=new NovelDetail(request,response);
			fw=nDetail.novelDetailShow();
			break;

		case "/viewer": //작품 보기
			Viewer view=new Viewer(request,response);
			fw=view.view();
			
			break;
	
		
		case "/report": //신고하기
			break;
			
			
			
		case "/write": //글쓰기
			Write write= new Write(request, response);
			fw=write.add();
			break;
			
			
			
		case "/bestwebnovel": //베스트 소설 목록
			break;
			
			
			
			
		case "/myPage": //마이페이지 
			MyPage myPage=new MyPage();
			fw=myPage.move();
			break;
			
			
			
			
		case "/payment": //결제창으로 이동
			PayMent payment=new PayMent(request, response);
			fw=payment.move();
			break;
			
			
		
		case "/authorchange": //유료작가로 전환 신청
			Authorchange aC= new Authorchange();
			fw=aC.move();
			break;
			
		case "/authorchangeinsert":
			AuthorChangeInsert aChangeInsert=new AuthorChangeInsert(request,response);
			fw=aChangeInsert.upDate();
			
			break;
			
		case "/signcompleted": //회원가입 DB에 저장	
			Signup sign = new Signup(request,response);
			fw=sign.signcompleted();
			System.out.println("회원가입1");
			break;
		case "/logout":	
			LogOut logOut = new LogOut(request,response);
			fw=logOut.logout();
			
			
			
			break;
		case "/chargecoin": //결제 페이지에서 결제하기 버튼 눌렸을때 충전, DB 업로드
			ChargeCoin cCoin=new ChargeCoin(request,response);
			fw=cCoin.chargeCoin();
			
			
			break;
		case "/admin":
			Admin admin=new Admin(request,response);
			fw=admin.adminCheck();
			
			
			break;
		
		case "/writing"	: //작품등록 페이지 이동 and 여건 확인
			Writing wt=new Writing(request,response);
			
			fw=wt.check();
			break;
		case "/novelinsert":
			NovelInsert nInsert=new NovelInsert(request,response);
			fw=nInsert.insert();
			break;
		default:

			break;
		}
		
		
		if(fw!=null) {
			if(fw.isRedirect()) {
				response.sendRedirect(fw.getPath());
			}else {
				request.getRequestDispatcher(fw.getPath()).forward(request, response);
			}
		}
		
	} //doProcess End
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
