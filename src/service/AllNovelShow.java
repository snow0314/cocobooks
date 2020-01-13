package service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Member;
import bean.Novel;
import dao.AllNovelShowDao;

public class AllNovelShow {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public AllNovelShow(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String allnovelshow() {
		AllNovelShowDao nDao=new AllNovelShowDao();
		List<Novel> nlist=new ArrayList<Novel>();
		String json;
		nlist=nDao.allnovelshow();
		Gson gson=new Gson();
		Type shapeType = new TypeToken<List<Member>>() {}.getType();
		json=gson.toJson(nlist,shapeType);
		return json;
	}
	
	

}
