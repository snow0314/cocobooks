package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import bean.Novel;
import dao.NovelDetailDao;

public class NovelDetail {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public NovelDetail(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward novelDetailShow() {
		Forward fw=new Forward();
		Novel novel=new Novel();
		int NovelNum=Integer.parseInt(request.getParameter("novelNum"));
		
		NovelDetailDao nDao=new NovelDetailDao();
		novel=nDao.novelDetailShow(NovelNum);
		
		
		return fw;
	}

}
