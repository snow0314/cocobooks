package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.FaideWebFictionBean;
import dao.DelFavoritesNovelDao;

public class DeleteFavoritesNovel {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public DeleteFavoritesNovel(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String del() {
		String str=null;
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		int delnum=Integer.parseInt(request.getParameter("novelNum"));
		DelFavoritesNovelDao dFDao= new DelFavoritesNovelDao();
		boolean result =dFDao.del(id,delnum);
		dFDao.close();
		if(result) {
			
			str="선호작 삭제 완료";
			return str;
		}
		else {
			str="오류";
			return str;
		}
	}

}
