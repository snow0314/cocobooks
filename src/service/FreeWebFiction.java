package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import bean.FreeWebFictionBean;
import dao.FreeWebFictionDao;

public class FreeWebFiction {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public FreeWebFiction(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward move() {
		Forward fw= new Forward();
		HttpSession session= request.getSession();
		String id=(String) session.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			request.setAttribute("login", "로그인후 이용해주세요");
			fw.setPath("main.jsp");
			fw.setRedirect(false);
			return fw;
		}
		List<FreeWebFictionBean> freeList=null;
		
		FreeWebFictionDao fDao=new FreeWebFictionDao();
		freeList=fDao.freeWebFictionList();
		if(freeList!=null&&freeList.size()!=0) {
			System.out.println(freeList);
			request.setAttribute("freelist",makehtml(freeList));
			fw.setPath("freeWebFiction.jsp");
			fw.setRedirect(false);
		}
		else {
			fw.setPath("/main");
			fw.setRedirect(false);
		}
		return fw;
	}

	private String makehtml(List<FreeWebFictionBean> freeList) { //작품 목록 리스트 HTML
		StringBuilder sb= new StringBuilder();
		sb.append("<tr>");
		sb.append("<td class='indexa'>작품 번호</td>");
		sb.append("<td class='indexa'>작가</td>");
		sb.append("<td class='indexa'>작품 제목</td>");
		sb.append("<td class='indexa'>작품 소개</td>");
		sb.append("<td class='indexa'>등급</td>");
		sb.append("<td class='indexa'>장르</td>");
		sb.append("<td class='indexa'>총 추천수</td>");
		sb.append("</tr>");
		for(int i=0 ;i<freeList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+freeList.get(i).getNovel_num()+"</td>");
			sb.append("<td>"+freeList.get(i).getUser_id()+"</td>");
			sb.append("<td><a href='noveldetail?novelNum="+freeList.get(i).getNovel_num()+"'>"+freeList.get(i).getTitle()+"</a></td>");
			sb.append("<td>"+freeList.get(i).getIntro()+"</td>");
			sb.append("<td>"+freeList.get(i).getGrade()+"</td>");
			sb.append("<td>"+freeList.get(i).getGenre()+"</td>");
			sb.append("<td>"+freeList.get(i).getLike()+"</td>");
			sb.append("</tr>");
			
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	}

