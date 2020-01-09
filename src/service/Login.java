package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.Forward;
import bean.Member;
import dao.LoginDao;

public class Login {
	HttpServletRequest request; 
	HttpServletResponse response;
	
	public Login(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	public Forward check() {
		Forward fw= new Forward();
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		Member mb = new Member();
		LoginDao lDao=new LoginDao();
		mb=lDao.loginCheck(id,pw);//true면 성공
		if(mb!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("kind", mb.getKind());
			System.out.println(mb.getCoin());
			System.out.println("로그인 성공");
			fw.setPath("/main");
			fw.setRedirect(false);
		}else {
			request.setAttribute("msg", "아이디 또는 비밀번호가 다릅니다.");
			System.out.println("아이디 또는 비밀번호가 다릅니다.");
			fw.setPath("main.jsp");
			fw.setRedirect(false);
		}
		lDao.close();
		return fw;
	}
}//class End
