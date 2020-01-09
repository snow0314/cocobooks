package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import bean.Member;
import dao.DeleteDao;

public class Delete {
	HttpServletRequest request; 
	HttpServletResponse response;
	HttpSession session=request.getSession();
	
	public Delete(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	public Forward signcompleted() {
		Forward fw=new Forward();
		
		DeleteDao deletedao=new DeleteDao();
		
		String id=(String)session.getAttribute("sessionID");
		String pw=request.getParameter("pw");
		
		
		
		DeleteDao dao = new DeleteDao();
        int check = dao.deleteMember(id,pw);

		if(check == 1){
            session.invalidate();
	   }
		return fw;
	 }
}

