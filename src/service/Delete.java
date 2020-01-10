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
	
	
	public Delete(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	public Forward dropmember() {
		Forward fw=new Forward();
		HttpSession session=request.getSession();
		DeleteDao deletedao=new DeleteDao();
		String id=(String)session.getAttribute("id");
		System.out.println("id="+id);
		String pw=request.getParameter("pw");
		System.out.println("pw="+pw);
		
        int check = deletedao.deleteMember(id,pw);

		if(check == 1){
            session.invalidate();
            fw.setPath("main.jsp");
	   }else {
		   fw.setPath("deleteFrm.jsp");
	   }
		return fw;
	 }
	}


