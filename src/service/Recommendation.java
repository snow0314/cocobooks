package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecommendationDao;

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
		boolean result=rDao.recCheck(id,sNum);
		
		if(result) {
			return "이미 추천한 글입니다.";
		}else {
			result=rDao.recAdd(id,sNum);
			if(result) {
				return "추천 하셨습니다.";
			}else {
				return "추천 실패";
			}
		}
		
	}

}
