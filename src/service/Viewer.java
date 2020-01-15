package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

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

	public String view() {
		
		HttpSession session= request.getSession();
		int story_num=Integer.parseInt(request.getParameter("story_num"));
		String id=(String)session.getAttribute("id");
		ViewerDao vDao=new ViewerDao();
		Story st=new Story();
		String json="";
		
		//리턴값이 true면 유료, false면 무료
		boolean result=vDao.kindCheck(story_num);
		//일단 유료,무료 작품인지 구별
		st=vDao.read(story_num); //글번호를 가지고 소설을 읽어온다
		
		if(result) {
			result=vDao.paidCheck(id,story_num);
			//구매목록 검사하여 구매한 작품이면 true, 아니면 false
			if(result) {
				//유료작품, 뷰어로 간다
				Gson gson =new Gson();
				json=gson.toJson(st); //제이슨으로 내용을 날려준다
				//request.setAttribute("rec",st.getRec()); //추천수
				
			}else {
				//작품을 구매해야한다
				request.setAttribute("message", "작품을 구매하세요");
			
				//작품 구매하라고 해야한다
			}
		}else {
			//무료작품, 뷰어로 간다
			Gson gson =new Gson();
			json=gson.toJson(st); //제이슨으로 내용을 날려준다
			//request.setAttribute("rec",st.getRec());
			
		}
		//그 후 해당 아이디의 구매목록에서 해당 화수를 구입했는지 체크
		//구매가 안되어 있으면 구매하라는 창이
		//구매가 되어있으면 뷰어로 넘어간다
		//뷰어로 넘어가고 조회수 1를 더해준다
		return json;
	}

}
