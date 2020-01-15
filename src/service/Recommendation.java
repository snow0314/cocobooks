package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Recommendation {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public Recommendation(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String recAdd() {
		RecommendationDao rDao=new RecommendationDao();
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("id");
		int sNum=Integer.parseInt(request.getParameter("story_num"));
		
		boolean result=rDao.recAdd();
		
		
		return null;
	}

}
