package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StoryDeleteDao;

public class StoryDelete {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public StoryDelete(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String delete() {
		StoryDeleteDao sDao=new StoryDeleteDao();
		int num=Integer.parseInt(request.getParameter("storyNum"));
		boolean result=sDao.deleteOne(num);
		
		if(result) {
			result=sDao.deleteTwo(num);
			return "삭제 성공";
		}else {
			return "삭제 실패";
		}
	}
	
	

}
