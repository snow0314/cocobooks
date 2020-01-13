package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.reflect.TypeToken;

import bean.FaideWebFictionBean;
import bean.Forward;
import bean.Member;
import dao.FaideWebFictionDao;

public class FaideWebFiction {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public FaideWebFiction(HttpServletRequest request, HttpServletResponse response) {
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
		List<FaideWebFictionBean> fwfList=null;
		
		FaideWebFictionDao fDao=new FaideWebFictionDao();
		fwfList=fDao.FaideWebFictionList();
		if(fwfList!=null&&fwfList.size()!=0) {
			System.out.println(fwfList);
			request.setAttribute("list",makehtml(fwfList));
			fw.setPath("faideWebFiction.jsp");
			fw.setRedirect(false);
		}
		else {
			fw.setPath("/main");
			fw.setRedirect(false);
		}
		return fw;
	}

	private String makehtml(List<FaideWebFictionBean> fwfList) {
		StringBuilder sb= new StringBuilder();
		for(int i=0 ;i<fwfList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+fwfList.get(i).getNovel_num()+"</td>");
			sb.append("<td>"+fwfList.get(i).getUser_id()+"</td>");
			sb.append("<td>"+fwfList.get(i).getTitle()+"</td>");
			sb.append("<td>"+fwfList.get(i).getIntro()+"</td>");
			sb.append("<td>"+fwfList.get(i).getGrade()+"</td>");
			sb.append("<td>"+fwfList.get(i).getGenre()+"</td>");
			sb.append("<td>"+fwfList.get(i).getLike()+"</td>");
			sb.append("</tr>");
			
		
		}
		return sb.toString();
	}

	
}
