package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;

public class Signup {
	HttpServletRequest request; 
	HttpServletResponse response;
	
	public Signup(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward signcompleted() {
		Forward fw=new Forward();
		request.getParameter("id");
		
		return null;
	}
	

}
