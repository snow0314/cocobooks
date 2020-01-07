package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/noveldetaillist","/list","/mynoble","/preference","/myinfo","/contents","/charge","/userinfo","/blacklistshow","/authorchange"
			,"/singoinfo","/noblelimit","/genreadd"})
public class RestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getServletPath();
		String json=null; //제이슨 받을 문자열 변수
		
		switch (cmd) {
		case "/list": //작품 목록
			
			
			
			break;

		case "/noveldetaillist": //작품 목록
			
			
			
			break;	
		case "/mynoble": //내가 쓴 작품 목록
			
			
			
			break;	
		case "/preference": //선호작 목록
			
			
			
			break;	
		case "/myinfo": //회원가입시 입력한 정보 출력
	
	
	
			break;	
		case "/contents": //그동안 구매한 작품 목록
			
			
			
			break;		
		case "/charge": //그동안 충전한 내역
			
			
			
			break;		
		case "/userinfo": //관리자기능, 회원보기
			
			
			
			break;	
		case "/blacklistshow": //관리자기능, 블랙리스트 보기
			
			
			
			break;	
		case "/authorchange": //관리자기능, 전환신청한 작가들 보기,변경
			
			
			
			break;
		case "/singoinfo": //관리자기능, 1회 이상 신고받은 모든 글 보기 및 확인 후 삭제 해준다
	
	
	
			break;
			
		case "/noblelimit": //관리자기능, 성인등급 제한
			
			
			
			break;
		case "/genreadd": //관리자기능, 장르 추가 기능
			
			
			
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
