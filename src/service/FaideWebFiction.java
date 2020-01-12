package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;

public class FaideWebFiction {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public FaideWebFiction(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward move() {
		Forward fw= new Forward();
		HttpSession session= request.getSession();
		String id=(String) session.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			request.setAttribute("login", "로그인후 이용해주세요");
			fw.setPath("main.jsp");
			fw.setRedirect(false);
			return fw;
		}
		fw.setPath("faideWebFiction.jsp");
		fw.setRedirect(false);
		return fw;
	}
	
}
