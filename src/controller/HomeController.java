package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import service.Signup;


@WebServlet({"/signup","/main","/login","/idsearch","/pwsearch","/dropmember","/searchboard","/freewebfiction","/faidewebfiction",
				"/noveldetail","/buynovel","/viewer","/report","/write","/bestwebnovel","/myPage","/payment","/authorchange","/signcompleted"
				})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getServletPath(); 
		Forward fw=null;
		
		switch (cmd) {
		case "/main": //메인화면
	
			Login lg=new Login(request,response);
			fw=lg.check();
			break;
		
		case "/signup": //회원가입
			break;
			fw=new Forward();
			fw.setPath("signup.jsp");
			
		
		case "/login": //로그인
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
			break;
			
			
			
		case "/bestwebnovel": //베스트 소설 목록
			break;
			
			
			
			
		case "/myPage": //마이페이지 
			break;
			
			
			
			
		case "/payment": //결제하기
			break;
			
			
		
		case "/authorchange": //유료작가로 전환 신청
			break;
			
			
			
		case "/signcompleted": //회원가입 완료	
			Signup sign = new Signup(request,response);
			fw=sign.signcompleted();
			

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
