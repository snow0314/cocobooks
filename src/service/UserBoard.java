package service;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.Forward;
import dao.UserBoardDao;

public class UserBoard {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public UserBoard(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward userWrite() {
		Forward fw= new Forward();
		HttpSession session= request.getSession();
		String id=(String) session.getAttribute("id");
		System.out.println("아이디:"+id);
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		
		UserBoardDao uDao=new UserBoardDao();
		boolean result=uDao.userWrite(id,title,contents);

		if(result) {
			System.out.println("글쓰기1");
			fw.setPath("userboard.jsp");
			fw.setRedirect(true);
			return fw;
		}

		return fw;
	}

	}

