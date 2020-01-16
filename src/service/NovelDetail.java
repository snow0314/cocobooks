package service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Forward;
import bean.Member;
import bean.Novel;
import bean.Story;
import dao.NovelDetailDao;

public class NovelDetail {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public NovelDetail(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward novelDetailShow() {
		Forward fw=new Forward();
		Novel novel=new Novel();
		int NovelNum=Integer.parseInt(request.getParameter("novelNum"));
		HttpSession session = request.getSession();
		
		NovelDetailDao nDao=new NovelDetailDao();
		String id=(String)session.getAttribute("id");
		int age=nDao.novelDetailCheck(id);
		String grade=nDao.novelDetailGradeCheck(NovelNum);
		
		//나이가 19세 이하면 성인 등급 소설은 읽지 못한다.
		if(age<19 && grade.equals("성인")) {
			fw.setPath("main.jsp");
			fw.setRedirect(true);
			return fw;
		}else {
			novel=nDao.novelDetailShow(NovelNum);
			request.setAttribute("novelDetail",novelDetailHtml(novel));
			fw.setPath("novelDetail.jsp");
			fw.setRedirect(false);
			return fw;
		}
		
		
	}

	private String novelDetailHtml(Novel novel) { //소설 상세페이지  HTML
		StringBuilder sb=new StringBuilder();
		sb.append("<div class='root' id='container'>");
		sb.append("<div class='root'id='top'>");
		sb.append("<div class='root' id='author'>"+novel.getId()+"</div>");
		sb.append("<div class='root' id='title'>"+novel.getTitle()+"</div>");
		sb.append("<div class='root' id='novel_num'>"+novel.getNovel_num()+"</div>");
		sb.append("<input type='hidden' id='novelNum' value='"+novel.getNovel_num()+"'>");
		sb.append("</div>");
		
		sb.append("<div class='root' id='sub_title'>"+novel.getIntro()+"</div>");
		
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("id");
		if(id.equals(novel.getId())) {
			sb.append("<div class='root' id='author_button'>");
			//등급변경 신청하는 버튼, 작품번호를 매개변수로 가져간다. 아이디의 경우는 세션에 저장되어 있음, novelDetail.jsp에 함수 작성
			sb.append("<input type='submit' onclick='gradeChangeApply("+novel.getNovel_num()+")' value='등급변경'>");
			//글쓰기 버튼, 작품번호를 가지고 write URL로 이동한다.
			sb.append("<input type='button' onclick='writemove("+novel.getNovel_num()+")' value='글쓰기'>");
			sb.append("</div>");
			sb.append("<p>현재등급: "+novel.getGrade()+"</p>");
		}else {
			sb.append("<div class='root' id='bottom'>");
			sb.append("<input type='button' onclick='preferenceAdd("+novel.getNovel_num()+")' value='선호작 추가'>");
			sb.append("<input type='button' id='modalopen' value='구매'>");
			sb.append("</div>");
			sb.append("<p>현재등급: "+novel.getGrade()+"</p>");
		}
		sb.append("<div class='root' id=\"contents_container\">");
		sb.append("<div class='root' id=\"contents\">");
		sb.append("</div>");
		sb.append("<div class='root' id=\"paging\">");
		sb.append("페이징 버튼");
		sb.append("</div>"); 
		sb.append("<input type='button' id='listBtn' onclick='moveMain()' value='메인으로'>");
		sb.append("</div>"); //container End
		
		return sb.toString();
	}

	public String NovelDetailList() {
		NovelDetailDao nDao=new NovelDetailDao();
		List<Story> slist=new ArrayList<Story>();
		
		slist=nDao.NovelDetailList(Integer.parseInt(request.getParameter("novelNum")));
		String json;
		Gson gson =new Gson();
		Type shapeType = new TypeToken<List<Story>>() {}.getType(); 
		json=gson.toJson(slist,shapeType);

		return json;
	}

}
