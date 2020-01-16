package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.AllChargeList;
import dao.AllChargeListDao;


public class Charge {
	HttpServletRequest request;
	HttpServletResponse response;
	public Charge(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public String allChargeList() {
		HttpSession session= request.getSession();
		String id = (String) session.getAttribute("id");
		AllChargeListDao allCListDao=new AllChargeListDao();
		List <AllChargeList> allCList= allCListDao.allList(id);
		String json=null;
		if(allCList!=null&&allCList.size()!=0) {
			Gson gson=new Gson();
			Type shapeType = new TypeToken<List <AllChargeList>>() {}.getType(); 
			
			json=gson.toJson(allCList,shapeType);
			System.out.println(json);
			return json;
		}
		
		return json;
	}

}
