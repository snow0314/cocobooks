package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Member;
import dao.UserInfoDao;

public class UserInfo {

	HttpServletRequest request;
	HttpServletResponse response;
	
	public UserInfo(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String allUserInfo() {
		UserInfoDao infoDao=new UserInfoDao();
		List<Member> list=infoDao.allUserInfo();
		String json;
		Gson gson=new Gson();
		Type shapeType = new TypeToken<List<Member>>() {}.getType(); 
		
		json=gson.toJson(list,shapeType);
		System.out.println(json);
		
		return json;
	}

}
