package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Member;
import dao.BlackListDao;

public class BlackList {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public BlackList(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String blacklistshow() {
		BlackListDao bDao=new BlackListDao();
		List<Member> list=bDao.blacklistshow();
		
		String json;
		Gson gson=new Gson();
		Type shapeType = new TypeToken<List<Member>>() {}.getType(); 
		
		json=gson.toJson(list,shapeType);
		System.out.println(json);
		
		
		return json;
	}

	public String blackListDelete() {
		BlackListDao bDao=new BlackListDao();
		String[] black=request.getParameterValues("black");
		System.out.println("블랙:"+black[0]);
//		for(int i=0;i<black.length;i++) {
//			System.out.println("블랙:"+black[i]);
//		}
		
		boolean result=bDao.blackListDelete(black);
		
		if(result) {
			return "해제 성공";
		}else {
			return "해제 실패";
		}
	}
	

}
