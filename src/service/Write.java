package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.Forward;
import bean.Story;
import dao.DeleteDao;
import dao.FreeWebFictionDao;


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
			story.setSR_ID((String)session.getAttribute("id"));
			story.setSR_CONTENTS(request.getParameter("board_content"));
			story.setSR_TITLE(request.getParameter("board_subject"));
			//story.setSR_NOBLE_NUM(sR_NOBLE_NUM);
			boolean result;
			FreeWebFictionDao fictiondao = new FreeWebFictionDao();
			result=fictiondao.write(story);
			
			
			if(result==false){
                System.out.println("게시판 등록 실패");
                return null;
            }
            System.out.println("게시판 등록 완료");
			return null;
		}			   
}      
