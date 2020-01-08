package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import bean.Member;
import dao.SignupDao;

public class Signup {
	HttpServletRequest request; 
	HttpServletResponse response;
	
	public Signup(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward signcompleted() {
		Forward fw=new Forward();
		Member mb= new Member();
		SignupDao signdao=new SignupDao();
		
		mb.setId(request.getParameter("id"));
		mb.setPw(request.getParameter("pw"));
		mb.setName(request.getParameter("name"));
		mb.setAge(Integer.parseInt(request.getParameter("age")));
		mb.setGender(request.getParameter("gender"));
		mb.setEmail(request.getParameter("email"));
		
		boolean result=signdao.signup(mb);
		
		if(result) {
			fw.setPath("main.jsp");
			fw.setRedirect(false);
			System.out.println("회원가입 성공 서비스 클래스");
		}else {
			System.out.println("회원가입 실패 서비스 클래스");
		}
		
		return fw;
	}
	

}
