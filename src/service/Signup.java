package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import bean.Member;

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
		
		request.getParameter("id");
		
		return null;
	}
	

}
