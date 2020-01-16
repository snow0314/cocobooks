package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Novel;
import dao.MyNovelDao;

public class MyNovel {
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	
	public MyNovel(HttpServletRequest request, HttpServletResponse response) {
			this.request=request;
			this.response=response;
	}


	public String check() {
		String json=null;
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		MyNovelDao myNovelDao= new MyNovelDao();
		List<Novel> myNovelList= myNovelDao.getList(id);
		if(myNovelList!=null&&myNovelList.size()!=0) {
			Gson gson= new Gson();
			Type shapeType = new TypeToken<List <Novel>>() {}.getType(); 
			json=gson.toJson(myNovelList,shapeType);
			return json;
		}
		return json;
	}

}
