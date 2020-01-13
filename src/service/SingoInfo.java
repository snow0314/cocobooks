package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Declaration;
import bean.Member;
import dao.SingoInfoDao;

public class SingoInfo {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public SingoInfo(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String singoinfo() {
		SingoInfoDao sDao=new SingoInfoDao();
		List<Declaration> dlist=sDao.singoinfo();
		
		Gson gson=new Gson();
		Type shapeType = new TypeToken<List<Member>>() {}.getType();
		String json=gson.toJson(dlist,shapeType);
		
		return json;
	}

}
