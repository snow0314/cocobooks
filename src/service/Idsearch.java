package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import dao.IdSearchDao;

public class Idsearch {
	HttpServletRequest request; 
	HttpServletResponse response;
	
	
	public Idsearch(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	public Forward idsearch() {
		IdSearchDao dao=new IdSearchDao();
		Forward search=new Forward();
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String id=dao.idsearch(name,email);
		request.setAttribute("id", id);
		if(id==null) {
			search.setPath("idsearch.jsp");
			
	}else {
		search.setPath("main.jsp");
	}
		return search;
	}

}
