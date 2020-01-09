package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;

public class PayMent {
	HttpServletRequest request; 
	HttpServletResponse response;
	public PayMent(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward move() {
		Forward fw=new Forward();
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		if(id!=null) {
			fw.setPath("payMent.jsp");
			fw.setRedirect(false);
		}else {
			fw.setPath("main.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}
	
}
