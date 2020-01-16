package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NovelGradeChangeDao;

public class NovelGradeChange {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public NovelGradeChange(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String novelgradechange() {
		int novelNum;
		novelNum=Integer.parseInt(request.getParameter("novelNum"));
		NovelGradeChangeDao nDao=new NovelGradeChangeDao();
		boolean result=nDao.novelgradechange(novelNum);
		
		if(result) {
			return "등급 전환 성공";
		}else {
			return "등급 전환 실패";
		}
	}

}
