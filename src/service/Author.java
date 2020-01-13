package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Member;
import dao.AuthorDao;
import dao.BlackListDao;

public class Author {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public Author(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String authorShow() {
		AuthorDao aDao=new AuthorDao();
		List<Member> list=aDao.authorShow();
		
		String json;
		Gson gson=new Gson();
		Type shapeType = new TypeToken<List<Member>>() {}.getType(); 
		
		json=gson.toJson(list,shapeType);
		
		return json;
		
	}

	public String authorchange() {
		AuthorDao aDao=new AuthorDao();
		String id=request.getParameter("authorId");
		System.out.println("전환2:"+id);
		boolean result=aDao.authorchange(id);
		
		if(result) {
			return "전환성공";
		}else {
			return "전환실패";
		}
	
	}
	

}
