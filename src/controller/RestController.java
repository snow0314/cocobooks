package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.Charge;
import service.Genre;
import service.MyInfo;
import service.Signup;
import service.UserInfo;


@WebServlet({"/noveldetaillist","/list","/mynoble","/preference","/myinfo","/contents","/charge","/userinfo","/blacklistshow"
			,"/singoinfo","/noblelimit","/checkid","/checkemail","/genredelete","/genreshow","/genreadd"})
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
			
			
			
			break;	
		case "/authorchange": //관리자기능, 전환신청한 작가들 보기,변경
			
			
			
			break;
		case "/singoinfo": //관리자기능, 1회 이상 신고받은 모든 글 보기 및 확인 후 삭제 해준다
	
	
	
			break;
			
		case "/noblelimit": //관리자기능, 성인등급 제한
			
			
			
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
			
		case "/genredelete":
			Genre genre2=new Genre(request,response);
			json=genre2.genreDelete();
			
			break;
			
		case "/genreadd":
			Genre genre3=new Genre(request,response);
			json=genre3.genreAdd();
			
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
