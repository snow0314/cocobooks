package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import bean.Story;
import dao.ViewerDao;

public class Viewer {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public Viewer(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward view() {
		Forward fw=new Forward();
		HttpSession session= request.getSession();
		int story_num=Integer.parseInt(request.getParameter("story_num"));
		String id=(String)session.getAttribute("id");
		ViewerDao vDao=new ViewerDao();
		Story st=new Story();
		
		//리턴값이 true면 유료, false면 무료
		boolean result=vDao.kindCheck(story_num);
		//일단 유료,무료 작품인지 구별
		if(result) {
			result=vDao.paidCheck(id,story_num);
			//구매목록 검사하여 구매한 작품이면 true, 아니면 false
			if(result) {
				//뷰어로 간다
				st=vDao.read(story_num);
				request.setAttribute("contents", st.getSR_CONTENTS());
				request.setAttribute("rec",st.getRec());
				fw.setPath("viewer.jsp");
				fw.setRedirect(false);
			}else {
				//작품 구매하라고 해야한다
			}
		}else {
			fw.setPath("viewer.jsp");
			fw.setRedirect(false);
		}
		//그 후 해당 아이디의 구매목록에서 해당 화수를 구입했는지 체크
		//구매가 안되어 있으면 구매하라는 창이
		//구매가 되어있으면 뷰어로 넘어간다
		//뷰어로 넘어가고 조회수 1를 더해준다
		return fw;
	}

}
