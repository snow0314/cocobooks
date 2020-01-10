package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import bean.Member;
import dao.AuthorChangeInsertDao;

public class AuthorChangeInsert {

	HttpServletRequest request;
	HttpServletResponse response;

	public AuthorChangeInsert(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward upDate() { //이미 신청이라면 신청된 회원입니다 라고 바꿔줘야됨
		Forward fw=new Forward();
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		AuthorChangeInsertDao aCIDao= new AuthorChangeInsertDao();
		Member mb=null;
		mb=aCIDao.check(id);
		if(mb.getApply().equals("신청")) {
		request.setAttribute("msg", "이미 신청된 회원입니다.");
		fw.setPath("myPage.jsp");
		fw.setRedirect(false);
		}else {
			System.out.println(mb.getApply());
			boolean result=aCIDao.upDate(id);
			if(result) {
				request.setAttribute("msg","신청이 완료 되었습니다.");
				fw.setPath("myPage.jsp");
				fw.setRedirect(false);
			}
			else {
				fw.setPath("main.jsp");
				fw.setRedirect(false);
			}
		}
		aCIDao.close();
		return fw;
	}

}
