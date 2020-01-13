package service;

import java.lang.reflect.Type;
import java.util.ArrayList;
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
		
		for(int i=0;i<black.length;i++) {
			System.out.println("블랙리스트:"+black[i]);
		}
		
		boolean result=bDao.blackListDelete(black);
		
		if(result) {
			return "해제 성공";
		}else {
			return "해제 실패";
		}
	}

	public String blackListAdd() { //블랙리스트 추가하는 메소드
		BlackListDao bDao=new BlackListDao();
		String id=request.getParameter("blackId");
		int result;
		result=bDao.blackListCheck(id); //리턴값이 -1이면 이미 블랙리스트,1이면 블랙리스트 추가가능 
		if(result==1) {
			result= bDao.blackListAdd(id);
			return "블랙리스트 추가 성공했습니다.";
		}else if(result==-1){
			return "이미 블랙리스트 추가된 인물입니다.";
		}
		return null;
	}
	
	public int blackListCheck() { //블랙리스트인지 검사하는 메소드
		BlackListDao bDao=new BlackListDao();
		String id=request.getParameter("blackId");
		int result= bDao.blackListCheck(id);
		
		return result;
	}
	
	

}
