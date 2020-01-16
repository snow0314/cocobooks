package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.Preference;
import dao.PreferenceActionDao;

public class PreferenceAction {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public PreferenceAction(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String preferenceAdd() {
		HttpSession session= request.getSession();
		PreferenceActionDao paDao=new PreferenceActionDao();
		String id=(String)session.getAttribute("id");
		int num=Integer.parseInt(request.getParameter("Novel_num"));
		
		boolean result=paDao.preferenceCheck(id,num);
		if(result) {
			result=paDao.preferenceAdd(id,num);
		}

		if(result) {
			return "등록 성공했습니다.";
		}else {
			return "이미 등록된 작품입니다.";
		}
		
	}

	public String preferenceShow() {
		HttpSession session= request.getSession();
		PreferenceActionDao paDao=new PreferenceActionDao();
		String id=(String)session.getAttribute("id");
		String json=null;

		List<Preference> listData=paDao.preferenceList(id);
		if(listData!=null&&listData.size()!=0) {
			Gson gson=new Gson();
			Type shapeType = new TypeToken<List <Preference>>() {}.getType(); 
			json=gson.toJson(listData,shapeType);
			System.out.println("선호작 불러오기 성공");
			System.out.println("선호작 json"+json);
			return json;
		}
		System.out.println("선호작 불러오기 실패");
		return json;
	}
	


}
