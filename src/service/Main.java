package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import bean.Member;
import dao.CoinCheckDao;

public class Main {
	HttpServletRequest request; 
	HttpServletResponse response;
	
	public Main(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward check() {
		Forward fw= new Forward();
		HttpSession session= request.getSession();
		String id=(String) session.getAttribute("id");
		if(id!=null) {
			CoinCheckDao ccDao= new CoinCheckDao();
			Member mb = new Member();
			 mb=ccDao.coinCheck(id);
			 if(mb!=null) {
				 session.setAttribute("coin", mb.getCoin());
				 fw.setPath("main.jsp");
				 fw.setRedirect(false);
			 }else {
				 fw.setPath("main.jsp");
				 fw.setRedirect(false);
			 }
		}else {
			fw.setPath("main.jsp");
			 fw.setRedirect(false);
		}
		return fw;
	}
	
}
