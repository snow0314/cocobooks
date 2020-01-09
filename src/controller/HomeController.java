package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import service.ChargeCoin;
import service.LogOut;
import service.Login;
import service.Main;
import service.PayMent;
import service.Signup;
import service.Write;


@WebServlet({"/signup","/main","/login","/idsearch","/pwsearch","/dropmember","/searchboard","/freewebfiction","/faidewebfiction",
				"/noveldetail","/buynovel","/viewer","/report","/write","/bestwebnovel","/myPage","/payment","/authorchange","/signcompleted"
				,"/logout","/chargecoin"})
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
			break;
			
			
			
			
		
		case "/pwsearch": //비밀번호 찾기
			break;
			
			
			
			
		case "/dropmember": //회원탈퇴
			break;
			
			
			
			
		case "/searchboard": //통합검색
			break;
			
			
			
		case "/freewebfiction": //무료 웹 소설
			break;
			
			
			
			
		case "/faidewebfiction": //유료 웹 소설
			break;
			
			
			
		case "/noveldetail": //작품 상세 페이지
			break;
			
			
			
		case "/buynovel": //작품 구매 페이지, 라이트박스 이용
			break;
			
			
			
		case "/viewer": //작품 보기
			break;
			
			
			
		case "/report": //신고하기
			break;
			
			
			
		case "/write": //글쓰기
			Write write= new Write();
			break;
			
			
			
		case "/bestwebnovel": //베스트 소설 목록
			break;
			
			
			
			
		case "/myPage": //마이페이지 
			break;
			
			
			
			
		case "/payment": //결제하기
			PayMent payment=new PayMent(request, response);
			fw=payment.move();
			break;
			
			
		
		case "/authorchange": //유료작가로 전환 신청
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
