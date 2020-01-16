package service;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import dao.NovelInsertDao;

public class NovelInsert {
	HttpServletRequest request;
	HttpServletResponse response;
	public NovelInsert(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward insert() {
		Forward fw= new Forward();
		HttpSession session= request.getSession();
		String id =(String) session.getAttribute("id");
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		String grade=request.getParameter("grade");
		String genre=request.getParameter("genre");
		String kind= request.getParameter("kind");
		NovelInsertDao nDao= new NovelInsertDao();
		int genreNum=nDao.genreCheck(genre);
		if(genreNum!=0) {
			boolean result=nDao.insert(id,title,contents,grade,genreNum,kind);
			if(result) {
				request.setAttribute("insertMessage", "작품 등록이 성공하였습니다.");
				fw.setPath("novelPush.jsp");
				fw.setRedirect(false);
			}else {
				request.setAttribute("insertMessage", "제목과 작품 소개 글을 확인해주세요.");
				fw.setPath("novelPush.jsp");
				fw.setRedirect(false);
			}
		}else {
			request.setAttribute("genreMessage", "유효하지 않는 장르입니다.");
			fw.setPath("novelPush.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}

}
