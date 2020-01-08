package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;

public class LogOut {
	HttpServletRequest request;
	HttpServletResponse response;
	public LogOut(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward logout() {
		Forward fw= new Forward();
		HttpSession session=request.getSession();
		session.invalidate();
		fw.setPath("main.jsp");
		fw.setRedirect(false);
		return fw;
	}
}
