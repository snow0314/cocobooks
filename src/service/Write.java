package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.Forward;
import bean.Story;
import dao.FreeWebFictionDao;
import dao.WriteDao;


public class Write {
		HttpServletRequest request; 
		HttpServletResponse response;
		
		
		public Write(HttpServletRequest request, HttpServletResponse response) {
			this.request=request;
			this.response=response;
		}
		
		
		
		public Forward add() {
			HttpSession session=request.getSession();
			Story story=new Story();
			Forward fw=new Forward();
			story.setSR_ID((String)session.getAttribute("id"));
			story.setSR_CONTENTS(request.getParameter("board_content"));
			story.setSR_TITLE(request.getParameter("board_subject"));
			story.setSR_NOBLE_NUM(Integer.parseInt(request.getParameter("novel")));
			WriteDao wDao=new WriteDao();
			boolean result=wDao.add(story);

			
			if(result==true){
                System.out.println("게시판 등록 완료");
                fw.setPath("noveldetail?novelNum="+story.getSR_NOBLE_NUM());
                fw.setRedirect(false);
                return fw;
            }
            System.out.println("게시판 등록 실패");
			return null;
		}



		public Forward wirtemove() {
			Forward fw=new Forward();
			String num=request.getParameter("novelNum");
			request.setAttribute("nobel_num", num);
			
			fw.setPath("write.jsp");
			fw.setRedirect(false);
			
			return fw;
		}			   
}      
