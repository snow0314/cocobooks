package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.AllChargeList;
import bean.Member;
import dao.ShowMyInfoDao;

public class MyInfo {
	HttpServletRequest request; 
	HttpServletResponse response;
	public MyInfo(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public String showMyInfo() {
		HttpSession session=request.getSession();
		String id= (String) session.getAttribute("id");
		ShowMyInfoDao showInfoDao= new ShowMyInfoDao();
		String json=null;
		Member mb=showInfoDao.showMyInfo(id);
		showInfoDao.close();
		if(mb!=null) {
			Gson gson=new Gson();
			json=gson.toJson(mb);
			System.out.println("프로필 불러오기 성공");
			return json;
		}else {
			System.out.println("프로필 불러오기 실패");
		}
		return json;
	}
	
}
