package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import dao.IdSearchDao;
import dao.PwSearchDao;

public class Pwsearch {
	HttpServletRequest request; 
	HttpServletResponse response;
	
	
	public Pwsearch(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	public Forward pwsearch() {
		PwSearchDao dao=new PwSearchDao();
		Forward search=new Forward();
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		String pw=dao.pwsearch(id,email);
		request.setAttribute("pwsearch", pw);
		if(pw==null) {
			search.setPath("pwsearch.jsp");
			
	}else {
		search.setPath("pwsearchafter.jsp");
	}
		return search;
	}

}
