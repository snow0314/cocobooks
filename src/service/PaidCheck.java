package service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Member;
import bean.Story;
import dao.paidCheckDao;

public class PaidCheck {

	HttpServletRequest request;
	HttpServletResponse response;
	
	public PaidCheck(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String paidCheck() {
		paidCheckDao pDao=new paidCheckDao();
		List<Story> plist=new ArrayList<Story>();
		HttpSession session= request.getSession();
		String id =(String)session.getAttribute("id");
		int num=Integer.parseInt(request.getParameter("novelNum"));
		plist=pDao.paidCheck(id,num);
		
		String json;
		Gson gson=new Gson();
		Type shapeType = new TypeToken<List<Member>>() {}.getType();
		json=gson.toJson(plist,shapeType);
		System.out.println("페이드체크:"+json);
		
		return json;
	}

}
